package homework_2_5_120;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(7);
        list.print();

        list.forEachAfter(3);
        System.out.println();
        list.forEachTo(6);


        list2.add(21);
        list2.add(22);
        list2.add(23);
        list2.add(24);
        list2.add(25);
        list2.print();
        System.out.println();
        list2.forEachAfter(22);
        list2.print();

    }
}