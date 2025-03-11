package org.machines.problems.jug;

/**
 * @author benja
 */
public class Jug {
    private final int maxCapacity;
    private int currentCapacity;

    /**
     * @param maxCapacity
     */
    public Jug(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
    }

    /**
     * @param maxCapacity
     * @param currentCapacity
     */
    private Jug(int maxCapacity, int currentCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    /**
     * @return copy of Jug instance
     */
    public Jug copy() {
        return new Jug(maxCapacity, currentCapacity);
    }

    public void moveTo(Jug jug) {
        int availableSpace = jug.getMaxCapacity() - jug.getCurrentCapacity();

        int transferable = Math.min(currentCapacity, availableSpace);

        this.currentCapacity -= transferable;
        jug.setCurrentCapacity(jug.getCurrentCapacity() + transferable);
    }
    public void fill() {
        currentCapacity = maxCapacity;
    }
    public void empty() {
        currentCapacity = 0;
    }
    public boolean isEmpty() {
        return currentCapacity == 0;
    }
    public boolean isFull() {
        return currentCapacity == maxCapacity;
    }
    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }
    public int getCurrentCapacity() {
        return currentCapacity;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    @Override
    public String toString() {
        return String.valueOf(currentCapacity);
    }
}
