package src; /**
 * @author ：Gary Wu
 * @date ：Created in 22:11 2020/1/2
 * @description：\
 * @modified By：
 * @version: $
 * @project: 10.ObjectOrientation
 */

import java.util.*;
public class Course {

    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        // TODO implement here
        return courseName;
    }

    public void addStudent(String student) {
        // TODO implement here
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public void dropStudent(String student) {
        // TODO implement here


    }

    /**
     * @return students 学生列表
     */
    public String[] getStudents() {
        // TODO implement here
        return students;
    }

    public int getNumberOfStudents() {
        // TODO implement here
        return numberOfStudents;
    }

}