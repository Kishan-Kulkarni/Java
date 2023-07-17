package OOPs.BasicOOPs;
import static OOPs.packages.message.greet;
public class basics {
    public static void main(String[] args) {

        System.out.println(Student.totalStudents);

        Student student1=new Student();  //Memory is dynamically allocated at run timme due to the "new" keyword
        System.out.println(student1.name);
        System.out.println(student1.rollNo);
        System.out.println(student1.marks);
        System.out.println();

        Student student2=new Student("Samar Sodhi", 10, 100f);
        student2.printDetails();
        System.out.println();

        Student student3=new Student(student2);
        student3.printDetails();
        System.out.println();


        //Printing total student
        System.out.println("The total number of students are:" + Student.totalStudents);
        System.out.println();
        // System.out.println(student1.totalStudents); This can also be done but not the correct way to do it

        greet();
    }
    
}
