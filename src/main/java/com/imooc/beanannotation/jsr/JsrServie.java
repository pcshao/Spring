package com.imooc.beanannotation.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

//@Service
@Named
public class JsrServie {
	
//	@Resource
//	@Inject
	private JsrDAO jsrDAO;
	
//	@Resource
	@Inject
	public void setJsrDAO(@Named("jsrDAO") JsrDAO jsrDAO) {
		this.jsrDAO = jsrDAO;
	}
	
	//以下的两个注解都是会被容器启动时执行
	@PostConstruct
	public void init() {
		System.out.println("JsrServie init.");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("JsrServie destroy.");
	}

	public void save() {
		jsrDAO.save();
	}
	
}
