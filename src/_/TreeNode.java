package _;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TreeNode {

    public static void main(String[] args) {
        Node<String> node = new Node<>(null, "1");

        fillTree(node);

        System.out.println(node);
        System.out.println(node.getChild());
        System.out.println(node.getChild().get(0).getChild());
    }

    static void fillTree(Node<String> parentNode) {
        if(Objects.isNull(parentNode))
            return;

        Node<String> node11 = new Node<>(parentNode, "11");
        Node<String> node12 = new Node<>(parentNode, "12");

        Node<String> node111 = new Node<>(node11, "111");
        Node<String> node112 = new Node<>(node11, "112");

        parentNode.setChild(Arrays.asList(node11, node12));
        node11.setChild(Arrays.asList(node111, node112));
    }
}

class Node<T> {
    public Node(Node<T> parent, T data) {
        this.parent = parent;
        this.data = data;
    }

    private Node<T> parent;
    private List<Node<T>> child;
    private T data;

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChild() {
        return child;
    }

    public void setChild(List<Node<T>> child) {
        this.child = child;
    }

    public T getData() {

        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "parent=" + parent +
                ", data=" + getData() +
                '}';
    }
}