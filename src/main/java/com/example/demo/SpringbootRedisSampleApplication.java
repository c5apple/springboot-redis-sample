package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class SpringbootRedisSampleApplication {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public static void main(String[] args) {
		//		SpringApplication.run(SpringbootRedisSampleApplication.class, args);

		try (ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootRedisSampleApplication.class, args)) {
			SpringbootRedisSampleApplication app = ctx.getBean(SpringbootRedisSampleApplication.class);
			app.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {

		// 文字列設定
		stringRedisTemplate.opsForValue().set("key1", "value1");

		// 文字列取得
		System.out.println(stringRedisTemplate.opsForValue().get("key1"));
	}
}
