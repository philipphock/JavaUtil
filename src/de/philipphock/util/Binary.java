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
	
	/**
	 * creates a byte array from a string that represents a binary string<br>
	 * <code>
	 * <pre>
	 *  ParityCheck p = new ParityCheck();
	 *	byte[] data = new byte[8];
	 *	StringBuilder sb = new StringBuilder();
	 *	sb.append("10001001");
	 *	sb.append("10001001");
	 *	sb.append("11111111");
	 *	sb.append("00000000");
	 *	sb.append("00001000");
		
	 *	byte[] bs = Binary.fromBinaryString(sb.toString());
	 *	String s = Binary.toBinaryString(bs, "\n", "0", "1", null);
	 *	System.out.println(s);
	 * </pre>
	 * </code>
	 *  outputs:
	 *  <pre>
	 *  10001001
	 *  10001001
	 *  11111111
	 *  00000000
	 *  00001000
	 *  </pre>
	 * @param s the string representing a binary string. Must be a multiple of 8
	 * @return the binary string
	 */
	public static byte[] fromBinaryString(String s){
		int bytelen = 8;
		int len =(int) Math.ceil(s.length()/8);
		byte[] ret = new byte[len];
		for (int i=0;i<ret.length;i++){
			int start = bytelen*i;
			ret[i] = byteFromBinaryString(s.substring(start,start+bytelen));
		}
		return ret;
	}
	
	/**
	 * creates a byte from a string, representing a byte.
	 * @param s the string. Must be a multiple of 8. If not, 0 is returned.
	 * 
	 * <code>
	 * <pre>
	 *  byte b = byteFromBinaryString("00001000");
	 *  // b is now 8
	 * </pre> 
	 * </code>
	 * 
	 * @return the byte
	 */
	public static byte byteFromBinaryString(String s){
		if (s==null || s.length() > 8){
			return 0;
		}
		byte ret = 0;
		for(int i=s.length()-1;i>=0;i--){
			char c = s.charAt(i);
			int op = 0;
			if (c == '1'){
				op = 1;
			}
			ret =  (byte) (ret | (op<<7-i));
			
		}
		return ret;
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
