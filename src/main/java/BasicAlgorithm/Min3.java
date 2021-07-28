package BasicAlgorithm;

import java.util.Scanner;

public class Min3 {
    static int min3(int a, int b, int c){
        int min = a;
        if(b<min) min= b;
        if(c<min) min= c;

        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b,c;
        System.out.println("a값은?");
        a= scanner.nextInt();
        System.out.println("b값은?");
        b= scanner.nextInt();
        System.out.println("c값은?");
        c= scanner.nextInt();

        int min = min3(a,b,c);
        System.out.println("최소값은:"+min);
    }
}
