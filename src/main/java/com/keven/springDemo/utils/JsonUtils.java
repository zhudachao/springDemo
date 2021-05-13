package com.keven.springDemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 
 * @ClassName: JsonUtils
 * @Description: json压缩、json格式化
 * @author zdchao
 * @date 2021年1月31日
 *
 */
public class JsonUtils {
	/**
	 * json格式化 @Title: JsonFormart @Description: json格式化 @param @param
	 * JsonString @param @return 参数 @return String 返回类型 @throws
	 */
	public static String jsonFormart(String JsonString) {
		JSONObject object = JSONObject.parseObject(JsonString);
		JsonString = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteDateUseDateFormat);
		return JsonString;
	}

	/**
	 *
	 * @Title: jsonCompress @Description: json压缩 @param @param
	 * JsonString @param @return 参数 @return String 返回类型 @throws
	 */
	public static String jsonCompress(String JsonString) {
		JSONObject object = JSONObject.parseObject(JsonString);
		JsonString = JSON.toJSONString(object, SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteMapNullValue);
		return JsonString;
	}

}
