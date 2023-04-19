public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 10; i++){
            list.add(i);
            list.clear();
        }for (int i = 0; i < 10; i++){
            System.out.println(list.get(i));
        }
    }
}
