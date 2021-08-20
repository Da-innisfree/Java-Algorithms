package ch04_StackAndQueue;

public class Gqueue<E> {
    private int max; //큐의 용량
    private int front; //첫 번째 요소 커서
    private int rear; //마지막 요소 커서
    private int num; //현재 데이터 수
    private E[] que; //큐 본체

    //실행 시 예외: 큐가 비어있음
    public static class EmptyGqueueException extends RuntimeException {
        public EmptyGqueueException() {
        }
    }

    //실행 시 예외: 큐가 가득 참
    public static class OverflowGqueueException extends RuntimeException {
        public OverflowGqueueException() {
        }
    }

    public Gqueue(int capacity){
        num = front = rear = 0;
        max= capacity;
        try{
            que = (E[]) new Object[max];
        }catch (OutOfMemoryError e){
            max=0;
        }
    }

    //큐에 데이터를 인큐
    public E enque(E x) throws Gqueue.OverflowGqueueException {
        if(num >= max)
            throw new Gqueue.OverflowGqueueException ();
        que[rear++] =x;
        num++;

        //rear가 max와 같아질 경우를 대비해 0으로 초기화
        if(rear == max)
            rear=0;
        return x;
    }

    //큐에 데이터를 디큐
    public E deque() throws Gqueue.EmptyGqueueException {
        if(num<=0)
            throw new Gqueue.EmptyGqueueException(); //큐가 비어 있음
        E x = que[front++];
        num--;
        //front와 max가 같아질 경우 0으로 초기화
        if(front ==max)
            front=0;
        return x;
    }

    //큐에서 데이터를 피크(프런트 데이터를 들여다봄)
    public E peek() throws Gqueue.EmptyGqueueException {
        if(num<=0)
            throw new Gqueue.EmptyGqueueException();
        return que[front];
    }

    //큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
    public int indexOf(E x){
        for(int i=0; i<num; i++){
            int idx = (i+front)%max;
            if(que[idx]==x) //검색 성공
                return idx;
        }
        return -1;  //검색 실패
    }
    //큐를 비우기
    public void clear() {
        num =front=rear= 0;
    }

    //큐의 용량 반환
    public int capacity() {
        return max;
    }

    //큐에 쌓여있는 데이터 수 반환
    public int size() {
        return num;
    }

    //큐가 비어있는지 체크
    public boolean isEmpty() {
        return num <= 0;
    }

    //큐가 가득 차있는지 체크
    public boolean isFull() {
        return num >= max;
    }

    //큐의 front->rear 순으로 출력
    public void dump() {
        if(num<=0)
            System.out.println("큐가 비어있습니다.");
        else{
            for (int i=0; i<num; i++)
                System.out.print(que[(i+front)%max] + " ");
            System.out.println();
        }
    }

    //큐의 front 기준으로 몇번째에 있는지 확인(검색 실패시 0 반환)
    public int search(E x){
        for(int i=0; i<num; i++){
            if(que[(i+front)%max]==x) return i+1;
        }
        return 0;
    }
}
