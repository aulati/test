package cn.aulati.test.leetcode.solution;

import cn.aulati.test.model.TreeNode;

import java.util.*;

public class Solution {
    /**
     * 1160. 拼写单词
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     *
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     *
     * 注意：每次拼写时，chars 中的每个字母都只能用一次。
     *
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     *
     * 示例 1：
     * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
     * 输出：6
     * 解释：
     * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
     *
     * 示例 2：
     * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
     * 输出：10
     * 解释：
     * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words 词汇表
     * @param chars 字母表
     * @return 可拼出的所有单词的长度之和
     */
    public int countCharacters(String[] words, String chars) {
        HashSet<Character> t = new HashSet<>();
        for (char c: chars.toCharArray()) {
            t.add(c);
        }

        int ret = 0, i, wordLen;

        // 题目要求 chars 中的每个字母都只能使用一次
        for (String word: words) {
            i = 0;
            wordLen = word.length();

            while (i < wordLen && t.contains(word.charAt(i))) {
                i++;
            }

            if (i == wordLen) {
                ret += wordLen;
            }
        }


        return ret;
    }

    public int numRollsToTarget3ms(int d, int f, int target) {
        if (d == 1) {
            return target <= f ? 1: 0;
        }
        else if (d > target || d * f < target) {
            return 0;
        }
        else if (d == target || d * f == target) {
            return 1;
        }

        int[] lastCache = new int[target + 1];
        Arrays.fill(lastCache, 1, Math.min(target, f) + 1, 1);

        int mod = (int) (Math.pow(10, 9) + 7);
        int[] curCache = new int[target + 1];
        for (int i = 2; i <= d; i++) {
            curCache[i - 2] = curCache[i - 1] = 0;
            for (int j = i, maxJ = Math.min(target, i * f); j <= maxJ; j++) {
                // f(d, f, target) = sum(f(d - 1, f, target - k)), 1 <= k <= f
                // curCache 的计算方式，在 lastCache 上从左往右平移一个大小为f的窗口，计算窗口内数字的和
                // curCache[j] = lastCache[j - 1 -f + 1] + lastCache[j - 1 -f + 1] + ... + lastCache[j - 1]
                //             = (lastCache[j - 1 -f] + ... + lastCache[j - 1 - 1]) + lastCache[j - 1] - lastCache[j - 1 -f]
                //             = curCache[j - 1] + lastCache[j - 1] - lastCache[j - 1 - f]
                curCache[j] = (lastCache[j - 1] + curCache[j - 1] - (j - 1 - f >= 0 ? lastCache[j - 1 - f] : 0)) % mod;
                if (curCache[j] < 0) {
                    curCache[j] += mod;
                }
            }
            int[] temp = lastCache;
            lastCache = curCache;
            curCache = temp;
        }
        return lastCache[target];
    }

    /**
     * 1155. 掷骰子的N种方法
     * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
     *
     * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
     *
     * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。
     *
     * 示例 1：
     * 输入：d = 1, f = 6, target = 3
     * 输出：1
     *
     * 示例 2：
     * 输入：d = 2, f = 6, target = 7
     * 输出：6
     *
     * 示例 3：
     * 输入：d = 2, f = 5, target = 10
     * 输出：1
     *
     * 示例 4：
     * 输入：d = 1, f = 2, target = 3
     * 输出：0
     *
     * 示例 5：
     * 输入：d = 30, f = 30, target = 500
     * 输出：222616187
     *
     * @param d 骰子数量
     * @param f 骰子的面数量
     * @param target 总点数
     * @return 掷出该总点数的组合数量
     */
    public int numRollsToTarget(int d, int f, int target) {
        int[][] n = new int[d + 1][target + 1];

        // 使用 1 个骰子，能掷出 1 ~ f 点的组合均为 1 种，其它点数组合为 0 种
        for (int j = Math.min(f, target); j >= 1; j--) {
            n[1][j] = 1;
        }

        /*
         * 使用 i(2 <= i <= d) 个骰子，掷出 t(i <= t <= target || (f * i)) 点的组合数量 n(i, t)
         * n(i, t) = n(i-1, t-1) + n(i-1, t-2) + ... + n(i-1, t-f)
         */
        int j;
        for (int i = 2; i <= d; i++) {
            for (int t = i; t <= target; t++) {
                n[i][t] = 0;
                j = t > f ? (t - f) : 0;
                for (; j < t; j++) {
                    n[i][t] += n[i - 1][j];

                    // 模 10^9 + 7
                    n[i][t] = n[i][t] % 1000000007;
                }
            }
        }

        return n[d][target];
    }

