public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArray = new MyArrayList<Integer>();
        myArray.add(1);
        myArray.add(2);
        myArray.add(9);
        myArray.add(5);
        myArray.add(7);
        myArray.sort();
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println(myArray.get(i));
        }
    }
}
