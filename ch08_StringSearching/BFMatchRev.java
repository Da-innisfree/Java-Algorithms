package ch08_StringSearching;

import java.util.Scanner;

//텍스트 뒤에서 부터 검색하여 패턴과 일치하는 위치 반환하는 메소드
public class BFMatchRev {
    static int bfMatchLast(String txt, String pat) {
        int pt = txt.length() - 1;
        int pp = pat.length() - 1;

        while (pt >= 0 && pp >= 0) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt--;
                pp--;
            } else {
                pt = pt - (pat.length() - pp) - 2;
                pp = pat.length() - 1;
            }

        }
        if (pp < 0)    //검색 성공!
            return pt + 1;    //가장 뒤쪽의 일치하는 곳의 위치 반환
        return -1;  //검색 실패!
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = stdIn.next(); //텍스트용 문자열

        System.out.print("패턴: ");
        String s2 = stdIn.next();   //패턴용 문자열

        int idx = bfMatchLast(s1, s2);   //문자열 s1에서 문자열 s2를 검색

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            //뒤에서부터 검색하여 일치하는 문자 위치를 구합니다.
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;//패턴 바로 앞까지 공백문자로 출력하기 위해 길이 구하기
            len += s2.length();

            System.out.println((idx + 1) + "번쨰 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패턴: %%%ds\n", len), s2);
        }

    }
}
