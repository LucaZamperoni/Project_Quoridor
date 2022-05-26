# Quoridor
This project was built as a requirement to have the opportunity to be selected for the 2022 Eventbrite Development Academy (6th edition).

<div align="center">
  <img align="auto" src="https://user-images.githubusercontent.com/99847899/170375816-bcf98936-8f48-4bab-bf72-9888dd61e228.jpg"/>
</div>

## What is the challenge about?
The participants had to develop a bot that could play a modified version of quoridor.
The main difference is that the official version of Quoridor must be played with one pawn per player, but in this case our bot has to play with 3 pawns.

For this challenge we could use any programming language that could implement websockets. I chose <b>java</b> because it is the only one I have learned so far :)


### Here are some Rules:
- Objective: each player must take their pawns to the other end of the board to earn as many points as possible. At the same time, each player has to prevent the advance of the oponent pawns.

- Each player has 10 walls that they can use to hinder the other player's progress.

- The possible actions in a turn are to move or to place a wall (horizontally or vertically). The only restriction is not to completely block the path of an enemy pawn.

- The player who gets the highest score in 200 moves (100 for each player) wins.

### How to get points?
- Add the power of 2 to the distance from the square of origin.
- Placing a wall grants 3 points.
- If your pawn reaches the other side of the board, you earn 1000 points.

## Comunication: Websockets
Definition: The WebSocket API is an advanced technology that makes it possible to open a two-way interactive communication session between the user's browser and a server. With this API, you can send messages to a server and receive event-driven responses without having to poll the server for a reply.

Basically the communication works as follows:

<div align="center">
  <img align="auto" src="https://user-images.githubusercontent.com/99847899/170379561-8febbf1d-2bc1-4d04-9b30-6f930e293466.png"/>
</div>
<br>
Once connected, the bots send and receive information from the server about how the board is. For example, to indicate a move, the message sent to the server is something like this: 
"from_row": 5,
"from_col": 1,
"to_row": 4,
"to_col": 1. To locate a wall, you must specify the row, column and orientation (vertical / horizontal).
<b>
The move is sent to the server. The server verifies if it is valid and, if so, sends the board to the other bot and so on.
</b>

# MY BOT
As I said, my bot was built in java, version 8.2. It has a total of 90 unit tests for the functions that contain logic, which together determine the bot's moves (I used JUnit for testing). I also used some libraries for handling websockets and messages in json format located in the "libraries" folder.

## How does it work?
In short, my code follows 3 steps:
1) Represents the board as a matrix.
2) Analyses the movement and profit of each pawn (both: own and enemies).
3) Based on those analysis, the bot decides whether to place a wall or to make a move.

## Some Clarifications

My bot's moves are simple: move forward, move sideways, or place a horizontal wall. With those plays I reached my main objective, which was to be among the first places in any tournament. When I achieved that goal, I decided to expend all the remaining time to the quality of the code and its documentation (for example rebuilding it using TDD, improving the performance of the functions and considerably reducing many lines of code) instead of insisting on the logic that would have been necessary to achieve higher scores in the future.

That's why the latest version of my bot doesn't place vertical walls or move backwards. If one of my pawns gets cornered, the code decides to continue playing with another pawn until the previous one is free 😉.

## And that's all, thanks for reading!! 
