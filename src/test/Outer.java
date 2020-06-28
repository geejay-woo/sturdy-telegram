package test;

public class Outer{
    public void foo(int x){
        final int y = 100;
        class MethodInner{
            int z =100;
            public int addXYZ(){return x+y+z;}
        }
    }
}