package ch09_List;

import java.util.Comparator;

public class CircLinkedList<E> {
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
    public CircLinkedList(){ //비어있는 연결 리스트는 노드, head,tail이 가리키는 곳이 없으므로 null로 초기화
        head = tail= crnt =null;
    }

    //노드 검색
    public E search(E obj, Comparator<? super E> c) {
        if (head != null) {
            Node<E> ptr = head; //현재 스캔 중인 노드
            do {
                if (c.compare(obj, ptr.data) == 0) { //검색 성공
                    crnt = ptr;
                    return ptr.data;
                }
                ptr = ptr.next; //다음 노드를 선택
            } while (ptr != head);
        }
        return null;        //검색 실패
    }

    //머리에 노드 삽입
    public void addFirst(E obj) {

    }


}
