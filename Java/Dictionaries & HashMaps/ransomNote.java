/*
    Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced 
    back to him through his handwriting. He found a magazine and wants to know if he can cut 
    out whole words from it and use them to create an untraceable replica of his ransom note. 
    The words in his note are case-sensitive and he must use only whole words available in the 
    magazine. He cannot use substrings or concatenation to create the words he needs.

    Given the words in the magazine and the words in the ransom note, print Yes if he can 
    replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        if(note.length > magazine.length){
            System.out.println("No");
            return;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : magazine){
            if(!map.containsKey(s)){
               map.put(s, 1); 
            }
            else{
               map.put(s, map.get(s) + 1); 
            }
        }
        
        for(String s : note){
            if(map.containsKey(s)){
                if(map.get(s) - 1 < 0){
                    System.out.println("No");
                    return;
                }
                map.put(s, map.get(s) - 1);
            }
            else{
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}