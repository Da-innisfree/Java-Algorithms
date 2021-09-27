package ch10_Tree;

import java.util.Comparator;

//이진검색트리
public class BinTree <K,V>{
    //노드
    static class Node<K,V>{
        private K key;      //키 값
        private V data;     //데이터
        private Node<K,V> left;     //왼쪽 자식 노드
        private Node<K,V> right;     //오른쪽 자식 노드

        //생성자
        Node(K key, V data, Node<K,V> left, Node<K,V> right){
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        //키 값을 반환
        K getKey(){
            return key;
        }

        //데이터를 반환
        V getValue(){
            return data;
        }

        //데이터를 출력
        void print(){
            System.out.println(data);
        }
    }

    private Node<K,V> root;     //루트
    private Comparator<? super K> comparator = null;        //비교자

    //생성자(루트를 null로 하여 비어있는 이진검색트리를 생성)
    public BinTree(){
        root=null;
    }

    //생성자
    public BinTree(Comparator<? super K> c){
        this();     //인수를 전달받지 않는 생성자 BinTree()를 호출하여 비어있는 이진검색트리 생성
        comparator = c;    //Comparator 설정
    }

    //두 키 값을 비교
    private int comp(K key1, K key2){
        return (comparator == null)? ((Comparable<K>)key1).compareTo(key2)
                : comparator.compare(key1,key2);
    }
}
