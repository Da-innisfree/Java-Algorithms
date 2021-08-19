package ch04_StackAndQueue;

//int형 링버퍼 큐
public class IntQueue {
    private int max; //큐의 용량
    private int front; //첫 번째 요소 커서
    private int rear; //마지막 요소 커서
    private int num; //현재 데이터 수
    private int[] que; //큐 본체

    //실행 시 예외: 큐가 비어있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {
        }
    }

    //실행 시 예외: 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {
        }
    }

    public IntQueue(int capacity){
        num = front = rear = 0;
        max= capacity;
        try{
            que = new int[max];
        }catch (OutOfMemoryError e){
            max=0;
        }
    }

    //큐에 데이터를 인큐
    public int enque(int x) throws OverflowIntQueueException{
        if(num >= max)
            throw new OverflowIntQueueException();
        que[rear++] =x;
        num++;
        
        //rear가 max와 같아질 경우를 대비해 0으로 초기화
        if(rear == max)
            rear=0;
        return x;
    }

    //큐에 데이터를 디큐큐

    
}
