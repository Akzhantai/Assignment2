# Assignment2
##MyArrayList
```

public class MyArrayList<E> implements MyList<E>{
    private Object[] arr;
    private int size;

    public MyArrayList(){
        arr = new Object[10];
        size = 0;
        // This is the constructor method, which initializes the array to a default size of 10 and sets the size to 0.
    }

    @Override
    public int size() {
        return size;
    }
    // This method returns the size of the array.
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if (arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }// This method checks if the specified object is present in the array.

    @Override
    public void add(E item) {
        if (size == arr.length){
            Object[] newArr = new Object[arr.length*2];
            for (int i = 0; i < size; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size++] = item;
    }// This method adds an element to the end of the array. If the array is full, it creates a new array with twice the size.

    @Override
    public void add(E item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            for (int i = index; i < size; i++){
                newArr[i+1] = arr[i];
            }
            arr = newArr;
        }else {
            for (int i = size -1; i >= index; i++){
                arr[i+1] = arr[i];
            }
        }
        arr[index] = item;
        size++;
    }// This method adds an element to the specified index in the array. If the array is full, it creates a new array with twice the size.
// If the index is invalid, it throws an IndexOutOfBoundsException.


    @Override
    public boolean remove(E item) {
        for (int i = 0; i < size; i++){
            if (arr[i].equals(item)){
                remove(i);
                return true;
            }
        }
        return false;
    }// This method removes the first occurrence of the specified element from the array and returns true.
// If the element is not found, it returns false.

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        E removed = (E) arr[index];
        for (int i = index; i < size-1; i++){
            arr[i] = arr[i+1];
        }
        size--;
        return removed;
    }// This method removes the element at the specified index from the array and returns the removed element.
// If the index is invalid, it throws an IndexOutOfBoundsException.

    @Override
    public void clear() {
        arr = new Object[10];
        size = 0;
    }
// This method clears the array by creating a new array of default size and setting the size to 0.

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) arr[index];
    }// This code is part of a class that implements a generic List interface // The following method overrides the get method of the List interface to return the element at a specified index // It first checks if the index is valid, throwing an exception if it's out of bounds // It then casts the element at the index to the generic type E and returns it

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if (arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }// The following method overrides the indexOf method of the List interface to return the index of the first occurrence of a specified object // It searches through the array and returns the index when the specified object is found // If the object is not found, it returns -1

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size-1; i >= 0; i--){
            if (arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }// The following method overrides the lastIndexOf method of the List interface to return the index of the last occurrence of a specified object // It searches through the array backwards and returns the index when the specified object is found // If the object is not found, it returns -1

    @Override
    public void sort() {
        for (int i = 0; i < size-1; i++){
            for (int j = i+1; j < size; j++){
                E e1 = (E) arr[i];
                E e2 = (E) arr[j];
                if(((Comparable<E>)e1).compareTo(e2)>0){
                    arr[i] = e2;
                    arr[j] = e1;
                }// The following method overrides the sort method of the List interface to sort the array using a selection sort algorithm // It compares each element of the array to every other element to determine its correct position // If the first element is greater than the second element, it swaps their positions
            }
        }
    }
}
```
This code defines a class MyArrayList that implements the MyList interface, which is a custom List interface. The MyArrayList class is a generic class that takes a type parameter E for the elements of the list.

The class has a private instance variable arr, which is an array of Objects that will store the elements of the list, and an integer variable size that will keep track of the number of elements in the list.

The MyArrayList class implements all the methods of the MyList interface, including:

