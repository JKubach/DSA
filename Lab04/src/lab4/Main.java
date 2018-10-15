package lab4;

public class Main {

    public static void main(String[] args) {
        ListCDLSBased list = new ListCDLSBased();

        list.add(0, 1);
        System.out.println(list.get(0));
        list.add(1,5);
        System.out.println(list.get(1));
        list.add(2,7);
        System.out.println(list.get(2));
        list.add(3,10);
        System.out.println(list.get(3));
        list.add(4,20);
        System.out.println(list.get(4));
        list.add(5, 30);
        System.out.println(list.get(5));


        System.out.println();
        list.remove(3);
    }
}
