package dev.oops;

public class Student {

    static int lastRollNumber = 100;

    private int studentId;
    private int marks;
    private String studentName;

    public Student(String studentName, int marks) {
        this.studentId = ++lastRollNumber;
        this.marks = marks;
        this.studentName = studentName;
    }

    public Student(String studentName) {
        this(studentName,-1);  //represents new admissions
    }

    public int getStudentId() {
        return studentId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void displayDetails(){

        System.out.printf("Student RollNo : %d %n",getStudentId());
        System.out.printf("Student Name : %s %n",getStudentName());
        System.out.printf("Student's Marks : %d %n",getMarks());

    }

    @Override
    public String toString() {
        return "%d : %s obtained %d".formatted(studentId,studentName,marks);
    }
}
