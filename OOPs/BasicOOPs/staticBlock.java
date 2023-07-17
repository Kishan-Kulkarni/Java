package OOPs.BasicOOPs;

public class staticBlock {
    static int a=4;
    static int b;

//This is called "Static Block" and is called only when the 1st object is created i.e. the class gets loaded for the 1st time
//To be used if one has to do some work on declared static variables
    static{
        System.out.println("Inside the static block rn");
        b=a*5;
    }

    public static void main(String[] args) {
        staticBlock obj1=new staticBlock();
        System.out.println(staticBlock.a +" " + staticBlock.b);
        b+=3;
        System.out.println(staticBlock.a +" " + staticBlock.b);

        staticBlock obj2=new staticBlock();
        System.out.println(staticBlock.a +" " + staticBlock.b);

    }
}
