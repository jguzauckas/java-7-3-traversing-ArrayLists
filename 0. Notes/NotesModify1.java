import java.util.ArrayList;

public class NotesModify1 {
    public static void main(String[] args) {
        ArrayList<Person> peopleList = new ArrayList<Person>();
        peopleList.add(new Person("Mr. G", 25));
        peopleList.add(new Person("Sam", 33));
        peopleList.add(new Person("Owen", 22));
        for (Person person : peopleList) {
            System.out.println(person);
            peopleList.remove(0);
        }
    }
}
