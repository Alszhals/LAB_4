import java.util.Random;
public class Main {
    public static void main(String[] args) {
        MyHashtable<MyTestingClass, Student> table = new MyHashtable<>();

        Random random = new Random();


        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(10000);
            String name = "Name" + i;
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student(id, "Student" + i);
            table.put(key, value);
        }


    }
}