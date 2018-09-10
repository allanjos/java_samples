package br.com.olivum.banking.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.config.ConfigurationException;

public class BankDatabase {
    private static BankDatabase instance = new BankDatabase();
    private static SessionFactory sessionFactory = null;
    private static Session session = null;

    private BankDatabase() {
        System.out.println("BankDatabase.BankDatabase()");
    }

    public static BankDatabase getInstance() {
        System.out.println("BankDatabase.getInstance()");

        if (instance == null) {
            instance = new BankDatabase();
        }

        return instance;
    }

    public static Session getSession() {
        return session;
    }

    public void open() {
        System.out.println("BankDatabase.open()");

        System.out.println("Starting MySQL session");

        String configFilePath = "/bank-hibernate.cfg.xml";

        try {
            sessionFactory = new Configuration().configure(configFilePath).buildSessionFactory();

            session = sessionFactory.openSession();
        }
        catch (ConfigurationException e) {
            System.err.println("Error on loading configuration from " + configFilePath);

            System.err.println("Exception: " + e);

            return;
        }
        catch (Throwable e) {
            System.err.println("Error: " + e);

            return;
        }
    }

    public void close() {
        System.out.println("BankDatabase.close()");

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
