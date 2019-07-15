package cn.aulati.test.algorithm;

import java.util.Arrays;
import java.util.Random;

import cn.aulati.test.ITest;

/**
 * Test all kinds of sorting algorithms.
 * @author Aulati
 *
 */
public class SortTestMain implements ITest {
	
	/* 
	 * To be invoked by TestMain
	 * 
	 * @see cn.aulati.test.ITest#runTest()
	 */
	@Override
	public void runTest() {
		test2();
	}

	private void test1() {
		int[] a = { 10, 5, 6, 2, 9, 8, 1, 4, 3, 7 };
		System.out.println("Input: " + Arrays.toString(a));

		Sort s = Sort.getInstance();
		s.mergeSortII(a);

		System.out.println("Output: " + Arrays.toString(a));
		System.out.println();
	}

	private void test2() {
		int[] numOfElements = {25, 50, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 51200, 102400};
		long[][] useTime = new long[numOfElements.length][5];
		long[] t = new long[6];
		
		Sort s = Sort.getInstance();
		
		for (int i = 0; i < numOfElements.length; i++) {
			// 1 create two arrays
			int[] arr1 = generateRandomArray(numOfElements[i]);
			int[] arr2 = arr1.clone();
			int[] arr3 = arr1.clone();
			int[] arr4 = arr1.clone();
			int[] arr5 = arr1.clone();

//			int[] ga1 = s.getHibbardArray(numOfElements[i]);
//			int[] ga2 = s.getSedgewickArray(numOfElements[i]);
			
			// 2 call sorting function
			t[0] = System.nanoTime();
			s.insertionSort(arr1);

			t[1] = System.nanoTime();
			s.shellSort(arr2);
			
			t[2] = System.nanoTime();
			s.mergeSort(arr3);
			
			t[3] = System.nanoTime();
			s.mergeSortII(arr4);

			t[4] = System.nanoTime();
			s.quickSort(arr5);
			
			t[5] = System.nanoTime();
			
			useTime[i][0] = t[1] - t[0];
			useTime[i][1] = t[2] - t[1];
			useTime[i][2] = t[3] - t[2];
			useTime[i][3] = t[4] - t[3];
			useTime[i][4] = t[5] - t[4];
		}
		
		// 3 输出各项排序所用时间
		for (int i = 0; i < numOfElements.length; i++) {
			System.out.printf("Round %2d, Elements:%7d, insSort:%,15d, shellSort:%,15d, mergeSort:%,15d, mergeSortII:%,15d, quickSort:%,15d%n"
					, i, numOfElements[i], useTime[i][0], useTime[i][1], useTime[i][2], useTime[i][3], useTime[i][4]);
		}
	}

	/**
	 * generate an array according to given param.
	 * 
	 * @param n the length.
	 * @return a random array.
	 */
	private int[] generateRandomArray(int n) {
		int[] ret = new int[n];
		
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			ret[i] = rnd.nextInt();
		}
		
		return ret;
	}
}
