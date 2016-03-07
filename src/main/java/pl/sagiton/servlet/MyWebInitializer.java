package pl.sagiton.servlet;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.sagiton.config.HibernateConfig;
import pl.sagiton.config.SecurityConfig;
import pl.sagiton.config.SpringWebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {


        servletContext
                .addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
                .addMappingForUrlPatterns(null, false, "/*");



        super.onStartup(servletContext);
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringWebConfig.class, SecurityConfig.class, HibernateConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


}