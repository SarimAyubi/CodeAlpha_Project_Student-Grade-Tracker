public class Student {
    private String name;
    private int grade;

    // Constructor
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getters and setters for name and grade
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Optional: A method to display the student details
    @Override
    public String toString() {
        return "Name: " + name + ", Grade: " + grade;
    }
}
