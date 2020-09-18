package cn.aulati.test;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        String s = sin.next();

        int len = s.length();
        int[] cnt = new int[10];
        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)) {
                case '0':
                    cnt[0]++;
                    break;
                case '1':
                    cnt[1]++;
                    break;
                case '2':
                    cnt[2]++;
                    break;
                case '3':
                    cnt[3]++;
                    break;
                case '4':
                    cnt[4]++;
                    break;
                case '5':
                    cnt[5]++;
                    break;
                case '6':
                    cnt[6]++;
                    break;
                case '7':
                    cnt[7]++;
                    break;
                case '8':
                    cnt[8]++;
                    break;
                case '9':
                    cnt[9]++;
                    break;
            }
        }

        int ans = factorial(len);
        for (int i = 0; i < 10; i++) {
            if (cnt[i] > 1) {
                ans = ans / factorial(cnt[i]);
            }
        }

        System.out.println(ans);
        
        
//        int ans = 1, curLen = 0;
//        for (int i = 0; i < 10; i++) {
//            int curCnt = 0;
//            while (cnt[i]-- > 0) {
//                ans *= (curLen + 1) - curCnt;
//            }
//        }
//
//        System.out.println(ans);
    }


    private static HashMap<Integer, Integer> map = new HashMap<>();

    private static int factorial(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }

        map.put(n, ans);
        return ans;
    }
}
