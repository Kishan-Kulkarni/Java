package OOPs.BasicOOPs.Principles.AbstractClasses;

public abstract class Parent {
//Cannot create object of abstract classes, because by doing so the object will not be able to access the  abstract methods
    int age;
    final int VALUE;

    public Parent(int age) {
        this.age=age;
        VALUE=32984;
    }

    static void greet(){
        System.out.println("Hey");
    }

    void greet2(){
        System.out.println("Hey");
    }

    
    abstract void carrer();
    abstract void partner();
}
