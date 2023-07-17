package OOPs.BasicOOPs.Principles.Inheritance;

public class BoxWeight extends Box{
    double weight;

    BoxWeight(){
        this.weight=-1;
    }

    public BoxWeight(double l, double w, double h, double weight) {
        super(l, w, h);//Responsible for calling concerned constructor in the parent class where these variables are intialized
        //Also, the variables of the parent class can be accesed by "super.variable", however they can also be accesed by "this."
        //as well but using the latter is not considered best practice.When no "super", the default constructor is called
        this.weight = weight;
    }

    public BoxWeight(Box other, double weight) {
        super(other);
        this.weight = weight;
    }

    BoxWeight(BoxWeight other){
        super(other);
        this.weight=other.weight;
    }
    
}
