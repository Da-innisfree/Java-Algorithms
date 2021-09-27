package ch03_Searching;

import java.util.Scanner;

public class Q4 {
    static void binsearch(int[] a, int n, int key){
        //첫줄 출력
    System.out.print("   |");
    for(int i=0; i<n; i++)
        System.out.printf("%3d",i);
    System.out.println();
    System.out.println("---+-------------------------");


    //key의 index 값 찾기
        int k= 0;
        for(int i=0; i<n; i++){
            if(a[i] ==key)
                k=i;
                break;
        }

    int pr = 0;
    int pl = n-1;


    do{
        int pc= (pr+pl)/2;
        System.out.print("   |");
        System.out.printf(String.format("%%%ds<-",(pr*3)+1),"");
        System.out.printf(String.format("%%%ds+",(pc*3)+2),"");
        System.out.printf(String.format("%%%ds->\n",(pl*3)+1),"");

        System.out.printf("%3d|",k);
        for(int i=0; i<n; i++)
            System.out.printf("%3d",a[i]);
        System.out.println();

        if(k==pc) break;
        else if(k<pc) pl=pc-1;
        else pr = pc+1;

    }while (pr<=pl);
        System.out.println(key+"는 a["+k+"에 있습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("요솟수를 정해주세요 ");
        int n = stdIn.nextInt();
        int[] a = new int[n];
        int i=0;

        for ( i = 0; i < n; i++) {
        do {
                System.out.print("x[" + i + "]: ");
                a[i] = stdIn.nextInt();
        } while(a[i-1]>a[i]);
        }

        System.out.print("key 값은? ");
        int key = stdIn.nextInt();

        binsearch(a, n,key);

    }
}
