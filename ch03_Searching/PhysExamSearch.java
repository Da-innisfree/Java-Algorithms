package ch03_Searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class PhysExamSearch {
     static class PhyscData{
         //데이터 정의
         private String name;
         private int height;
         private double vision;

         //생성자
         public PhyscData(String name, int height, double vision){
             this.name = name; this.height= height; this.vision=vision;
         }
         //문자열을 반환
         @Override
         public String toString() {
             return "name='" + name + '\'' +
                     ", height=" + height +
                     ", vision=" + vision;
         }
         //오름차순으로 정렬하기 위한 comparator
         public static final Comparator<PhyscData> HEIGHT_ORDER
                 = new HeightOrderComparator();

         private static class HeightOrderComparator implements Comparator<PhyscData> {
             @Override
             public int compare(PhyscData o1, PhyscData o2) {
                 return (o1.height > o2.height)? 1:
                         (o1.height< o2.height)? -1:0;
             }
         }

         public static final Comparator<PhyscData> VISION_ORDER
                 = new VisionOrderComparator();
         private static class VisionOrderComparator implements Comparator<PhyscData>{
             @Override
             public int compare(PhyscData o1, PhyscData o2) {
                 return (o1.vision > o2.vision)? -1:
                         (o1.vision < o2.vision)? 1:0;
             }
         }
     }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        //오름차순으로 정렬됐음
        PhyscData[] x ={
                new PhyscData("이나령",162,0.3),
                new PhyscData("유지훈", 168,0.4),
                new PhyscData("김한결", 169,0.8),
                new PhyscData("홍준기", 171,1.5),
                new PhyscData("전서현",173,0.7),
                new PhyscData("이호연", 174,1.2),
                new PhyscData("이수민",175,2.0),
        };

        System.out.print("몇 cm인 사람을 찾고 있나요?: ");
        int height = stdIn.nextInt();
        int idx = Arrays.binarySearch(x, new PhyscData("",height,0.0), PhyscData.HEIGHT_ORDER);

        if(idx<0)
            System.out.println("요소가 없습니다.");
        else{
            System.out.println("x["+idx+"]에 있습니다.");
            System.out.println("찾은 데이터: "+x[idx]);
        }

        System.out.print("시력으 몇인 사람을 찾고 있나요?: ");
        double vision = stdIn.nextDouble();

        int idx2 = Arrays.binarySearch(x, new PhyscData("",0,vision), PhyscData.VISION_ORDER);

        if(idx2 <0 )
            System.out.println("요소가 없습니다.");
        else{
            System.out.println("x["+idx2+"]에 있습니다.");
            System.out.println("찾은 데이터: "+x[idx2]);
        }
    }


}
