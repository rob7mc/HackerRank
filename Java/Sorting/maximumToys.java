/*
    Mark and Jane are very happy after having their first child. Their son loves toys, 
    so Mark wants to buy some. There are a number of different toys lying in front of him, 
    tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize 
    the number of toys he buys with this money. Given a list of toy prices and an amount to spend, 
    determine the maximum number of gifts he can buy.

    Note Each toy can be purchased only once.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        // Sort prices in ascending order
        /*
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[i] > prices[j]){
                    int temp = prices[i];
                    prices[i] = prices[j];
                    prices[j] = temp;
                }
            }
        }
        */
        
        // Sort prices in ascending order (More Efficient)
        for(int i=1; i<prices.length; i++){
            int j = i;
            int a = prices[i];
            while(j>0 && prices[j-1]>a){
                prices[j] = prices[j-1];
                j--;
            }
            prices[j] = a;
        }

        int total = 0;
        int count = 0;
        for(int i=0; i<prices.length; i++){
            if(total + prices[i] > k){
                break;
            }
            total = total + prices[i];
            count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}