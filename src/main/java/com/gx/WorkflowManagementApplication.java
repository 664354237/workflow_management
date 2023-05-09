package com.gx;

import org.activiti.engine.ProcessEngines;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WorkflowManagementApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WorkflowManagementApplication.class);
	}
	public static void main(String[] args) {
		ProcessEngines.getDefaultProcessEngine();
		SpringApplication.run(WorkflowManagementApplication.class, args);
	}

}
