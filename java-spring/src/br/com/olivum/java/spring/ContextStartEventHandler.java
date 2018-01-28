package br.com.olivum.java.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
       System.out.println("ContextStartEventHandler.onApplicationEvent() event=" + event.toString());
    }
}