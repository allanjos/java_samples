package br.com.olivum.java.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor {
   @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {

        System.out.println("BeforeInitialization : " + beanName);

        return bean;
   }

   @Override
   public Object postProcessAfterInitialization(Object bean, String beanName)
       throws BeansException {

       System.out.println("AfterInitialization : " + beanName);

       return bean;
   }
}