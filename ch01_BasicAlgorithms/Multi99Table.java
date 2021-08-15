package chap01;

public class Multi99Table {
    public static void main(String[] args) {
        System.out.println("------곱셈표------");

        for (int i=1; i<=9; i++){
            for (int j=1; j<=9; j++)
                System.out.printf("%3d", i*j); //i*j를 3자리로 출력 나머지는 빈칸
            System.out.println(); //한 루프가 끝나고 줄바꿈
        }
    }
}
