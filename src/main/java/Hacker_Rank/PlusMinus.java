package Hacker_Rank;
import java.util.Scanner;

public class PlusMinus {
     static  int positive_count,negative_count,zero_count;
     static float positive,negative,zero;
     static int n;
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
            for(int i=0; i<=arr.length-1; i++){
                if(arr[i]>0){
                    positive_count++;

                }
                if (arr[i]<0){
                    negative_count++;
                }
                if(arr[i]==0){
                    zero_count++;
                }
            }
            System.out.println(positive_count+","+negative_count+","+zero_count);
            positive = (float) positive_count/n;
            System.out.printf("%f\n",positive);
            negative = (float)negative_count/n;
            System.out.printf("%f\n",negative);
            zero = (float)zero_count/n;
            System.out.printf("%f\n",zero);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
         n = scanner.nextInt();       // input array size
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" "); //  input array item
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);
        scanner.close();
    }
}
