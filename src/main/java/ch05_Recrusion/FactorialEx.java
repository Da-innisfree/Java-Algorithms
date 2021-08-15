package ch05_Recrusion;

import java.util.Scanner;

class FactorialEx{
    static int factorialEx(int n){
        if(n==0)
            return 1;
        else {
            int result = n;
            for (int i = n-1; i > 0; i--) {
                result *=i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int x = stdIn.nextInt();

        System.out.println(x+"의 팩토리얼은 "+factorialEx(x)+"입니다.");
    }
}