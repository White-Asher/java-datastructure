// 링버퍼로 큐 만들기

package ch4.ex04;

public class IntQueue {
    private int[] que;  // 큐 배열
    private int capacity; // 큐 용량
    private int front;
    private int rear;
    private int num;

    // 실행시 예외: 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){ }
    }

    // 실행시 예외: 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){ }
    }

    //생성자
    public IntQueue(int maxlen){
        num = front = rear = 0;
        capacity = maxlen;
        try{
            que = new int[capacity];
        }catch (OutOfMemoryError e){
            capacity = 0;
        }
    }
}
