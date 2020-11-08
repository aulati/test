package cn.aulati.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1286. 字母组合迭代器
 * 请你设计一个迭代器类，包括以下内容：
 *
 * 一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
 * 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 * 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
 *
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator
 *
 * iterator.next(); // 返回 "ab"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "ac"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "bc"
 * iterator.hasNext(); // 返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/iterator-for-combination
 */
public class CombinationIterator {

    private List<String> list;
    private char[] c;
    private int len = 0;
    private int idx = 0;
    private int size = 0;

    /**
     * 构造函数
     * @param characters 有序且字符唯一 的字符串
     * @param combinationLength 返回的字母组合长度
     */
    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();

        c = characters.toCharArray();
        len = c.length;

        generate("", 0, combinationLength);

        size = list.size();
    }

    public String next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < size;
    }

    /**
     * 生成所有的字母组合
     * @param pre 前续字母组合
     * @param idx 下一个字符的位置下标
     * @param left 剩余长度
     */
    private void generate(String pre, int idx, int left) {
        if (left == 0) {
            list.add(pre);
            return;
        }

        for (int i = idx; i <= len - left; i++) {
            generate(pre + c[i], i + 1, left - 1);
        }
    }
}
