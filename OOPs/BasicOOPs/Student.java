package OOPs.BasicOOPs;

public class Student{
    String name;
    int rollNo;
    float marks;
    //"final" keyword can be used to make sure the primitive values are not changed, but for non-primitives the internal values can
    //be changed but cannot be reassigned to another non-primitive of the same type
    static long totalStudents;//As total Students is independent of what student you are talking about, it has  to be static 
    Student(){
        this ("Kishan Kulkarni" , Integer.MIN_VALUE, 0.00f);
    }

    Student(String name, int rollNo, float marks){
        System.out.println("New student created");
        this.name=name;
        this.rollNo=rollNo;
        this.marks=marks;
        Student.totalStudents+=1;/*static variables accesed using the class name and not the object name, "this" also cane be used
        but using class name is more correct."static" is intialized before any other object and hence is not object dependent(instance
        indepent or doesnot belong to an instance)
        That is why "main" method is static as it may have to run without any object created of the top most class that it is 
        a part of. This is also why a non static method cannot be used in a static method as it does creates a contradiction(static
        running without any objects created, but containing a non static which is object dependent)
        static methods are not dependent only on the objects of the class directly above them, but other subclasses that are static
        can have instances of this method aka different values for different objects
        */
    }

    Student (Student other){
        System.out.println("New student created");
        this.name=other.name;
        this.rollNo=other.rollNo;
        this.marks=other.marks;
        Student.totalStudents+=1;
    }

    void printDetails(){
        System.out.println(this.name);
        System.out.println(this.rollNo);
        System.out.println(this.marks);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Student destroyed");//This function called just before the garbage collection hits, not used for
                                                  //security issues etc.
    }

}