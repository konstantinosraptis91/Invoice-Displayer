package invoice.displayer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

/**
 *
 * @author konstantinos
 */
@Configuration
@ComponentScan(basePackages="invoice.displayer")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
    
    @Bean
    public ViewResolver getXSLTViewResolver(){
         
        XsltViewResolver xsltResolover = new XsltViewResolver();
        xsltResolover.setOrder(1);
        xsltResolover.setSourceKey("xmlSource");
         
        xsltResolover.setViewClass(XsltView.class);
        xsltResolover.setViewNames(new String[] {"XSLTView"});
        xsltResolover.setPrefix("/WEB-INF/xsl/");
        xsltResolover.setSuffix(".xsl");
         
        return xsltResolover;
    }
     
    @Bean
    public ViewResolver getHTMLViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("resources/views/");
        resolver.setSuffix(".html");
        resolver.setOrder(2);
        return resolver;
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("resources/**").addResourceLocations("resources/");
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
}
