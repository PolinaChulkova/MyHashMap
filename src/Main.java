
public class Main {
    public static void main(String[] args) {
        Student st1 = new Student(1, "Polina", "Economics");
        Student st2 = new Student(2, "Viktorya", "Economics");
        Student st3 = new Student(3, "Akop", "Economics");
        Student st4 = new Student(4, "Luiza", "Math");
        Student st5 = new Student(5, "Nastya", "IT");

        HashMap<Integer, Student> hashMap = new HashMap<>(4, 2);
        hashMap.put(st1.getId(), st1);
        hashMap.put(st2.getId(), st2);
        hashMap.put(st3.getId(), st3);

        hashMap.next();
        System.out.println("-----------------------------------------");

        hashMap.put(st4.getId(), st4);
        hashMap.put(st5.getId(), st5);

        Student st = new Student(5, "Nastya", "IT");

        System.out.println(hashMap.containsValue(st));

        hashMap.next();

//        System.out.println("-----------------------------------------");
//
//        System.out.println(hashMap.get(1));
//        hashMap.remove(1);
//        System.out.println(hashMap.get(3));
//        System.out.println("-----------------------------------------");
//        hashMap.next();
//    }
    }
}
