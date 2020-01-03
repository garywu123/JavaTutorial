package src;

import src.Course;

/**
 * @author     ：Gary Wu
 * @date       ：Created in 22:11 2020/1/2 
 * @description：
 * @modified By：
 * @version: $
 */

public class TestCourse {

    public static void main(String[] args) {
        Course course1 = new Course("Data structure");
        Course course2 = new Course("Data science");

        course1.addStudent("Gary");
        course1.addStudent("Bobo");
        course1.addStudent("Ginger");

        course2.addStudent("Kelvin");
        course2.addStudent("Stephen");

        System.out.println("Number of students in course: " + course1.getNumberOfStudents());
        String[] students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++) {
            System.out.print(students[i] + ", ");
        }
        System.out.println();
        System.out.println("Number of students in course: " + course2.getNumberOfStudents());
    }
}
