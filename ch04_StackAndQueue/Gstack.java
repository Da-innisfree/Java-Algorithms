package ch04_StackAndQueue;

public class Gstack<E> {
    private int max;
    private int ptr;
    private E[] stk;

    //실행 시 예외: 스택이 비어있음
    public static class  EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){}
    }

    //실행 시 예외: 스택이 가득 참
    public static class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){}
    }

    //생성자
    public Gstack(int capacity){
        ptr=0;
        max = capacity;
        try{
            stk = (E[]) new Object[max]; //스택 본체용 배열을 생성
        }catch(OutOfMemoryError e){ //생성할 수 없음 에러
            max=0;
        }
    }


}
