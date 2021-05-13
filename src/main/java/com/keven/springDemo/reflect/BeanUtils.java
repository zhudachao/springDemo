package com.keven.springDemo.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.fabric.xmlrpc.base.Array;

public class BeanUtils {

	private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

	// 获取获取类
	Class<?> clazz = null;

	public static Class<?> getClass(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			logger.info("获取类失败：{}", e.getMessage());
		}
		return null;
	}

	public Class<?> getClass(Object object) {
		return object.getClass();
	}

	// 获取构造方法
	public void getConstructs(String className) throws Exception {
		Class<?> clazz = Class.forName(className);
		Constructor<?>[] constructs = clazz.getConstructors();
		logger.info(Arrays.toString(constructs));
		for (Constructor<?> constructor : constructs) {
			Class[] paras = constructor.getParameterTypes();
			logger.info("构造函数名：{}，参数类型：{}", paras);
		}
	}

	// 获取成员变量
	public void getFields(String className) {
		try {
			Class clazz = Class.forName(className);
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true); // 对private成员变量可访问
				logger.info("{}成员变量：{}", className, field);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取所有方法及方法参数
	public void getMethod(String className) throws Exception {
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance(); // 获取对象实例
		Method[] methods = clazz.getMethods();

		for (Method m : methods) {
			logger.info("{}成员方法：{}", className, m);
			Class[] params = m.getParameterTypes();
			for (Class c : params) {
				logger.info("方法{}的参数：{}", m.getName(), c);
			}

		}
	}

	// 获取实例并调用指定
	public void getMethod(String className, String methodName, Class<?> paraType) throws Exception {
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance(); // 获取对象实例

		Method[] methods = clazz.getMethods();
		Method method = clazz.getMethod(methodName, paraType);// 方法名称、参数类型
		Method priMethod = clazz.getDeclaredMethod(methodName, paraType);
		priMethod.setAccessible(true);
		priMethod.invoke(obj, ""); // 调用方法

	}

	// 注解打印
	public void getAnnos(String className) throws Exception {
		Class clazz = Class.forName(className);
		Annotation[] annos = clazz.getAnnotations();
		for (Annotation anno : annos) {
			Class c = anno.annotationType();
			logger.info("{}获取注解：{}", className, anno);
			logger.info("输出注解数组：{}", Arrays.toString(clazz.getAnnotationsByType(anno.getClass())));
		}
	}

	// 是否含有某个注解,输出注解
	public boolean getAnno(String className, Class annoType) throws Exception {
		Class clazz = Class.forName(className);
		Annotation[] annos = clazz.getAnnotations();
		boolean isPresent = clazz.isAnnotationPresent(annoType);
		return isPresent;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Class.forName("com.keven.springDemo.reflect.Person");
		System.out.println(clazz.getSimpleName());
	}
	

}
