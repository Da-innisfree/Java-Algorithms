package ch04_StackAndQueue;

public class IntAryQueue {
    private int max; //큐 용량
    private int num; //현재 데이터 수
    private int[] que; //큐 본체

    //실행 시 예외: 큐가 비어있음
    public class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException() {
        }
    }

    //실행 시 예외: 큐가 가득 참
    public class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException() {
        }
    }

    //큐 생성자
    public IntAryQueue(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    //인큐 (큐에 데이터 인큐)
    public int enqueue(int x) throws OverflowIntAryQueueException {
        if (num >= max)
            throw new OverflowIntAryQueueException();
        que[num++] = x;
        return x;
    }

    //디큐 (큐에 데이터 디큐)
    public int dequeue() throws EmptyIntAryQueueException {
        if (num <= 0)
            throw new EmptyIntAryQueueException();
        int x = que[0];
        for (int i = 0; i < num; i++)
            que[i] = que[i + 1];
        return x;
    }

    //큐에서 맨앞 데이터 피크
    public int peek() throws EmptyIntAryQueueException {
        if (num <= 0)
            throw new EmptyIntAryQueueException();
        return que[0];
    }

    //큐에서 x를 찾아 인덱스 (없으면 -1) 반환 (디큐되는 순서대로 검색)
    public int indexOf(int x) {
        for (int i = 0; i < num; i++)
            if (que[i] == x)
                return i;
        return -1;
    }

    //큐를 비우기
    public void clear() {
        num = 0;
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
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }
}
