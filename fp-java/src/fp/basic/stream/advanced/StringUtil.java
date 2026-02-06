package fp.basic.stream.advanced;

public abstract class StringUtil {

	private StringUtil() {}
	
	public static int toInt(String str) {
		if(str==null) {
			return 0;
		}
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}
}
