package report;

public class Report0119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2 부터 100,000 까지의 숫자 중 소수(Prime Number : 약수가 1과 자신만 있는 수)만 출력하는 프로그램을 작성해 
//		본인의 Git Repository에 Push하고 Repository 주소를 댓글로 등록하세요.
		
//		소수는 제곱을 넘을수없다(ex 5 x 5 = 25 비교값은 25를넘을수없음)
		   for (int i = 2; i <= 500; i++) {
			   
	            int d;
	            for (d = 2; d * d <= i; d++) {
	            	System.out.println("t:"+d);
	                if (i % d == 0) {
	                	//나머지가 0이면 합성수
	                	break;
	                	
	                }
	            }
	            if (d * d > i) {
	                System.out.println(i);
	            }
	        }
		
	}

}
