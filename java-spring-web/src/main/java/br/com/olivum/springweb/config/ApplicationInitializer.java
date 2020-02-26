package br.com.olivum.springweb.config;

import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
      registration.setInitParameter("dispatchOptionsRequest", "true");
      registration.setAsyncSupported(true);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("ApplicationInitializer.getRootConfigClasses()");

        return new Class[] { ApplicationConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("ApplicationInitializer.getServletConfigClasses()");

        return new Class[] { WebConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("ApplicationInitializer.getServletMappings()");

        return new String[] { "/" };
    }
}
