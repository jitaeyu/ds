package exam;

public class Variables1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 중요한 타입 ( int,long,float,double, boolean)
//		나이가 몇살인지 구해보는 나이 계산기
//		현재 연도 - 나의 생년(2026-1996+1)
		{
			int nowYear = 2026;
			int myBirthYear = 1996;
			int myAge = nowYear-myBirthYear+1;
			System.out.println("나이:"+myAge);
			
			long price = 1000;
			long buildingPrice = 10_000_000_000L;
			
			float ratio = 5.1111F;
			
			
			int a = (int)1L ;
			
//			byte num = (byte) 128;
			int num = Integer.MAX_VALUE;
			num=num+1;
			System.out.println(num);
			
			byte bNumber = 127;
			bNumber = (byte) (bNumber+1);
			System.out.println(bNumber);
			
			System.out.println(10L + 3.5F);
			
			System.out.println((float)10/3);
		}
		System.out.println("끝!");
		
		
	}

}
