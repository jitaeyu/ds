package fp.basic.convert;

import java.util.function.Function;

public class Converter {

	public void printConvertResult2(String str, Function<String, Integer> function) {
		int result = function.apply(str);
		System.out.println(result);
	}
	
	public void printConvertResult(String str, Changer changer) {
		int result = changer.changeToInt(str);
//		System.out.println(result);
				
		
	}
}
