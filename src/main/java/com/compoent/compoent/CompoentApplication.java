package com.compoent.compoent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.compoent.compoent.dao")
public class CompoentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompoentApplication.class, args);
	}
}
