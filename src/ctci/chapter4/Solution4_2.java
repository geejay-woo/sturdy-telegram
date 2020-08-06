package ctci.chapter4;

import entity.Graph;
import entity.Node;
import entity.State;

import java.util.LinkedList;

public class Solution4_2 {

    public boolean search(Graph g, Node start, Node end) {
        LinkedList<Node> q = new LinkedList<>();

        for(Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        Node u;
        while(!q.isEmpty()) {
            u = q.poll();
            if(u!=null) {
                for(Node v:u.getAdjacent()) {
                    if(v.state==State.Unvisited) {
                        if(v==end) return true;
                        else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }
}
