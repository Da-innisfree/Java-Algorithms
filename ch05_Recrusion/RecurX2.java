package ch05_Recrusion;

import ch04_StackAndQueue.IntStack;

import java.util.Scanner;

public class RecurX2 {
    static void recur3(int n){
        IntStack s = new IntStack(n);
        while (true) {
            if (n > 0) {
                s.push(n);
                n = n - 1;
                continue;
            }
            if (s.isEmpty() != true) {
                n= s.peek();
                n= n-2;
                if(n<=0)
                System.out.println(s.pop());
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수를 입력해주세요. ");
        int x = stdIn.nextInt();

        recur3(x);

    }
}
