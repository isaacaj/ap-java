package labs.student;

import util.NumScanner;

import java.util.Scanner;

public class Runner
{
    public static void main(String[] args)
    {
        Student student = new Student("Isaac Ash", 10);
        System.out.println(student);
        student.setGradeLevel(12);

        int grade = student.getGradeLevel();
        System.out.println("The student's current grade level is: " + grade);

        String name = student.getName();
        System.out.println("The student's name is: " + name);

        System.out.println("The student's ID is: " + student.getID());

        System.out.println("Please enter a name for a new student...");
        Scanner scanner = new Scanner(System.in);
        String newName = scanner.nextLine();

        System.out.println("Please enter the grade level of the new student...");
        NumScanner numScanner = new NumScanner();
        int newGrade = numScanner.nextInt(1, 13);

        Student newStudent = new Student(newName, newGrade);
        System.out.println(newStudent.getName());
        System.out.println(newStudent.toString());
        System.out.println(student.toString());
    }
}