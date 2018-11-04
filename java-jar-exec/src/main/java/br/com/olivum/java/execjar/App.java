package br.com.olivum.java.execjar;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public App() {
        logger.debug("App()");
    }

    public static void main(String args[]) {
        BasicConfigurator.configure();

        logger.debug("main()");
    }
}
