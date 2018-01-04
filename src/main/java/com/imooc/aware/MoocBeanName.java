package com.imooc.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MoocBeanName implements BeanNameAware, ApplicationContextAware {

	private String beanName;
	
	/**
	 * 覆盖了原有的直接在主方法里调用bean名就执行的方法，打印出一句bean名
	 */
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("MoocBeanName : " + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("setApplicationContext : " + applicationContext.getBean(this.beanName).hashCode());
	}

}
