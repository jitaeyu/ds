package exam;

public class BjExam5 {

	public static void main(String[] args) {
		
		int a = 9;
		int b = -13;
		int quadrant =0;
		
		if(a>0) {
			if(b>0) {
				quadrant=1;
			}else {
				quadrant=4;
			}
		}else if (b>0) {
			quadrant =2;
		}else {
			quadrant=3;
		}
		System.out.println("Q4:"+quadrant);
//다음
		
		
		// TODO Auto-generated method stub
		int h = 10;
		int m = 10;
		int time = 0;
		int eTime = 45;
		
		time = (h*60)+m-eTime;
		
		System.out.println("Q3: "+time/60+"시 "+time%60);
		
//		-45
//
//		1. 분으로 환산. 
//		2. 환산값 -45
//		3. 결과값 시로 변환

		
//		다음
		
		a=17;
		b=40;
		int addTime=20;
		int sumTime = b+addTime;
		
		time=0;
		if(sumTime>=60) {
			a=a+(sumTime/60);
			b=sumTime%60;
			if(a>=24) {
				a=a-24;
			}
		}else {
			b=b+addTime;
		}
		
		System.out.println("Q5: "+ a+"시"+b+"분");
		
		
//		다음
//		1. 주사위는 1~6까지 3개있다
//		2. 3개 숫자가 다 같으면 10000 + 해당숫자 X 1000
//		3. 2개만 같을 시 1000+ 해당숫자 X 100
//		4. 모두 다르면 가장큰숫자 X 100

		a = 3;
		b = 3;
		int c = 6;
		int money=0;
		
	
		if(a==b && b==c) {
			money=10000+(a*1000);
			System.out.println("test: "+money);
		}else if(a==b || a==c || b==c) {
		}		
		
	}

}
