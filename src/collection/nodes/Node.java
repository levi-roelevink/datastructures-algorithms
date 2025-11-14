package collection.nodes;

public class Node<V> {
    private V val;
    private Node<V> prev;
    private Node<V> next;

    public Node(V val, Node<V> prev, Node<V> next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public Node(V val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public V getVal() {
        return val;
    }

    public Node<V> getPrev() {
        return prev; // How about null?
    }

    public Node<V> getNext() {
        return next;
    }

    public void setNext(Node<V> node) {
        next = node;
    }

    public void setPrev(Node<V> node) {
        prev = node;
    }
}
