package ch3.q02;

import java.util.Scanner;

class Question2 {
    static int seqSearch(int[] a, int n, int key){
        int i = 0;

        a[n] = key;
        System.out.print(" | ");
        for (int j = 0; j < a.length; j++) {
            System.out.print(j +" ");
        }
        System.out.println("");
        System.out.println("-+------------");

        for (i = 0; i <=n ; i++) {
            System.out.println(" | ");
            if(a[i] == key){
                break;
            }
        }
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = scan.nextInt();
        int[] x = new int[num+1];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i+"]:");
            x[i] = scan.nextInt();
        }

        System.out.print("검색할 값: ");
        int ky = scan.nextInt();

        int idx = seqSearch(x, num, ky);

        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("그 값은 x["+idx +"]에 있습니다.");
        }

    }
}
