package test;

public class A {

    public B fun(String str) {
        
        return new B(){
            
            @Override
            public void change() {
            }

            @Override
            public void show() {
                System.out.println(str);
            }
        };
    }

    public static void main(String[] args) {
        B b = new A().fun("xixi");
        b.change();
        b.show();

    }
    
}
interface B{
    void show();
    void change();
}