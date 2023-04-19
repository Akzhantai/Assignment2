public class MyArrayList<E> implements MyList<E>{
    private Object[] arr;
    private int size;

    public MyArrayList(){
        arr = new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if (arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }

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
    }

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
    }


    @Override
    public boolean remove(E item) {
        for (int i = 0; i < size; i++){
            if (arr[i].equals(item)){
                remove(i);
                return true;
            }
        }
        return false;
    }

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
    }

    @Override
    public void clear() {
        arr = new Object[10];
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if (arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size-1; i >= 0; i--){
            if (arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {

    }
}
