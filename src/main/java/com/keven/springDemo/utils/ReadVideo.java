package com.keven.springDemo.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

/**
 * 统计目录下视频信息和时长信息
 * @author zdchao
 *
 */
public class ReadVideo {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ReadVideo.class);

	
	public  static void getVideoTime(String filePath) {
		long sum =0;
		long num =0;		
		File source =new File(filePath);
		File[] files = source.listFiles();
		
		for (File file : files) {
			try {
				MultimediaObject obj = new MultimediaObject(file);
				String fileName =file.getName();
				MultimediaInfo  info =obj.getInfo();				
				long ls = info.getDuration()/60000;//获取时间 MM
				String format = info.getFormat();//获取格式
//				int height =info.getVideo().getSize().getHeight();
//				int width =info.getVideo().getSize().getWidth();
				logger.info("视频:{}, 时长:{}, 格式:{}",fileName,ls,format);
				sum = sum+ls;
				num ++;
				
			} catch (EncoderException e) {
				
			}
			logger.info("该目录下视频视频个数：{},总时长：{}",num,sum);			
			
		}		
	}
	
	public static void main(String[] args) {
		getVideoTime("E:\\BaiduNetdiskDownload\\视频-1\\视频-1");
	}
	

}
