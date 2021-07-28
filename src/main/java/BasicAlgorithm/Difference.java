package BasicAlgorithm;

import java.util.Scanner;

public class Difference {
    //정수체크는?
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int a, b;
        System.out.println("a값은?");
        a = stdIn.nextInt();

        do{
            System.out.println("b값은?");
            b = stdIn.nextInt();
            if(b>a)
                break;
            System.out.println("a보다 큰 값을 입력하세요!");
        }while (true);
        System.out.println("b-a는 "+(b-a)+"입니다.");
    }
}
