package chap03;

import java.util.Scanner;

public class SeqSearchSen {
    
    //오솟수가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형 검색
    static  int seqSearchSen(int[] a, int n, int key){
        int i=0;
        a[n] = key; //보초는 추가

       /*
        while (true){
            if (a[i]==key)
                break;
            i++;
        }
        return i==n ? -1: i;*/

        for( i=0; a[i] != key; i++);

            return i == n? -1 :i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num+1]; //요소수+1 배열
        
        for (int i=0; i<num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }
        
        System.out.print("검색할값: ");
        int ky = stdIn.nextInt();
        
        int idx= seqSearchSen(x, num, ky);

        if(idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
    }
}
