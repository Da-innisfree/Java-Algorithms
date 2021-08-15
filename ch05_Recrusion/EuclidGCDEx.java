package ch05_Recrusion;

import java.util.Scanner;

public class EuclidGCDEx {
    static int euclidGCDEx(int x, int y) {
        while(true) {
            if (y == 0)
                break;
            if (y > 0) {
                int z = y;
                y = x % y;
                x=z;
                continue;
            }
    break;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요: ");
        int y = stdIn.nextInt();
        System.out.println("최대공약수는 "+euclidGCDEx(x,y)+"입니다.");
    }
}
