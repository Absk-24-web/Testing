package common.Expression;

import java.util.Stack;

public class StackBrackets {

//    public static void main(String[] args) {
//        System.out.println("Enter the Expression:-");
//        Scanner scan = new Scanner(System.in);
//        String in = scan.nextLine();
//        char[] exp = new char[in.length()];      //{,{,(,),},],}  {,[,{,(,),},],}  {8*[5*[4*5]*(2+4)*4]/5}
//        for (int i = 0; i < in.length(); i++)
//            exp[i] = in.charAt(i);
//
//        if (checkBrackets(exp))
//            System.out.println("Balanced ");
//        else
//            System.out.println("Not Balanced ");
//    }


    public static boolean checkBrackets(char[] exp){
        Stack<Character> stack = new Stack<>();

        for (char c : exp) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }
            if (c == ']' || c == ')' || c == '}') {

                if (stack.isEmpty()) {
                    return false;
                } else if (!isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); /*balanced*/
    }

    private static boolean isMatchingPair(char char1, char char2) {
        if (char1 == '(' && char2 == ')')
            return true;
        else if (char1 == '{' && char2 == '}')
            return true;
        else if (char1 == '[' && char2 == ']')
            return true;
        else
            return false;
    }
}

