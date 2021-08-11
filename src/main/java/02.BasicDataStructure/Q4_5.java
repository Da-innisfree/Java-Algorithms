package chap02;

import java.util.Scanner;

public class Q4_5 {
    //배열 b 요소를 a로 복사
    static void copy(int[] a, int[] b){

        for(int i =0; i<b.length; i++) {
            a[i] = b[i];
        }
    }

    static void rcopy(int[] a, int[] b){
        int num = b.length;
        for(int i=0; i<num; i++){
            a[num-i-1] = b[i];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("수를 정해주세요.");
        int num = stdIn.nextInt();
        int[] b = new int[num];
        int[] a = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("b["+i+"]의 값은? ");
            b[i] = stdIn.nextInt();
        }

        copy(a,b);
        for(int i=0; i<num; i++)
            System.out.print("a["+i+"]의 값은 "+a[i]+" ");
        System.out.println();

        for (int i=0; i<num; i++)
            System.out.print("b["+i+"]의 값은 "+b[i]+" ");
        System.out.println();

        rcopy(a,b);
        for(int i=0; i<num; i++)
            System.out.print("a["+i+"]의 값은 "+a[i]+" ");
        System.out.println();

        for (int i=0; i<num; i++)
            System.out.print("b["+i+"]의 값은 "+b[i]+" ");
    }
}
