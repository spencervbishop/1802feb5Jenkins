package com.ex.context;

import com.ex.data.ConnectionUtils.H2DataConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * WebListener is an interface that "listens" for the servlet context
 * to be created. In this implementation the listener will start an in
 * memory database that will hold the data we will query and manipulate
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            Class.forName(H2DataConnector.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        H2DataConnector.connector().unregisterDriver();
    }
}
