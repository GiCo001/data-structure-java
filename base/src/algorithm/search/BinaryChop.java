package algorithm.search;

/**
 * 描述: 二分查找
 * 适合有序数组 不适合链表 链表二分查找时间复杂度为O（n）
 * 时间复杂度 O（log n）
 *
 * @author YJM
 * @create 2019-03-28 13:54
 */
public class BinaryChop {
    /**
     * 简单的二分查找  适合用在无重复数字
     *
     * @param array  有序数组
     * @param target
     * @return
     */
    public static int simpleBinaryChop(int[] array,int target){
        int length = array.length;
        int left = 0;
        int right = length-1;
        while(left<=right){
            int mid = left+(right-left>>1);
            if(array[mid]==target){
                return mid;
            }
            if(array[mid]>target){
                right = mid-1;
                continue;
            }
            if (array[mid]<target) {
                left = mid+1;
                continue;
            }
        }
        return -1;
    }

    /**
     * 二分查找 出 有序数组中第一个匹配的数（数组有重复）
     *
     * @param array
     * @param target
     * @return
     */
    public static int binaryChopTheFirst(int[] array,int target){
        int length = array.length;
        int left = 0;
        int right = length-1;
        while (left<=right){
            int mid = left+(right-left>>1);
            if(array[mid] == target){
                //如果中间的数是匹配的 那么要判断是不是第一个 判断mid前一个数是不是少于target即可
                if(mid==0||array[mid-1]<target){
                    return mid;
                }
                //如果是等于 那么继续二分  right为mid-1
                right = mid-1;
                continue;
            }
            if(array[mid]<target){
                left = mid+1;
                continue;
            }
            if(array[mid]>target){
                right = mid-1;
                continue;
            }
        }
        return -1;
    }

    /**
     *  二分查找 出 有序数组中第一个大于等于target的数（数组有重复）
     * @param array
     * @param target
     * @return
     */
    public static int binaryChopTheFirstGt(int[] array,int target) {
        int length = array.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left+(right-left>>1);
            if(array[mid]>=target){
                if(mid==0||array[mid-1]<target){
                    return mid;
                }
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return  -1;
    }

    /**
     * 二分查找 出 有序数组中最后一个匹配的数（数组有重复）
     *
     * @param array
     * @param target
     * @return
     */
    public static int binaryChopTheLast(int[] array,int target){
        int length = array.length;
        int left = 0;
        int right = length-1;
        while (left<=right){
            int mid = left+(right-left>>1);
            if(array[mid]==target){
                if(mid==length-1 || array[mid+1]>target){
                    return mid;
                }
                left = mid+1;
                continue;
            }
            if(array[mid]<target){
                left = mid+1;
                continue;
            }
            if(array[mid]>target){
                right = mid-1;
                continue;
            }
        }
        return -1;
    }
    /**
     *  二分查找 出 有序数组中最后一个小于等于target的数（数组有重复）
     * @param array
     * @param target
     * @return
     */
    public static int binaryChopTheLastLt(int[] array,int target) {
        int length = array.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left+(right-left>>1);
            if(array[mid]<=target){
                if(mid==length-1||array[mid+1]>target){
                    return mid;
                }
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return  -1;
    }

    public static int cycleBinaryChop(int[] array,int target){
        int length = array.length;
        int left = 0;
        int right=length-1;
        while(left<=right){
            int mid = left+((right-left)>>1);
            if(array[mid]==target){
                return mid;
            }
            if(array[mid]<array[right]){
                //mid右边有序 可以进行二分
                if(array[mid]<target&&array[right]>=target){
                    left = mid+1;
                    continue;
                }
                right = mid-1;
            }else {
                //左边有序
                if(array[left]<=target&&array[mid]>target){
                    right = mid-1;
                    continue;
                }
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] simpleArray = {1,3,4,5,6,7,8,9};
        int[] complexArray = {1,3,4,5,6,8,8,9,11,18};
        int[] complexArrayT = {3,4,6,7,10};
        int[] cycleArray={4,5,6,7,0,1,2};
        System.out.println(cycleBinaryChop(cycleArray,6));
        //System.out.println(simpleBinaryChop(simpleArray,3));
        //System.out.println(binaryChopTheFirstGt(complexArrayT,9));
//        int bsearch = bsearch(a, 10, 8);
//        System.out.println(bsearch);
    }
}
