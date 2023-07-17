package OOPs.BasicOOPs.Principles.InterfacesWithClasses;

public class NewCar{
    private Engine engine;
    private Media player=new CDPlayer();

    public NewCar(Engine engine) {
        this.engine = engine;
    }

    public NewCar() {
        engine=new PowerEngine();
    }

    public void start(){
        engine.start();
    }

    public void stop(){
        engine.stop();
    }

    public void acc(){
        engine.acc();
    }

    public void startMusic(){
        player.start();
    }                   
                                //Here we created 2 objects of engine and media and then we access the concerned method 
                                //and override it accordingly
    public void stopMusic(){
        player.stop();
    }

    public void upgradeEngine(){
        this.engine=new ElectricEngine();
    }
}
