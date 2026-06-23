
/**
 * Manages a list of students, allowing addition, removal, and searching of students.
 * 
 * @author ITSC 1213
 * @version Feb 15, 2025
 */

import java.util.ArrayList;

public class StudentManagement {

    private ArrayList<Student> students;

    /**
     * Constructs a new StudentManagement system with an empty list of students.
     */
    public StudentManagement() {
        students = new ArrayList<>();
    }

    /**
     * Adds a new student to the student list if they are not already present.
     * Returns the student ID if added successfully, otherwise returns "-99".
     *
     * @param student The student object to add.
     * @return The student ID if successfully added, otherwise "-99".
     */
    public String addStudent(Student student) {
        // Search for the student in the list using their studentID.
        // If not already present, add the student to the list and return the student ID.
        // if already present, return "-99" as an error code.
        // TO-DO: Implement this method

        return "-99";
    }

    /**
     * Removes a student from the list based on their student ID.
     * Returns the student ID if removed successfully, otherwise returns "-99".
     *
     * @param studentID The unique ID of the student to remove.
     * @return The student ID if successfully removed, otherwise "-99".
     */
    public String removeStudent(String studentID) {
        // Search for the student in the list using their studentID.
        // If found, remove the student and return their student ID.
        // If not found, return "-99" as an error code.
        // TO-DO: Implement this method

        return "-99";
    }

    /**
     * Searches for a student in the list by their student ID.
     *
     * @param studentID The ID of the student to search for.
     * @return The student object if found, otherwise null.
     */
    public Student searchStudent(String studentID) {
        // Iterate through the list of students and check if any student’s studentID
        // matches the given ID.
        // If found, return the Student object.
        // If not found, return null.
        // TO-DO: Implement this method

        return null;
    }

    /**
     * Prints the details of all students in the system.
     * If no students are found, it prints an appropriate message.
     */
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student.getStudentInfo());
                System.out.println("-----------------------------");
            }
        }
    }
}
