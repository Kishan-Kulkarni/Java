package OOPs.BasicOOPs.Principles.Inheritance;

public class Box {
    double l;
    double w;
    double h;

    Box(){
        this.l=-1;
        this.w=-1;
        this.h=-1;
    }

    Box(double side){
        this.l=side;
        this.w=side;
        this.h=side;
    }

    public Box(double l, double w, double h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    Box(Box other){
        this.l=other.l;
        this.w=other.w;
        this.h=other.h;
    }

    public void info(){
        System.out.println("Box is running");
    }
}
