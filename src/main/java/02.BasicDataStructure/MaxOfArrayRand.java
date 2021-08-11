package chap02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {
    static int maxOf(int[] a){
        int max= a[0];
        for(int i=1; i<a.length; i++){
            if(a[i]>max) max = a[i];
        }
        return  max;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner stdIn = new Scanner(System.in);
        
        System.out.println("키의 최대값을 구합니다.");
        System.out.print("사람의 수: ");
        int num = stdIn.nextInt();
        
        int[] height = new int[num];
        
        System.out.println("키값은 아래와 같습니다.");
        for(int i=0; i<num; i++){
            //0부터 n-1까지 난수 생성
            height[i] = 100+random.nextInt(90); //키 값이므로 100 부터
            System.out.println("height["+i+"]: "+height[i]);
        }
        System.out.println("최댓값은 "+maxOf(height)+"입니다.");
    }
}
