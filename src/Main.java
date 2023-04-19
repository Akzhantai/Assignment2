public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myArray = new MyArrayList<String>();
        myArray.add("1");
        myArray.add("2");
        myArray.add("3");
        myArray.add("4");
        myArray.add("5");
        myArray.remove(1);
        myArray.clear();
        for (int i = 0; i < myArray.size(); i++){
            System.out.println(myArray.get(i));
        }
    }
}