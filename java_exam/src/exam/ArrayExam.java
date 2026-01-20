package exam;

public class ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int [] scoreArray = new int[7];
//		System.out.println(scoreArray);
//		String[] aa = new String[2];
//		System.out.println(aa);
//		Double[] bb = new Double[5];
//		
//		System.out.println(bb);

		int[] scoreArray = new int[7];
//		scoreArray[0] = 18;
//		scoreArray[1] = 22;
//		scoreArray[2] = 55;
//		scoreArray[3] = 66;
//		scoreArray[4] = 77;
//		scoreArray[5] = 88;
//		scoreArray[6] = 99;
//		int count =0;
		int count=0;
//		int random=0;
		while(scoreArray.length>=count) {
			for (int i = 0; i < scoreArray.length; i++) {
				scoreArray[i] = (int)(Math.random()*99+1);
//				System.out.println(i);
				for (int j = 1; j < scoreArray.length; j++) {
					if(scoreArray[i]==scoreArray[j]) {
						if(i>0) {
							i--;
						}
					}else {
						count++;
						
					}
					
				}
			}
		}
			for (int i = 0; i < scoreArray.length; i++) {
				scoreArray[i] = (int)(Math.random()*99+1);
			}
			
		
		
//		for (int i = 0; i < scoreArray.length; i++) {
//			System.out.print(" "+scoreArray[i]);
//		}
		
		
		
		
	}

}