    /**
     *
     * @param text
     * @return
     */
    public int maxRepOpt1(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }

        int len = text.length();
        char[] tc = text.toCharArray();
        HashMap<Character, LinkedList<TextRange>> a = new HashMap<>();
        int cnt;
        for (int i = 0; i < len;) {
            TextRange tr = new TextRange();
            tr.c = tc[i];
            tr.pos = i;

            cnt = 0;
            do {
                i++;
                cnt++;
            } while (i < len && tc[i] == tc[i - 1]);

            tr.len = cnt;

            if (!a.containsKey(tr.c)) {
                LinkedList<TextRange> list = new LinkedList<>();
                list.add(tr);
                a.put(tr.c, list);
            } else {
                LinkedList<TextRange> list = a.get(tr.c);
                list.add(tr);
            }
        }

        //
        int max = 0;
        for (Character c: a.keySet()) {
            LinkedList<TextRange> list = a.get(c);
            cnt = list.size();
            if (cnt == 1) {
                max = Math.max(max, list.get(0).len);
            } else if (cnt == 2) {
                TextRange tr1 = list.get(0);
                TextRange tr2 = list.get(1);
                if (tr1.pos + tr1.len + 1 == tr2.pos) {
                    // 前后两个相同字符的串间隔一个不同的字母
                    max = Math.max(max, tr1.len + tr2.len);
                } else {
                    max = Math.max(max
                            , Math.max(tr1.len, tr2.len) + 1);
                }
            } else {
                // 该字符有3个子串
                for (int i = 1; i < cnt; i++) {
                    TextRange tr1 = list.get(i - 1);
                    TextRange tr2 = list.get(i);
                    if (tr1.pos + tr1.len + 1 == tr2.pos) {
                        max = Math.max(max, tr1.len + tr2.len + 1);
                    } else {
                        max = Math.max(max
                                , Math.max(tr1.len, tr2.len) + 1);
                    }
                }
            }
        }

