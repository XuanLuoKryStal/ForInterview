#!/bin/bash

ALL_LIST_FILE=list.json
PARSE_DATA=data.json
DOCKER_ID_FILE=docker.json
# consul中服务对应名字，地址和ID
NAME=default
IP=default
ID=default
DOCKER_ID=default;
# consul

# 函数：1.获取consul在线列表，然后根据服务名称，获取ip和id
function GET_ALL_LIST(){
    url="http://10.128.27.21:8500/v1/agent/services"
    echo "GET consul all services info : curl "$url

    curl ${url} > ${ALL_LIST_FILE}
    
    cat list.json| jq -c ".[] | [.ID,.Service,.Address]"| column -t -s'[],"' > ${PARSE_DATA}

 while read LINES; do
     name=`echo $LINES | awk '{print $2}'`
     if [ "$name" = "$1" ]; then
        IP=`echo $LINES | awk '{print $3}'`
        ID=`echo $LINES | awk '{print $1}'`
        NAME=$name
     fi
 done <  ${PARSE_DATA}
}

# 函数：2.根据ip删除consul中实例
function DELETE_CONSUL_SERVICE(){
    url="http://10.128.27.21:8500/v1/agent/service/deregister/"${ID}
    echo "Delete consul service : curl "$url 
    curl ${url}
}

# 函数：3.判断consul中服务是否已经删除
function CHECK_IF_DELETE(){
    url="http://10.128.27.21:8500/v1/health/service/"${NAME}
    echo "Check consul service : curl "$url
    var=`curl ${url} | jq '.[]|keys'`
    if [ ${#var} -gt 1 ];then
       return 0
    else 
       return 1  #delete
    fi
}

# 函数： 4.循环判断是否已经删除，否则再手动删除
function CIRCLE_CHECK(){
    count=3
while [ $count -ne 0 ]; do
    CHECK_IF_DELETE
    result=$?
    if [ $result -eq 1 ]; then
        break
    else
        echo "DELETE ing"
        DELETE_CONSUL_SERVICE
        Sleep 15
    fi
    let count-=1
done
}

# docker

# 函数：5.查找根据服务名称，检查找到对应IP，并删除docker服务
function DELECT_DOCKER(){
  docker ps|grep ${NAME} | awk '{print $1}' > ${DOCKER_ID_FILE}
  while read LINES; do
    echo $LINES
      commd=`docker inspect ${LINES} | jq  -r '.[]|.NetworkSettings.IPAddress'`
      if [[ "$commd" = "$IP" ]]; then
          echo "DELETE docker....."$LINES
         `docker restart $LINES`
      fi
  done < ${DOCKER_ID_FILE}
}



# 主函数 传参数：服务名称
# 描述 ：目前是演示一个服务先删除consul，然后找到对应ip在docker对应实例删除
# TODO ： 如果是多个，就要将IP等用数组存在，然后遍历重复以下操作

# 1. 查找所有服务保持在list.json中
GET_ALL_LIST $1
# 2. 删除consul服务
DELETE_CONSUL_SERVICE
Sleep 15
# 3. 循环校验是否删除
CIRCLE_CHECK
# 4. 最终判断是否删除，仍然删除不了就退出程序
CHECK_IF_DELETE
finalResult=$?
if [ $finalResult -eq 0 ]; then
    echo "Can not delete !!"
   exit 1
fi
#5. 删除对应并重启对应docker服务
DELECT_DOCKER

