// 입력받은 10진수를 2진수~36진수로 기수 변환하여 출력
package ch2.ex06;

import java.util.Scanner;

public class CardConv {
    static int cardConv(int x, int r, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // r로 나눈 나머지를 저장
        do{
            d[digits++] =dchar.charAt(x%r);
            x /= r;
        }while (x != 0);

        // 배열 d의 숫자 문자열을 역순으로 정렬
        for (int i = 0; i < digits/2; i++) {
            char t = d[i];
            d[i] = d[digits - i -1];
            d[digits - i -1 ] = t;

        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int no; // 변환하는 정수
        int cd; // 기수
        int dno; // 변환 후의 자릿수
        int retry; // 다시 한번?
        char[] cno = new char[32]; // 변환 후 각 자리의 숫자를 넣어두는 문자 배열

        System.out.println("10진수를 기수 변환합니다.");
        do{
            do{
                System.out.print("변환하려는 정수 (정수는 0이상) :");
                no = scan.nextInt();
            } while(no < 0);

            do{
                System.out.print("어떤 진수로 변환할까요? (2~36): ");
                cd = scan.nextInt();
            }while(cd < 2 || cd > 36);

            dno = cardConv(no, cd, cno);

            System.out.print(cd + "진수로");
            for (int i = 0; i < dno; i++) {
                System.out.print(cno[i]);
            }
            System.out.println("입니다.");

            System.out.println("한번더? (1: y, 2: n)");
            retry = scan.nextInt();
        }while(retry == 1);
    }
}
