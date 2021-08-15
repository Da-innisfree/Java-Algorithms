package chap03;

import java.util.Scanner;

public class Q5 {
    static int binSearch(int[] a, int n, int key){
        int pr =0;
        int pl =n-1;

        do{
            int pc = (pr+pl)/2;

            if(key == a[pc]){
                for(; pc>pr; pc--) {
                    if (a[pc-1] < key)
                        break;
                }
                return pc;
            }else if(a[pc]<key) {
                pr = pc + 1;
            }
            else { pl= pc-1;}
        }while(pr<=pl);
            return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("요솟수를 정해주세요 ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.print("오름차순으로 입력하기 x[0]는? ");
        x[0] = stdIn.nextInt();
        for(int i=1; i<num; i++){
            do{
                System.out.print("x["+i+"]는? ");
                x[i] = stdIn.nextInt();
            }while (x[i]<x[i-1]);
        }

        System.out.print("key값 정해주세요.");
        int key = stdIn.nextInt();

        int idx = binSearch(x, num, key);

         System.out.println(key+"는 x["+idx+"에 있습니다.");

    }



}
