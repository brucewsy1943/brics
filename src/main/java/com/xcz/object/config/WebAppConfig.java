package com.xcz.object.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

	
	
	//@Value("${spring.upload.path}")
    //private  String realPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    
    
		// * 资源映射路径
		 //* addResourceHandler：访问映射路径
		 //* addResourceLocations：资源绝对路径
		
       // registry.addResourceHandler("/image/**").addResourceLocations("file:"+realPath+"image/");
       // registry.addResourceHandler("/file/**").addResourceLocations("file:"+realPath+"file/");
      //  registry.addResourceHandler("/fun/**").addResourceLocations("classpath:/fun/");
    }
    
    
  /*  @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/");
       
    }*/
    
    
    
    
    
    

}



