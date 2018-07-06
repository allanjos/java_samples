package br.com.olivum.springdesktop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    private static ApplicationContext context = null;

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        
        context = new AnnotationConfigApplicationContext(Config.class);
        
        Game game = context.getBean("game", Game.class);
        
        game.start();
        
        game.stop();
    }
}
