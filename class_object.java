
class Pen {
    String color; // blueprint
    String type;

    public void write() { // methods
        System.out.println("Write something");
    }

    public void printColor() {
        System.out.println(this.color);
        // 'this' is a keyword that when called describes that particular object

    }

}

class Student {
    String name;
    int age;

    public void printInfo() {
        System.out.println(this.name);
        System.out.println(this.age);

    }

    // Student(){ //non parametarised constructor usage
    // System.out.println("constuctor check");
    // }
    // Student(String newName , int newAge ){ //parametarised constructor usage
    // this.name = newName;
    // this.age = newAge ;
    // }
    Student() { // empty function defined to initialize s1

    }

    Student(Student s2) { // copy constructor; it takes info abou s2 object and puts in current object
        this.name = s2.name;
        this.age = s2.age;
    }

}

public class class_object {
    public static void main(String[] args) {
        // if a car is being manufactured, the blueprint is the class and the cars
        // manufactured are objects
        // Pen pen1 = new Pen();
        // pen1.color = "red"; //objects
        // pen1.type = "gel";
        // Pen pen2 = new Pen();
        // pen2.color ="blue";
        // pen2.type = "ball";
        // pen1.printColor();
        // pen2.printColor();

        // Student s1 = new Student();
        // s1.age =14;
        // s1.name="Arun";
        // s1.printInfo();

        /*
         * Student() is called a constructor they are methods itself but dont return
         * anything not even void,they can
         * only be called when an object is being created, the name of the constructor
         * has to be the same as that of
         * the class, they are of three types the above one is a non parametrized
         * constructor if a function bythe name
         * Student() is called after class Students , then first that is run as it is a
         * constructor(construction comes
         * first then comes implementation)
         */

        // Student s1 = new Student("Arun" , 14); //calling a parametarised constructor
        // s1.printInfo();

        Student s1 = new Student();
        s1.name = "Arun"; /*
                           * an empty Student() has to e made as s1 cant be intialised and if it cant be
                           * initialized it cant be copied to s2
                           */
        s1.age = 14;
        Student s2 = new Student(s1);
        s2.printInfo();
      Student s3 = new Student(s1);
      s3.printInfo();
    }
}
