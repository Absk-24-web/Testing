package Hacker_Rank;

import java.util.Scanner;

public class PlusMinusSum {
        public static long sum;
        public static long min = Long.MAX_VALUE;
        public static long max = 0;
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            long curr = arr[i];
            if(max < curr)
            {
                max = curr;
            }
            if(min > curr)
            {
                min = curr;
            }
            sum = sum +curr;
        }
        long minSum = sum - max;
        long maxSum = sum - min;
        System.out.println(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        miniMaxSum(arr);
        scanner.close();
    }
}
