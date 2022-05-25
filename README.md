# Quoridor
This project was developed for EDA6, a talent show proposed by eventbrite.

<div align="center">
  <img height="300em" src="https://user-images.githubusercontent.com/99847899/170375816-bcf98936-8f48-4bab-bf72-9888dd61e228.jpg"/>
</div>

## What is the challenge about?
For this challenge we could use any programming language that could implement websockets, I chose <b>java</b> because it is the only one I have learned so far :)

The participants had to develop an artificial intelligence that could play a modified version of quoridor.
The main difference is that Quoridor is normally played with one pawn per player, in this case our AI has to play with 3 pawns.

### Here are some Rules:
- Objective: each player must take their pawns to the other end of the board to earn as many points as possible. At the same time, each player has to prevent the advance of the other.

- Each player has 10 walls that they can use to hinder the other player's progress.

- The possible actions in a turn are to move or to place a wall (horizontally or vertically). The only restriction is not to completely block the path of an enemy pawn.

- The player who gets the highest score in 200 moves (100 for each player) wins.

### How to get points?
- Add the power of 2 to the distance from the square of origin.
- Locating a wall grants 3 points.
- If your pawn reaches the other side of the board, you earn 1000 points.

## Comunication: Websockets
Definition: The WebSocket API is an advanced technology that makes it possible to open a two-way interactive communication session between the user's browser and a server. With this API, you can send messages to a server and receive event-driven responses without having to poll the server for a reply.

Basically the communication works as follows:

<div align="center">
  <img height="200em" src="https://user-images.githubusercontent.com/99847899/170379561-8febbf1d-2bc1-4d04-9b30-6f930e293466.png"/>
</div>
<br>
Once connected, the bots send and receive information from the server about how the board is. For example, to indicate a move, the message sent to the server is something like this: 
"from_row": 5,
"from_col": 1,
"to_row": 4,
"to_col": 1. To locate a wall, you must specify the row, column and orientation (vertical / horizontal).
<b>
The move is sent to the server, the server verifies if it is valid, sends the board to the other bot and so on.
</b>

# MY BOT
As I said, my bot was built in java, specifically in version 8.2. It has a total of 90 unit tests for the functions that contain logic, which together determine the bot's moves (I used Junit for testing). I also used some libraries for handling websockets and messages in json format, they are in the "libraries" folder.





