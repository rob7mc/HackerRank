/*
  Given a 6x6 2D Array, arr:

  1 1 1 0 0 0
  0 1 0 0 0 0
  1 1 1 0 0 0
  0 0 0 0 0 0
  0 0 0 0 0 0
  0 0 0 0 0 0

  An hourglass in A is a subset of values with indices falling in this pattern in arr's 
  graphical representation:

  a b c
    d
  e f g

  There are 16 hourglasses in arr. An hourglass sum is the sum of an hourglass' values. Calculate 
  the hourglass sum for every hourglass in arr, then print the maximum hourglass sum. The array 
  will always be 6x6.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[] sums = new int[16];
        int k=0;

        for(int i=0; i<=3; i++){
            for(int j=0; j<=3; j++){
                sums[k++] = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
            }
        }
        
        //Arrays.sort(sums); // The function below is Arrays.sort(sums)
        for(int l=0; l<sums.length; l++){
            for(int m=l+1; m<sums.length; m++){
                if(sums[l]>sums[m]){
                    int temp = sums[l];
                    sums[l] = sums[m];
                    sums[m] = temp;
                }
            }
        }
        return sums[sums.length-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}