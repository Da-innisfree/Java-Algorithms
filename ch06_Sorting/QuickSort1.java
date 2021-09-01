package ch06_Sorting;


public class QuickSort1 {
    //a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //퀵 정렬(배열을 나누는 과정을 출력합니다.)
    static void quickSort(int[] a, int left, int right) {
        int pl = left; //왼쪽 커서
        int pr = right; //오른쪽 커서
        int x = a[(pl + pr) / 2]; //피벗

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

        //left와 pr과 비교/ right와 pl과 비교
        if (left < pr) quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }
}
