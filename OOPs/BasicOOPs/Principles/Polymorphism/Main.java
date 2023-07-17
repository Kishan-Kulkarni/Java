package OOPs.BasicOOPs.Principles.Polymorphism;

public class Main {
    public static void main(String[] args) {
        //Implementation of polymorphism
        Shapes circle=new Circle();
        //Initialy, according to compile time which only looks at reference variables, the area() in Shapees will be set to 
        //run, but in runtime the object is checked and if the object also has area() then this method overides the previous method
        //so, it is imp to have area() in both the classes

        circle.area();
    }
}
