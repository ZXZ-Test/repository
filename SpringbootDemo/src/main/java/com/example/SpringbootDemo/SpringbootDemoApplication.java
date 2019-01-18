package com.example.SpringbootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 功能描述:
 * SSpringBootDemoHelloApplication.java 是SpringBoot应用程序入口，或者叫主程序。
 * 注解@SpringBootApplication 标注他是一个SpringBoot应用，main方法使他成为一个主程序，将在应用启动时首先被执行。
 * 注解@RestController 标注这也是一个控制器。
 * Copyright: Copyright (c) 2019
 * Company: Lyl
 * @author Uncle Drew
 * @version 1.0 2019-01-16 16:48
 */
@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}

