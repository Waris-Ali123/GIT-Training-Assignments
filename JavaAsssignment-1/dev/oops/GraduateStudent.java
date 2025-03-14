package dev.oops;

public class GraduateStudent extends Student{

    enum Specialization{ ARTIFICAIL_INTELLIGENCE,DATA_SCIENCE,MACHINE_LEARNING }
    private boolean isPlaced;
    private double cgpa;

    private String projectName;
    private Specialization specialization;

    public GraduateStudent(String studentName, int marks, boolean isPlaced, double cgpa, String projectName, Specialization specialization) {
        super(studentName, marks);
        this.isPlaced = isPlaced;
        this.cgpa = cgpa;
        this.projectName = projectName;
        this.specialization = specialization;
    }

    public GraduateStudent(String studentName, boolean isPlaced, double cgpa, String projectName, Specialization specialization) {
        super(studentName);
        this.isPlaced = isPlaced;
        this.cgpa = cgpa;
        this.projectName = projectName;
        this.specialization = specialization;
    }

    public GraduateStudent(String studentName,double cgpa, String projectName, Specialization specialization) {
        super(studentName);
        this.isPlaced = false;
        this.cgpa = cgpa;
        this.projectName = projectName;
        this.specialization = specialization;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        System.out.printf("Student Specialization : %s %n",getSpecialization());
        System.out.printf("Student Project Name : %s %n",getProjectName());
        System.out.printf("Student is placed : %b %n",isPlaced());
        System.out.printf("Student Marks : %d %n",getMarks());
    }

    //Overlaoding displayDetails() method of Graduate Student Class.
    public void displayDetails(boolean showGraduateDetails) {
        super.displayDetails();     //shows only simple student data
        if(showGraduateDetails)    displayDetails();  //shows the data for the graduate student.
    }

}
