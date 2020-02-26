package br.com.olivum.banking.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.config.ConfigurationException;

public class BankDatabase {
    private static final Logger logger = LogManager.getLogger(BankDatabase.class);
    private static BankDatabase instance = new BankDatabase();
    private static SessionFactory sessionFactory = null;
    private static Session session = null;

    private BankDatabase() {
        logger.debug("BankDatabase.BankDatabase()");
    }

    public static BankDatabase getInstance() {
        logger.debug("BankDatabase.getInstance()");

        if (instance == null) {
            instance = new BankDatabase();
        }

        return instance;
    }

    public static Session getSession() {
        return session;
    }

    public void open() {
        logger.debug("BankDatabase.open()");

        logger.debug("Starting MySQL session");

        String configFilePath = "/bank-hibernate.cfg.xml";

        try {
            sessionFactory = new Configuration().configure(configFilePath).buildSessionFactory();

            session = sessionFactory.openSession();
        }
        catch (ConfigurationException e) {
            logger.error("Error on loading configuration from " + configFilePath);

            logger.error("Exception: " + e);

            return;
        }
        catch (Throwable e) {
            logger.error("Error: " + e);

            return;
        }
    }

    public void close() {
        logger.debug("BankDatabase.close()");

        if (session != null) {
            session.close();

            session = null;
        }

        if (sessionFactory != null) {
            sessionFactory.close();

            sessionFactory = null;
        }
    }
}
