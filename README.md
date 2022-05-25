# Quoridor
This project was developed for EDA6, a talent show proposed by eventbrite.

![U081c048345e74541b82c5c685103f39fn](https://user-images.githubusercontent.com/99847899/170201090-a2c6e9c7-927b-4a41-88a3-9420f98c8cd6.jpg)

## What is the challenge about?
For this challenge we could use any programming language that could implement websockets, I chose java because it is the only one I have learned so far :)

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

## Comunication
Having mentioned some of the rules, let's talk about the communication between bots ...

### Websockets
Definition: The WebSocket API is an advanced technology that makes it possible to open a two-way interactive communication session between the user's browser and a server. With this API, you can send messages to a server and receive event-driven responses without having to poll the server for a reply.

Basically the communication works as follows:

![image](https://user-images.githubusercontent.com/99847899/170199809-0c223d06-4985-4d27-9ef8-78d103a63cfb.png)




 
