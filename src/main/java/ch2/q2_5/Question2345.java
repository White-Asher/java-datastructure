package ch2.q2_5;

import java.util.Arrays;
import java.util.Scanner;

public class Question2345 {
    static void swap(int[] a, int idx1, int idx2){
        // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a){
        for (int i = 0; i < a.length/2; i++) {
            swap(a, i, a.length-i-1);
            System.out.println(Arrays.toString(a));
            System.out.println("a["+ i +"]과 a["+ String.valueOf(a.length-i-1) +"]를 교환합니다.");
        }
    }
    
    static int sumOf(int[] a){
        int sn = 0;
        for (int idx:a) {
            sn += idx;
        }
        return sn;
    }
    
    static void copy(int[] a, int[] b){
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    static void rcopy(int[] a, int[] b){
        reverse(a);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = scan.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x["+i+"]:");
            x[i] = scan.nextInt();
        }

        reverse(x);

        System.out.println("x = "+ Arrays.toString(x));
        System.out.println("역순 정렬을 마쳤습니다.");

        System.out.println("배열의 모든 합은: "+ String.valueOf(sumOf(x)));

        int[] a = new int[x.length];
        copy(a, x);
        System.out.println("복사된 배열:"+Arrays.toString(a));

        reverse(a);
    }
}
