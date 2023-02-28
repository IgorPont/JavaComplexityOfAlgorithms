package LeftRedBlackTree;

class node {
    node left, right;
    int data;

    // красный -> true, черный -> false
    boolean color;

    node(int data) {
        this.data = data;
        left = null;
        right = null;

        // Новый узел всегда красного цвета
        color = true;
    }
}

public class LeftRBTree {

    public static node root = null;

    // Поворот узла
    node rotateLeft(node myNode) {
        // System.out.printf("left rotation!!\n");
        node child = myNode.right;
        node childLeft = child.left;

        child.left = myNode;
        myNode.right = childLeft;

        return child;
    }

    // Поворот узла
    node rotateRight(node myNode) {
        // System.out.printf("right rotation\n");
        node child = myNode.left;
        node childRight = child.right;

        child.right = myNode;
        myNode.left = childRight;

        return child;
    }

    // Проверка на цвет
    boolean isRed(node myNode) {
        if (myNode == null)
            return false;
        return (myNode.color == true);
    }

    // Смена цвета, если два красных
    void swapColors(node node1, node node2) {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    // Вставка в красно-черное дерево
    node insert(node myNode, int data) {
        if (myNode == null)
            return new node(data);

        if (data < myNode.data)
            myNode.left = insert(myNode.left, data);

        else if (data > myNode.data)
            myNode.right = insert(myNode.right, data);

        else
            return myNode;


        // Балансировка
        if (isRed(myNode.right) && !isRed(myNode.left)) {
            myNode = rotateLeft(myNode);
            swapColors(myNode, myNode.left);
        }

        if (isRed(myNode.left) && isRed(myNode.left.left)) {
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }

        if (isRed(myNode.left) && isRed(myNode.right)) {
            myNode.color = !myNode.color;
            myNode.left.color = false;
            myNode.right.color = false;
        }

        return myNode;
    }

    // Обход
    void inorder(node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
}
