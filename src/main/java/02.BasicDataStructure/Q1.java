package chap02;

import java.util.Random;
import java.util.Scanner;

public class Q1 {
    static int maxOf(int[] a){
        int max = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i] > max) max= a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner stdIn = new Scanner(System.in);

        int num = random.nextInt(10)+1;
        System.out.println("사람 수는? "+num);
        int[] height = new int[num];

        System.out.println("키값은 아래와 같습니다.");
        for(int i=0; i<num ; i++){
            height[i]= 100+ random.nextInt(90);
            System.out.println("height["+i+"]: "+height[i]);
        }
        System.out.print("최댓값은 "+maxOf(height)+"입니다.");


    }
}
