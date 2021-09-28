package ch07_Set;

//int형 집합 클래스 IntSet을 사용하는 예
public class IntSetTester {
    public static void main(String[] args) {
        IntSet s1 = new IntSet(20);
        IntSet s2 = new IntSet(20);
        IntSet s3 = new IntSet(20);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        s1.copyTo(s2);
        s2.add(12);
        s2.add(11);
        s2.add(110);
        s2.add(111);

        s3.copyFrom(s2);

        System.out.println("s1= "+s1);
        System.out.println("s2= "+s2);
        System.out.println("s3= "+s3);

        s1.addAll(s2);
        System.out.println("s1= "+s1);
        System.out.println("s2= "+s2);
        System.out.println("s3= "+s3);

        s1.intersectionOf(s2,s3);
        System.out.println("s1= "+s1);
        System.out.println("s2= "+s2);
        System.out.println("s3= "+s3);



    }
}
