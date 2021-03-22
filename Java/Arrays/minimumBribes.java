/*
    It is New Year's Day and people are in line for the Wonderland rollercoaster ride. 
    Each person wears a sticker indicating their initial position in the queue from 1 to n. 
    Any person can bribe the person directly in front of them to swap positions, but they still 
    wear their original sticker. One person can bribe at most two others.

    Determine the minimum number of bribes that took place to get to a given queue order. 
    Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        Boolean chaotic = false;
        int count = 0;
        for(int i=0; i<q.length; i++){
            if(q[i]-(i+1) > 2){
                chaotic = true;
                break;
            }
            for(int j=Math.max(0,q[i]-2); j<i; j++){
                if(q[j]>q[i]){
                    count += 1;
                }
            }
        }
        if(chaotic == true){
            System.out.println("Too chaotic");
        }
        else{
            System.out.println(count);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}