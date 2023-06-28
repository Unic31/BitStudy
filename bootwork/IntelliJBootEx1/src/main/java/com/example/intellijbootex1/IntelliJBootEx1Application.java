package com.example.intellijbootex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"study.*"})
public class IntelliJBootEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(IntelliJBootEx1Application.class, args);
	}

}
