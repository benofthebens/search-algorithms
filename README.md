# AI Search Algorithms
This repository is to show and describe the implementation of **Search Algorithms** and their application in different problems in Java
## Table of Contents
- [Description](#description)
- [Table of Contents](#table-of-contents)
- [Requirements](#requirements)
- [Problems](#problems)
  - [The Jug Problem](#the-jug-problem)
    - [Description](#description)
      - [Allowed Operations](#allowed-operations)
    - [Classes](#classes)
      - [Jug](#jug)
      - [JugState](#jugstate)
      - [JugStateSpace](#jugstatespace)
- [Algorithms](#algorithms)
  - [Breadth First Search](#breadth-first-search)
  - [Depth First Search](#depth-first-search)
  - [Progressive Deepening Search](#progressive-deepening-search)
## Requirements
- Java 17+
- Gradle
## Problems
### The Jug Problem
#### Description
The Jug problem, you are given:
- Two jugs with known capacities:
  - _Jug A_ of capacity **a** liters. 
  - _Jug B_ of capacity **b** liters.
- **Unlimited** water supply from a tap.
- No measuring marks on the jugs.
- The task is to measure exactly c liters of water using the two jugs.
##### Allowed Operations
- Fill the Jug to it's max capacity
- Empty The Jug until it is completely empty
#### Classes
##### Jug

This is the Class for where a Jug is defined it has the instance variables of:
- maxCapacity
- currentCapacity

The Jug can be filled, emptied and moved and can be checked to whether they are filled or are empty. The Jug instance can also be copied

##### JugState
This class inherits from the State class which itself inherits from the Node class this class stores a state in the JugStateSpace

This class uses the edges instance variable from the Node class to store the next possible options i.e fill, empty, move
stores the Jug states in a list called jugs

##### JugStateSpace
This class inherits from the abstract class of StateSpace which contains an inital state a goal state and a list of the nodes within the State Space.

## Algorithms
### Breadth First Search
- Guaranteed to find a solution
- Admissible (In the case of uniform cost)
- Efficiency depends on where the solution is

| When To Use                                   | When Not To Use                     |
|-----------------------------------------------|-------------------------------------|
| Space is not a problem                        | Space is Limited                    |
| Need to find a solution with the fewest steps | Solution is deep in the Search Tree |
| Very deep or infinite Search trees            | The branching factor is large       |

Example Usage:
> The Jug Problem: 
> 1. Queue is initialised with enqueueing the initial state and a hashmap for visited nodes that stores the node and it's parent is used to prevent cycles.
> 2. While the Queue is not empty 
> 3. currentState is initialised with the value of dequeue on the queue.
> 4. the currentState is expanded
>   - All of the available valid transitions (i.e if a jug is empty it will not try to empty it ) are executed on the current state
>   - If the states generated exist in the visited hashmap it is ignored.
>   - The valid states are checked against the goal state
>     - if the state is the goal state it will backtrack through the hashmap and return the path
>     - if it is not the goal state it will continue
>   - The valid states are returned and enqueued into the queue
> 5. The currentState is marked as visited if it has no parent node the parent node will be marked as null.
> 6. it will either return a path to the goal node and in the case of no solution it will return no solution.
### Depth First Search
- Guaranteed to find a solution
- Not admissible 
- Efficiency depends on where the solution is

| When To Use                                                        | When Not To Use                                |
|--------------------------------------------------------------------|------------------------------------------------|
| Space is restricted                                                | Paths are infinite                             |
| Solutions are at similar depths                                    | The search graph contains cycles               |
| You might have knowledge to allow you to order nodes at each level | Some solutions are deep and others are shallow |

### Progressive Deepening Search
