# Game-of-Life-
This program simulates John Von Neumann's Game of Life. The definition of life according to John Von Neumann is that a cell is alive if it can reproduce itself and simulate a Turing machine.

The user must be able to provide these 3 things as arguments when executing the program from Console:

the size of the square grid (any integer)
the number of iterations (any integer)
whether to:
initialize the cells with a Random pattern (enter R)
The program will use a graphical display to show the iterations.  There should be sufficient delay between each iteration for the user to be able to see what's happening (not too fast, not too slow!), and the user should be able to see the individual cells (don't draw them too small!)


Running instructions:

1) Compile using “javac Life.java”
2) Run using “java LIFE size iterations R” where n is your choice of number of iterations and r
3) Program should display your choice of rule number for your choice of number of
iterations.

Example run command in Console: java Life 100 500 R will run life with a grid size 100 for 500 iterations, beginning with a random initial pattern of cells
