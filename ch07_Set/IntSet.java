package ch07_Set;

public class IntSet {
    private int max;    //집합의 최대 개수
    private int num;    //집합의 요소 개수
    private int[] set;  //집합 본체

    //생성자
    public IntSet(int capacity) {
        num = 0;
        max = capacity;
        try {
            set = new int[max];   //집합 배열 생성
        } catch (OutOfMemoryError e) {    //배열 생성 실패
            max = 0;
        }
    }

    //집합의 최대 개수
    public int capacity() {
        return max;
    }

    //집합의 요소 개수
    public int size() {
        return num;
    }

    //집합에서 n을 검색합니다.(index 반환)
    public int indexOf(int n) {
        for (int i = 0; i < num; i++)
            if (set[i] == n)
                return i;   //검색 성공
        return -1;  //검색 실패
    }

    //집합에 n이 있는지 없는지 확인합니다.
    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    //집합에  n을 추가합니다.
    public boolean add(int n) {
        if (num >= max || contains(n) == true)   //가득 찼거나 이미 n이 존재합니다.
            return false;
        else {
            set[num++] = n;  //가장 마지막 자리에 n을 추가합니다.
            return true;
        }
    }

    //집합에서 n을 삭제합니다.
    public boolean remove(int n) {
        int idx;    //n이 저장된 요소의 인덱스

        if (num <= 0 || (idx = indexOf(n)) == -1)  //비어있거나 n이 존재하지 않습니다.
            return false;
        else {
            set[idx] = set[--num];  //마지막 요소를 삭제한 곳으로 옮깁니다.
            return true;
        }
    }

    //집합 s에 복사합니다.
    public void copyTo(IntSet s) {
        int n = (s.max < num) ? s.max : num; //복사할 요소 개수
        for (int i = 0; i < n; i++)
            s.set[i] = set[i];
        num = n;
    }

    //집합 s를 복사합니다.
    public void copyFrom(IntSet s) {
        int n = (max < s.num) ? max : s.num;    //복사할 요소 개수
        for (int i = 0; i < n; i++)
            set[i] = s.set[i];
        num = n;
    }

    //집합 s와 같은지 확인합니다.
    public boolean equalTo(IntSet s) {
        if (num != s.num)    //요소 개수가 같지 않으면 집합도 같지 않습니다.
            return false;

        for (int i = 0; i < num; i++) {
            int j = 0;
            for (; j < s.num; j++)
                if (set[i] == s.set[j])
                    break;
            if (j == s.num)    //set[i]는 s에 포함되지 않습니다.
                return false;
        }
        return true;
    }

    //집합 s1과 s2의 합집합을 복사합니다.
    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);   //집합 s1을 복사합니다.
        for (int i = 0; i < s2.num; i++)
            add(s2.set[i]);
    }

    //"{ a b c }" 형식의 문자열로 표현을 바꿉니다.
    public String toString() {
        StringBuffer temp = new StringBuffer("{ ");
        for (int i = 0; i < num; i++)
            temp.append(set[i] + " ");
        temp.append("}");
        return temp.toString();
    }

    //공집합인지 확인합니다.
    public boolean isEmpty() {
        return num <= 0 ? true : false;
    }

    //집합이 가득 찼는지 확인합니다.
    public boolean isFull() {
        return num >= max ? true : false;
    }

    //집합을 초기화합니다.(모든 요소 삭제)
    public void clear() {
        for (int i = 0; i < num; i++)
            set[i] = 0;
        num = 0;
    }

    //집합 s의 모든 요소를 추가합니다.
    public boolean addAll(IntSet s) {
        boolean flag = false;
        for (int i = 0; i < s.num; i++)
            if(add(s.set[i]) ==true)
                flag=true;
            else flag=false;
        return flag;
    }

    //집합 s에 들어있는 요소를 제외하고 삭제합니다.
    public boolean retain(IntSet s) {
        int idx;
        if (s.num <= 0)
            return false;
        else {
            for (int i = 0; i < num; i++) {
                if (s.indexOf(set[i]) == -1)
                    remove(set[i]);
            }
        }
        return false;
    }

    //집합 s에 들어있는 요소를 삭제합니다.
    public boolean remove(IntSet s) {
        int i = 0;
        if (s.num <= 0)
            return false;
        else {
            while (i < s.num) {
                if (indexOf(s.set[i]) == -1) {
                    i++;
                    continue;
                } else {
                    remove(s.set[i]);
                    i++;
                    continue;
                }

            }
            return true;
        }

    }
    //집합 s의 부분집합인지 확인합니다.
    public boolean isSubsetOf(IntSet s){
        for(int i=0; i<num;i++){
            if(s.indexOf(set[i])==-1)
                return false;
        }
        return true;
    }
    //집합 s의 진부분집합인지 확인합니다.
    public boolean isProperSubsetOf(IntSet s){
        if(equalTo(s))
            return false;
        else return isSubsetOf(s);
    }

    // 집합 s1과 s2의 교집합을 복사
    public void intersectionOf(IntSet s1, IntSet s2) {
        clear();
        for (int i = 0; i < s1.num; i++)
            if (s2.contains(s1.set[i]))
                add(s1.set[i]);
    }

    // 집합 s1과 s2의 차집합을 복사
    public void differenceOf(IntSet s1, IntSet s2) {
        clear();
        for (int i = 0; i < s1.num; i++)
            if (!s2.contains(s1.set[i]))
                add(s1.set[i]);
    }



}