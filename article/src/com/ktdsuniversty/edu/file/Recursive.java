package com.ktdsuniversty.edu.file;

import java.io.File;

public class Recursive {
	
	public void deleteFiles(File target) {
		if(target.isFile()) {
			System.out.println(target.getAbsolutePath());
			target.delete();
		}else if(target.isDirectory()) {
//			폴더 내부의 목록을 조회
			File[] children= target.listFiles();
			for(File child: children) {
//				System.out.println(child);
				this.deleteFiles(child);
			}
			System.out.println(target.getAbsolutePath());
			target.delete();
		}
	}
	
	public void printFiles(File target) {
		if(target.isFile()) {
			System.out.println(target.getAbsolutePath());
		}else if(target.isDirectory()) {
//			폴더 내부의 목록을 조회
			File[] children= target.listFiles();
			for(File child: children) {
//				System.out.println(child);
				this.printFiles(child);
			}
		}
	}
	
	public int sumToZero(int start) {
		if(start ==1) {
			return 1;
		}
		return start + sumToZero(start-1);
	}
	
	public void printNumber(int number) {
		System.out.println(number);
		if(number>0) {
			printNumber(number-1);
		}
	}
	
	public void print(int number) {
		System.out.println("출력"+number);
		if(number<3) {
			print(number+1);
			System.out.println(number+"스택을 실행완료했습니다.");
		}
	}

	public static void main(String[] args) {
		Recursive r =  new Recursive();
//		r.print(1);
//		r.printNumber(5);
		int result = r.sumToZero(5);
//		System.out.println(result);
		
		File root = new File("C:/dev_programs");
		File root2 = new File("C:\\Users\\yjt36\\Documents\\삭제대상");
		
//		r.printFiles(root);
		r.deleteFiles(root2);
	}
}
