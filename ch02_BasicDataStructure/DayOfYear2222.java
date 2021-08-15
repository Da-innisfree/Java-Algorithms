package chap02;

import java.util.Scanner;

public class DayOfYear2222 {
    //각 달의 일수
    static int[][] mdays = {
            {31,28,31,30,31,30,31,31,30,31,30,31}, //평년
            {31,29,31,30,31,30,31,31,30,31,30,31} //윤년
    };

    //서기 year년은 윤년인가? (윤년: 1, 평년: 0)
    static int isLeap(int year){
        return (year%4 ==0 && year%100 !=0 || year%400 ==0) ? 1:0;
    }

    //서기 y년 m월 d일의 그 해 경과 일 수를 구함
    static int dayOfYear(int y, int m, int d){
        int days =d;

        for(int i=1; i<m; i++) //1월~ m-1월의 일 수를 더함
            days+= mdays[isLeap(y)][i-1];
        return days;
    }

    public static void main(String[] args) {
     System.out.println(mdays[0][0]);
    }
}
