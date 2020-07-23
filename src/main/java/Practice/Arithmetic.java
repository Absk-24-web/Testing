package Practice;

import java.io.File;
import java.util.Scanner;

public class Arithmetic {

    public static void main(String[] args) {

        /*7*/
//        seven();

        /*31*/
//        thirtyOne();

        /*38*/
        String s = "Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33";
//        String s = "System.out.println(\"Java Class Path: \"+System.getProperty(\"java.class.path\")+\"\\n\")";
        count(s);

        /*39*/
//        thirtyNine();

        /*41*/
//        fortyOne();

        /*45*/
//        fortyFive();

        /*58*/
//        fiftyEight();

        /*61*/
//        reverse();

    }


    public static void seven() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(a + " X " + i + " = " + a * i);
        }
    }

    public static void thirtyOne() {
        System.out.println("\nJava Version: " + System.getProperty("java.version"));
        System.out.println("Java Runtime Version: " + System.getProperty("java.runtime.version"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
        System.out.println("Java Vendor URL: " + System.getProperty("java.vendor.url"));
        System.out.println("Java Class Path: " + System.getProperty("java.class.path")+"\n");
    }

    /*38*/
    public static void count(String x) {
        char[] ch = x.toCharArray();
        int letter = 0;
        int space = 0;
        int num = 0;
        int other = 0;
        for (int i = 0; i < x.length(); i++) {
            if (Character.isLetter(ch[i])) {
                letter++;
            } else if (Character.isDigit(ch[i])) {
                num++;
            } else if (Character.isSpaceChar(ch[i])) {
                space++;
            } else {
                other++;
            }
        }
        System.out.println(x);
        System.out.println("letter: " + letter);
        System.out.println("space: " + space);
        System.out.println("number: " + num);
        System.out.println("other: " + other);
    }

    public static void thirtyNine() {
        int amount = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (k != i && k != j && i != j) {
                        amount++;
                        System.out.println(i + "" + j + "" + k);
                    }
                }
            }
        }
        System.out.println("Total number of the three-digit-number is " + amount);
    }

    public static void fortyOne() {
        Scanner in = new Scanner(System.in);
        int ch = in.next().charAt(0);
        System.out.println(ch);

    }

    public static void fortyFive() {
        File f = new File("hs_err_pid5296.log");
        System.out.println("byte: " + f.length());
    }

    public static void fiftyEight() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String upper_case_line = "";
        Scanner lineScan = new Scanner(s);
        while (lineScan.hasNext()) {
            String word = lineScan.next();
            upper_case_line += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }
        System.out.println(upper_case_line.trim());

    }

    public static void reverse() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the word:-");
        String word = in.nextLine();
//        word = word.trim();
//        System.out.println(word);
        String result = "";
        char[] ch = word.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            result += ch[i];
//            System.out.println(result);
        }
        System.out.println("Reverse word: " + result.trim());

    }


}
