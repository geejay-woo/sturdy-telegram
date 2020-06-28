package datastructure;

public class QuickUnionUF extends UF {

    public QuickUnionUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        //这里是root的充要条件就是p=id[p]
        while(p!=id[p]){
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot!=qRoot) {
            id[pRoot] = qRoot;
        }
    }

    
    
}