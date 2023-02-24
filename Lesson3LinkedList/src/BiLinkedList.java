public class BiLinkedList {
    Node head;
    Node tail;

    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }

    }

    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            next.previous = next;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public class Node {
        int value;
        Node next;

        Node previous;

    }
}
