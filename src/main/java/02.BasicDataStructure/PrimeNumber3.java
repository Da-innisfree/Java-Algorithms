package chap02;

public class PrimeNumber3 {
    public static void main(String[] args) {
        int counter =0; //곱셈과 나눗셈 횟수
        int ptr =0; //찾은 소수의 개수
        int[] prime = new int[500]; //소수 저장하는 배열

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int n=5; n<=1000; n +=2) {//대상은 홀수만
            boolean flag = false;
            for (int i=1; prime[i]*prime[i] <= n; i++){ //제곱근 이하의 소수들로 나누어 지지않음 체크
                counter += 2;

                if(n%prime[i] ==0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                prime[ptr++] = n;
                counter++;
            }
        }
        for (int i=0; i<ptr; i++)
            System.out.println(prime[i]);

        System.out.println("곱셈과 나눗셈을 수행한 횟수: "+counter);
    }
}
