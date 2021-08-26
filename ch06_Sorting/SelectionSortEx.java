package ch06_Sorting;

import java.util.Scanner;

public class SelectionSortEx {

    //a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    
    //단순 선택 정렬
    static void selectionSort(int[] a, int n){
        for(int i=0; i<n-1; i++){
            int min = i; //아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스 기록
            for(int j=i+1; j<n; j++)
                if(a[j] < a[min])
                    min=j; //가장 작은 요소 저장
                
            for(int b=0; b<n; b++ ) //아직 정렬되지 않은 부분에서 가장 첫 요소와 작은 요소 표시
                System.out.print((b==i)? " *":(b==min)? " +":"  ");
            System.out.println();
            
            for(int x: a) //배열 a 출력
                    System.out.printf("%2d",x);
            System.out.println();

                swap(a, i, min); //아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소와 교환
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x,nx);    //배열 x를 단순 삽입 정렬

        System.out.println("오름차순으로 정렬했습니다.");
    }
}