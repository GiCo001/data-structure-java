package algorithm.sort.n2;

import utils.CustomerUtils;

/**
 * 描述: 选择排序 不稳定
 * 选择排序也分为已排区间和未排区间，但和插入排序不同的是选择排序是从未排区间中取最小的值插入到已排区间中，将已排区间的要插入最后位置和未排区间中最小值交换。
 * 插入排序则是从未排区间第一位插入到已排区间中的某个位置。
 *
 *  最坏时间复杂度O（n^2） 倒序
 *  最好时间复杂度O（n^2）  已排好序
 *  最好时间复杂度O（n^2）
 *
 *
 * @author YJM
 * @create 2019-03-13 11:02
 */
public class Select {
    public static int[] selectSort(int array[]){
        for(int i=0,length=array.length;i<length-1;i++){
            int min = i;
            for(int j=i+1;j<length;j++){
                if(array[min]>array[j]){
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return  array;
    }

    public static void main(String[] args) {
        CustomerUtils.printAll(selectSort(new int[]{4,5,6,1,2,3}));
    }
}
