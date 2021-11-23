package com.psj.javase;

import java.util.Random;

public class Sort {

    private static Random random = new Random();

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 1, 2, 3,7,9,6,8};
        zhijie(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void maopao(int[] nums) {//冒泡排序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void guibing(int[] nums, int left, int right) {//归并排序
        if (left < right) {
            int mid = left + (right - left) / 2;
            guibing(nums, left, mid);
            guibing(nums, mid + 1, right);
            merge(nums, left, right, mid);
        }
    }

    public static void merge(int[] nums, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int leftstart = left;
        int rightstart = mid + 1;
        int newindex = 0;
        while (leftstart <= mid && rightstart <= right) {
            if (nums[leftstart] < nums[rightstart]) {
                temp[newindex++] = nums[leftstart++];
            } else {
                temp[newindex++] = nums[rightstart++];
            }
        }
        while (leftstart <= mid) {
            temp[newindex++] = nums[leftstart++];
        }
        while (rightstart <= right) {
            temp[newindex++] = nums[rightstart++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }



    public static void zhijie(int[] nums) {//直接排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public static void kuaisu(int[] nums, int left, int right) {//快速排序
        if (left < right) {
            int i = random.nextInt(right - left + 1) + left;
            swap(nums, left, i);
            int priotindex = partition(nums, left, right);
            kuaisu(nums, left, priotindex - 1);
            kuaisu(nums, priotindex + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int proit = left;
        int index = proit + 1;
        for (int i = proit + 1; i <= right; i++) {
            if (nums[i] < nums[proit]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, proit, index - 1);
        return index - 1;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(nums, i, n);
        }
        int i = n - 1;
        while (i >= 0) {
            swap(nums, 0, i);

            sink(nums, 0, i);
            i--;
        }
    }

    //构建大顶堆
    private static void sink(int[] nums, int k, int n) {
        while (2 * k + 1 < n) {
            int childIndex = 2 * k + 1;
            if (childIndex + 1 < n && nums[childIndex + 1] > nums[childIndex]) {
                childIndex += 1;
            }
            if (nums[k] > nums[childIndex]) {
                break;
            }
            swap(nums, k, childIndex);
            k = childIndex;
        }
    }
}
