package chap01;

import java.util.Scanner;

public class DigitsNo {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int a;

        do{
            System.out.println("값을 입력하세요.");
            a = stdIn.nextInt();
        }while (a<=0);
        
       int num=0;

      // do{
       //    if(a<10) break;
       //    a = a/10;
       //    num++;
       //}while (a>0);

       while(a>0){
               a/=10;
               num++;
       }


       System.out.println("그 수는 "+num+"자리 입니다.");
    }

}
