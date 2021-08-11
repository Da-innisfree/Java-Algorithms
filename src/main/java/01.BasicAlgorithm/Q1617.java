package BasicAlgorithm;

import java.util.Scanner;

public class Q1617 {
    static  void spira(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=(i-1)*2+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void npira(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i+1; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=(i-1)*2+1; j++){
                System.out.print(i%10);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;
        do{
            System.out.print("값을 입력해주세요.");
            n = stdIn.nextInt();
        }while (n<=0);

        spira(n);
        npira(n);
    }

}
