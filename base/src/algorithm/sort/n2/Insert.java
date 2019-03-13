package algorithm.sort.n2;

import utils.CustomerUtils;

/**
 * 描述: 插入排序  稳定
 * 插入排序分两个区间 一个是已排区间 另一个是未排区间。初始已排区间只有一个元素，就是数组第一个元素。取未排区间中的元素，在已排区间中找到合适的插入位置插入，并保证已排区间一直有序，重复这个步骤
 * 最坏时间复杂度O（n^2） 倒序
 * 最好时间复杂度O（n）  已排好序
 * 平均时间复杂度为O（n^2）  每次操作 都相当于在已排区间（数组）中插入一个数据 数组中平均插入的时间复杂度为n 这个步骤要执行n次 即平均为O（n^2）
 *
 * @author YJM
 * @create 2019-03-13 11:02
 */
public class Insert {
    /**
     * 直接插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        for (int i = 1, length = array.length; i < length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
        return array;
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        int length = array.length;
        if (length == 1) {
            return array;
        }
        int step = length/2;
        while (step>=1){
            for(int i=step; i<length;i++){
                 int temp = array[i];
                 int j = i-step;
                 for (;j>=0;j-=step){
                     if(array[j]>temp){
                         array[j+step] = array[j];
                     }else {
                         break;
                     }
                 }
                 array[j+step] = temp;
            }
            step = step/2;
        }
        return array;
    }

    public static void main(String[] args) {
        CustomerUtils.printAll(shellSort(new int[]{4, 5, 6, 1, 2, 3}));
    }
}
