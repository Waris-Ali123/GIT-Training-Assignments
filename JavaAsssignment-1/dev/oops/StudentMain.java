package dev.oops;

public class StudentMain {
    public static void main(String[] args) {
        String lineSeperator = "-".repeat(80);



        Student s1 = new Student("Waris", 99);
        System.out.println(lineSeperator);
        System.out.println("Displaying Normal Student Details");
        System.out.println(lineSeperator);
        s1.displayDetails();


        GraduateStudent g1 = new GraduateStudent("Ali",95,true,93.5,"Image recognition", GraduateStudent.Specialization.MACHINE_LEARNING);
        System.out.println(lineSeperator);
        System.out.println("Displaying Graduate Student Details (overriding the displayDetails() method)");
        System.out.println(lineSeperator);

        g1.displayDetails();

        System.out.println(lineSeperator);
        System.out.println("Displaying Graduate Student Details but not displaying the graduate data, using overloading the displayDetails() method (Method Overloading");
        System.out.println(lineSeperator);

        g1.displayDetails(false);


        System.out.println(lineSeperator);
        System.out.println("Printing the Student s1 object by overriding Object Class String method(Method Overriding)");
        System.out.println(lineSeperator);
        System.out.println(s1);

        System.out.println(lineSeperator);
        Student baseClassObj = new GraduateStudent("Shams",56,false,55,"E-commerce", GraduateStudent.Specialization.DATA_SCIENCE);
        System.out.println("Using base class refrence for child class object showing runtime polymorphism ");
        System.out.println(lineSeperator);
        baseClassObj.displayDetails();
    }
}