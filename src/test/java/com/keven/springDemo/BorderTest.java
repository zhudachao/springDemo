package com.keven.springDemo;

import java.util.Scanner;

public class BorderTest {
	
	public final static int LIMIT = 2000;  //限购数量
	
	public static void main(String[] args) {
		int cur = 1000;
		System.out.println(Integer.MAX_VALUE);
		Scanner input  =new Scanner(System.in);
		System.out.println("输入预购数量：");  //2147483647 int最大值
		while(input.hasNext()) {
			int order = input.nextInt();
			if(order>0 && order+cur<=2000) {
				System.out.println("预购数量为："+ order);
			}else {
				System.out.println("超过限购数量");
			}
		}
		
	}

}
