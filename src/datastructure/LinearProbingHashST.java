package datastructure;

public class LinearProbingHashST<Key, Value> implements UnorderedST<Key, Value> {

    private int N = 0;
    private int M = 16;
    private Key[] keys;
    private Value[] values;

    

    public LinearProbingHashST() {
        init();
    }

    private void init() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * 删除操作应当将右侧所有相邻的键值对重新插入散列表中
     */
    @Override
    public void delete(Key key) {
        int i = hash(key);
        //找到key对应的index
        while(keys[i]!=null && !key.equals(keys[i]))
            i = (i+1)%M;
        
        //这个key不存在散列表里
        if(keys[i]==null)
            return ;
        
        //存在，i就是key在散列表中对应的index
        keys[i] = null;
        values[i] = null;

        //将之后相连的键值对重新插入
        i = (i+1)%M;

        while(keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            putuInternal(keyToRedo, valToRedo);
            i = (i+1)%M;
        }
        N--;
        resize();

    }

    @Override
    public Value get(Key key) {
        for(int i = hash(key); keys[i]!=null; i = (i+1)%M)
            if(keys[i].equals(key))
                return values[i];
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        resize();
        putuInternal(key,value);
    }

    private void putuInternal(Key key, Value value) {
        int i;
        for(i = hash(key); keys[i] != null; i=(i+1)%M)
            if(keys[i].equals(key)) {
                values[i] = value;
                return ;
            }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    private void resize() {
        if(N>M/2)
            resize(2*M);
        else if(N<=M/8)
            resize(M/2);
    }

    private void resize(int cap) {
        LinearProbingHashST<Key,Value> t = new LinearProbingHashST<>(cap);
        for(int i = 0; i<M; i++)
            if(keys[i]!=null)
                t.putuInternal(keys[i], values[i]);
        keys = t.keys;
        values = t.values;
        M = t.M;
    }


    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public LinearProbingHashST(int m) {
        this.M = m;
        init();
    }

    
    
}