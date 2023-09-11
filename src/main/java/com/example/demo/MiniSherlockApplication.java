package com.example.demo;
//import com.example.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.*")
@SpringBootApplication
public class MiniSherlockApplication {
	public static void main(String[] args) {
		SpringApplication.run(MiniSherlockApplication.class, args);
	}
}