package org.machines.problems.jug;

import org.machines.search.algorithm.BFS;
import org.machines.search.algorithm.DFS;
import org.machines.search.algorithm.ProgressiveDeepeningSearch;

import java.util.ArrayList;
import java.util.List;

public class JugMain {
    public static void main(String[] args) {

        List<Jug> jugs = new ArrayList<>();
        jugs.add(new Jug(7));
        jugs.add(new Jug(4));
        //jugs.add(new Jug(5));
        JugState jugState = new JugState(jugs);

        List<Jug> goalJugs = new ArrayList<>();
        Jug goalJug1 = new Jug(7);
        Jug goalJug2 = new Jug(4);
        //Jug goalJug3 = new Jug(5);

        // Set the goal
        goalJug1.setCurrentCapacity(2);
        goalJug2.setCurrentCapacity(0);
        //goalJug3.setCurrentCapacity(0);

        goalJugs.add(goalJug1);
        goalJugs.add(goalJug2);
        //goalJugs.add(goalJug3);
        ProgressiveDeepeningSearch search = new ProgressiveDeepeningSearch();
        search.setMaxDepth(20);

        JugStateSpace jugStateSpacePDS= new JugStateSpace(jugState,new JugState(goalJugs), search);
        JugStateSpace jugStateSpaceDfs = new JugStateSpace(jugState,new JugState(goalJugs), new DFS());
        JugStateSpace jugStateSpaceBfs = new JugStateSpace(jugState,new JugState(goalJugs), new BFS());
        System.out.println(jugStateSpacePDS.search());
        System.out.println(jugStateSpaceDfs.search());
        System.out.println(jugStateSpaceBfs.search());
    }
}
