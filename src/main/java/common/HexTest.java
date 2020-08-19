package common;
public class HexTest {

        public static void main(String args[]){
//            		0F 4D 61 69 6E 5F 44 6F 6F 72 5F 4F 70 65 6E
//				    10 4D 61 69 6E 5F 44 6F 6F 72 5F 43 6C 6F 73 65 00
//		String s = "0F 4D 61 69 6E 5F 44 6F 6F 72 5F 4F 70 65 6E 00"; //Main_Door_Open
//		String s= "10 53 61 66 65 5F 44 6F 6F 72 5F 43 6C 6F 73 65"; // Safe_Door_Close
//		String s ="0F 53 61 66 65 5F 44 6F 6F 72 5F 4F 70 65 6E 00 0A 44 75 72 61 63 65 5F 4F 4E 00"; //Safe_Door_Open
//		String s ="0A 44 75 72 61 63 65 5F 4F 4E 00 0F 4D 61 69 6E 5F 44 6F 6F 72 5F 4F 70 65 6E 00"; //Durace_ON
            String s = "50";
            s = s.replace(" ", "");
            HexadecimalToString(s);
        }

        public static String HexadecimalToString(String s) {
            String str = s;
            String result = new String();
            char[] charArray = str.toCharArray();
            for(int i = 0; i < charArray.length; i=i+2) {
                String st = ""+charArray[i]+""+charArray[i+1];
                char ch = (char)Integer.parseInt(st, 16);
                result = result + ch;
            }
            System.out.println(result);
            return result;
        }

}
