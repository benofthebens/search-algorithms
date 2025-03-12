package org.machines;

import org.machines.problems.maptransversal.MapState;
import org.machines.problems.maptransversal.MapStateSpace;
import org.machines.search.State;
import org.machines.search.algorithm.Astar;
import org.machines.search.algorithm.Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<State> mapStates = new ArrayList<>();

        MapState mapState = new MapState("A", 0,0);
        MapState mapState2 = new MapState("B", 6,7);
        MapState mapState3 = new MapState("C",10,1);
        MapState mapState4 = new MapState("D",7,6);
        MapState mapState5 = new MapState("E",4,2);
        MapState mapState6 = new MapState("F", 8,6);

        mapState.addEdge(mapState2);
        mapState.addEdge(mapState3);
        mapState2.addEdge(mapState4);
        mapState3.addEdge(mapState5);
        mapState4.addEdge(mapState6);
        mapState3.addEdge(mapState6);

        mapStates.add(mapState);
        mapStates.add(mapState2);
        mapStates.add(mapState3);
        mapStates.add(mapState4);
        mapStates.add(mapState5);
        mapStates.add(mapState6);

        Dijkstra dijkstra = new Dijkstra(mapStates);
        Astar astar = new Astar(mapStates);

        MapStateSpace mapStateSpace = new MapStateSpace(mapState, mapState6, astar);
        mapStateSpace.addNode(mapState);
        mapStateSpace.addNode(mapState2);
        mapStateSpace.addNode(mapState3);
        mapStateSpace.addNode(mapState4);
        mapStateSpace.addNode(mapState5);
        mapStateSpace.addNode(mapState6);
        System.out.println(mapStateSpace.search());

    }
}