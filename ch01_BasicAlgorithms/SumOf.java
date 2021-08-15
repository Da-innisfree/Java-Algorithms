package chap01;

import java.util.Scanner;

public class SumOf {
    static int sumof(int a, int b){
        int s, l;

     if(a>b) {
          s = b;
          l = a;
     }else {
          s =a;
          l =b;
     }
        int sum =0;
        for (int i=s; i<=l; i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("a의 값은?");
        int a = stdIn.nextInt();
        System.out.println("b의 값은?");
        int b = stdIn.nextInt();

        int sum = sumof(a,b);
        System.out.println(a+"와"+b+"포함, 사이 값들의 합은 "+sum);

    }
}
