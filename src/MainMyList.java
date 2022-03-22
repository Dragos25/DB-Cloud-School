public class MainMyList {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(5);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(9);
        list.add(10);
        list.add(10);
        list.print();
        MyList<Student> listStudents = new MyList<>(10);
        Student student1 = new Student("Marcel", 9.5d);
        Student student2 = new Student("Gigel", 8.4d);
        Student student3 = new Student("Marian", 7.6d);
        listStudents.add(student1);
        listStudents.add(student2);
        listStudents.add(student3);

        listStudents.print();
        System.out.println(listStudents.lookup(student2));
        Student student4 = new Student("Viorel", 4d);
        System.out.println(listStudents.lookup(student4));
        System.out.println(list.lookup(2));

    }
}
