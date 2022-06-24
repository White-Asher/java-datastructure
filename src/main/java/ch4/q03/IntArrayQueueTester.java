package ch4.q03;

import java.util.Scanner;

public class IntArrayQueueTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntArrayQueue intArrayQueue = new IntArrayQueue(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n", intArrayQueue.size(), intArrayQueue.getCapacity());
            System.out.print("(1)인큐 (2)ㅣ디큐(3)피크 (4)덤프 (0)종료: ");

            int menu = scanner.nextInt();
            if(menu == 0){
                break;
            }

            int x;
            switch(menu){

                    // 푸시
                case 1:
                    System.out.print("데이터: ");
                    x = scanner.nextInt();
                    try{
                        intArrayQueue.enque(x);
                    }catch (IntArrayQueue.OverflowIntStackException e){
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                    // 팝팝
                case 2:
                   try{
                        x = intArrayQueue.deque();
                        System.out.println("팝한 데이터는 "+x+" 입니다.");
                    }catch(IntArrayQueue.EmptyIntStackException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                    // 피크
                case 3:
                    try{
                        x = intArrayQueue.peek();
                        System.out.println("피크한 데이터는 "+ x +"입니다.");
                    }catch (IntArrayQueue.EmptyIntStackException e){
                        System.out.println("스택이 비어 있습니다.");;
                    }
                    break;

                    // 덤프
                case 4:
                    intArrayQueue.dump();
                    break;
            }
        }
    }
}
