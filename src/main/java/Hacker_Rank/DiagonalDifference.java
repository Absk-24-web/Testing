package Hacker_Rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
public class DiagonalDifference {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int result = Result.diagonalDifference(arr);
            System.out.println(result);
    }
}

class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int result,a = 0,b = 0;
        for(int i=0; i<arr.size();i++){
            for (int j=0;j<arr.size();j++) {
                if (i == j)
                    a = a + arr.get(i).get(j);
                if (i == arr.size() - j - 1)
                    b = b + arr.get(i).get(j);
            }
        }
                result = Math.abs(a-b);
        return result;
    }

}