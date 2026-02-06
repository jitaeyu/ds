package fp.basic.stream.advanced;

public abstract class ArrayUtil {

	private ArrayUtil() {}
	
	public static String getValue(String[] array, int index) {
		if(0<=index && array.length>index) {
			String value = array[index];
			if(value != null) {
				value = value.replace("\"","");
			}
//			return array[index];
			return value;

		}
		return null;
	}
}