        return max;
    }

    class TextRange {
        char c;
        int pos;
        int len;
    }
    /**
     * 5141. 最大的以 1 为边界的正方形
     * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
     *
     * @param grid 网格数组
     * @return 最大正方形中的元素数量
     */
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 两个二维数组，分别记录位置(i, j)的向左的以1为边的最大边长，向上的以1为边的最大边长
        int[][] left = new int[m][n];
        int[][] up = new int[m][n];
        int aMax = 0;

        // 第一个元素
        if (grid[0][0] == 1) {
            left[0][0] = 1;
            up[0][0] = 1;
            aMax = 1;
        }

        // 第一列初始化
        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 1) {
                left[i][0] = 1;
                up[i][0] = up[i - 1][0] + 1;
                aMax = 1;
            }
        }

        // 第一行初始化
        for (int i = 1; i < n; i++) {
            if (grid[0][i] == 1) {
                up[0][i] = 1;
                left[0][i] = left[0][i -1] + 1;
                aMax = 1;
            }
        }

        // 按行计算 left[i][j] 和 up[i][j]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;

                    // 计算以此位置为右下顶点的正方形的最大边长
                    for (int k = Math.min(left[i][j], up[i][j]); k > aMax; k--) {
                        if (up[i][j - k + 1] >= k && left[i -k + 1][j] >= k) {
                            aMax = k;
                            break;
                        }
                    }
                } else {
                    left[i][j] = 0;
                    up[i][j] = 0;
                }
            }
        }

        return aMax * aMax;
    }

    /**
     * 5140. 字母板上的路径
     * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
     *
     * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
     *
     * 我们可以按下面的指令规则行动：
     *
     * 如果方格存在，'U' 意味着将我们的位置上移一行；
     * 如果方格存在，'D' 意味着将我们的位置下移一行；
     * 如果方格存在，'L' 意味着将我们的位置左移一列；
     * 如果方格存在，'R' 意味着将我们的位置右移一列；
     * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
     * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
     *
     * @param target
     * @return
     */
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int iPre = 0, jPre = 0, iCur, jCur;
        int abIdx = 0;

        for (char c : target.toCharArray()) {
            // ASCII: a = 97
            abIdx = c - 97;
            iCur = abIdx / 5;
            jCur = abIdx % 5;

            if (iCur == 5) {
                // 先水平向左移动
                repeatString(sb, "L", jPre - jCur);
                repeatString(sb, "D", iCur - iPre);
            } else if (iPre == 5) {
                repeatString(sb, "U", iPre - iCur);
                repeatString(sb, "R", jCur - jPre);
            } else {
                if (iCur >= iPre) {
                    repeatString(sb, "D", iCur - iPre);
                } else {
                    repeatString(sb, "U", iPre - iCur);
                }

                if (jCur >= jPre) {
                    repeatString(sb, "R", jCur - jPre);
                } else {
                    repeatString(sb, "L", jPre - jCur);
                }
            }

            sb.append("!");
            iPre = iCur;
            jPre = jCur;
        }

        return sb.toString();
    }

    private void repeatString(StringBuilder sb, String s, int cnt) {
        for (int i = 0; i < cnt; i++) {
            sb.append(s);
        }
    }

    /**
     * 最长公共子字符串
     *
     * @param x 字符串1
     * @param y 字符串2
     * @return 字符串1、2的最长公共子字符串
     */
    public String longestSubstring(String x, String y) {
        if (x == null || x.length() == 0 || y == null || y.length() == 0) {
            return "";
        }

        int m = x.length(), n = y.length();

        int[][] c = new int[m][n];
        int maxLen = 0, maxPos = -1;

        for (int i = 1; i < m; i++) {
            c[i][0] = x.charAt(i) == y.charAt(0) ? 1 : 0;
            if (c[i][0] > maxLen) {
                maxLen = c[i][0];
                maxPos = i + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            c[0][i] = x.charAt(0) == y.charAt(i) ? 1 : 0;
            if (c[0][i] > maxLen) {
                maxLen = c[0][i];
                maxPos = 1;
            }
        }

        // x, y 长度均 >= 2 的情况
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (x.charAt(i) == y.charAt(j)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    if (c[i][j] > maxLen) {
                        maxLen = c[i][j];
                        maxPos = i + 1;
                    }
                } else {
                    c[i][j] = 0;
                }
            }
        }

        return x.substring(maxPos - maxLen, maxPos);
    }

    /**
     * 给字母字符串进行基数排序时，所需的桶大小。
     */
    private static final int STRING_BUCKETS = 256;

    /**
     * 用基数排序，给固定长度的字符串数组排序
     *
     * @param s      要排序的字符串数组
     * @param strLen 字符串的长度
     * @return 排序好的字符串数组
     */
    public String[] radixSort(String[] s, int strLen) {
        if (s.length <= 1) {
            return s;
        }

        int n = s.length;
        ArrayList<ArrayList<String>> buckets = new ArrayList<>(STRING_BUCKETS);
        for (int i = 0; i < STRING_BUCKETS; i++) {
            buckets.add(new ArrayList<>());
        }

        int sp;
        for (int j = strLen - 1; j >= 0; j--) {
            // 按当前位置的字符，分别入桶
            for (int k = 0; k < n; k++) {
                buckets.get(s[k].charAt(j)).add(s[k]);
            }

            sp = 0;
            for (int i = 0; i < STRING_BUCKETS; i++) {
                for (String item : buckets.get(i)) {
                    s[sp++] = item;
                }

                buckets.get(i).clear();
            }
        }

        return s;
    }

    /**
     * 前序序列当前位置
     */
    private int _preIdx;
    /**
     * 后序遍历序列当前位置
     */
    private int _posIdx;
    /**
     * 前序遍历序列
     */
    private int[] _preorder;
    /**
     * 中序遍历序列
     */
    private int[] _inorder;
    /**
     * 后序遍历序列
     */
    private int[] _postorder;
    /**
     * 中序遍历序列中，节点值与位置的Map。用于根据前序遍历当前节点的值，迅速确定其在中序遍历中的位置
     */
    Map<Integer, Integer> _inMap;

    public TreeNode buildTreeII(int[] inorder, int[] postorder) {
        _inorder = inorder;
        _postorder = postorder;
        _posIdx = postorder.length - 1;

        _inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            _inMap.put(inorder[i], i);
        }

        return buildTreeHelperII(0, inorder.length - 1);
    }

    private TreeNode buildTreeHelperII(int left, int right) {
        if (left > right) {
            return null;
        }

        int val = _postorder[_posIdx];
        TreeNode root = new TreeNode(val);

        _posIdx--;

        int inPos = _inMap.get(val);
        root.right = buildTreeHelperII(inPos + 1, right);
        root.left = buildTreeHelperII(left, inPos - 1);

        return root;
    }

    /**
     * 105.从前序与中序遍历序列构造二叉树
     * 标签：树，深度优先搜索，数组
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        _preIdx = 0;
        _preorder = preorder;
        _inorder = inorder;

        _inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            _inMap.put(inorder[i], i);
        }

        return buildTreeHelper(0, inorder.length);
    }

    /**
     * 从前序与中序遍历序列构造二叉树的辅助函数
     *
     * @param left  中序遍历序列中构造子树的子序列启始下标（包含）
     * @param right 中序遍历序列中构造子树的子序列终点下标（不包含）
     * @return 该中序遍历序列的子序列构造而成的二叉树
     */
    private TreeNode buildTreeHelper(int left, int right) {
        if (left == right) {
            return null;
        }

        int val = _preorder[_preIdx];
        TreeNode root = new TreeNode(val);

        int inpos = _inMap.get(val);

        _preIdx++;
        root.left = buildTreeHelper(left, inpos);
        root.right = buildTreeHelper(inpos + 1, right);

        return root;
    }

    /**
     * 94.二叉树的中序遍历（迭代算法）
     *
     * @param root 二叉树的根
     * @return 中序遍历的结果
     */
    public List<Integer> inorderTraversalII(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {

            // 沿左子树向下，依次将节点入栈，直到叶节点，此循环退出
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }

            // 从栈中取出叶节点，遍历该节点的值，然后进入其右子树
            cur = st.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    /**
     * 94.二叉树的中序遍历
     *
     * @param root 二叉树的根
     * @return 中序遍历的结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorderTraversalHelper(list, root);
        return list;
    }

    private void inorderTraversalHelper(List<Integer> list, TreeNode root) {
        if (root != null) {
            inorderTraversalHelper(list, root.left);
            list.add(root.val);
            inorderTraversalHelper(list, root.right);
        }
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 开始位置和结束位置
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0) {
            return ans;
        }

        int i = 0, j = nums.length - 1;
        int m, pos = -1;

        if (nums[i] > target || nums[j] < target) {
            return ans;
        }

        if (nums[i] != target && nums[j] != target) {
            // 二分查找出现的位置 pos
            while (i < j) {
                m = (i + j) / 2;
                if (nums[m] > target) {
                    j = m - 1;
                } else if (nums[m] < target) {
                    i = m + 1;
                } else {
                    pos = m;
                    break;
                }
            }
        } else {
            if (nums[i] == target) {
                ans[0] = 0;
                j = 0;
                while (j < nums.length && nums[j] == target) {
                    j++;
                }
                ans[1] = j - 1;
            } else {
                ans[1] = j;
                i = j;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }
                ans[0] = i + 1;
            }
            return ans;
        }

        // 中心扩展查找端点
        if (pos >= 0) {
            i = pos;
            while (i >= 0 && nums[i] == target) {
                i--;
            }
            ans[0] = i + 1;

            j = pos;
            while (j < nums.length && nums[j] == target) {
                j++;
            }
            ans[1] = j - 1;
        }

        return ans;
    }

    /**
     * 11. 盛最多水的容器
     *
     * @param height 容器高度数组
     * @return 最多的盛水量
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, s = -1;
        while (i < j) {
            if (height[i] < height[j]) {
                s = Math.max(s, (j - i) * height[i]);
                i++;
            } else {
                s = Math.max(s, (j - i) * height[j]);
                j--;
            }
        }
        return s;
    }

    /**
     * 56.合并区间
     *
     * @param intervals 区间的集合
     * @return 合并所有重叠区间后的数组
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> sorted = new LinkedList<>();

        // 1 用插入排序，将区间数组按 区间开始数字 进行排序
        int pos;
        for (int i = 0; i < intervals.length; i++) {
            pos = 0;
            for (; pos < sorted.size(); pos++) {
                if (sorted.get(pos)[0] >= intervals[i][0]) {
                    break;
                }
            }
            sorted.add(pos, intervals[i]);
        }

        // 2 按顺序合并区间
        List<int[]> ans = new ArrayList<>();
        ans.add(sorted.get(0));
        int[] pre = ans.get(0);
        int[] cur;
        for (int i = 1; i < sorted.size(); i++) {
            cur = sorted.get(i);
            if (cur[0] <= pre[1]) {
                // 当前区间与前一个区间有重叠
                pre[1] = Math.max(cur[1], pre[1]);
            } else {
                ans.add(cur);
                pre = cur;
            }
        }

        return ans.toArray(new int[0][0]);
    }

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * @param triangle 给定一个三角形
     * @return 自顶向下最小路径和
     */
    public int minimumTotalSpaceTuning(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) {
            return 0;
        }

        int[] sum = new int[n];
        sum[0] = triangle.get(0).get(0);

        List<Integer> r;
        for (int i = 1; i < n; i++) {
            r = triangle.get(i);

            // 从后往前数，该行最右边一个位置的路径和最小值 = 三角形节点值 + 前一位置的值（最小路径和只用个一维数组保存）
            sum[i] = r.get(i) + sum[i - 1];

            for (int j = i - 1; j > 0; j--) {
                // 中间位置的最小路径和 = 三角形节点值 + 上一行相邻节点的最小路径和中的较小值
                sum[j] = r.get(j) + Math.min(sum[j], sum[j - 1]);
            }

            // 第一个位置的最小路径和 = 三角形该节点的值 +
            sum[0] = r.get(0) + sum[0];
        }

        int ans = sum[0];
        for (int k = 1; k < n; k++) {
            if (sum[k] < ans) {
                ans = sum[k];
            }
        }
        return ans;
    }

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * @param triangle 给定一个三角形
     * @return 自顶向下最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) {
            return 0;
        }

        int[][] sum = new int[n][n];
        sum[0][0] = triangle.get(0).get(0);

        List<Integer> r;
        int i, j;
        for (i = 1; i < n; i++) {
            r = triangle.get(i);
            sum[i][0] = r.get(0) + sum[i - 1][0];
            int m = r.size();
            for (j = 1; j < m - 1; j++) {
                sum[i][j] = r.get(j) + Math.min(sum[i - 1][j - 1], sum[i - 1][j]);
            }
            sum[i][j] = r.get(j) + sum[i - 1][j - 1];
        }

        int ans = sum[n - 1][0];
        for (int k = 1; k < n; k++) {
            if (sum[n - 1][k] < ans) {
                ans = sum[n - 1][k];
            }
        }
        return ans;
    }

    /**
     * 71.简化路径
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     *
     * @param path 绝对路径
     * @return 简化后的规范路径
     */
    public String simplifyPath(String path) {
        String[] pathElements = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pathElements.length; i++) {
            switch (pathElements[i]) {
                case "":
                case ".":
                    break;
                case "..":
                    if (sb.length() != 0) {
                        int left = sb.lastIndexOf("/");
                        sb.delete(left, sb.length());
                    }
                    break;
                default:
                    sb.append('/');
                    sb.append(pathElements[i]);
            }
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }


    /**
     * 1106. 解析布尔表达式 (143期周赛)
     *
     * @param expression 是以上述形式给出的有效表达式，表示一个布尔值。
     * @return 布尔表达式的运算结果
     */
    public boolean parseBoolExpr(String expression) {
        boolean ans = false;


        return ans;
    }

    private boolean parseBoolExprInner(String expression, int i) {
        char c = expression.charAt(i);
        if (c == '!') {

        }
        return false;
    }


    /**
     * 1105. 填充书架(143期周赛)
     *
     * @param books       每本书的宽度和高度
     * @param shelf_width 书架的宽度
     * @return 书架的最小高度
     */
    public int minHeightShelves(int[][] books, int shelf_width) {
        int h = 0, rowW, rowH, len = books.length;
        for (int i = 0; i < len; i++) {

        }

        return h;
    }

    /**
     * 1103. 二叉树寻路(143期周赛)
     *
     * @param label 节点的标号
     * @return 返回从根节点的路径
     */
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new LinkedList<>();
        return ans;
    }

    /**
     * 143期周赛 分糖果
     *
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];

        int i = 0, curcnt = 0, cntall = candies;

        end:
        while (cntall > 0) {
            for (i = 0; i < num_people; i++) {
                curcnt++;
                if (cntall > curcnt) {
                    ans[i] += curcnt;
                    cntall -= curcnt;
                } else {
                    ans[i] += cntall;
                    break end;
                }
            }
        }


        return ans;
    }

    /**
     * 64.最小路径和 动态规划
     *
     * @param grid 参数
     * @return 路径和最小值
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        ans[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            ans[i][0] = ans[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            ans[0][j] = ans[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = grid[i][j] + (ans[i - 1][j] < ans[i][j - 1] ? ans[i - 1][j] : ans[i][j - 1]);
            }
        }

        return ans[m - 1][n - 1];
    }

    /**
     * 63.有障碍物情况下的不同路径 动态规划
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ans = new int[m][n];

        ans[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 0) {
                ans[i][0] = 0;
            } else {
                ans[i][0] = ans[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] != 0) {
                ans[0][j] = 0;
            } else {
                ans[0][j] = ans[0][j - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 0) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                }
            }
        }

        return ans[m - 1][n - 1];
    }

    /**
     * 62.不同路径
     *
     * @param m 路径图宽度
     * @param n 路径图高度
     * @return 总的路径数量
     */
    public int uniquePaths(int m, int n) {
        // ans 为到达路径表格上(i, j)位置处的总路径数
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
            }
        }

        return ans[m - 1][n - 1];
    }
}
