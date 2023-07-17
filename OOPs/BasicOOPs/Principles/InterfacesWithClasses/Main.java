package OOPs.BasicOOPs.Principles.InterfacesWithClasses;

public class Main{
    public static void main(String[] args) {
        NewCar car=new NewCar();
        car.start();
        car.startMusic();
        car.upgradeEngine();
        car.start();
        //Here these 2 are going to give diff outputs but previously we couldnt diffrentiate between the 2
    }
}