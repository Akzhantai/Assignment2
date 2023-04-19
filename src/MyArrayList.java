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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public boolean remove(E item) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) arr[index];
    }

    @Override
    public int IndexOf(Object o) {
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
