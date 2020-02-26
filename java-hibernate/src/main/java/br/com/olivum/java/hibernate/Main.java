package br.com.olivum.java.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.config.ConfigurationException;

public class Main {
    private static SessionFactory sessionFactoryMySQL;
    //private static SessionFactory sessionFactorySqlServer;
    //private static SessionFactory sessionFactoryOracle;

    private static String hibernateMySQLCfgFilePath = "hibernate.mysql.cfg.xml";
    //private static String hibernateMsSQLCfgFilePath = "hibernate.mssql.cfg.xml";
    //private static String hibernateOracleCfgFilePath = "hibernate.oracle.cfg.xml";

    public static void main(String[] args) {
        // MySQL session

        System.out.println("Starting MySQL session");

        try {
            sessionFactoryMySQL = new Configuration().configure(hibernateMySQLCfgFilePath).buildSessionFactory();
        }
        catch (ConfigurationException e) {
            System.err.println("Error on loading configuration from " + hibernateMySQLCfgFilePath);

            System.err.println("Exception: " + e);

            return;
        }
        catch (Throwable e) {
            System.err.println("Error: " + e);

            return;
        }

        // Register in MySQL

        // Register new product

        Date date = new Date();

        Product product = new Product();
        product.setName("Product " + date.getTime());

        Session sessionMySQL = sessionFactoryMySQL.openSession();

        Transaction transactionMySQL = sessionMySQL.beginTransaction();

        // Saving objects to session

        sessionMySQL.save(product);

        // Commit transaction

        transactionMySQL.commit();

        sessionMySQL.close();

        sessionFactoryMySQL.close();

        /*
        // SQL Server session

        System.out.println("Starting MS SQL Server session");

        try {
            sessionFactorySqlServer = new Configuration().configure(hibernateMsSQLCfgFilePath).buildSessionFactory();
        }
        catch (ConfigurationException e) {
            System.err.println("Error on loading configuration from " + hibernateMsSQLCfgFilePath);

            System.err.println("Exception: " + e);

            return;
        }
        catch (Throwable e) {
            System.err.println("Error: " + e);

            return;
        }

        // Register in SQL Server

        // Register new product

        product = new Product();
        product.setName("Product " + date.getTime());

        Session sessionSqlServer = sessionFactorySqlServer.openSession();

        Transaction transactionSqlServer = sessionSqlServer.beginTransaction();

        // Saving objects to session

        sessionSqlServer.save(product);

        // Commit transaction

        transactionSqlServer.commit();

        sessionSqlServer.close();

        sessionFactorySqlServer.close();
        */

        /*
        // Oracle session

        System.out.println("Starting Oracle session");

        try {
            sessionFactoryOracle = new Configuration().configure(hibernateOracleCfgFilePath).buildSessionFactory();
        }
        catch (ConfigurationException e) {
            System.err.println("Error on loading configuration from " + hibernateOracleCfgFilePath);

            System.err.println("Exception: " + e);

            return;
        }
        catch (Throwable e) {
            System.err.println("Error: " + e);

            return;
        }

        // Register in Oracle

        // Register new product

        product = new Product();
        product.setName("Product " + date.getTime());

        Session sessionOracle = sessionFactoryOracle.openSession();

        Transaction transactionOracle = sessionOracle.beginTransaction();

        // Saving objects to session

        sessionOracle.save(product);

        // Commit transaction

        transactionOracle.commit();

        sessionOracle.close();

        sessionFactoryOracle.close();
        */

        System.out.println("Finishing");

        System.exit(0);
    }
}