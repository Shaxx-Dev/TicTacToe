# TicTacToe
Tic Tac Toe
This is a simple console-based Tic Tac Toe game implemented in Java. The game supports two modes of play: playing against another human player or playing against the computer. The implementation uses various object-oriented programming concepts to structure the game logic.

Features:
1.	Two Modes of Play: Play against a friend or play against the computer.
2.	Computer Player: The computer player makes random valid moves.
3.	User Input Validation: Ensures that player moves are within the valid range and on unoccupied positions.
4.	Win Detection: Checks for win conditions across rows, columns, and diagonals.
5.	Board Display: Displays the current state of the game board after each move.
6.	Draw Detection: Identifies if the game ends in a draw when the board is full and there is no winner.
7.	Object-Oriented Programming Concepts Used

Topics Used for developing:

1.Classes and Objects:
tictactoe: This class contains the game board and methods to initialize the board, display it, place marks, and check win conditions.
player (abstract class): An abstract class that defines common properties and methods for players.
humanplayer: A subclass of player that handles moves made by human players.
Computer player: A subclass of player that handles moves made by the computer 

2.Inheritance:
player: The humanplayer and Computer player classes inherit from the abstract player class, implementing the makemove method specific to each type of player.

3.Encapsulation:
Private Members: The board in the tictactoe class is private, ensuring that it can only be accessed and modified through public methods.

4.Polymorphism:
Method Overriding: The makemove method is overridden in the humanplayer and Computer player classes to provide specific implementations for each type of player.

5.Abstraction:
Abstract Class: The player class is abstract, providing a template for what a player should do without implementing the specifics.



