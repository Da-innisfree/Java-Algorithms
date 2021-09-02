package ch06_Sorting;

import java.util.Scanner;

public class QuickSortEx4A {

    //a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //a[idx1], a[idx2], a[idx3]의 값을 비교해 중앙값 인덱스 리턴합니다.
    static int sort3(int[] a, int idx1, int idx2, int idx3) {
        if (a[idx1] > a[idx2]) swap(a, idx1, idx2);
        if (a[idx2] > a[idx3]) swap(a, idx2, idx3);
        if (a[idx1] > a[idx2]) swap(a, idx1, idx2);
        return idx2;
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

    //퀵 정렬(배열을 나누는 과정을 출력합니다./요소의 개수가 적은 그룹을 먼저 나누기(요소가 9개 이하이면 insertionSort)
    static void quickSort(int[] a, int left, int right) {
        if (right - left <= 9) {
            insertionSort(a, left, right);
        } else {
            int pl = left; //왼쪽 커서
            int pr = right; //오른쪽 커서

            int idx = sort3(a, left, (left + right) / 2, right); //피벗 정렬한 인덱스
            swap(a,idx, right-1); //피벗 인덱스와 right-1 인덱스와 swap
            int x = a[right-1]; //피벗
            pl++;
            pr--;

            System.out.printf("a[%d]~a[%d]: {", left, right);
            for (int i = left; i < right; i++)
                System.out.printf("%d, ", a[i]);
            System.out.printf("%d\n", a[right]);

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if ((right - pl) < (pr - left)) {
                int temp;
                temp = left;
                left = pl;
                pl = temp;
                temp = pr;
                pr = right;
                right = temp;
            }
            //left와 pr과 비교/ right와 pl과 비교 후 재귀 메소드 호출
            if (left < pr) quickSort(a, left, pr);
            if (pl < right) quickSort(a, pl, right);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬(배열을 나누는 과정을 출력합니다.)/ 요소의 개수가 적은 그룹을 먼저 나누기");
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
