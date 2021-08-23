package ch06_Sorting;

import java.util.Scanner;

//버블정렬 비교, 교환 값 출력하기
public class BubbleSortEx {

    //a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2){
        int t =a[idx1];
        a[idx1]=a[idx2];
        a[idx2] =t;
    }
    
    //버블 정렬
    static void bubbleSort(int[] a,int n){
        int pair=0; //패스의 총 비교 횟수를 기록
        int exchg=0; //패스의 총 교환 횟수를 기록
        for(int i=0; i<n-1; i++) {
            System.out.println("패스"+(i+1)+":");
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    for(int ar: a ) {
                        System.out.printf("%d%s",ar, ar==a[j-1]? " + ":"   " );
                    }
                    System.out.println();
                        swap(a, j - 1, j);
                        exchg++;
                }else{
                    for(int ar: a ) {
                        System.out.printf("%d%s",ar, ar==a[j-1]? " - ":"   " );
                    }
                    System.out.println();
                }
                pair++;
            }
        } System.out.println("비교를 "+pair+"회 했습니다.");
            System.out.println("교환을 "+exchg+"회 했습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(교환 과정 출력)");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i=0; i<nx; i++){
            System.out.print("x["+i+"]: ");
            x[i]= stdIn.nextInt();
        }

        bubbleSort(x, nx); //배열 x를 버블 정렬

        System.out.println("오름차순으로 정렬했습니다.");
    }
    }


