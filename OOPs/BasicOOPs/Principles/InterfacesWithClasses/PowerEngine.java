package OOPs.BasicOOPs.Principles.InterfacesWithClasses;

public class PowerEngine implements Engine{

    @Override
    public void acc() {
        System.out.println("Accelerates like a normal power engine");        
        
    }

    @Override
    public void start() {
        System.out.println("Starts like a normal power engine");        
        
    }

    @Override
    public void stop() {
        System.out.println("Stops like a normal power engine");        
        
    }
    
}
