package br.com.olivum.banking.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import br.com.olivum.banking.database.BankDatabase;

@WebListener
public class ContextInitializer implements ServletContextListener, HttpSessionListener {
    private static final Logger logger = Logger.getLogger(ContextInitializer.class);
    private BankDatabase database = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("ContextInitializer.contextInitialized()");

        BasicConfigurator.configure();

        database = BankDatabase.getInstance();

        database.open();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("ContextInitializer.contextDestroyed()");

        database.close();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.debug("ContextInitializer.sessionCreated()");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.debug("ContextInitializer.sessionDestroyed()");
    }
}
