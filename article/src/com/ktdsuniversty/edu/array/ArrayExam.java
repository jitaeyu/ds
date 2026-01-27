package com.ktdsuniversty.edu.array;

import java.util.Arrays;

public class ArrayExam {

	public void array01() {
		int[] numarray = {1,4,1,2,5,2,4,2,3,4,4};
		int findNum = 2;
		int count = 0;
		for (int i = 0; i < numarray.length; i++) {
			count++;
		}
		
		System.out.println(count);
	}
	
	public void array02() {
		int [] numArray = {1,10,4,9,2,3,8,5,7,6};
		int baseNum=5;
		for (int i = 0; i < numArray.length; i++) {
			if(numArray[i]<baseNum) {
				System.out.println(numArray[i]+" ");
			}
		}
	}
	
	
	
	public void arrayPg01() {
		String[] arr = {"a","b","c"};
		String result = "";
		
		for (int i = 0; i < arr.length; i++) {
//			if() {
//				
//			}
		}
	}
	
	public void arrayPg02() {
		int [] numList = {12,4,15,46,38,1,14,56,32,10};
		
		
		for (int i = 0; i < numList.length; i++) {
			 for (int j = i+1; j < numList.length; j++) {
//				System.out.println(numList[i]+"와 비교중인숫자는"+numList[j]);
				if(numList[i]>numList[j]) {
					int a = numList[i];
					numList[i]=numList[j];
					numList[j]=a;
				}
			 }
			 int[] result = new int [numList.length-5];
			 for (int k = 5; k < numList.length; k++) {
				result[k-5] = numList[k];
				
			}
//			 for (int k : result ) {
//					System.out.print(" "+k);
//			 }		
		}
		System.out.println();
		 
	}
	
	public void arrayQ01() {
//		최솟값과 최댓값을 구하는 프로그램을 작성하시오.첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.7 35
		int [] numList= {20,10,35,30,7};
		for (int i = 0; i < numList.length; i++) {
			for (int j = 0; j < numList.length; j++) {
				if(numList[i]<numList[j]) {
					int temp= numList[i];
					numList[i]=numList[j];
					numList[j]=temp;
				}

			}
		}
		System.out.println("Q1: "+numList[0]+" "+numList[numList.length-1]);
	}
	
	public void arrayQ02() {
	int [] numList= {3, 29, 38, 12, 57, 74, 40, 85, 61};
	int [] numList2=numList;
	int max=numList[numList.length-1];
	Arrays.sort(numList);
	int as=Arrays.binarySearch(numList2, max);
//	System.out.println(Arrays.toString(numList));
	System.out.println("Q2: "+numList[numList.length-1]+" "+as);
//	Arrays.binarySearch()
//	int max = Arrays.binarySearch(numList, max);
//	for (int i = 0; i < numList.length; i++) {
//		if(numList[i]) {
//			
//		}
//		
//	}
	
	}
	
	public void arrayQ03() {
		int [] numList={1,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		Arrays.sort(numList);
		System.out.print("Q3: ");
		for (int i = 0; i < numList.length-1; i++) {
			if((numList[i]-numList[i+1])==-1) {
			}else {
				System.out.print(" "+(numList[i]+1));
			}
		}
		
	
	}
	
	public static void main(String[] args) {
		ArrayExam array = new ArrayExam();
		array.arrayQ01();
		array.arrayQ02();
		array.arrayQ03();
//		int [] numArray = new int[10];
//		numArray[0] = 10; //1
//		
//		String[] strArray = new String[] {"A","B","C"};//2
//		String[] strArray2= {"A","B","C"};//3
//		
//		array.arrayPg02();
	}
}
