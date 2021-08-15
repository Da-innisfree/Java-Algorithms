package chap01;

import java.util.Scanner;

public class SumWhileI {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("i의 값을 출력합니다.");
        System.out.print("n의 값: ");
        int n = stdIn.nextInt();

//        int sum = 0;
        int i=0;

        while ( i<=n){
           // sum +=i;
            i++;
            System.out.println(i);
        }
    }
}
