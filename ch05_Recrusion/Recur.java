package ch05_Recrusion;

import java.util.Scanner;

public class Recur {

    static void recur(int n){
        if(n>0){
            recur(n-1);
            System.out.println("recur()");
            System.out.println(n);
            recur(n-2);
        }
    }
    static void recur2(int n){
        if(n>0){
            recur2(n-2);
            System.out.println("recur2()");
            System.out.println(n);
            recur2(n-1);
        }
    }
    //하향식 분석(top-down analysis) int n=4 / 2141321
/*
                            recur2(4)
                    recur2(2)/4/ recur2(3)
    recur2(0)/2/recur2(1)           recur2(1)/3/recur2(2)
        recur2(-1)/1/recur2(0)  recur2(-1)/1/recur2(0)  recur2(0)/2/recur2(1)
*/

    //상향식 분석(bottom-up analysis) int n=4
  /*  recur2(0), recur2(-1) : 아무것도 하지 않음
    recur2(1): recur2(-1)/1/recur2(0)
    recur2(2): recur2(0)/2/recur2(1)
    recur2(3): recur2(1)/3/recur2(2)
    recur2(4): recur2(2)/4/ recur2(3)    */

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 ");
        int x = stdIn.nextInt();

        recur(x);
        recur2(x);
    }
}
