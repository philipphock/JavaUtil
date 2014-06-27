package de.philipphock.util;
/**
 * Byte Utility Class
 * @author Philipp Hock, mail@philipphock.de
 *
 */
public class Binary {
	
	/**
	 * Creates a Binary String for a given bytearray, if sb is null, the String will be returned, otherwise, sb is used, null will be returned
	 * @param b the byte to visualize
 	 * @param byteSplitter the String between each array element in visualization
	 * @param zero how zeros are visualized
	 * @param one how ones are visualized
	 * @param sb if null, the value will be returned, otherwise the result will be appended to sb and null will be returned
	 * @return null if sb is not null, the visualized bytearray if b is null
	 */
	public static String toBinaryString(byte[] b,String byteSplitter,String zero, String one, StringBuilder sb){
		boolean noreturn = true;
		if (sb == null){
			noreturn = false;
			sb = new StringBuilder();
		}
		
		for (int i = 0;i<b.length;i++){
			Binary.toBinaryString(b[i], "0", "1",sb);
			sb.append(byteSplitter);
		}
		
		if (noreturn){
			return null;
		}else{
			return sb.toString();
		}
	}
	
	/**
	 * Creates a Binary String for a given byte, if sb is null, the String will be returned, otherwise, sb is used, null will be returned
	 * @param b the byte to visualize
	 * @param zero how zeros are visualized
	 * @param one how ones are visualized
	 * @param sb if null, the value will be returned, otherwise the result will be appended to sb and null will be returned
	 * @return null if sb is not null, the visualized byte if b is null
	 */
	public static String toBinaryString(byte b,String zero, String one,StringBuilder sb){
		boolean noreturn = true;
		if (sb == null){
			noreturn = false;
			sb = new StringBuilder();
		}
		for (int i=7;i>=0;i--){
			if ( ((b>>i) & 1) == 1){
				sb.append(one);
			}else{
				sb.append(zero);
			}
		}
		if (noreturn){
			return null;
		}else{
			return sb.toString();
		}
	}
	
//	public static void main(String[] args) {
//		byte[] b = {0,1};
//		StringBuilder sb = new StringBuilder();
//		Binary.toBinaryString(b, " ","0", "1",sb);
//		System.out.println(sb.toString());
//	}
	
//	public static void main(String[] args) {
//		byte[] b = {0,1};
//		String s = Binary.toBinaryString(b, " ","0", "1",null);
//		System.out.println(s);
//	}
}
