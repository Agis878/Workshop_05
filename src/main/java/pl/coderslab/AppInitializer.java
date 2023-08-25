package pl.coderslab;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.coderslab.configuration.AppConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInitializer extends

        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override

    protected Class<?>[] getRootConfigClasses() { return null; }


    @Override

    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{AppConfig.class};  }


    @Override

    protected String[] getServletMappings() {

        return new String[]{"/"};   }


    public void onStartup(ServletContext container) throws ServletException { //uruchamia kontext spring, dodaje appcongi, ustawia dispatcher


        FilterRegistration.Dynamic fr = container.addFilter("encodingFilter", //wymusza utf-8
                new CharacterEncodingFilter());
        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");
    }
}