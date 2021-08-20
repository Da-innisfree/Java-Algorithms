package ch04_StackAndQueue;

public class IntDeque {
    private int max; //deck의 용량
    private int num; //현재 데이터 수
    private int front; //맨 앞 커서
    private int rear; //맨 뒤 커서
    private int[] que; //deck 본체

    //실행 시 예외: 큐가 비어있음
    public class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException() {
        }
    }

    //실행 시 예외: 큐가 가득 참
    public class OverflowDequeException extends RuntimeException {
        public OverflowDequeException() {
        }
    }

    public IntDeque(int capacity){
        num =front=rear= 0;
        max= capacity;
        try{
            que = new int[max]; //deck 본체용 배열 생성
        }catch (OutOfMemoryError e){
            max=0;
        }
    }

    //deck 프런트에 인큐
    public int enqueueF(int x) throws IntDeque.OverflowDequeException {
        if (num >= max)
            throw new IntDeque.OverflowDequeException();
        num++;
        if(--front <0)
            front= max-1;
        que[front] =x;
        return x;
    }

    //deck 리어에 인큐
    public int enqueueR(int x) throws IntDeque.OverflowDequeException {
        if (num >= max)
            throw new IntDeque.OverflowDequeException();
        que[rear++] = x;
        num++;
        if(rear == max)
            rear =0;
        return x;
    }

    //deck 프런트에서 디큐
    public int dequeueF() throws IntDeque.EmptyIntDequeException {
        if (num <= 0)
            throw new IntDeque.EmptyIntDequeException();
        int x = que[front++];
        num--;
        if(front==max)
            front =0;
        return x;
    }

    //deck 리어에서 디큐
    public int dequeueR() throws IntDeque.EmptyIntDequeException {
        if (num <= 0)
            throw new IntDeque.EmptyIntDequeException();
        if(--rear <0)
            rear= max-1;
        return  que[rear];
    }

    //deck의 front에서 데이터 피크
    public int peekF() throws IntDeque.EmptyIntDequeException {
        if (num <= 0)
            throw new IntDeque.EmptyIntDequeException();
        return que[front];
    }

    //deck의 rear에서 데이터 피크
    public int peekR() throws IntDeque.EmptyIntDequeException {
        if (num <= 0)
            throw new IntDeque.EmptyIntDequeException();
        return que[rear==0? max-1: rear-1];
    }

    //deck에서 x를 찾아 인덱스 (없으면 -1) 반환 (디큐되는 순서대로 검색)
    public int indexOf(int x) {
        for (int i = 0; i < num; i++)
            if (que[i] == x)
                return i;
        return -1;
    }

    //deck을 비우기
    public void clear() {
        num = front =rear= 0;
    }

    //deck의 용량 반환
    public int capacity() {
        return max;
    }

    //deck에 쌓여있는 데이터 수 반환
    public int size() {
        return num;
    }

    //deck이 비어있는지 체크
    public boolean isEmpty() {
        return num <= 0;
    }

    //deck이 가득 차있는지 체크
    public boolean isFull() {
        return num >= max;
    }

    //deck의 front->rear 순으로 출력
    public void dump() {
        if(num<=0)
            System.out.println("deck이 비어있습니다.");
        else{
            for (int i=0; i<num; i++)
                System.out.print(que[(i+front)%max] + " ");
            System.out.println();
        }
    }

}
