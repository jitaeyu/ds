package java_exam;

public class MethodExam {
	
	public static int computeAdd(int number1, int number2){
		int computeResult = number1+number2;
		
		return computeResult;
	}
	
	public static void printMyname(String name) {
		System.out.println("이름은 "+name+"입니다");
	}
	
	public static void printSum(int number) {
		int sum=0;
		for(int i=1; i<= number; i++) {
			sum+=i;
		}
		System.out.println("Q1:"+sum);
	}
	
	public static void printPrime(int number) {
		System.out.print("Q2:");
		for (int i = 2; i <= number; i++) {
			   
            int j;
            for (j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                	//나머지가 0이면 합성수
                	break;
                	
                }
            }
            if (j * j > i) {
                System.out.print(" "+i);
            }
        }
	}
	
	public static void printMax(int number1,int number2) {
		System.out.println();
		int a=number1;
		int b=number2;
		int temp;
		if(a>b) {
			temp=a;
		}else {
			temp=b;
		}
		System.out.println("Q3: "+temp);
	}
	
	
	public static void printAge(int number) {
		String temp;
		
		if(19<=number) {
			temp="성인";
		}else {
			temp="미성년";
		}
		System.out.println("Q4: "+temp);
	}
	
	private static String getFizzBuzz(int number1) {
		String temp;
		
		if(3%number1==0 && 5%number1==0) {
			temp="FizzBuzz";
		}else {
			if(3%number1==0) {
				temp="Q:5 Fizz";
			}else if (5%number1==0) {
				temp="Q:5 Buzz";
			}else {
				temp=String.valueOf(number1);
			}
		}
		return temp;
		
	}
	
	public static int[] getUniqueNumbers() {


		int[] lottoNums = new int[7];
			
			int count = 0; // 배열에 채워진 숫자의 개수.
			boolean existsNumber = false; // 새롭게 만든 숫자가 배열내에 존재하는지 여부.
			int randomNumber = 0; // 새롭게 만들 숫자 1 ~ 45중 하나.
			
			while (count < 7) { // 배열에 숫자가 7개가 채워질 때까지 반복.
				randomNumber = (int) (Math.random() * 45 + 1);
				existsNumber = false;
				
				// 새롭게 만든 숫자가 배열에 존재하는지 확인.
				for (int i = 0; i < count; i++) {
					if (lottoNums[i] == randomNumber) {
						existsNumber = true;
						break;
					}
				}
				
				// 새롭게 만든 숫자가 배열에 없다면, 배열에 추가한다.
				if (!existsNumber) { 
					lottoNums[count] = randomNumber;
					count++; // 배열에 채운 숫자 하나 증가.
				}
			}
			
			
		return lottoNums;
		
	}
	
	public static String getEvenOdd(int number1,int number2) {
		String temp;
		int su = number1*number2;
		if(su%2==0) {
			temp="짝수";
		}else {
			temp="홀수";
		}
		
		return temp;
		
	}
	
	public static int getSumOfFive(int number1,int number2,int number3,int number4,int number5) {
		int temp=0;
		
		temp=number1+number2+number3+number4+number5;
		
		return temp;
	}
	
	public static double getAverage(int number1,int number2) {
		double temp= number1/number2;
		
		
		
		return temp;
		
	}
	
	public static String getGrage(int number) {
		String temp;
		
		if(number>=95) {
			temp="A";
		}else if (number>=85) {
			temp="B";
		}else if (number>=75) {
			temp="C";
		}else if (number>=65) {
			temp="D";
		}else{
			temp="F";
		}
		
		return temp;
	}
	
	public static String nextChar(char c) {
		String temp;
		int pp = c+1;
		char ch = (char)pp;
		temp=Character.toString(ch);
		return temp;
		
	}
	
	public static void main( String[] args) {
		printSum(10);
		printPrime(20);
		printMax(50,20);
		printAge(20);
		printAge(15);
		
		String a=getFizzBuzz(3);
		System.out.println(a);
		
//		
		
		getUniqueNumbers();
		
		int[] bb= new int[7];
		bb=getUniqueNumbers();
		System.out.print("Q6: ");
		for (int i = 0; i < bb.length; i++) {
			System.out.print(bb[i] + " ");
		}
		System.out.println();
		String dap =getEvenOdd(4,5);
		String dap2 =getEvenOdd(3,5);
		System.out.println("Q7: "+dap);
		System.out.println("Q7: "+dap2);
		
		int hap =getSumOfFive(1,2,3,4,5);
		System.out.println("Q8: "+hap);
		
		double average =getAverage(150,3);
		System.out.println("Q9: "+average);
		
		String rank = getGrage(95);
		System.out.println("Q10: "+rank);
		
		String next = nextChar('f');
		System.out.println("Q11: 입력값의 다음은: "+next);
	}
	
}
