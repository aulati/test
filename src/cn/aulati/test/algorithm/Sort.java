package cn.aulati.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Aulati
 */
public class Sort {

    private static Sort _instance;

    private Sort() {
    }

    public static Sort getInstance() {
        if (_instance == null) {
            _instance = new Sort();
        }
        return _instance;
    }

    /**
     * insertion sort.
     *
     * @param a
     */
    public void insertionSort(int[] a) {
        int j, tmp;
        for (int p = 1; p < a.length; p++) {
            tmp = a[p];
            for (j = p; j > 0 && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    /**
     * shell sort. use Shell's recommended sequences.
     *
     * @param a
     */
    public void shellSort(int[] a) {
        int j, tmp;
        for (int gap = a.length / 2; gap > 0; gap /= 2) {

            // an insertion sort inside
            for (int p = gap; p < a.length; p += gap) {
                tmp = a[p];

                for (j = p; j > 0 && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = tmp;
            }
        }
    }

    /**
     * shell sort, using Hibbard's sequences.
     *
     * @param a
     */
    public void shellSort(int[] a, int[] gapArr) {
        int gap, j, tmp;

        for (int i = gapArr.length - 1; i >= 0; i--) {
            gap = gapArr[i];

            // an insertion sort inside
            for (int p = gap; p < a.length; p += gap) {
                tmp = a[p];

                for (j = p; j > 0 && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = tmp;
            }
        }
    }

    /**
     * get Hibbard's array for shell sorting. h = 2^k -1
     *
     * @param len
     * @return
     */
    public int[] getHibbardArray(int len) {
        if (len <= 0) {
            return new int[0];
        }

        Double dk = Math.log(len / 2 + 1) / Math.log(2);
        int k = dk.intValue();

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = (2 << i) - 1;
        }

        return ret;
    }

    /**
     * get Swdgewick's array for shell sorting.
     *
     * @param len number of elements to be yielded.
     */
    public int[] getSedgewickArray(int len) {
        if (len <= 0) {
            return new int[0];
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);

        int i, j, m, n;
        len /= 2;

        i = 1;
        j = 2;
        m = 9 * (1 << 2 * i) - 9 * (1 << i) + 1;
        n = (1 << 2 * j) - 3 * (1 << j) + 1;

        while (m <= len || n <= len) {
            if (m < n) {
                list.add(m);
                i++;
                m = 9 * (1 << 2 * i) - 9 * (1 << i) + 1;
            } else if (m == n) {
                list.add(m);
                i++;
                m = 9 * (1 << 2 * i) - 9 * (1 << i) + 1;
                j++;
                n = (1 << 2 * j) - 3 * (1 << j) + 1;
            } else {
                list.add(n);
                j++;
                n = (1 << 2 * j) - 3 * (1 << j) + 1;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Merge sort, just as you see.
     *
     * @param a
     */
    public void mergeSort(int[] a) {
        if (a.length > 1) {
            int[] tmp = new int[a.length];
            mergeSort(a, tmp, 0, a.length - 1);
        }
    }

    /**
     * 归并排序的递归方法
     *
     * @param a     要排序的数组
     * @param tmp   临时数组
     * @param left  排序区间开始下标
     * @param right 排序区间的结束下标
     */
    private void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center, right);
        }
    }

    /**
     * Merge two sorted sub array.
     *
     * @param a
     * @param tmp
     * @param leftpos
     * @param leftend
     * @param rightend
     */
    private void merge(int[] a, int[] tmp, int leftpos, int leftend, int rightend) {
        int i, j, tp = leftpos;
        int rightpos = leftend + 1;

        i = leftpos;
        j = rightpos;
        while (i <= leftend && j <= rightend) {
            if (a[i] <= a[j]) {
                tmp[tp++] = a[i++];
            } else {
                tmp[tp++] = a[j++];
            }
        }

        // copy the rest elements
        while (i <= leftend) {
            tmp[tp++] = a[i++];
        }

        // copy the rest elements
        while (j <= rightend) {
            tmp[tp++] = a[j++];
        }

        // copy back to array a[]
        for (; leftpos <= rightend; leftpos++) {
            a[leftpos] = tmp[leftpos];
        }
    }

    /**
     * 使用迭代方法的归并排序
     *
     * @param a 要排序的数组
     */
    public void mergeSortII(int[] a) {
        if (a.length <= 1) {
            return;
        }

        int[] tmp = new int[a.length];
        int[] stmp;
        int left, right, leftEnd, rightEnd, tp, cnt = 0;

        for (int gap = 1; gap < a.length; gap <<= 1) {
            for (int curPos = 0; curPos < a.length; curPos += 2 * gap) {
                left = curPos;
                right = curPos + gap;
                if (right >= a.length) {
                    // 最后一趟只有左半部分，无须合并。直接把 [curPos, a.length - 1] 的元素从 a 复制到 tmp
                    do {
                        tmp[left] = a[left];
                        left++;
                    } while (left < a.length);

                    // 跳出里层循环
                    break;
                }

                leftEnd = right - 1;
                rightEnd = right + gap - 1;
                if (rightEnd >= a.length) {
                    // 如果右半部分
                    rightEnd = a.length - 1;
                }

                tp = curPos;
                while (left <= leftEnd && right <= rightEnd) {
                    if (a[left] <= a[right]) {
                        tmp[tp++] = a[left++];
                    } else {
                        tmp[tp++] = a[right++];
                    }
                }

                while (left <= leftEnd) {
                    tmp[tp++] = a[left++];
                }
                while (right <= rightEnd) {
                    tmp[tp++] = a[right++];
                }
            }

            // 交换 a 和 tmp
            stmp = a;
            a = tmp;
            tmp = stmp;

            // 记录 a 和 tmp 的交换次数
            cnt++;
        }

        if (cnt % 2 == 1) {
            // a 和 tmp 交换了奇数次
            for (int i = 0; i < a.length; i++) {
                a[i] = tmp[i];
            }
        }
    }

    private void mergeII(int[] a, int[] tmp, int left, int right, int rightEnd) {
        if (right >= a.length) {
            // 最后一趟只有左半部分，无须合并。直接把 [curPos, a.length - 1] 的元素从 a 复制到 tmp

        }
    }

    /**
     * 快速排序
     *
     * @param a 要排序的数组
     */
    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private final int CUTOFF = 10;

    private void quickSort(int[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            int i = left, j = right - 1;
            int pivot = median3(a, left, right);

            for (; ; ) {
                while (a[++i] < pivot) {
                }
                while (a[--j] > pivot) {
                }

                if (i < j) {
                    swapReference(a, i, j);
                } else {
                    break;
                }
            }

            swapReference(a, i, right - 1);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);

        } else {
            insertionSort(a, left, right);
        }
    }

    private int median3(int[] a, int left, int right) {
        int center = (left + right) / 2;

        // make sure a[left] < a[center] < a[right]
        if (a[right] < a[left]) {
            swapReference(a, left, right);
        }
        if (a[center] < a[left]) {
            swapReference(a, left, center);
        }
        if (a[right] < a[center]) {
            swapReference(a, right, center);
        }

        // move pivot to position: right - 1
        swapReference(a, center, right - 1);
        return a[right - 1];
    }

    private final void swapReference(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    /**
     * Insertion sort.
     *
     * @param a
     * @param left
     * @param right
     */
    public void insertionSort(int[] a, int left, int right) {
        int tmp, j;
        for (int p = left + 1; p <= right; p++) {
            tmp = a[p];
            for (j = p; j > left && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
}
