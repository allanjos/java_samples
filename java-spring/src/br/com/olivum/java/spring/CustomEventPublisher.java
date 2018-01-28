package br.com.olivum.java.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {
   private ApplicationEventPublisher publisher;

   @Override
   public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
       System.out.println("CustomEventPublisher.setApplicationEventPublisher()");

       this.publisher = publisher;
   }

   public void publish() {
       System.out.println("CustomEventPublisher.publish()");

       CustomEvent customEvent = new CustomEvent(this);

       publisher.publishEvent(customEvent);
   }
}