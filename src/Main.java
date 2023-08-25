import classes.LinkedList;
public class Main {

    static void fn(int x) {}
    public static void main(String[] args) throws Exception {

        LinkedList<Integer> list = new LinkedList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        list.remove(list.size() / 2);
        list.set(99, 0);
        list.add(66, 1);

    }
}