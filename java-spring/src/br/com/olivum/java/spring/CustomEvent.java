package br.com.olivum.java.spring;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent{
    private static final long serialVersionUID = 2052836196134871100L;

    public CustomEvent(Object source) {
       super(source);

       System.out.println("CustomEvent.CustomEvent()");
    }

    @Override
    public String toString(){
       return "Custom Event";
    }
 }