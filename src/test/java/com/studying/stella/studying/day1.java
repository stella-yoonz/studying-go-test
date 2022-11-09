package com.studying.stella.studying;
import java.util.Scanner;

public class day1 {

     public void main(String[] args) {


            Scanner scan = new Scanner(System.in);

            String putNumers[] = new String[scan.nextInt()];

            for (int i = 0; i < putNumers.length; i++) {
                putNumers[i] = scan.next();
            }
                   scan.close();

            for (int i = 0; i < putNumers.length; i++) {

                int cnt = 0;	// 연속횟수
                int sum = 0;	// 누적 합산

                for (int j = 0; j < putNumers[i].length(); j++) {

                    if (putNumers[i].charAt(j) == 'O') {
                        cnt++;
                    }
                    else {
                        cnt = 0;
                    }
                    sum += cnt;
                }

                System.out.println(sum);
            }

    }

}
