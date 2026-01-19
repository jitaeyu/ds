package exam;

import java.util.Scanner;


public class UpDownGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		Scanner sc = new Scanner(System.in);
//		
//		int inputNumber =0;
//		while (inputNumber<=100) {
//			inputNumber = sc.nextInt();
//			System.out.println(inputNumber);
//		}
//		System.out.println("exit");
		
//		Scanner sc = new Scanner(System.in);
//		int value= 0;
//		int answer=0;
//		while(true) {
//			System.out.println("Input Number");
//			value=sc.nextInt();
//			if(answer == value) {
//				System.out.println("정답");
//				break;
//			}else if(answer>value) {
//				System.out.println("up");
//			}else {
//				System.out.println("down");
//			}
//		}
		
//		int i =0;
//		int n = 8;
//		int inputNumber = 2;
//		while(i<=n) {
//			++i;
//			System.out.println("2 x "+i+"=" +inputNumber*i);
//		}
		
		
//		int n = 3;
//		int i = 0;
//		int sum=0;
//		while (i<n) {
//			i++;
//			sum = sum+i;
//			System.out.println("합:"+sum);
//		}
		
//		int n = 20;
//		int i = 0;;
//		while(true) {
//			i++;
//			if(1<=n/4) {
//				System.out.print("long ");
//			}
//			if(i>n/4) {
//				break;
//			}
//		}
//		System.out.println("int");
//		
//		int n = 5;
//		int i =0;
//		
//		while (i<=n-1) {
//			i++;
//			int j =1;
//			while (i>=j) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println("");
//			
//		}
		
		int n = 5;
		int i = 0;
		String temp = "ㅎ";
		String temp2 = "  ";
		while(i<=n) {
			i++;
//			System.out.print("TT:"+(n-i)+":TT");
			System.out.println(n-i);
			int v=n-1;
			while(true) {
				System.out.print(temp2);
				v++;
				if(n-1>=0) {
					break;
				}
			}
			
			System.out.println("*");
			int j =0;
			while(i>=j) {
				System.out.print(temp);
				j++;
				
			}
		}
		
		
	}


}
