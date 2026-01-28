package report.store;

public class MartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mart mart = new Mart("상품", 5000, 10, 10000);
		
		int a= mart.sell("손님1", 10000);
	}

}
