package br.com.olivum.java.spring;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
       System.out.println("CustomEventHandler.onApplicationEvent(): event=" + event.toString());
    }
 }