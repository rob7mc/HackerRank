/*
    You are given a phone book that consists of people's names and their phone number. 
    After that you will be given some person's name as query. For each query, print the 
    phone number of that person.

    Input Format:
    The first line will have an integer n denoting the number of entries in the phone book. 
    Each entry consists of two lines: a name and the corresponding phone number. 
    After these, there will be some queries. Each query will contain a person's name. 
    Read the queries until end-of-file.

    Sample Input:
    3
    uncle sam
    99912222
    tom
    11122222
    harry
    12299933
    uncle sam
    uncle tom
    harry

    Sample Output:
    uncle sam=99912222
    Not found
    harry=12299933
*/

import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
        Map<String, Integer> map = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
            map.put(name, phone);
		}
		while(in.hasNext())
		{
			String name = in.nextLine();
            Integer phone = map.get(name);
            if(phone!=null){
                System.out.println(name + "=" + phone);
            }
            else{
                System.out.println("Not found");
            }
		}
	}
}