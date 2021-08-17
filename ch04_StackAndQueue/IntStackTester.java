package ch04_StackAndQueue;

import java.util.Scanner;

//int형 스택 사용 예
public class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64); //최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("현재 데이터 수: " + s.size() + "/" + s.capacity());
            System.out.print("(1)푸시 (2) 팝 (3)피크 (4)덤프 (5)인덱스 찾기 (6)스택 비우기 (7)스택 쌓인 데이터수 (8)스택용량 (9)가득찼는지확인 (10)비웠는지확인 (0)종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1: //push
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2: //pop
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3: //peek
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4: //dump
                    s.dump();
                    break;

                case 5: //indexOf
                   System.out.print("찾고 싶은 데이터: ");
                   x= stdIn.nextInt();
                   int index = s.indexOf(x);
                   if(index ==-1 ) System.out.println("해당 데이터의 인덱스가 없습니다.");
                   else System.out.println("해당 인덱스는 "+index+"에 있습니다.");
                    break;

                case 6: //clear
                    s.clear();
                    break;

                case 7: //size
                    x= s.size();
                    System.out.println("스택에 쌓여 있는 데이터 수는 "+x+"입니다.");
                    break;

                case 8: //capacity
                    x = s.capacity();
                    System.out.println("스택의 용량은 "+x+"입니다.");
                    break;

                case 9: //isFull
                    if(s.isFull()) System.out.println("스택이 가득 찼습니다.");
                    else System.out.println("스택이 가득 차지 않았습니다.");
                    break;

                case 10: //isEmpty
                    if(s.isEmpty()) System.out.println("스택이 비었습니다.");
                    else System.out.println("스택이 비어있지 않습니다.");
                    break;

            }
        }


    }
}
