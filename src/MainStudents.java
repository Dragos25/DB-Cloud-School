import java.util.*;

public class MainStudents {

    public static void main(String[] args) {
        HashMap<Integer, TreeSet<Student>> grades = new HashMap<>();
        Student student1 = new Student("Marcel", 9.5d);
        Student student2 = new Student("Gigel", 8.4d);
        Student student3 = new Student("Marian", 7.6d);
        Student student4 = new Student("Ionica", 8.9d);
        Student student5 = new Student("Andrei", 6.3d);
        Student student6 = new Student("Maria", 9.4d);
        Student student7 = new Student("Diana", 5.3d);
        Student student8 = new Student("Roxana", 10d);
        Student student9 = new Student("Roxana", 9.8d);


        for(int i=1;i<=10;i++){
            TreeSet<Student> newTree = new TreeSet<>();
            newTree = (TreeSet<Student>) newTree.descendingSet();
            grades.put(i,newTree);
        }



        addStudentToMap(student1, grades);
        addStudentToMap(student2, grades);
        addStudentToMap(student3, grades);
        addStudentToMap(student4, grades);
        addStudentToMap(student5, grades);
        addStudentToMap(student6, grades);
        addStudentToMap(student7, grades);
        addStudentToMap(student8, grades);
        addStudentToMap(student9, grades);

        printMap(grades);




    }

    public static void addStudentToMap(Student student, HashMap<Integer, TreeSet<Student>> map){
        double grade = student.getGrade();
        if(grade - (int)grade >= 0.5) grade = Math.round(grade);
        else grade = Math.floor(grade);

        map.get((int)grade).add(student);


    }

    public static void printMap(HashMap<Integer, TreeSet<Student>> map){
        for(int i=1;i<=10;i++){
            if(map.get(i).size()==0) continue;
            System.out.println("Grade " + i + ":");
            printTreeSet(map.get(i));

        }
    }

    public static void printTreeSet(TreeSet<Student> set){
        for(Student student: set){
            System.out.println(student.toString());
        }
    }
}