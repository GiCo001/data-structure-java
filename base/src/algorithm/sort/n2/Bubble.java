package algorithm.sort.n2;

import utils.CustomerUtils;

/**
 * 描述: 冒泡排序 稳定
 * 比较操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，一轮比较后将最大的数会被冒泡到数组最后
 * <p>
 * 最坏时间复杂度O（n^2） 倒序
 * 最好时间复杂度O（n）  已排好序
 * 平均时间复杂度为O（n^2） 平均逆有序度 （满有序度为1+2+...+n-1=n*(n-1）/2 ） 最好情况逆有序度为0 最坏是n*(n-1）/2  平均为n*(n-1）/4
 *
 * @author YJM
 * @create 2019-03-13 11:01
 */
public class Bubble {
    public static int[] bubbleSort(int[] array) {
        int temp;
        //无交换 结束标志
        boolean flag = false;
        for (int i = 0, length = array.length; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return array;
    }

    /**
     * 向下冒泡
     *
     * @param arr
     */
    private static void bubbleDownSort(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = CustomerUtils.random(10);
        long start = System.currentTimeMillis();
        CustomerUtils.printAll(bubbleSort(array));
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("bubblesort->>>>>>>:" + time);
    }
}
