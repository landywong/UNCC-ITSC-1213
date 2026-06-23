/**
 * This file contains automated test cases to verify the correctness of methods
 * in Student.java and StudentManagement.java
 * Each test method checks a specific functionality and prints whether the test
 * passed (✓✓✓) or failed (xxx).
 * 
 * @author ITSC 1213
 * @version Feb 15, 2025
 */

public class StudentManagementTest {
    public static void main(String[] args) {
        // Create a StudentManagement instance
        StudentManagement studentManagement = new StudentManagement();

        // Create Student objects
        Student student1 = new Student("Alice Johnson", "S001");
        Student student2 = new Student("Bob Smith", "S002");

        // Test: Add students to the management system
        System.out.println("########################################################");
        System.out.println("TEST: Adding students...");
        String student1Added = studentManagement.addStudent(student1);
        String student2Added = studentManagement.addStudent(student2);

        if (!student1Added.equals("-99") && !student2Added.equals("-99")) {
            System.out.println("✓✓✓ Passed: Students successfully added! IDs: " + student1Added + ", " + student2Added);
        } else {
            System.out.println("xxx FAIL --> Students were not added correctly.");
        }

        // Test: Attempt to add a duplicate student
        System.out.println("\n########################################################");
        System.out.println("TEST: Attempting to add duplicate student...");
        String duplicateStudent = studentManagement.addStudent(student1);
        if (duplicateStudent.equals("-99")) {
            System.out.println("✓✓✓ PASS --> Duplicate student correctly prevented.");
        } else {
            System.out.println("xxx FAIL --> Duplicate student was added.");
        }

        // Test: Enroll students in courses
        System.out.println("\n########################################################");
        System.out.println("TEST: Enrolling students in courses...");
        String addedCourse1 = student1.addCourse("Java Programming");
        String addedCourse2 = student1.addCourse("Data Structures");
        String addedCourse3 = student2.addCourse("Web Development");

        if (!addedCourse1.equals("-99") && !addedCourse2.equals("-99") && !addedCourse3.equals("-99")) {
            System.out.println(
                    "✓✓✓ PASS --> Courses successfully added: " + addedCourse1 + ", " + addedCourse2 + ", " + addedCourse3);
        } else {
            System.out.println("xxx FAIL --> Courses were not added correctly.");
        }

        // Attempt to add the same course again (should fail)
        System.out.println("\n########################################################");
        System.out.println("TEST: Attempting to add duplicate course...");
        String duplicateCourse = student1.addCourse("Java Programming");
        if (duplicateCourse.equals("-99")) {
            System.out.println("✓✓✓ PASS --> Duplicate course correctly prevented.");
        } else {
            System.out.println("xxx FAIL --> Duplicate course was added.");
        }

        // Test: Search for a student
        System.out.println("\n########################################################");
        System.out.println("TEST: Searching for student with ID S001...");
        Student foundStudent = studentManagement.searchStudent("S001");
        if (foundStudent != null && foundStudent.getStudentID().equals("S001")) {
            System.out.println("✓✓✓ PASS --> Student S001 found successfully!");
        } else {
            System.out.println("xxx FAIL --> Student S001 not found.");
        }

        // Test: Remove a course
        System.out.println("\n########################################################");
        System.out.println("TEST: Removing a course...");
        String removedCourse = student1.removeCourse("Java Programming");
        if (!removedCourse.equals("-99")) {
            System.out.println("✓✓✓ PASS --> Successfully removed course: " + removedCourse);
        } else {
            System.out.println("xxx FAIL --> Course removal failed.");
        }

        // Attempt to remove a non-existent course (should fail)
        System.out.println("\n########################################################");
        System.out.println("TEST: Attempting to remove a non-existent course...");
        String nonexistentCourse = student1.removeCourse("Python Programming");
        if (nonexistentCourse.equals("-99")) {
            System.out.println("✓✓✓ PASS --> Non-existent course removal correctly prevented.");
        } else {
            System.out.println("xxx FAIL --> Non-existent course was removed.");
        }

        // Test: Remove a student
        System.out.println("\n########################################################");
        System.out.println("TEST: Removing student S002...");
        String studentRemoved = studentManagement.removeStudent("S002");

        if (!studentRemoved.equals("-99")) {
            System.out.println("✓✓✓ PASS --> Student S002 successfully removed!");
        } else {
            System.out.println("xxx FAIL --> Student removal failed.");
        }

        // Test: Attempt to remove a non-existent student
        System.out.println("\n########################################################");
        System.out.println("TEST: Attempting to remove a non-existent student...");
        String nonexistentStudent = studentManagement.removeStudent("S005");
        if (nonexistentStudent.equals("-99")) {
            System.out.println("✓✓✓ PASS --> Non-existent student removal correctly prevented.");
        } else {
            System.out.println("xxx FAIL --> Non-existent student was removed.");
        }

    }
}
