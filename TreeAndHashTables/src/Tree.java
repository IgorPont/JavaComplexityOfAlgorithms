import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root;

    public boolean exist(int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    private Node find(Node node, int value) {
        /**
         * Обход дерева в глубину от корня
         */
        if (node.value == value) {
            return node;
        } else {
            for (Node child : node.children) {
                Node result = find(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    private Node find2(int value) {
        /**
         * Еще способ обхода дерева, но в ширину, когда оно большое
         */
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }

    // Остановился на 17:25

    public class Node {
        int value;
        List<Node> children;
    }
}
