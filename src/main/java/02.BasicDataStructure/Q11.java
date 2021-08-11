package chap02;

import java.util.Scanner;

public class Q11 {
    int y;
    int m;
    int d;

    public Q11(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    //각 달의 일수
    static int[][] mdays = {
            {31,28,31,30,31,30,31,31,30,31,30,31}, //평년
            {31,29,31,30,31,30,31,31,30,31,30,31} //윤년
    };

    //서기 year년은 윤년인가? (윤년: 1, 평년: 0)
    static int isLeap(int year){
        return (year%4 ==0 && year%100 !=0 || year%400 ==0) ? 1:0;
    }

    Q11 after(int n){
        if(n<0 ) return before(-n);

        Q11 q = new Q11(this.y, this.m, this.d);
        q.d+= n;

        while (q.d > mdays[isLeap(q.y)][q.m]){
            q.d -= mdays[isLeap(q.y)][q.m];
            if(++q.m >12){
                q.y++;
                q.m =1;
            }
        }return q;

        }

        Q11 before(int n){
        Q11 q = new Q11(this.y, this.m, this.d);

        if(n<0) return after(-n);
        q.d -=n;

        while (q.d<1){
            if(--q.m <1){
                q.y--;
                q.m=12;
            }
            //if절에 포함되지 않아서 m-1
            q.d += mdays[isLeap(q.y)][q.m-1];
        }
        return  q;

    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("날짜를 입력하세요.");

        System.out.print("년: ");
        int y = stdIn.nextInt();
        System.out.print("월: ");
        int m = stdIn.nextInt();
        System.out.print("일: ");
        int d = stdIn.nextInt();

        Q11 q11 = new Q11(y,m,d);

        System.out.println("몇 일 앞/뒤의 날짜를 구할까요?: ");
        int n = stdIn.nextInt();

        Q11 date = q11.after(n);
        System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다. \n", n,date.y,date.m,date.d);

        Q11 date2 = q11.before(n);
        System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일입니다. \n",n, date2.y, date2.m, date2.d);
    }

}
