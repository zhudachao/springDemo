package com.keven.springDemo;

import java.math.BigDecimal;

import com.alibaba.fastjson.serializer.ValueFilter;

public class BigDecimalValueFilter implements ValueFilter {
	 public Object process(Object o, String name, Object value) {
			//o是待转换的对象，name是字段名，value是字段值
	        if (null != value && value instanceof BigDecimal) {
	            return ((BigDecimal) value).setScale( 2 ).toString();
	        }
	        return value;
	    }
	}