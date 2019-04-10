package structure.list;

import java.util.Random;

/**
 * 描述: 跳表的一种实现方式
 * （跳表中存储的是正整数，并且存储的是不重复的）
 *
 * 结构
 * 5 head->2
 * 4 head->1->2
 * 3 head->1->2->4->5->6
 * 2 head->1->2->3->4->5->6
 * 1 head->1->2->3->4->5->6
 * 0 head->1->2->3->4->5->6
 *
 * @author YJM
 * @create 2019-04-09 17:12
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node();  // 带头链表

    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        //生成随机层数函数 在这层以及下层都要插入这个值
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        //每层要更新的数组节点
        Node update[] = new Node[level];
        for (int i = 0; i < level; ++i) {
            //update节点初始化指向head
            update[i] = head;
        }

        // 找出每一层最后一个小于value的节点 然后将value插入到这个节点后面
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;// 记录最后一个小于value的节点
        }

        // 更新每层节点
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // 如果这次的层数比总层数大 则更新
        if (levelCount < level) {
            levelCount = level;
        }
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    // 随机 level 次，如果是奇数层数 +1，防止伪随机
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public class Node {
        private int data = -1;
        /**
         * forward[0] 表示第0层 node的下一个节点
         * forward[1] 表示第1层 node的下一个节点
         */
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(5);
        skipList.insert(6);
        skipList.printAll();
    }

}
