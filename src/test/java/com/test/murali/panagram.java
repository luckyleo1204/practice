package com.test.murali;

import java.util.Scanner;

public class panagram {
    public static void main(String[] args) {

        //pack my box with five dozen liquor jugs

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
//reads a string from the user
        String str = sc.nextLine();
//determines the length of the string
        int n=str.length();
        int freq[] = new int[26];
//loop iterate over all the characters
        for(int i=0;i<26;i++)
        {
//initially, each character marked with index 0
            freq[i]=0;
        }  //end of for loop
//loop iterate over the given string
        for(int i=0;i<n;i++)
        {
            if(str.charAt(i)!=' ')
            {
//subtract 'a' from the character at the specified index and increment the freqency index by 1
//means that chracter is marked
                freq[str.charAt(i)-'a']++;
            }  //end of if
        }  //end of for loop
        int temp=0;
        for(int i=0;i<26;i++)
        {
//if frequency index is 0, means character is unmarked
            if(freq[i]==0)
            {
//set temp to 1 and break the loop
                temp=1;
                break;
            }
        }  //end of for loop
//if condition is true, the string is pangram string, else not pangram
        if(temp==1)
        {
            System.out.println("The string is not a pangram string.");
        }
        else
        {
            System.out.println("The string is a pangram string.");
        }

}
}
