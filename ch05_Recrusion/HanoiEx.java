package ch05_Recrusion;

import java.util.Scanner;

public class HanoiEx {
    
    //no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y){
        //기둥명을 문자열로 지정
        String[] towers = {"A","B","C"};

        if(no>1)
            move(no-1, x, 6-x-y);
        System.out.println("원반["+no+"]을 "+towers[x-1]+"기둥에서 "+towers[y-1]+"기둥으로 옮김");

        if(no>1)
            move(no-1, 6-x-y,y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("원반 개수: ");
        int n = stdIn.nextInt();
        move(n,1,3);
    }



}
