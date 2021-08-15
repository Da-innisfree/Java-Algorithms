package chap02;

import java.util.Scanner;

public class Q9 {

    static int[][] mdays ={
            {31,28,31,30,31,30,31,31,30,31,30,31},
            {31,29,31,30,31,30,31,31,30,31,30,31}
    };

    //서기 year년은 윤년인가? (윤년: 1, 평년: 0)
    static int isLeap(int year){
        return (year%4==0 && year%100 !=0 || year%400 ==0) ? 1: 0;
    };

    static  int leftDayOfYear(int y, int m, int d){

        while (--m !=0){
            d  += mdays[isLeap(y)][m];
        }
        return 365- d +isLeap(y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int retry;

        System.out.println("남은 일수 구하기");

        do{
            System.out.print("년:");
            int year = stdIn.nextInt();
            System.out.print("월: ");
            int month = stdIn.nextInt();
            System.out.print("일: ");
            int day = stdIn.nextInt();

            System.out.printf("연내 남은 일자는 %d일입니다.\n", leftDayOfYear(year,month,day));

            System.out.print("한 번 더 할까요? (1.예 / 0.아니오)");
            retry = stdIn.nextInt();
        }while (retry==1);
    }
}