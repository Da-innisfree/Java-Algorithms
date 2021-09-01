package ch06_Sorting;

import ch04_StackAndQueue.IntStack;

public class QuickSort2 {
    //a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //퀵 정렬(비재귀 버전)
    static void quickSort(int[] a, int left, int right){
        //스택 생성
        IntStack lstack = new IntStack(right-left+1);
        IntStack rstack = new IntStack(right-left+1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop(); //왼쪽 커서
            int pr = right = rstack.pop(); //오른쪽 커서
            int x = a[(left + right) / 2]; //피벗

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if(left < pr){
                lstack.push(left); //왼쪽 그룹 범위의 인덱스를 푸시합니다.
                rstack.push(pr);
            }
            if(pl <right){
                lstack.push(pl); //오른쪽 그룹 범위의 인덱스를 푸시합니다.
                rstack.push(right);
            }
        }
    }
}
