package com.keven.springDemo.test;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;


public class Dlob2StringTest {
	
	public static void main(String[] args) throws SerialException, UnsupportedEncodingException, SQLException {
		
		String str ="blob demo";
		Blob b =new SerialBlob(str.getBytes("utf-8"));
	
		System.out.println(new String(b.getBytes(1, (int) b.length())));
		
		
		
	}

}
