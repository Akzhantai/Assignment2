public class MyLinkedList<E> implements MyList<E> {
    private class Node {
        E element;
        Node next;
        Node prev;

        public Node(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        if (head == null) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(E item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(E item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(item);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = newNode;
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(E item) {
        if (head == null) {
            return false;
        }
        if (head.element.equals(item)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
            return true;
        }
        Node current = head.next;
        while (current != null) {
            if (current.element.equals(item)) {
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return current.element;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        if (index < size/2){
            for (int i = 0; i < index; i++){
                current = current.next;
            }
        }else {
            current = tail;
            for (int i = size -1; i > index; i--){
                current = current.prev;
            }
        }
        return current.element;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
