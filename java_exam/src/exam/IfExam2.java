package exam;
public class IfExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int korScore = 90;
		int engScore = 88;
		int mathScore = 70;
		int progScore =80;
		
		int sum,average =0;
		sum=korScore+engScore+mathScore+progScore;
		average = sum/4;
		System.out.println("합: " + sum );
		System.out.println("평균: "+ average);
		
		if(average>= 95) {
			System.out.println("학점은 A+ 입니다.");
		}else if(average>=90) {
			System.out.println("학점은 A 입니다.");
		}else if(average>=85) {
			System.out.println("학점은 B+ 입니다.");
		}else if(average>=80) {
			System.out.println("학점은 B 입니다.");
		}else if(average>=75) {
			System.out.println("학점은 C 입니다.");
		}else if(average>=70) {
			System.out.println("학점은 F 입니다.");
		}
		
		
		
	}

}
