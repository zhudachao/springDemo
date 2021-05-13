package com.keven.springDemo.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.springframework.util.StringUtils;

public class Validate {
	
	public static void valid(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = obj.getClass();	
		Field[] fields =clazz.getDeclaredFields();
		for (Field field : fields) {
			if(field.isAnnotationPresent(NotNull.class)) {
				NotNull annoClass =	field.getAnnotation(NotNull.class);
				if(!StringUtils.isEmpty(field.get(obj))){					
					System.out.println(field.get(obj));
				}else {
					System.out.println(annoClass.value()+"不能为空");
					
				}
				
			
			}
			}
		}

}
