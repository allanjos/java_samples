package br.com.olivum.java.execjar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import org.apache.log4j.Logger;

public class AppTest
{
    Logger logger = Logger.getLogger(AppTest.class);

    @Test
    public void testApp()
    {
        assertTrue(true);
    }
}
