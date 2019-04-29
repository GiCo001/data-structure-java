package structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:  二叉查找树二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值。
 * <p>
 * 树的概念：
 * <p>
 * 高度：节点到叶子节点的最长路径（边数）
 * 深度：节点到根节点所经历的边的个数
 * 层数：深度加一
 * 树的高度：根节点的高度
 * <p>
 * 分为 满二叉树  完全二叉树 非完全二叉树
 * 两种存储方式： 链表 和 顺序（不适合非完全二叉树 左右节点位置2i 2i+1  i为父节点位置  好处节省内存） 存储
 * 遍历： 前中后序遍历
 *
 * @author YJM
 * @create 2019-04-29 15:33
 */
public class BinarySearchTree {
    private Node tree;

    private List<Node> find(int value) {
        List<Node> list = new ArrayList<>();
        Node root = tree;
        while (root != null) {
            if (root.value > value) {
                root = root.leftChild;
            }
            if (root.value <= value) {
                if (root.value == value) {
                    list.add(root);
                }
                root = root.rightChlid;
            }
        }
        return list;
    }

    private void insert(int value) {
        if (tree == null) {
            tree = new Node(value);
            return;
        }
        Node root = tree;

        while (root != null) {
            if (value < root.value) {
                if (root.leftChild == null) {
                    root.leftChild = new Node(value);
                    break;
                }
                root = root.leftChild;
            }
            if (value >= root.value) {
                if (root.rightChlid == null) {
                    root.rightChlid = new Node(value);
                    break;
                }
                root = root.rightChlid;
            }
        }
    }

    private void delete(int value) {
        Node node = tree;
        Node nodeParent = null;
        while (node != null && node.value != value) {
            nodeParent = node;
            if (value < node.value) {
                node = node.leftChild;
            } else {
                node = node.rightChlid;
            }
        }
        if (node == null) {
            return;
        }
        delete(node, nodeParent);
    }

    private void delete(Node node, Node nodeParent) {
        //要删除的节点有两个子节点
        if (node.leftChild != null && node.rightChlid != null) {
            Node minRightNode = node.rightChlid;
            Node minParentRightNode = node;
            // 查找右子树中最小节点
            while (minRightNode.leftChild != null) {
                //重复的节点处理
                if (minRightNode.leftChild.value == node.value) {
                    minRightNode.leftChild = minRightNode.leftChild.rightChlid;
                    continue;
                }
                minParentRightNode = minRightNode;
                minRightNode = minRightNode.leftChild;
            }
            //替换值
            node.value = minRightNode.value;
            //指到最小值
            node = minRightNode;
            //指到最小值的父节点
            nodeParent = minParentRightNode;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node replaceNode;
        if (node.leftChild != null) {
            replaceNode = node.leftChild;
        } else if (node.rightChlid != null) {
            replaceNode = node.rightChlid;
        } else {
            replaceNode = null;
        }

        if (nodeParent == null) {
            //如果是根节点
            tree = replaceNode;
        } else if (nodeParent.leftChild == node) {
            nodeParent.leftChild = replaceNode;
        } else if (nodeParent.rightChlid == node) {
            nodeParent.rightChlid = replaceNode;
        }
    }

    private void print() {
        Node root = tree;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.value);
            if (currentNode.leftChild != null) {
                queue.add(currentNode.leftChild);
            }
            if (currentNode.rightChlid != null) {
                queue.add(currentNode.rightChlid);
            }
        }
    }

    public static class Node {
        private int value;
        private Node leftChild;
        private Node rightChlid;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(6);
        binarySearchTree.insert(8);
        binarySearchTree.insert(5);
        binarySearchTree.insert(5);
        binarySearchTree.delete(5);
        binarySearchTree.print();
    }

}
