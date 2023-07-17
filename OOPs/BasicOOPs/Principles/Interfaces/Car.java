package OOPs.BasicOOPs.Principles.Interfaces;

public class Car implements Engine , Brakes, Media{

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car");
    }

    @Override
    public void start() {
        System.out.println("I start like a normal car");        
    }

    @Override
    public void stop() {
        System.out.println("I stop like a normal car");        
    }

    @Override
    public void brakes() {
        System.out.println("I brake like a normal car");        
    }

    //Here even though there are 2 start() and stop() functions, it is only mentioned 2 times ans it doesnt care as to which
    //one we are reffering to it will override it regardless
    
}
