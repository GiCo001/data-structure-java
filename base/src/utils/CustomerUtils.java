package utils;

/**
 * 描述:
 *
 * @author YJM
 * @create 2019-03-13 14:11
 */
public class CustomerUtils {
    public static int[] random(int n) {
        int[] a = new int[n];
        for (int i = 0; i < 10; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        return a;
    }

    public static void printAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }
}
