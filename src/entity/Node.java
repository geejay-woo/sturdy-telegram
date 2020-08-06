package entity;

/**
 * 图中的节点
 */
public class Node {
    private Node adjacent[];
    public int adjacentCount;
    private String vertex;
    public State state;

    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;
        this.adjacentCount = 0;
        adjacent = new Node[adjacentLength];
    }

    public void addAdjacent(Node x) {
        if(adjacentCount>=adjacent.length) {
            System.out.println("can't add adjacent, cuz beyond arr's length");
            return;
        }
        this.adjacent[adjacentCount++] = x;
    }

    public Node[] getAdjacent() {
        return adjacent;
    }

    public String getVertex() {
        return vertex;
    }
}
