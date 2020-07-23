package Hacker_Rank;

import java.util.Scanner;

public class Day25 {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int T = in.nextInt();

        //for (int i = 0; i < T; i++) {
        while (true) {
            String str = in.next();
            if(str.equals("exit"))
                break;
            try{
                int n = Integer.parseInt(str);
                if (n >= 2 && isPrime(n))
                    System.out.println("Prime");
                else System.out.println("Not prime");
            }
            catch (Exception e){
                System.out.println("Invalid input:- " + str);
            }
            //}
        }
    }
}
