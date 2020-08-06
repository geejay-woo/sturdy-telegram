package entity;

/**
 * 图
 */
public class Graph {
    private Node vertices[];
    public int count;
    public Graph(){
        vertices = new Node[30];
        count = 0;
    }
    public void addNode(Node x) {
        if(count<30)
            vertices[count++] = x;
        else
            System.out.println("Graph full");
    }
    public Node[] getNodes(){
        return vertices;
    }
}
