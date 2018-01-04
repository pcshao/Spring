package com.imooc.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@ImportResource("classpath:config.xml")
public class StoreConfig {
	
//	@Value("${url}")
//	private String url;
//	
	/**
	 * 2017/12/25
	 * 此处如果直接将配置文件写成username而不是指定了唯一性的*.username，会在运行时自动将当前使用操作系统的username赋值给变量，而不是要的配置文件中的username
	 * 
	 */
//	@Value("${jdbc.username}")
//	private String username;
//	
//	@Value("${password}")
//	private String password;
//	
//	@Bean
//	public MyDriverManager myDriverManager() {
//		return new MyDriverManager(url, username, password);
//	}
	
	
//	@Bean(name = "stringStore", initMethod="init", destroyMethod="destroy")
//	public Store stringStore() {
//		return new StringStore();
//	}
	
	
//	@Bean(name = "stringStore")
//	@Scope(value="prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
//	public Store stringStore() {
//		return new StringStore();
//	}

	/**
	 * 1.基于泛型的自动装配，通过指定是String还是Integer来获取并生成不同的对象
	 * 2.已经装配好了的String类型的stringStore和Integer类型的integerStore
	 * 3.通过@Autowired来泛型装配成s1和s2，方便测试
	 * 4.
	 */
	@Autowired
	private Store<String> s1;
	
	@Autowired
	private Store<Integer> s2;
	
	@Bean
	public StringStore stringStore() {
		return new StringStore();
	}
	
	@Bean
	public IntegerStore integerStore() {
		return new IntegerStore();
	}
	
	@Bean(name = "stringStoreTest")
	public Store stringStoreTest() {
		
		//下面的控制台打印也是在当前config文件下被注册的，即使这个bean没有被调用，但是初始化时还是会执行syso
		System.out.println("s1 : " + s1.getClass().getName());
		System.out.println("s2 : " + s2.getClass().getName());
		return new StringStore();
	}
	

}
