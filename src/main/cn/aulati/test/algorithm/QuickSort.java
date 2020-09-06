package cn.aulati.test.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    public static List<Integer> sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    private static final int THREASHOLD = 10;

    private static void qsort(int[] nums, int left, int right) {
        if (left + THREASHOLD < right) {
            int pivot = medium(nums, left, right);
            int l = left;
            int r = right - 1;
            while (l < r) {
                while (nums[++l] < pivot) {
                }
                while (nums[--r] > pivot) {
                }

                if (l < r) {
                    swap(nums, l, r);
                } else {
                    break;
                }
            }

            swap(nums, l, right - 1);
            qsort(nums, left, l - 1);
            qsort(nums, l + 1, right);

        } else {
            insertSort(nums, left, right);
        }
    }

    private static int medium(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[left] > nums[mid]) {
            swap(nums, left, mid);
        }
        if (nums[left] > nums[right]) {
            swap(nums, left, right);
        }
        if (nums[mid] > nums[right]) {
            swap(nums, mid, right);
        }
        swap(nums, mid, right -1);
        return nums[right - 1];
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private static void insertSort(int[] nums, int left, int right) {
        int len = right - left + 1;
        int j;
        for (int i = left + 1; i <= right; i++) {
            int tmp = nums[i];
            for (j = i; j > left && tmp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = tmp;
        }
    }
}
