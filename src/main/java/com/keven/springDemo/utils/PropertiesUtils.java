package com.keven.springDemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


    /**
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author zdchao
    * @date 2019年5月6日
    *
    */
   
public enum PropertiesUtils {
    INSTANCE;
	private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
	private static PropertiesConfiguration config = null;

	public PropertiesConfiguration getConfig() {
		return getConfig("/application_dev.properties");

	}

	public PropertiesConfiguration getConfig(String filena) {
		if (null == this.config) {
			synchronized (PropertiesUtils.class) {
				if (null == this.config) {
					init(filena);
				}
			}
		}
		return config;
	}
	
	public String getString(String key) {
		return this.getString(key);
	}  
	
	
	public void init(String filena) {
		try {
			if (null == this.config) {
				this.config = new PropertiesConfiguration();
			}
			filena = filena.startsWith("/") ? filena.substring(1, filena.length()) : filena;

			String filePath = Thread.currentThread().getContextClassLoader().getResource(filena).toURI().getPath();
			File file = new File(filePath);
			InputStreamReader  is =new InputStreamReader(new FileInputStream(file));
							
			if (file.exists()) {
				logger.error("配置文件路径:{}", filePath);
				config.load(is);
			} else {
				logger.error("配置文件{}不存在", filePath);
			}
			
			//设置重加载策略
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
			
			
			

		} catch (URISyntaxException e) {
			
		}catch(ConfigurationException e) {
			logger.error(e.getMessage());
//			throw new ConfigurationException(e.getMessage());
		}catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
//		PropertiesConfiguration prop= new PropertiesUtils().getConfig();
		
//		PropertiesUtils prop =new PropertiesUtils();
//		String mq_ip =prop.getString("mq_ip");
//		System.out.println(mq_ip);
	}

}
