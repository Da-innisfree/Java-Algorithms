package chap01;

import java.util.Scanner;

public class Med3 {
    static int med3(int a, int b, int c){
        if(a>=b)
            if(b>=c)
                return b;
            else if(c>=a)
                return a;
            else return c;
        else if(a>=c)
            return a;
        else if(b>=c)
            return c;
        else return b;

    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int a,b,c;
        System.out.println("a>b>c"+med3(5,4,3));
        System.out.println("a>b=c"+med3(5,3,3));
        System.out.println("a=b>c"+med3(5,5,3));
        System.out.println("a=b=c"+med3(3,3,3));
        System.out.println("a>c>b"+med3(5,3,4));

        System.out.println("b>a>c"+med3(4,5,3));
        System.out.println("b>c>a"+med3(3,5,4));
        System.out.println("b>c=a"+med3(3,5,3));

        System.out.println("c>a>b"+med3(4,3,5));
        System.out.println("c>a=b"+med3(3,3,5));
        System.out.println("c=a>b"+med3(5,3,5));
        System.out.println("c>b>a"+med3(3,4,5));
        System.out.println("c=b>a"+med3(3,5,5));
    }
}
