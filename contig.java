// Program determines the max sum of a contiguos subsequence in a
// sequence of integers
// The max is determined in just one pass through the sequence. Thus,
// it works in linear time
// The idea: each time the current sum becomes negative, we start from
// Scratch with a new sum
// Program written by:   Marius Zimand
// Date: Jan. 31, 2018

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class contig {

    public static final int SIZE = 100;

    public static void main(String[] args) {

        int length;
        int[] a = new int[SIZE];
        length = read_values(a);
        int sum = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i <= length - 1; i++) {
            sum = sum + a[i];
            if (sum > max) {
                max = sum;
                end = i;
            } else if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        if (sum > 0) {
            System.out.println("max contig sum = " + max);
            System.out.println("initial index = " + start + ", final index = " + end);
        } else
            System.out.println("all numbers are negative");
    } // end function main

    public static int read_values(int a[]) {

        int length = -1;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String oneLine;
        StringTokenizer str;

        System.out.println("Enter the sequence of integers");
        try {
            oneLine = in.readLine();
            str = new StringTokenizer(oneLine);
            length = str.countTokens();
            System.out.println("No of elements " + length);
            for (int i = 0; i < length; i++) {
                a[i] = Integer.parseInt(str.nextToken());
                System.out.println("Element " + i + " = " + a[i]);
            }
        } catch (IOException e) {
            System.err.println("Unexpected error");
        }
        return length;
    } // end function read_values

} // end program Contig
