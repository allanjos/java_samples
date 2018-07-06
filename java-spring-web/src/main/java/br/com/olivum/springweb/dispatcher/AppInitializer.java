package br.com.olivum.springweb.dispatcher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import br.com.olivum.springweb.config.WebMvcConfigure;

public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        System.out.println("AppInitializer.onStartup()");

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        context.register(WebMvcConfigure.class);

        context.setServletContext(container);

        /*
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet());

        registration.setLoadOnStartup(1);
        */

        //registration.addMapping("*.html");
    }
}
