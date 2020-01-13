# Double Slided
The Individual Project for Worcester Polytechnic's Software Engineering Course

Course dates: October - December 2019

(Group Project available [here](https://github.com/mastlouis/CS3733-Lydia))

## Contents
- [Double Slided](#double-slided)
  - [Contents](#contents)
  - [Overview](#overview)
    - [Project Goal](#project-goal)
    - [Branch Functions](#branch-functions)
  - [Solver](#solver)
  - [The EBC Model](#the-ebc-model)
    - [The Entity Layer](#the-entity-layer)
    - [The Boundary Layer](#the-boundary-layer)
    - [The Controller Layer](#the-controller-layer)

## Overview

This project is a game written in Java that launches a GUI using [WindowBuilder](https://www.eclipse.org/windowbuilder/) and [Java Swing](https://docs.oracle.com/javase/8/docs/technotes/guides/swing/index.html). The game consists of eight double-sided tiles in a 3x3 grid. The front (grey side) of each tile has a number between 1 and 4, and the back (black side) has a number that is 5 minus the number on the front. Clicking on a tile adjacent to the blank space will flip the tile over and swap its position with the blank space. If all four of the same number appear at any given time, the player has lost the game.

There are four configurations in which the game can start (01, 234, 56, 789). The game can be reset back to the chosen configuration at any time. There is also a move-counter that tracks how many moves the player has made.

### Project Goal

The main learning objective for this project was to learn the [Entity Boundary Controller Model](#the-ebc-model) – a framework for designing and organizing larger-scale programming projects.

### Branch Functions

There are four branches to this project – master, testCases, stringNotation, and solver.

The master branch is the first working iteration of Double Slided.

The testCases branch contains enough JUnit test cases to test the program with 80% code coverage.

The stringNotation branch is where I created a standard to represent each board state as a string.

The solver branch is focused on [solving every possible board state](#solver) rather than on letting the user play the game. 

## Solver

The solver branch has a series of classes that can generate and solve every board state. The following is an explanation of how the solver works.

First, a permutation generator generates every permutation of 9 numbers(0-8). I assigned numbers to each type of tile. 

| Symbol on Front of Tile | Corresponding Numbers |
| :---------------------- | :-------------------- |
| 1                       | 1, 2                  |
| 2                       | 3, 4                  |
| 3                       | 5, 6                  |
| 4                       | 7, 8                  |
| (Blank Space)           | 9                     |

The permutation generated corresponds to the positions in which the tiles will be placed on the board. The first number is the top left square, the second number is the top middle square, and so on. Each pair of numbers that correspond to the same tile must be in ascending order form left to right, or the permutation will be discarded as a duplicate.

The solver uses a breadth-first-search with a few optimizations to save computations. For each permutation generated, the solver attempts to move the blank tile in all four possible directions. For each valid direction, the solver will check whether or not the board is in the solved state. If the board is not in a solved state, the solver checks whether or not that board state has been encountered before. If the board state has not been encountered before, the solver converts the board state into a string and places that string into a queue of board states to check and into a list of board states reached.

One further optimization is that the solver will not attempt to move a tile back to where it just came from.

The solver is very slow, and there is probably room for optimization in converting board states to and from strings. There were a few places where I sacrificed time-efficiency in favor of space-efficiency. After seeing how slow the solver is, favoring time-efficiency in some of these cases would likely have been better.

## The EBC Model

For this course, we learned the Entity Boundary Controller (EBC) Model, which is a framework for organizing large coding projects. The idea is to categorize objects as either an entity, boundary, or controller. [Entity objects](#the-entity-layer) store the state of the system. [Boundary objects](#the-boundary-layer) make up the user interface and the actionable elements with which the user can interact. [Controller objects](#the-controller-layer) manipulate the state of the system and update the boundary to show the new state to the user.

### The Entity Layer

For this project, the entity objects were the components needed to play the game abstractly. The model is a top-level object that contains all other entity objects as fields. The entity objects used are as follows:
* [Tile](https://github.com/mastlouis/DoubleSlided/blob/solver/src/starter/entity/Tile.java)
* [Board](https://github.com/mastlouis/DoubleSlided/blob/solver/src/starter/entity/Board.java)
* [Model](https://github.com/mastlouis/DoubleSlided/blob/solver/src/starter/entity/Model.java)

### The Boundary Layer

The boundary objects are all of the classes that the GUI uses. The GUI was designed using [WindowBuilder](https://www.eclipse.org/windowbuilder/) and [Swing](https://docs.oracle.com/javase/8/docs/technotes/guides/swing/index.html). These classes including the following:
* [App](https://github.com/mastlouis/DoubleSlided/blob/solver/src/starter/entity/Model.java) (Extends [JFrame]())
* [PuzzlePanel]() (Extends [JPanel]())

### The Controller Layer

The controller objects were created around a specific design pattern. Before coding the project, we were asked to break down the design specification into a series of *Use Cases*, where each *Use Case* is a single action that the user can take. Each *Use Case* is incorporated into the application as its own controller object.

For this particular project, the boundary objects held the actionable elements that the user could interact with and that would serve as an *entry point* for the controller objects.

| Use Case   | Controller Class                                                                                                                         |
| :--------- | :--------------------------------------------------------------------------------------------------------------------------------------- |
| Move Tile  | [MoveTileController](https://github.com/mastlouis/DoubleSlided/blob/solver/src/starter/controller/MoveTileController.java)               |
| Reset Game | [ResetController](https://github.com/mastlouis/DoubleSlided/blob/solver/src/starter/controller/ResetController.java)                     |
| Exit Game  | [ExitApplicationController](https://github.com/mastlouis/DoubleSlided/blob/solver/src/starter/controller/ExitApplicationController.java) |

Each controller object had a reference to a top-level boundary object and a top-level entity object, which allowed the controller to manipulate the state of the application and transfer this information to the GUI with ease.