package OOPs.BasicOOPs.Principles.AbstractClasses;

public class Main {
    public static void main(String[] args) {
        Son son=new Son(30);
        Daughter daughter=new Daughter(32);

        son.carrer();
        daughter.carrer();

        son.partner();
        daughter.partner();

        Parent.greet();
        son.greet2();

        System.out.println(son.age);
    }
}
