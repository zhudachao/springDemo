package com.keven.springDemo;

import java.math.BigDecimal;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlException;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Test {
	public static void main(String[] args) throws OgnlException {
		BigDecimal demimal =new BigDecimal(200.00);
		BigDecimalValueFilter bigDecimalValueFilter =new BigDecimalValueFilter();
		JSONObject json =new JSONObject();
				json.put("amt", demimal);
		System.out.println(JSONObject.toJSONString(json,bigDecimalValueFilter,SerializerFeature.WriteNullNumberAsZero));
		Object obj= Ognl.getValue("amt", json);
		BigDecimal ret = (BigDecimal) Ognl.getValue("amt", json);
		System.out.println(ret);
		
		
		
		
		
	}
	
}
