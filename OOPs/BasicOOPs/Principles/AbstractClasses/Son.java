package OOPs.BasicOOPs.Principles.AbstractClasses;

public class Son extends Parent{
    


    public Son(int age) {
        super(age);
    }

    @Override
    void greet2() {
        System.out.println("Hey I am the son");
    }

    @Override
    void carrer() {
       System.out.println("I want to be a developer");
        
    }

    @Override
    void partner() {
        System.out.println("I like Komi san");
        
    }
    
}
