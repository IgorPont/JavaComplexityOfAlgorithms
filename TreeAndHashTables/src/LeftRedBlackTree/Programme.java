package LeftRedBlackTree;

import static LeftRedBlackTree.LeftRBTree.root;

public class Programme {

    public static void main(String[] args) {

        LeftRBTree node = new LeftRBTree();

        root = node.insert(root, 10);

        root.color = false;

        root = node.insert(root, 20);
        root.color = false;

        root = node.insert(root, 30);
        root.color = false;

        root = node.insert(root, 40);
        root.color = false;

        root = node.insert(root, 50);
        root.color = false;

        root = node.insert(root, 25);
        root.color = false;

        node.inorder(root);

    }
}
