package Practice;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Pattern pattern =new Pattern();;
        pattern.simplePatten();
    }

    public void simplePatten(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the limit:-");
        int limit = scan.nextInt();
        for(int i=1; i<=limit; i++){
            for(int j=1; j<=limit; j++){
                if(j<=i){
                    System.out.println("*");
                }
                else{
                    System.out.println(" ");
                }
            }
            System.out.println();
        }
    }
}
