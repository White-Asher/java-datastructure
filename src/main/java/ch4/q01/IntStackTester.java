// IntStack 미사용 메서드 사용.

package ch4.q01;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntStack intStack = new IntStack(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n", intStack.size(), intStack.getCapacity());
            System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)클리어 (6)찾기 (7)비어있는지 확인 (8)가득찼는지 확인 (0)종료: ");

            int menu = scanner.nextInt();
            if(menu == 0){
                System.out.println("프로그램을 종료합니다.");
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

                    // 클리어
                case 5:
                    intStack.clear();
                    System.out.println("클리어를 수행했습니다.");
                    break;

                    // 스택에서 데이터 찾기
                case 6:
                    System.out.print("찾을 데이터를 입력하세요: ");
                    int data = scanner.nextInt();
                    int result = intStack.indexOf(data);
                    if(result >=0){
                        System.out.println(result+"번째 인덱스에 위치합니다.");
                    }else if(result<0){
                        System.out.println("해당 데이터를 찾을 수 없습니다.");
                    }
                    break;

                    //스택이 비어있는가?
                case 7:
                    if(intStack.isEmpty()){
                        System.out.println("스택이 비어 있습니다.");
                    }else{
                        System.out.println("스택이 비어있지 않습니다.");
                    }
                    break;

                    // 스택이 가득찼는가?
                case 8:
                    if(intStack.isFull()){
                        System.out.println("스택이 가득 찼습니다.");
                    }else{
                        System.out.println("스택이 가득 차있지 않습니다.");
                    }
                    break;
            }
        }
    }
}
