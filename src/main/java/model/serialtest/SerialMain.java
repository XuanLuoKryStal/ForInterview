package model.serialtest;

import java.io.*;

public class SerialMain {
    public static void main(String[] args) {
        //测试类实现Serializable
        PersonSerial personSerial=new PersonSerial(12,"lili");
        PersonSerial result= (PersonSerial) serialTest(personSerial);
        System.out.println(result);
        //测试类实现Externalizable
        PersonExternalSerial externalSerial=new PersonExternalSerial(20,"haha");
        PersonExternalSerial resultExternal=(PersonExternalSerial) serialTest(externalSerial);
        System.out.println(resultExternal);
    }

    public static Object serialTest(Object source){
        ObjectOutputStream outputStream=null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("tempFile"));
            outputStream.writeObject(source); //会去判断是否personSerial是否重写类writeObject方法，如果重写就调用，底层还是反射机制
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectInputStream inputStream=null;
        File file = new File("tempFile");
        try{
            inputStream=new ObjectInputStream(new FileInputStream(file));
            return inputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new Object();
    }



}
