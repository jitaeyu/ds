package exam;

public class BjExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 2;
		
		if(a>b) {
			System.out.println("Q1:>");
		}else if(a<b){
			System.out.println("Q1:<");
			
		}else {
			System.out.println("Q1: ==");
		}
	
		a=100;
		if(a>=90) {
			System.out.println("Q2: A");
		}else if (a>=80) {
			System.out.println("Q2: B");
		}else if (a>=70) {
			System.out.println("Q2: C");
		}else {
			System.out.println("Q2: F");
		}
		
		a=1999;
		if(a%4==0 && 0<a%100 ) {
			if(a%400 ==0) {
				System.out.println("Q3: 1");
			}else {
				System.out.println("Q3: 0");
			}
		}else {
			System.out.println("Q3: 0");
		}
		}
		
	

}
