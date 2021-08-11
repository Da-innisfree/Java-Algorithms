package chap02;

import java.util.Scanner;

public class Q7 {
    static int cardCon(int a, int n, int[] cd){
        int digits =0;
        String dcahr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.printf("%2d |%5d",n,a);
        do{
            System.out.println("   +----------");


        }while (a!=0);

        return digits;

    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("10진수를 기수 변환합니다.");
        System.out.print("변환하는 음이 아닌 정수: ");
        int no = stdIn.nextInt();
        System.out.print("\n어떤 진수로 변환할까요? (2-36): ");
        int cd = stdIn.nextInt();

        int[] cno = new int[32];

        System.out.println(cd+" |    "+no);
        do{



        }while(no!=0);


    }
}
