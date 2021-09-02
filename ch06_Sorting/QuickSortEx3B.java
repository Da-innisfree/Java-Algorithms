package ch06_Sorting;

import ch04_StackAndQueue.IntStack;

import java.util.Scanner;

//퀵 정렬(비재귀 버전, 피벗 선택하기 방법 1/ 요소의 개수가 적은 그룹을 먼저 나누기(요소가 9개 이하이면 insertionSort))
public class QuickSortEx3B {
    //3개 중에 중앙값을 피벗으로 선택합니다.
    static int med3(int a, int b, int c) {
        if (a >= b)
            if (b >= c) return b;
            else if (a <= c) return a;
            else return c;

        else if (a > c) return a;
        else if (b > c) return c;
        else return b;
    }

    //a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //단순 삽입 정렬
    static void insertionSort(int[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j;
            int tmp = a[i];
            //a[j-1]이 tmp 보다 큰값인지
            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    //퀵 정렬(비재귀 버전, 요소의 개수가 적은 그룹을 먼저 나누기(요소가 9개 이하이면 insertionSort))
    static void quickSort(int[] a, int left, int right) {

        //스택 생성
        IntStack lstack = new IntStack(right - left + 1); //right-left+1 => 나눌 배열의 요솟수
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop(); //왼쪽 커서
            int pr = right = rstack.pop(); //오른쪽 커서

            //요솟수가 9개 이하일 경우
            if (right - left <= 9) insertionSort(a, left, right);
            else {
                int x = med3(a[left], a[(left + right) / 2], a[right]); //피벗

                do {
                    while (a[pl] < x) pl++;
                    while (a[pr] > x) pr--;
                    if (pl <= pr)
                        swap(a, pl++, pr--);
                } while (pl <= pr);

                switch ((pr - left) <= (right - pl) ? 1 : 2) {
                    case 1:
                        if (left < pr) {
                            lstack.push(left); //왼쪽 그룹 범위의 인덱스를 푸시합니다.
                            rstack.push(pr);
                            break;
                        }
                    case 2:
                        if (pl < right) {
                            lstack.push(pl); //오른쪽 그룹 범위의 인덱스를 푸시합니다.
                            rstack.push(right);
                            break;
                        }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬(비재귀 버전)/ 요소의 개수가 적은 그룹을 먼저 나누기");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx - 1); //배열 x를 퀵 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]= " + x[i]);
    }

}
