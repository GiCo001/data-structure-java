package array;

/**
 * 描述:
 * 1)数组的插入，删除，按照下标随机访问操作；
 * 2）数组的类型是int类型
 *
 * @author YJM
 * @create 2019-03-11 15:58
 */
public class Array {
    //数组
    public int data[];
    //数组长度
    private int n;
    //数组实际个数
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
        }
        //将index的数往后推
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        //将index后面的数往前推
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.remove(4);
        array.printAll();
    }
}
