package fp.basic.calc;

public class Test {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		//num1 num2를 더해 반환한다.
		int result = calc.calc2(1,2,( a, b)->{return a+b;});
//		int result = calc.calc(1,2,( a, b)-> a+b);
		//num1 num2의 제곱한 수 반환
		int result2 = calc.calc2(2,2,(num1, num2)->{return num1*num2;});
		
//		num1과 num2중 큰수를 반환
		int result3 = calc.calc2(3,4,(nb1,nb2)->{
			int big;
			if(nb1>=nb2) {
				big=nb1;
			}else {
				big =nb2;
			}
			return big;
		});
		
//		num1이 num2의 배수라면 0을 반환 아니라면 1을반환
		int result4 = calc.calc2(4,2, (num1,num2)->{
			if(num1%num2==0) {
				return 0;
			}
			return 1;
		});
		
//		System.out.println(result);
		System.out.println(result3);
		System.out.println(result4);
		
	}
}
