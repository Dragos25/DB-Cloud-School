public class Student implements Comparable<Student>{
    private String name;
    private Double grade;

    public Student(String name, Double grade){
        this.name=name;
        this.grade=grade;
    }

    public Double getGrade(){
        return this.grade;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.grade,o.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
