package com.supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;


@EnableAutoConfiguration
@ImportResource(locations={"classpath:mybatis-config.xml"})
public class SupplierApplication extends SpringBootServletInitializer{
	
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		  return application.sources(new Class[] { SupplierApplication.class });
	  }
	  
	  public static void main(String[] args)throws Exception{
		  SpringApplication.run(SupplierApplication.class, args);
	  }
}

