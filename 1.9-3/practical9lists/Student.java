package practical9lists;

public class Student implements Comparable<Student> {
    private final int idNumber;
    private final double score;

    public Student(int idNumber, double score) {
        this.idNumber = idNumber;
        this.score = score;
    }

    public int getIdNumber() { return idNumber; }
    public double getScore() { return score; }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.score, score);
    }

    @Override
    public String toString() {
        return "Студент № " + idNumber + ", балл: " + score;
    }
}
