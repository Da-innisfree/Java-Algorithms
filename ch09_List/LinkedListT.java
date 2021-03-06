package ch09_List;

import java.util.Comparator;

//꼬리 노드 포함
public class LinkedListT<E> {
    //노드
    class Node<E> {
        private E data; //데이터
        private Node<E> next;   //뒤쪽 포인터(다음 노드 참조)

        //생성자
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;   //머리 노드
    private Node<E> tail;   //꼬리 노드
    private Node<E> crnt;   //선택 노드

    //생성자
    public LinkedListT() {
        head = tail = crnt = null; //비어있는 연결 리스트는 노드, head,tail이 가리키는 곳이 없으므로 null로 초기화
    }

    //노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head; //현재 스캔 중인 노드

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) { //검색 성공
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next; //다음 노드를 선택
        }
        return null;        //검색 실패
    }

    //머리에 노드 삽입
    public void addFirst(E obj) {
        boolean empty = (tail == null);
        Node<E> ptr = head; //삽입 전의 머리 노드
        head = crnt = new Node<E>(obj, ptr);
        if (empty)
            tail = crnt;
    }

    //꼬리에 노드 삽입
    public void addLast(E obj) {
        if (head == null)   //리스트가 비어있을 경우 head에 노드 삽입
            addFirst(obj);
        else {      //리스트가 비어있지 않을 경우 꼬리에 노드 삽입
            tail.next = crnt = new Node<E>(obj, null);
            tail = crnt;  //tail 변경
        }
    }

    //머리 노드를 삭제
    public void removeFirst() {
        if (head != null) { //리스트가 비어 있지 않으면
            head = crnt = head.next;
            if (head == null)
                tail = null;
        }
    }

    //꼬리 노드를 삭제
    public void removeLast(){
        if(head != null){
           if(head.next == null)
               removeFirst();
           else {
               Node<E> ptr = head; //스캔 중인 노드
               Node<E> pre = head; //스캔 중인 노드의 앞쪽 노드

               while (ptr.next != null) {
                   pre = ptr;
                   ptr = ptr.next;
               }

               pre.next = null;    //pre는 삭제 후의 꼬리 노드
               crnt =tail= pre;

           }
        }
    }
    
    //노드 p를 삭제
    public void remove(Node p){
        if(head != null){       //비어있는 리스트인지 확인
            if (p == head)       //p가 머리 노드면
                removeFirst();
            else if (p==tail)       //p가 꼬리 노드면
                removeLast();
            else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) return;     //p가 리스트에 없습니다.
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    //선택 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    //모든 노드를 삭제
    public void clear() {
        while (head != null)  //노드에 아무것도 없을 때까지 머리 노드 삭제
            removeFirst();
        crnt = null;
    }

    //선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false;   //이동할 수 없음
        crnt = crnt.next;
        return true;
    }

    //선택 노드를 출력
    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    //모든 노드를 출력
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    //서로 같은 노드를 찾아 모두 삭제
    public void purge(Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            int count = 0;
            Node<E> pre = ptr;
            Node<E> ptr2 = ptr.next;

            while (ptr2 != null) {

                if (c.compare(pre.data, ptr2.data) == 0) {      //compare 메소드를 이용하여 같은 값 확인
                    pre.next = ptr2.next;       //같은 값일 경우 노드 삭제
                    count++;
                } else
                    ptr2 = ptr2.next;       //pre와 ptr2.next값과 비교를 위함
            }
            if (count == 0)
                ptr = ptr.next;
            else {      //같은 값이 있었던 것을 체크 후 노드 석제
                Node<E> temp = ptr;
                remove(ptr);
                ptr = temp.next;
            }

        }
        crnt = head;
    }

    //머리부터 n개 뒤의 노드에 대한 참조리턴(n이 0이면 head 참조 리턴)
    public E retrieve(int n) {
        Node<E> ptr = head;

        while (n > 0 && ptr != null) {
            if (n-- == 0) {     //n을 1씩 줄이면서 0이 될때까지 체크 후 리턴
                crnt = ptr;
                return ptr.data;        //검색 성공
            }
            ptr=ptr.next;       //다음 노드 주목
        }
        return null;
    }
}
