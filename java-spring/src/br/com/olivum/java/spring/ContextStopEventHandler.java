package br.com.olivum.java.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class ContextStopEventHandler implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
       System.out.println("ContextStopEventHandler.onApplicationEvent() event=" + event.toString());
    }
}
