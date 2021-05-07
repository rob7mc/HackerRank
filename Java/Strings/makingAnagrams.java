/*
    A student is taking a cryptography class and has found anagrams to be very useful. 
    Two strings are anagrams of each other if the first string's letters can be rearranged 
    to form the second string. In other words, both strings must contain the same exact 
    letters in the same exact frequency. For example, bacdc and dcbac are anagrams, but bacdc 
    and dcbad are not.

    The student decides on an encryption scheme that involves two large strings. The encryption 
    is dependent on the minimum number of character deletions required to make the two strings anagrams. 
    Determine this number.

    Given two strings, a and b, that may or may not be of the same length, determine the minimum number 
    of character deletions required to make a and b anagrams. Any characters can be deleted from either 
    of the strings.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    static int makeAnagram(String a, String b) {
        int count = 0;
        int[] arr = new int[26];
        for(int i=0; i<a.length(); i++){
            arr[a.charAt(i)-97]++;
        }
        for(int i=0; i<b.length(); i++){
            arr[b.charAt(i)-97]--;
        }
        for(int j=0; j<arr.length; j++){
            count += Math.abs(arr[j]);
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}