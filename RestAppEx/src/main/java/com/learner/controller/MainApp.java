/**
 * 
 */
package com.learner.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author DELL
 *
 */
@SpringBootApplication
@ComponentScan("com.learner")
public class MainApp {
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
}
