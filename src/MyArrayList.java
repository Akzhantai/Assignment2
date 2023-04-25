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
    public void duplicate() {
        Object[] newArr = new Object[arr.length];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
            for (int j = 0; j < size; j++) {
                arr[j] = newArr[j];
            }
        }
    }
    public void deleteAllDuplicates(){
        for (int i = 0; i < size-1; i++){
            duplicate();
        }size--;
    }
}
