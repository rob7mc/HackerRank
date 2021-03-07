/*
    Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. 
    Try to solve this problem using Arraylist.
    
    You are given n lines. In each line there are zero or more integers. You need to answer a few 
    queries where you need to tell the number located in yth position of xth line. 
    
    Take your input from System.in.

    Input Format:
    The first line has an integer n. In each of the next n lines there will be an integer d 
    denoting number of integers on that line and then there will be d space-separated integers. 
    In the next line there will be an integer q denoting number of queries. Each query will consist 
    of two integers x and y.

    Sample Input:
    5
    5 41 77 74 22 44
    1 12
    4 37 34 36 52
    0
    3 20 22 33
    5
    1 3
    3 4
    3 1
    4 3
    5 5

    Sample Output:
    74
    52
    37
    ERROR!
    ERROR!
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // First number given tells us how many lines to expect
        for(int i=0; i<n; i++){
            ArrayList<Integer> row = new ArrayList<>();
            int p = in.nextInt();
            for(int j=0; j<p; j++){
                row.add(in.nextInt());
            }
            rows.add(row);
        }
        
        int n2 = in.nextInt(); // This number tells us how many queries to expect
        for(int i=0; i<n2; i++){
            int q = in.nextInt() - 1; // -1 for index purposes
            int q2 = in.nextInt() - 1; // -1 for index purposes
            
            try{
                System.out.println(rows.get(q).get(q2));
            }
            catch(Exception e){
                System.out.println("ERROR!");
            }
        }
    }
}
