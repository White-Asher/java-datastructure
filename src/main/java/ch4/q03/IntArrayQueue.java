package ch4.q03;

public class IntArrayQueue {
    private int[] que;  // 큐 배열
    private int capacity; // 큐 용량
    private int num;  // 큐 포인터

    // 실행시 예외: 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){ }
    }

    // 실행시 예외: 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){ }
    }

    //생성자
    public IntArrayQueue(int maxlen){
        num = 0;
        capacity = maxlen;
        try{
            que = new int[capacity]; // 스택 본체용 배열을 생성
        }catch (OutOfMemoryError e){ // 생성할 수 없음
            capacity = 0;
        }
    }

    // 스택에 x를 푸시
    public int enque(int x) throws OverflowIntStackException{
        if(num >= capacity) // 만약 스택이 가득찼다면
            throw new OverflowIntStackException(); // 예외발생
        que[num++] = x;
        return x; // 스택이 가득 안찼다면 push함
    }

    // 스택에서 데이터를 팝(꼭대기에 있는 데이터를 꺼냄)
    public int deque() throws EmptyIntStackException{
        if(num <= 0 ){ // 스택이 비어있다면
            throw new EmptyIntStackException(); // 예외 발생
        }
        int x = que[0];
        for (int i = 0; i < num; i++) {
            que[i] = que[i+1];
        }
        num--;
        return que[--num]; // 스택이 비어있지 않다면 맨 위 꺼냄
    }


    // 스택에서 데이터를 피크(꼭대기에 있는 데이터를 들여다봄)
    public int peek() throws EmptyIntStackException{
        if(num <=0)
            throw new EmptyIntStackException();
        return que[num - 1];
    }

    public void clear(){
        num = 0;
    }

    //스택에서 x를 찾아 인덱스(없으면-1) 반환
    public int indexOf(int x){
        for (int i = num - 1; i >= 0  ; i--) {  // 꼭대기부터 선형검색
            if(que[i] == x){
                return i;
            }
        }
        return -1;
    }

    //스택의 용량을 반환환
    public int getCapacity(){
        return capacity;
    }

    // 스택에 쌓여 있는 데이터 개수를 반환
    public int size(){
        return num;
    }

    // 스택이 비어있는가?
    public boolean isEmpty(){
        return num <=0;
    }

    // 스택이 가득 찼는가?
    public boolean isFull(){
        return num >= capacity;
    }

    //스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump(){
        if(num <=0){
            System.out.println("큐가 비어 있습니다.");
        }
        else{
            for (int i = 0; i < num; i++) {
                System.out.print(que[i] + " ");
            }
            System.out.println();
        }
    }
}
