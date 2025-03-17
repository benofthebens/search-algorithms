
# AI Search Algorithms

This repository demonstrates and describes the implementation of **Search Algorithms** and their application in different problems in **Java**.

---

## Table of Contents
- [Description](#description)
- [Requirements](#requirements)
- [Problems](#problems)
  - [The Jug Problem](#the-jug-problem)
    - [Description](#description)
    - [Allowed Operations](#allowed-operations)
    - [Classes](#classes)
      - [Jug](#jug)
      - [JugState](#jugstate)
      - [JugStateSpace](#jugstatespace)
  - [Sudoku](#sudoku)
- [Algorithms](#algorithms)
  - [Breadth First Search](#breadth-first-search)
  - [Depth First Search](#depth-first-search)
  - [Progressive Deepening Search](#progressive-deepening-search)

---

## Requirements

- Java 17+
- Gradle

---

## Problems

### The Jug Problem

#### Description

In the **Jug Problem**, you are given:
- Two jugs with known capacities:
  - **Jug A** of capacity **a** liters.
  - **Jug B** of capacity **b** liters.
- **Unlimited** water supply from a tap.
- No measuring marks on the jugs.
- The task is to measure exactly **c** liters of water using the two jugs.

#### Allowed Operations

- **Fill**: Fill the jug to its maximum capacity.
- **Empty**: Empty the jug until it is completely empty.
- **Move**: Pour water from one jug to the other until one is either full or empty.

#### Classes

##### Jug
This class defines a **Jug** object with the following instance variables:
- **maxCapacity**: The maximum capacity of the jug.
- **currentCapacity**: The current amount of water in the jug.

The **Jug** class provides methods to:
- **fill** the jug to its maximum capacity.
- **empty** the jug until it's completely empty.
- **move** water between jugs.
- Check whether the jug is **filled** or **empty**.
- **copy** the jug state.

##### JugState
This class inherits from the **State** class, which itself inherits from the **Node** class. It represents a specific **state** in the **JugStateSpace**.

It stores:
- A list of **jugs** and their current states.
- The **edges** of the state (i.e., possible transitions such as fill, empty, or move).

##### JugStateSpace
This class inherits from the **StateSpace** abstract class, which includes:
- An **initial state** and a **goal state**.
- A list of **nodes** representing the possible states in the search space.

---

### Sudoku
Given an $N*N$ matrix where $N$ is a perfect square where the grid is divided into sub grids of $\sqrt{N} * \sqrt{N}$. 
Where the objective is to fill the rows and columns from 1 to $N$ so that a number appears only once in the row and column.
- Each row must contain only one of each 1 to $N$ without any repeats
- Each column must contain only one of each 1 to $N$ without any repeats
- Each  $\sqrt{N} * \sqrt{N}$ subgrid must contain the digits of 1 to $N$ without repetition
 
Goal: To find the permutation of the $N*N$ matrix that satisfies these constraints

- **State**: The state is the grid with a selected cell that is modified.
- **Transitions**: The transitions are the insertions from 1 to $N$
- **Cost**: Assuming uniform cost 
- **Initial State**: input matrix i.e: 
 
$$
\begin{bmatrix}
7 & 3 & 2 & 0 & 0 & 0 & 0 & 0 & 0 \\
0 & 0 & 6 & 1 & 0 & 0 & 0 & 0 & 0 \\
0 & 0 & 8 & 6 & 0 & 5 & 0 & 0 & 0 \\
3 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 8 \\
0 & 0 & 0 & 4 & 9 & 0 & 0 & 0 & 5 \\
0 & 9 & 0 & 0 & 0 & 0 & 0 & 6 & 0 \\
0 & 0 & 0 & 0 & 6 & 0 & 2 & 7 & 0 \\
0 & 0 & 0 & 0 & 0 & 7 & 0 & 0 & 0 \\
0 & 8 & 0 & 0 & 0 & 2 & 3 & 0 & 0 \\
\end{bmatrix}
$$

- Goal State: There is not a static goal state that is defined the goal state is just whether the output matrix satisfies the constraints i.e:
 
$$
\begin{bmatrix}
  7 & 3 & 2 & 9 & 8 & 4 & 6 & 5 & 1 \\
  9 & 5 & 6 & 1 & 2 & 3 & 8 & 4 & 7 \\
  1 & 4 & 8 & 6 & 7 & 5 & 9 & 2 & 3 \\
  3 & 7 & 4 & 2 & 5 & 6 & 1 & 9 & 8 \\
  2 & 6 & 1 & 4 & 9 & 8 & 7 & 3 & 5 \\
  8 & 9 & 5 & 7 & 3 & 1 & 4 & 6 & 2 \\
  5 & 1 & 3 & 8 & 6 & 9 & 2 & 7 & 4 \\
  4 & 2 & 9 & 3 & 1 & 7 & 5 & 8 & 6 \\
  6 & 8 & 7 & 5 & 4 & 2 & 3 & 1 & 9 \\
  \end{bmatrix}
$$

---

## Algorithms

### Breadth First Search
- **Guaranteed to find a solution**.
- **Admissible** (in the case of uniform cost).
- Efficiency depends on the location of the solution.
- Uses a Queue

#### When to Use

| ✅ **When to Use**                                   | ❌ **When Not to Use**                     |
|-----------------------------------------------------|-------------------------------------------|
| Space is not a problem                              | Space is limited                          |
| Need to find a solution with the fewest steps       | Solution is deep in the search tree       |
| Very deep or infinite search trees                  | The branching factor is large             |

#### Example Usage [The Jug Problem](#the-jug-problem)

1. **Initialize** a queue with the initial state and a hashmap for visited nodes (and their parent nodes to prevent cycles).
2. While the queue is not empty:
3. **Dequeue** the current state.
4. **Expand** the current state by executing all available valid transitions (fill, empty, or move).
5. If a generated state exists in the visited hashmap, **ignore** it.
6. **Check** the generated state against the goal state:
    - If it matches the goal state, **backtrack** through the visited hashmap to find the path.
    - If not, continue the search.
7. **Enqueue** valid states and mark them as visited.
8. Mark the current state as visited if it doesn't have a parent node (mark parent as null).

#### Example Usage [Sudoku](#sudoku)
1. Initialise a queue with the initial state and a hashmap for the visited nodes
2. While the queue is not empty
3. to get the currenState dequeue from the queue.
4. expand the currentState by executing all available and valid transitions i.e the insertion of valid numbers in the cell from 1 to $N$
5. Check if the generated state meets the criteria of the goal state
6. enqueue the valid states and mark the as visited
   - If it matches the pre-conditions backtrack though the hashmap from the currentState and reverse the list.
   - If not continue the search.
7. Mark the current state as visited if it doesn't have a parent node (mark parent as null)

---

### Depth First Search
- **Guaranteed to find a solution**.
- **Not admissible**.
- Efficiency depends on the location of the solution.
- Uses Stack (Recursion)

#### When to Use

| ✅ **When to Use**                                           | ❌ **When Not to Use**                          |
|-------------------------------------------------------------|------------------------------------------------|
| Space is restricted                                         | Paths are infinite                             |
| Solutions are at similar depths                             | The search graph contains cycles               |
| You have knowledge to allow ordering of nodes at each level | Some solutions are deep and others are shallow |

#### Example Usage [The Jug Problem](#the-jug-problem)

#### Example Usage [Sudoku](#sudoku)

---

### Progressive Deepening Search

- Compromise between BFS and DFS.
- Added extra variable of depth bound (d) which imposes backtracking when the frontier is at that depth.
- If the no solution is found at depth d increase d.
- Save nodes that are found at depth d to a pending list.
  - If open is empty and the goal is not found move the pending list to the open list.

| ✅ **When to Use**              | ❌ **When Not to Use**  |
|--------------------------------|------------------------|
| Limited Space                  | Known shallow solution |
| Unknown Depth of the Solution: | Large branching factor |
| Can find the optimal solution  | Non-Optimal Solutions  |

#### Example Usage [The Jug Problem](#the-jug-problem)

#### Example Usage [Sudoku](#sudoku)

---

### A star


---

### Dijkstra

---

### Branch & Bound

---