package com.javaex.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException{

		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int menu;
		
		
 		List<Person> pList= new ArrayList<Person>();
 		
 		InputStream in = new FileInputStream("C:\\javaStudy\\PhoneDB.txt");
 		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
 		BufferedReader br = new BufferedReader(isr);
 		
 		while(true) {
			String str = br.readLine();
			if(str == null) {
				break;
			}
			String[] pInfo = str.split(",");
			if(pInfo.length == 3) {
				Person p = new Person(pInfo[0], pInfo[1], pInfo[2]);
				pList.add(p);
			}
				
		}
 		
 		
 		System.out.println("*****************************************");
 		System.out.println("* \t 전화번호 관리 프로그램 \t*");
 		System.out.println("*****************************************");
 		
 		
 		while(run) {
 			System.out.println("");
 			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
 			System.out.println("----------------------------------------");
 			System.out.print(">메뉴번호:");
 			menu = sc.nextInt();
 			switch(menu) {
 			
 				case 1:
 					System.out.println("<1.리스트>");
 					
 					for(int i=0; i<pList.size(); i++) {
 						System.out.println((i+1) + ".  " + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t" + pList.get(i).getCompany());
 					}
 					break;
 					
 				case 2:
 					System.out.println("<2.등록>");
 					System.out.print(">이름: ");
 					sc.nextLine();
 					String name = sc.nextLine();
 					System.out.print(">휴대전화: ");
 					String hp = sc.nextLine();
 					System.out.print(">회사전화: ");
 					String company = sc.nextLine();
 					
 					Person p = new Person(name, hp, company);
 					pList.add(p);
 					
 					OutputStream out = new FileOutputStream("C:\\javaStudy\\PhoneDB.txt");
 					OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
 					BufferedWriter bw = new BufferedWriter(osw);
 					
 					for(int i=0; i<pList.size(); i++) {
 						String personData = pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany();
 						bw.write(personData);
 						bw.newLine();
 					}
 					bw.close();
 					
 					System.out.println("[등록되었습니다.]");
 					break;
 					
 				case 3:
 					
 					System.out.println("<3.삭제>");
 					System.out.print(">번호 : ");
 					
 					int num = sc.nextInt();
 					
 					if((num-1)<0 || (num-1)>=pList.size()) {
 						System.out.println("다시 입력해주세요.");
 					} else {
 						pList.remove(num-1);
 	 					System.out.println("[삭제되었습니다.]");
 	 					OutputStream out1 = new FileOutputStream("C:\\javaStudy\\PhoneDB.txt");
 	 					OutputStreamWriter osw1 = new OutputStreamWriter(out1, "UTF-8");
 	 					BufferedWriter bw1 = new BufferedWriter(osw1);
 	 					
 	 					for(int i=0; i<pList.size(); i++) {
 	 						String personData = pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany();
 	 						bw1.write(personData);
 	 						bw1.newLine();
 	 					}
 	 				bw1.close();	
 	 				
 					}
 					
 					break;
 					
 				case 4:
 					System.out.println("<4.검색>");
 					System.out.print(">이름: ");
 					sc.nextLine();
 					String str = sc.nextLine();
 					
 					for(int i=0; i<pList.size(); i++) {
 						if(pList.get(i).getName().contains(str)) {
 							System.out.println((i+1) + ".  " + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t" + pList.get(i).getCompany());
 						}
 					}
 					
 					break;
 					
 				case 5:
 				
 					System.out.println("*****************************************");
 			 		System.out.println("* \t \t 감사합니다 \t \t*");
 			 		System.out.println("*****************************************");
 					run = false;
 					break;
 					
 				default:
 					System.out.println("[다시 입력해 주세요.]");
 					break;
 					
 			}
 		}
 		
 		
		
 		
 		
 		
		
	
 		
 		
		
		
		
 		
 		
		br.close();
 		sc.close();
 		
 		
	}

}
