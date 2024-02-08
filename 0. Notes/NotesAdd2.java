import java.util.ArrayList;

public class NotesAdd2 {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(5);
        intList.add(2);
        intList.add(13);
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
            if (intList.get(i) == 2) {
                intList.add(i, 3);
            }
        }
    }
}
