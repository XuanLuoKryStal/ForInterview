package model.spring.transaction;

import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class test {
    public static void main(String[] args) throws SQLException {
        String s="1";
        s.intern();

        DataSource dataSource =new DriverManagerDataSource() ;
        Connection connection=DriverManager.getConnection("jdbc:mysql://10.110.200.78:4000/dzf_yctl?useUnicode=true&useSSL=false",
                "dzf_yctl",
                "dzf_yctl123");

        
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager(dataSource);
        TransactionDefinition definition=null;
        dataSourceTransactionManager.getTransaction(null);

        TransactionInterceptor lo;
        TransactionManager manager;
        DefaultAopProxyFactory p;




    }
}
