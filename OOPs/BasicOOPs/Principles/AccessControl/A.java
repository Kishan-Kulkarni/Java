package OOPs.BasicOOPs.Principles.AccessControl;

public class A {
    private int num;
    private String name;
    private int[] arr;
  

    //These "private" elements can only be accessed within this file,"public" ones anywhere,when nothing is mentioned then only in
    //the current package

    public void setNum(int num) {
        this.num = num;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setArr(int[] arr) {
        this.arr = arr;
    }
    public int getNum() {
        return num;
    }
    public String getName() {
        return name;
    }
    public int[] getArr() {
        return arr;
    }



    
}
