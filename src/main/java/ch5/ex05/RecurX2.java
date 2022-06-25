// 재귀를 제거

package ch5.ex05;

public class RecurX2 {
    static void recur(int n){
        IntStack s = new IntStack(64);

        while(true){
            if(n > 0){
                s.push(n);
                n = n - 1;
                continue;
            }
            if(s.isEmpty() != true){
                n = s.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }
}
