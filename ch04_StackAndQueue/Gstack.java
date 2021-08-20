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
    //스택에 x를 푸시하는 메소드
    public E push(E x) throws Gstack.OverflowIntStackException {
        if(ptr >= max)
            throw new Gstack.OverflowIntStackException();
        return  stk[ptr++] = x;
    }

    //스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
    public E pop() throws Gstack.EmptyIntStackException {
        if(ptr<=0)
            throw new Gstack.EmptyIntStackException();
        return stk[--ptr];
    }

    //스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
    public E peek() throws Gstack.EmptyIntStackException {
        if(ptr <=0)
            throw new Gstack.EmptyIntStackException();
        return stk[ptr -1];
    }

    //스택에서 x를 찾아 인덱스(없으면 -1)를 반환(팝하는 순서대로 검색)
    public int indexOf(E x){
        for(int i= ptr-1; i>=0; i--)
            if(stk[i]==x)
                return i;
        return -1;
    }

    //스택을 비움
    public void clear(){
        ptr=0;
    }

    //스택의 용량을 반환
    public int capacity(){
        return max;
    }

    //스택에 쌓여 있는 데이터 수를 반환
    public int size(){
        return ptr;
    }

    //스택이 비어 있는가?
    public boolean isEmpty(){
        return ptr <=0;
    }

    //스택에 가득 찾는가?
    public boolean isFull(){
        return ptr >=max;
    }

    //스택 안의 모든 데이터를 바닥->꼭대기 순으로 출력
    public void dump(){
        if(ptr <=0)
            System.out.println("스택이 비어있습니다.");
        else {
            for (int i=0; i<ptr; i++)
                System.out.print(stk[i]+" ");
            System.out.println();
        }
    }

}
