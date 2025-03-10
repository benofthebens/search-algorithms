package org.machines.problems.jug;

import org.machines.search.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JugState extends State {

    private List<Jug> jugs;

    public JugState(List<Jug> jugs) {
        super();
        this.jugs = jugs.stream()
                .map(Jug::copy)
                .collect(Collectors.toList());
    }
    public List<Jug> getJugs() {
        return jugs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for(int i = 0; i < jugs.size(); i++) {
            builder.append(jugs.get(i).toString());
            if(i == jugs.size() - 1)
                continue;

            builder.append(",");
        }
        builder.append(")");
        return builder.toString();
    }

    @Override
    public State copy() {
        return new JugState(jugs);
    }

    @Override
    public List<State> expand() {
        List<State> states = new ArrayList<>();
        List<JugState> emptyJugs = jugs.stream().map(
                jug -> {
                    List<Jug> jugList = new ArrayList<>();
                    for (Jug value : jugs) {
                        if (jug.equals(value) && !jug.isEmpty()) {
                            Jug jugCopy = jug.copy();
                            jugCopy.empty();
                            jugList.add(jugCopy);
                            continue;
                        }
                        if(!jug.isEmpty()) {
                            jugList.add(value);
                        }
                    }
                    if (!jugList.isEmpty()) {
                        return new JugState(jugList);
                    }
                    return null;
                }
        ).toList();
        List<JugState> fillJugs = jugs.stream().map(
                jug -> {
                    List<Jug> jugList = new ArrayList<>();
                    for (Jug value : jugs) {
                        if (jug.equals(value) && !jug.isFull()) {
                            Jug jugCopy = jug.copy();
                            jugCopy.fill();
                            jugList.add(jugCopy);
                            continue;
                        }
                        if (!jug.isFull()) {
                            jugList.add(value);
                        }
                    }
                    if (!jugList.isEmpty()) {
                        return new JugState(jugList);
                    }
                    return null;
                }
        ).toList();
        List<JugState> movedJugs  = jugs.stream().map(
                jug -> {
                    List<Jug> jugList = new ArrayList<>();
                    for(Jug value : jugs) {
                        if(!jug.equals(value) && !jug.isEmpty() && !value.isFull()) {
                            Jug source= jug.copy();
                            Jug target = value.copy();

                            jugList.add(null);
                            jugList.add(null);

                            source.moveTo(target);

                            jugList.set(jugs.indexOf(jug), source);
                            jugList.set(jugs.indexOf(value), target);

                        }
                    }
                    if(!jugList.isEmpty()) {
                        return new JugState(jugList);
                    }
                    return null;
                }
        ).toList();
        states.addAll(emptyJugs);
        states.addAll(fillJugs);
        states.addAll(movedJugs);
        states = states.stream().filter(state -> !Objects.isNull(state)).collect(Collectors.toList());
        this.edges.addAll(states);
        return states;
    }

    @Override
    public boolean isGoalState(State goalState, State currentState) {
        JugState jugGoalState = (JugState) goalState;
        JugState jugCurrentState = (JugState) currentState;

        return (
                jugGoalState.getJugs().get(0).getCurrentCapacity() == jugCurrentState.getJugs().get(0).getCurrentCapacity() &&
                jugGoalState.getJugs().get(1).getCurrentCapacity() == jugCurrentState.getJugs().get(1).getCurrentCapacity()
        );
    }
}
