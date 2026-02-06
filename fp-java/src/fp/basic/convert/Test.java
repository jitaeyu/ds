package fp.basic.convert;

public class Test {

	public static void main(String[] args) {
		
		Converter converter = new Converter();
//		숫자로 변환한 결과를 반환한다
		converter.printConvertResult2("10",(a)->Integer.parseInt(a));
		converter.printConvertResult2("12",Integer::parseInt);
		converter.printConvertResult2("asdsa",str->str.length());
		converter.printConvertResult2("asdsa",String::length);
		
		
	}
}
