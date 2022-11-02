package lk.ijse.dep9.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lk.ijse.dep9.db.ConnectionPool;
import org.apache.commons.dbcp2.BasicDataSource;

//@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        ConnectionPool dbPool = new ConnectionPool(3); /*Manualy created Connection Pool*/
        BasicDataSource dbPool = new BasicDataSource(); /* get an instance of Apache connection ppol*/
        dbPool.setUrl("jdbc:mysql://localhost:3306/dep9_lms");
        dbPool.setUsername("root");
        dbPool.setPassword("Nipun@96");
        dbPool.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dbPool.setInitialSize(10); /* Setting initial pool size*/
        dbPool.setMaxTotal(20); /* can be expanded up to 20 connections */

        sce.getServletContext().setAttribute("pool",dbPool);
    }
}
