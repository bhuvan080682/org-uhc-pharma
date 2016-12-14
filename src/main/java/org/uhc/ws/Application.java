package org.uhc.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages="org.uhc")
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableAsync
public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
		System.out.println("###########Succesfully loaded Spring boot application################");
	}
	
	/*@Bean
	public CacheManager cacheManager(){
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("drugs");
		return cacheManager;
	}*/

	@Bean
	public CacheManager cahceManager(){
	GuavaCacheManager cacheManager = new GuavaCacheManager();
	return cacheManager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
