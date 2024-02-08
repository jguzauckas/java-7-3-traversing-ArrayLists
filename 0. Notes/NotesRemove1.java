import java.util.ArrayList;

public class NotesRemove1 {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("Hi");
        strList.add("Hello");
        strList.add("Hello");
        strList.add("Hey");
        strList.add("Hello");
        strList.add("Hola");
        for (int i = 0; i < strList.size(); i++) {
            if (strList.get(i).equals("Hello")) {
                strList.remove(i);
            }
        }
        for (String str : strList) {
            System.out.println(str);
        }
    }
}
