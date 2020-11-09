package cn.aulati.test.leetcode;

/**
 * LeetCode Test No 696.
 * <p>
 * https://leetcode.com/problems/count-binary-substrings/
 *
 * @author Aulati
 */
public class CountBinarySubstrings {

    /**
     * a instance of this class.
     */
    private static CountBinarySubstrings _instance = null;

    private CountBinarySubstrings() {
    }

    public static CountBinarySubstrings getInstance() {
        if (_instance == null) {
            _instance = new CountBinarySubstrings();
        }
        return _instance;
    }

    /*
     * 先找到01或10子串，然后分别向前后扩展对比。
     */
    public int countBinarySubstrings(String s) {
        int len = s.length();
        int cntAll = 0, cntCur, preIdx, curIdx;
        char pre, cur;
        pre = s.charAt(0);
        for (int i = 1; i < len; ) {
            cur = s.charAt(i);
            if (cur != pre) {
                // 找到一个 10 或 01 子串，前后扩展找到以此子串为中心的最大子串
                curIdx = i + 1;
                preIdx = i - 2;
                cntCur = 1;
                while (preIdx >= 0 && curIdx < len && s.charAt(preIdx) == pre && s.charAt(curIdx) == cur) {
                    cntCur++;
                    preIdx--;
                    curIdx++;
                }

                // 把这一串的数量计入总数量中
                cntAll += cntCur;

                // 跳过该段
                pre = cur;
                i += cntCur;
            } else {
                i++;
            }
        }

        return cntAll;
    }
}
