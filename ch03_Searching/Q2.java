package chap03;

import java.util.Scanner;

public class Q2 {
    static int seqSearch(int[] x,int n, int key){
        System.out.print("   |");
        for(int i=0; i<n; i++) {
            System.out.printf("%3d",i);
        }
        System.out.print("\n---+");
        for(int k=0; k<2*n +2; k++)
            System.out.print("-");
        System.out.println();

        for(int i=0; i<n; i++){
            System.out.print("   |");
           System.out.printf(String.format("%%%ds*\n",(i*3+2))," ");

            System.out.printf("%3d|",i);
            for(int j=0; j<n; j++){
                System.out.printf("%3d",x[j]);
            }
            System.out.println();
            if(x[i] ==key) return i;
        }return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("요솟수 정하기: ");
        int n= stdIn.nextInt(); //요솟수 정하기
        int[] x = new int[n];
        
        //값 입력
        for(int i=0; i<n; i++){
            System.out.println("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.printf("key 값은? ");
        int ky = stdIn.nextInt();
       int idx =  seqSearch(x,n, ky);
        if(idx==-1)
            System.out.println("그 값의 요소가 없습니다.");
        else
        System.out.printf(ky+"은 x["+idx+"]에 있습니다.");
    }
}
