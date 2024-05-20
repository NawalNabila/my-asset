package com.nabilla.myasset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MyassetApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyassetApplication.class, args);
	}

}
