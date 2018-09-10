package br.com.olivum.banking.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import br.com.olivum.banking.database.BankDatabase;

@WebListener
public class ContextInitializer implements ServletContextListener, HttpSessionListener {
    private BankDatabase database = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextInitializer.contextInitialized()");

        database = BankDatabase.getInstance();

        database.open();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextInitializer.contextDestroyed()");

        database.close();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("ContextInitializer.sessionCreated()");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("ContextInitializer.sessionDestroyed()");
    }
}
