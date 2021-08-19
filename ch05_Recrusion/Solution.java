package ch05_Recrusion;

public class Solution {
        static int[] solution() {
         int[] arr = {4,3,2,1};
            int[] answer ={};

            int min = arr[0];
            if(arr.length ==1){
                answer[0]=-1;
            }else{
                for(int a : arr){
                    if(a<min) min =a;
                }
                int i=0;
                for(int a: arr){
                    if(a !=min) answer[i++] =a;
                }

            }
            return answer;
        }

    public static void main(String[] args) {
        System.out.println(solution());
    }

}
