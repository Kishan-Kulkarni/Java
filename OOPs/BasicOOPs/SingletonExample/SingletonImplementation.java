package OOPs.BasicOOPs.SingletonExample;

public class SingletonImplementation {
    public static void main(String[] args) {
        Singleton obj1=Singleton.getInstance();


        Singleton obj2=Singleton.getInstance();


        Singleton obj3=Singleton.getInstance();

        //All these 3 are pointing to the same object i.e. instance
    }
}
