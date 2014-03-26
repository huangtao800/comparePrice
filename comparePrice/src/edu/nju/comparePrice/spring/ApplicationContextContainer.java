package edu.nju.comparePrice.spring;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;



public class ApplicationContextContainer implements ApplicationContextAware {
	protected static Logger logger = LoggerFactory.getLogger(ApplicationContextContainer.class);
	
	// 声明�?��静�?变量保存
    private static ApplicationContext applicationContext;
		


    public static ApplicationContext getContext() {
        return applicationContext;
    }

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		applicationContext = context;
		logger.info(String.format("***************set context in %s****************", this.getClass().getName()));
	}
	
    /**
     * 获取Spring容器中的对象
     * @param <B>
     * @param beanClass
     * @return
     */
	public static <B> B getBean(Class<B> beanClass) {
		return getBean(beanClass, getContext());
	}
	
    /**
     * 获取Spring容器中的对象
     * @param <B>
     * @param beanClass
     * @return
     */
	@SuppressWarnings("unchecked")
	public static <B> B getBean(Class<B> beanClass, ApplicationContext context) {
		String[] beanNames = context.getBeanNamesForType(beanClass);
		if (0 == beanNames.length) {
			throw new RuntimeException("Cannot find bean of class: " + beanClass.getName());
		}

		return (B) context.getBean(beanNames[0]);
	}
}
