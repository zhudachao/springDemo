package com.keven.springDemo;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.util.MapUtils;


public class TestConfig {
	
	public static void main(String[] args) {
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> output =new HashMap<String, Object>();
		map.put("output", output);
//		Ognl.setValue(tree, root, value);
//		Ognl.setValue(expression, context, root, value);
		try {
			Ognl.setValue("output.prcscd", map, "yhsd");
			System.out.println(map);
		} catch (OgnlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
