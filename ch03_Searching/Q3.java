package ch03_Searching;

import java.util.Scanner;

public class Q3 {
    static int searchidx(int[] a, int n, int key, int[] idx){
        int num=0;
        for(int i=0; i<n; i++){
            if(a[i] ==key ) idx[num++] = i;
        }
        return  num;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("요솟수를 정해주세요");
        int array = stdIn.nextInt();

        int[] x = new int[array];
        for(int i=0; i< array; i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("key값은? ");
        int key = stdIn.nextInt();

        int[] idx = new int[array];

        System.out.println(searchidx(x,array,key,idx));
    }
}
