package exam;

public class TypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//84~87
//		 묵시적형변환
		int num = 10;
		float fnum = num;
		double dnum = num;

		System.out.println(num);
		System.out.println(fnum);
		System.out.println(dnum);
		System.out.println();
		
//		명시적 형변환
		
		float fnum1 = 10.9f;
		int num1 = (int)fnum;
		System.out.println(fnum1);
		System.out.println(num1);
		
		double dnum1 = 11.15;
		num1=(int)dnum1;
		System.out.println(dnum1);
		System.out.println(num1);
		System.out.println();
		
//		소수점 처리
		double dnum2 = 10.1;
		dnum2 = Math.ceil(dnum2);
		System.out.println(dnum2);//올림
		
		dnum2=10.9;
		dnum2 = Math.floor(dnum2);
		System.out.println(dnum2);//내림
		
		dnum2=15.18;
		dnum2=Math.round(dnum2);
		System.out.println(dnum2);//반올림
		
		dnum2 = 10.56;
		dnum2 = Math.round(dnum2);
		System.out.println(dnum2);//반올림
		System.out.println();
		
		double dnum3=29.37;
		double dnum4 = dnum3*10;
		System.out.println(dnum4);
		
		dnum4 = Math.round(dnum4);
		System.out.println(dnum4);
		
		double dnum5 = dnum4/10;
		System.out.println(dnum5);
		
	}

}
