class Students {
    String name ;
    int age ;
    public void printInfo(String name){
        System.out.println(name);
    }                                             /*this is compile time polymorphism here if the variable of 2 fuctons
                                                 cant be the same if they are then the return type of function is different
                                                  if a variable does reapeat then it has to be accompanied by another variable*/
    public void printInfo(int age){
        System.out.println(age);
    }
    public void printInfo(String name , int age){
        System.out.println(name + " " + age );
    }
}



public class polymorphism {
    public static void main(String[] args) {
        Students s1 = new Students();
        s1.name = "Arun";
        s1.age = 14;
        s1.printInfo(s1.name , s1.age);
    }
}
