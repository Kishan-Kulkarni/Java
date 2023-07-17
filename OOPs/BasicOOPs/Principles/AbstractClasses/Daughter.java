package OOPs.BasicOOPs.Principles.AbstractClasses;

public class Daughter extends Parent{

    public Daughter(int age) {
        super(age);
    }

    @Override
    void greet2() {
        System.out.println("Hey I am the daughter");
    }

    @Override
    void carrer() {
        System.out.println("I want to be a Doctor");        
    }

    @Override
    void partner() {
        System.out.println("I like Tadano kun");
        
    }
    
}