package chap01;

import java.util.Scanner;

public class Square_14 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("삼각형을 출력합니다.");
        System.out.print("단 수: ");
        int a = stdIn.nextInt();

        for(int i=1; i <=a; i++){
            for(int j=1; j<=a; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
