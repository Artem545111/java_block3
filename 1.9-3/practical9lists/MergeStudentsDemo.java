package practical9lists;

public class MergeStudentsDemo {
    public static void main(String[] args) {
        StudentList first = new StudentList();
        first.add(new Student(101, 86));
        first.add(new Student(102, 95));
        first.add(new Student(103, 78));

        StudentList second = new StudentList();
        second.add(new Student(201, 92));
        second.add(new Student(202, 86));
        second.add(new Student(203, 99));

        System.out.println("Первый список:");
        first.printAll();
        System.out.println("Второй список:");
        second.printAll();

        StudentList combined = StudentList.combine(first, second);
        System.out.println("Общий список по убыванию балла:");
        combined.printAll();
    }
}
