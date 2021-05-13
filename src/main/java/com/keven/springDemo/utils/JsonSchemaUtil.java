package com.keven.springDemo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jackson.JsonNodeReader;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

/**
 * @ClassName: JsonSchemaUtil
 * @Description: json校验
 * @author zdchao
 * @date 2021年1月31日
 *
 */
public class JsonSchemaUtil {

	private static final Logger logger = LoggerFactory.getLogger(JsonSchemaUtil.class);

	public static boolean isValid(String jsonStr) throws Exception {
		JsonNode jsonNode = JsonSchemaUtil.strToJsonNode(jsonStr);
		JsonNode schemaNode = JsonSchemaUtil.schemaToJsonNode("classpath:jsonschema.json");
		return getProcessingReport(jsonNode, schemaNode);
	}

	/**
	 * @param jsonStr
	 *            验证json字符串
	 * @throws Exception
	 */
	private static JsonNode strToJsonNode(String jsonStr) throws Exception {
		JsonNode jsonNode = null;
		try {
			jsonNode = JsonLoader.fromString(jsonStr);
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new Exception(e.getMessage());
		}
		return jsonNode;
	}

	/**
	 * @param jsonFilePath
	 *            jsonSchema文件路径
	 * @throws Exception
	 */
	private static JsonNode schemaToJsonNode(String jsonFilePath) throws Exception {
		JsonNode jsonSchemaNode = null;
		try {
			jsonSchemaNode = new JsonNodeReader().fromReader(new FileReader(ResourceUtils.getFile(jsonFilePath)));
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new Exception(e.getMessage());
		}
		return jsonSchemaNode;
	}

	/**
	 * @param jsonNode
	 *            json数据node
	 * @param schemaNode
	 *            jsonSchema约束node
	 */
	private static boolean getProcessingReport(JsonNode jsonNode, JsonNode schemaNode) {
		// fge验证json数据是否符合json schema约束规则
		ProcessingReport report = JsonSchemaFactory.byDefault().getValidator().validateUnchecked(schemaNode, jsonNode);
		if (report.isSuccess()) {
			// 校验成功
			return true;
		} else {
			Iterator<ProcessingMessage> it = report.iterator();
			StringBuilder ms = new StringBuilder();
			ms.append("json格式错误: ");
			while (it.hasNext()) {
				ProcessingMessage pm = it.next();
				if (!LogLevel.WARN.equals(pm.getLogLevel())) {
					ms.append(pm);
				}
			}
			System.err.println(ms);
			return false;
		}
	}

	public static void main(String[] args) throws Exception {

		String jsonStr = "{\"age\":30,\"name\":\"Michael\",\"baby\":[\"Lucy\",\"Lily\"]}";
//		JsonNode jsonNode = JsonSchemaUtil.strToJsonNode(jsonStr);
//		JsonNode schemaNode = JsonSchemaUtil.schemaToJsonNode("classpath:jsonschema.json");
//		System.out.println(getProcessingReport(jsonNode, schemaNode));
		System.out.println(isValid(jsonStr));
	}

}
