package chap02;

import java.util.Scanner;

public class Q3 {
    static int sumOf(int[] a){
        int sum=0;

        for(int i=0; i<a.length; i++){
            sum+=a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("값을 정해주세요.");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for(int i=0; i<num ; i++){
            System.out.print("x["+i+"]의 값: ");
            x[i] = stdIn.nextInt();
        }
        System.out.println("배열의 모든 요소의 합은 "+sumOf(x)+"입니다.");

    }
}