size(): Returns the number of elements in the list.
contains(Object o): Returns true if the list contains the specified element, false otherwise.
add(E item): Adds the specified element to the end of the list. If the array is full, it creates a new array with twice the size.
add(E item, int index): Adds the specified element to the list at the specified index. If the array is full, it creates a new array with twice the size. If the index is invalid, it throws an IndexOutOfBoundsException.
remove(E item): Removes the first occurrence of the specified element from the list and returns true. If the element is not found, it returns false.
remove(int index): Removes the element at the specified index from the list and returns the removed element. If the index is invalid, it throws an IndexOutOfBoundsException.
clear(): Removes all elements from the list.
get(int index): Returns the element at the specified index. If the index is invalid, it throws an IndexOutOfBoundsException.
indexOf(Object o): Returns the index of the first occurrence of the specified element in the list. If the element is not found, it returns -1.
lastIndexOf(Object o): Returns the index of the last occurrence of the specified element in the list. If the element is not found, it returns -1.
sort(): Sorts the list in ascending order using a selection sort algorithm.
The MyArrayList class uses an array to store the elements of the list. When the array is full and a new element needs to be added, the class creates a new array with twice the size and copies the elements from the old array to the new array.

The MyArrayList class is a simple implementation of a List that can be used to store a collection of elements. However, it has some limitations, such as being slower than other List implementations when the number of elements is large, and not being thread-safe.

##MyLinkedList
```
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
        if (head == null) {
            return -1;
        }
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (tail == null) {
            return -1;
        }
        int index = size - 1;
        Node current = tail;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public void sort() {
        head = mergeSort(head);
        // Update tail reference
        Node current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        tail = current;
    }

    private Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        // Split list in half
        Node slow = node;
        Node fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = slow.next;
        slow.next = null;
        second.prev = null;
        // Recursively merge sublists
        Node left = mergeSort(node);
        Node right = mergeSort(second);
        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node dummy = new Node(null);
        Node current = dummy;
        while (left != null && right != null) {
            if (((Comparable<E>)left.element).compareTo(right.element) < 0) {
                current.next = left;
                left.prev = current;
                left = left.next;
            } else {
                current.next = right;
                right.prev = current;
                right = right.next;
            }
            current = current.next;
        }
        if (left != null) {
            current.next = left;
            left.prev = current;
        } else {
            current.next = right;
            right.prev = current;
        }
        // Update prev references
        Node tail = dummy.next;
        while (tail.next != null) {
            tail.next.prev = tail;
            tail = tail.next;
        }
        return dummy.next;
    }
}
```
This is a Java implementation of a doubly linked list, which is a data structure that stores a sequence of elements with each element containing references to the previous and next elements.
The class that contains the code extends the AbstractList class and overrides several of its methods, including get(), indexOf(), lastIndexOf(), and sort().
The get() method returns the element at the specified index in the list. It first checks whether the index is within the valid range (i.e., between 0 and the size of the list). If the index is valid, it uses a loop to traverse the list starting from either the head or the tail, depending on whether the index is closer to the beginning or the end of the list. Finally, it returns the element at the specified index.
The indexOf() method returns the index of the first occurrence of the specified object in the list. It first checks whether the head of the list is null, in which case it immediately returns -1. Otherwise, it uses a loop to traverse the list, checking each element against the specified object until a match is found. If a match is found, it returns the index of the matching element. If the end of the list is reached without finding a match, it returns -1.
The lastIndexOf() method is similar to indexOf(), but it returns the index of the last occurrence of the specified object in the list. It traverses the list from the tail to the head and returns the index of the first matching element it encounters. If no matching element is found, it returns -1.
The sort() method uses the merge sort algorithm to sort the list in ascending order. It first calls a private helper method, mergeSort(), to recursively divide the list into sublists until each sublist contains only one element. Then, it calls another private helper method, merge(), to merge the sublists back together in sorted order. Finally, it updates the head and tail references to reflect the sorted list.
The mergeSort() method recursively divides a given list into two sublists, using the slow/fast pointer technique. It first checks whether the list is empty or contains only one element. If so, it returns the list unchanged. Otherwise, it uses the slow/fast pointer technique to split the list in half, and then recursively applies mergeSort() to each half. Finally, it calls the merge() method to merge the two sorted sublists back together.
The merge() method merges two sorted sublists into a single sorted list. It creates a dummy node as a placeholder for the new list and uses two pointers to traverse the two sublists. It compares the elements at the current positions of the two pointers and adds the smaller element to the new list, updating the pointers as needed. Once one of the sublists is fully processed, it adds the remaining elements of the other sublist to the new list. Finally, it updates the prev references of the new list to reflect the doubly linked structure.
