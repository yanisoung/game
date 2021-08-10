package com.bai.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * 游戏启动类
 *
 * @author Bai
 * @date 2021/8/10 21:00
 */
@SpringBootApplication(scanBasePackages = "com.bai.game")
@PropertySource(value = {"classpath:application.properties"})
public class Application {

	public static void main (String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("------------启动成功-----------");
	}
}
