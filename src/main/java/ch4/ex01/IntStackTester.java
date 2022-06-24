package ch4.ex01;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntStack intStack = new IntStack(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n", intStack.size(), intStack.getCapacity());
            System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료: ");

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
                        intStack.push(x);
                    }catch (IntStack.OverflowIntStackException e){
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                    // 팝팝
                case 2:
                   try{
                        x = intStack.pop();
                        System.out.println("팝한 데이터는 "+x+" 입니다.");
                    }catch(IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                    // 피크
                case 3:
                    try{
                        x = intStack.peek();
                        System.out.println("피크한 데이터는 "+ x +"입니다.");
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비어 있습니다.");;
                    }
                    break;

                    // 덤프
                case 4:
                    intStack.dump();
                    break;
            }
        }
    }
}
