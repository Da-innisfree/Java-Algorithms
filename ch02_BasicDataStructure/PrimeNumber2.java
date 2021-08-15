package chap02;

public class PrimeNumber2 {
    public static void main(String[] args) {
        int counter = 0; //나눗셈의 횟수
        int ptr=0; //찾은 소수의 개수
        int[] prime = new int[500]; //소수를 저장하는 배열

        prime[ptr++] =  2; //2는 소수

        for(int n =3; n<=1000; n+=2){ //대상은 홀수만
            int i;
            for(i=1; i< ptr; i++){
                counter++;
                if(n%prime[i]==0) //prime 배열에 있는 값들로 나누기
                    break;
            }
            if(ptr ==i) //마지막까지 나누어 떨어지지 않음
                prime[ptr++] = n; //소수라고 배열에 저장하면서 ptr++
        }

        for(int i=0; i<ptr; i++) //소수 출력
            System.out.println(prime[i]);

        System.out.println("나눗셈을 수행한 횟수: "+counter);
    }
}
