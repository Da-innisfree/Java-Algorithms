package chap01;

import java.util.Scanner;

public class Max4 {

    static int max4(int a, int b, int c, int d){
        int max = a;
        if(b>max) max =b;
        if(c>max) max=c;
        if(d>max) max =d;

        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a,b,c,d;
        System.out.println("a의 값?");
        a= scan.nextInt();
        System.out.println("b의 값?");
        b= scan.nextInt();
        System.out.println("c의 값?");
        c= scan.nextInt();
        System.out.println("d의 값?");
        d= scan.nextInt();

       int max =  max4(a,b,c,d);
       System.out.println("최대값은 "+max);
    }
}
