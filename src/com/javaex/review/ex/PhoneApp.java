package com.javaex.review.ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException{

		System.out.println("*******************************************");
		System.out.println("* \t   전화번호 관리 프로그램 \t  *");
		System.out.println("*******************************************");
		
		Scanner sc = new Scanner(System.in);
		
		List<Person> pList = new ArrayList<Person>();
		
		FileReader fr = new FileReader("C:\\javaStudy\\PhoneDB - 복사본.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			String str = br.readLine();
			if(str == null) {
				break;
			}
			String[] pInfo = str.split(",");
			String name = pInfo[0];
			String hp = pInfo[1];
			String company = pInfo[2];
			
			Person p = new Person(pInfo[0], pInfo[1], pInfo[2]);
			pList.add(p);
		}
		
		
		
		while(true) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------------");
			System.out.print(">메뉴번호:");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("<1.리스트>");
					for(int i=0; i<pList.size(); i++) {
						pList.get(i).get
					}
					
					
					break;
					
				case 2:
					
					
				case 3:
					
					
					
				case 4:
					
					
				case 5:
					
					
				default:	
			}
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		br.close();
		sc.close();
		
	}

}
