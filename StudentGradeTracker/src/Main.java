import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner h = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println();
        System.out.println("\t\t\t***Welcome to Student Grade Tracker***");
        while (true) {
            // Display menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add Student and Grade");
            System.out.println("2. Display All Students and Grades");
            System.out.println("3. Search for Student Grade");
            System.out.println("4. Update a Student's Grade");
            System.out.println("5. Compute Average, Highest, and Lowest Grade");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = h.nextInt();
            h.nextLine(); // Consume newline after the integer input

            switch (choice) {
                case 1:
                    // Add a student and their grade
                    System.out.print("Enter student's name: ");
                    String name = h.nextLine();
                    System.out.print("Enter student's grade: ");
                    int grade = h.nextInt();
                    students.add(new Student(name, grade));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    // Display all students and their grades
                    System.out.println("\nAll Students and Grades:");
                    if (students.isEmpty()) {
                        System.out.println("No students in the system.");
                    } else {
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 3:
                    // Search for a student's grade by name
                    System.out.print("Enter the student's name to search: ");
                    String searchName = h.nextLine();
                    boolean found = false;
                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(searchName)) {
                            System.out.println("Found student: " + student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Update a student's grade
                    System.out.print("Enter the student's name to update: ");
                    String updateName = h.nextLine();
                    found = false;
                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(updateName)) {
                            System.out.print("Enter the new grade for " + student.getName() + ": ");
                            student.setGrade(h.nextInt());
                            System.out.println("Grade updated successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    // Compute and display average, highest, and lowest grades
                    if (students.isEmpty()) {
                        System.out.println("No students to compute.");
                    } else {
                        int total = 0, highest = students.getFirst().getGrade(), lowest = students.getFirst().getGrade();
                        for (Student i : students) {
                            total += i.getGrade();
                            if (i.getGrade() > highest) {
                                highest = i.getGrade();
                            }
                            if (i.getGrade() < lowest) {
                                lowest = i.getGrade();
                            }
                        }
                        double average = total / (double) students.size();
                        System.out.printf("Average Grade: %.2f%n", average);
                        System.out.println("Highest Grade: " + highest);
                        System.out.println("Lowest Grade: " + lowest);
                    }
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Thank you for using Student Grade Tracker");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
