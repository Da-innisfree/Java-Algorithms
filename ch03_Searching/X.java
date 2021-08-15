package chap03;

import java.util.Comparator;

public class X {

    public static final Comparator<A> COMPARATOR = new Comp();

    private static class Comp implements Comparator<A>{
        @Override
        public int compare(A o1, A o2) {
            //d1이 d2보다 크면 양의 값
            //d1이 d2보다 작으면 음의 값
            //d1이 d2와 같으면 0
            return 0;
        }
    }
}
