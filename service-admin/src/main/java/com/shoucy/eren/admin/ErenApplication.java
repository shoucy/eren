package com.shoucy.eren.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.shoucy.eren.admin.mapper")
@SpringBootApplication(scanBasePackages = "com.shoucy.eren")
public class ErenApplication {

	public static void main(String[] args) {
		// 关闭pageHelper的banner，它实在是太大了。
		System.setProperty("pagehelper.banner", "false");
		SpringApplication.run(ErenApplication.class, args);
	}

}
