package lab11;

public class MyBinarySearchTreePlus <T extends KeyedItem<KT>,KT extends Comparable<? super KT>> extends MyBinarySearchTree<T,KT> implements BSTPInterface<T,KT> {

    public int getHeight() {
        int height = 0;
        if (root  != null) {
            height += getHeight(root);
        }
        return height;
    }
    private int getHeight(TreeNode<T> treeNode){
        if (treeNode == null) {
            return 0;
        }
        int ls = getHeight(treeNode.getLeftChild());
        int rs = getHeight(treeNode.getRightChild());
        if (ls > rs) {
            return 1 + ls;
        }
        else {
            return 1 + rs;
        }
    }

    public int getSize() {
        int size = 0;
        if (root != null) {
            size += getSize(root);
        }
        return size;
    }

    private int getSize(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int ls = getSize(treeNode.getLeftChild());
        int rs = getSize(treeNode.getRightChild());
        return ls + rs + 1;

    }

    public String toStringInorder() {
        String result ="";
        if (root != null) {
            result += toStringInorder(root);
        }
        return result;
    }
    private String toStringInorder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return "";
        }
        String result = "";
        result += toStringInorder(treeNode.getLeftChild());
        result += treeNode.getItem().getKey() + " ";
        result += toStringInorder(treeNode.getRightChild());
        return result;
    }

    public String toStringPreorder() {
        String result = "";
        if (root != null) {
            result += toStringPreorder(root);
        }
        return result;
    }
    private String toStringPreorder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return "";
        }
        String result = "";
        result += treeNode.getItem().getKey() + " ";
        result += toStringInorder(treeNode.getLeftChild());
        result += toStringInorder(treeNode.getRightChild());
        return result;
    }

    public String toStringPostorder() {
        String result = "";
        if (root != null) {
            result += toStringPostorder(root);
        }
        return result;
    }
    private String toStringPostorder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return "";
        }
        String result = "";
        result += toStringInorder(treeNode.getLeftChild());
        result += toStringInorder(treeNode.getRightChild());
        result += treeNode.getItem().getKey() + " ";
        return result;
    }

    public MyBinarySearchTreePlus<T , KT> getCopyOfTree()
    {
        MyBinarySearchTreePlus<T , KT> tree = new MyBinarySearchTreePlus<>();
        return getCopyOfTree(root, tree);

    }
    private MyBinarySearchTreePlus<T,KT> getCopyOfTree(TreeNode<T> treeNode, MyBinarySearchTreePlus<T, KT> copyTree) {
        if (treeNode != null) {
            copyTree.insert(treeNode.getItem());
            getCopyOfTree(treeNode.getLeftChild(), copyTree);
            getCopyOfTree(treeNode.getRightChild(), copyTree);
        }
        return copyTree;
    }
// returns a new tree containing a copy of the original tree
// with the same structure. Note: the new tree should not have
// any shared nodes with the original.(recursive implementation)
}
