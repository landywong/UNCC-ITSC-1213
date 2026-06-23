
/**
 * Represents a student with a name, student ID, and a list of enrolled courses.
 * 
 * @author ITSC 1213
 * @version Feb 15, 2025
*/

import java.util.ArrayList;

public class Student {
    private String name;
    private String studentID;
    private ArrayList<String> courses;

    /**
     * Constructs a new Student with a given name and student ID.
     * Initializes an empty list of courses.
     * 
     * @param name      The name of the student.
     * @param studentID The unique identifier for the student.
     */
    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.courses = new ArrayList<>();
    }

    /**
     * Adds a course to the student's course list if it is not already enrolled.
     * Returns the course name if added successfully, otherwise returns -99.
     * 
     * @param course The name of the course to add.
     * @return The course name if successfully added, otherwise "-99".
     */
    public String addCourse(String course) {
        // Check if the course is already in the list.
        // If not enrolled, add the course to the list and return the course name.
        // If already enrolled, return "-99" as an error code.
        // TO-DO: Implement this method

        return "-99";
    }

    /**
     * Removes a course from the student's course list if it exists.
     * Returns the course name if successfully removed, otherwise returns -99.
     * 
     * @param course The name of the course to remove.
     * @return The course name if successfully removed, otherwise "-99".
     */
    public String removeCourse(String course) {
        // Check if the course is in the list.
        // If enrolled, remove the course and return the course name.
        // If not found, return "-99" as an error code.
        // TO-DO: Implement this method

        return "-99";
    }

    /**
     * Retrieves the student's information, including name, ID, and enrolled
     * courses.
     * 
     * @return A formatted string containing the student's details.
     */
    public String getStudentInfo() {
        return "Student Name: " + name + "\nStudent ID: " + studentID + "\nCourses: " + courses;
    }

    /**
     * Retrieves the student's ID.
     * 
     * @return The student ID.
     */
    public String getStudentID() {
        return studentID;
    }
}
