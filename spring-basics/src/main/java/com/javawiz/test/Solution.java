package com.javawiz.test;

import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        
        String s = scanner.nextLine();
        
        String[] arrItems = s.split(" ");
        
        if(n == arrItems.length) {
        	System.out.println(arr.length);
            System.out.println(s);
            for (int i = n-1; i >= 0; i--) {
				System.out.print(arrItems[i]+" ");
			}
        }
        System.out.println(Math.pow(2, 3));
        scanner.close();
    }
}
