import java.util.ArrayList;

public class NotesTraversal2 {
    public static void main(String[] args) {
        ArrayList<Double> doubleList = new ArrayList<Double>();
        doubleList.add(-4.5);
        doubleList.add(12.1);
        doubleList.add(80.23);
        for (double num : doubleList) {
            System.out.println(num);
        }
    }
}