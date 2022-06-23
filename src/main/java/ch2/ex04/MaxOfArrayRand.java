// 배열 요소의 최댓값을 출력(값을 난수로 생성)
package ch2.ex04;

import java.util.Scanner;
import java.util.Random;

class MaxOfArrayRand {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("키의 최댓값을 구합니다.");

        System.out.print("사람수: ");
        int num = scan.nextInt();

        int[] height = new int[num];

        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height["+i+"]:"+height[i]);
        }
        System.out.println("최댓값은"+ maxOf(height)+"입니다");
    }
}
