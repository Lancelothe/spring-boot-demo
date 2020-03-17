package com.lancelot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lancelot
 */
@SpringBootApplication
@MapperScan("com.lancelot.mapper")
public class MybatisAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisAnnotationApplication.class, args);
	}

}
