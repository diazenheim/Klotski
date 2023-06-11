# Klotski
## User manual

The following is a simple user manual for the usage of our 
application (`klotski`), which is a remake of the famous table 
game Klotski.

---

## Overview

**Klotski App** is a Java application that simulates the 
Klotski board game allowing to move pieces on a board
with the goal to bring the red square down to 
the red line at the bottom of the board.
The game is very intuitive and gives the possibility to 
save a match to reload it in the future but also the standard
possibility to go back until the beginning of the game, step
by stem or reset it immediately to the preset configuration. 
Furthermore we added the "Best Move" functionality which guides 
the player from whatever situation he stepped in to the end of the game.


---

## Launching the program

The simplest way to launch the program is to download the 
archive folder `Klotski.zip`  ( 
[from the git repository](https://github.com/diazenheim/Klotski),
unzip it and within the Klotski folder launch the following command 
using `java -jar target/Klotski-1.0-SNAPSHOT.jar`.  
You can also open the source code with Intellij Idea and run 
the app with it using MainWrapper as the main class
(the project dependencies are downloaded with Maven, right click on the
project root --> Mave --> Reload Project).
It requires Java 20.

---

## The Start - Choose configuration

After the start, the first dialog window is shown where the 
user is prompted to choose a configuration to start the game
by pressing the 'Load' button on the selected configuration.

---

## The Game

After the configuration selection a new window will open 
with the board containing all the pieces and a menu on the right.

The goal of the game is to bring the red Square down to the bottom 
red line. To do that, the player needs to move the other blue pieces
to free the red one.
To move the pieces the player need first to select the piece he wants 
to move and the has 3 choices:
1. using the arrows in the menu on the right according to the chosen direction
2. pressing the arrow on the keyboard according to the chosen direction
3. swipe with the mouse according to the chosen direction

The <kbd>Best Move</kbd> button helps the player by automatically
choosing the piece and doing the best move towards the game victory

The <kbd>Back</kbd> button brings back the last piece moved to its 
previous position.

The <kbd>Save Game</kbd> button gives the possibility to save a match in 
the user root location on the player PC under the folder <kbd>saved<kbd> 
which is automatically created by the program.

The <kbd>Load Game</kbd> button gives the possibility to load a game 
saved previously.

The <kbd>Reset</kbd> button gives the possibility to reset the game to the 
initial configuration.

The <kbd>Quit</kbd> button simply gives the possibility to quit the game.
This button has the extra functionality that asks the user to save the game 
if he didn't do that yet.

---

## Libraries

The main libraries we used are: 
1. Jackson: used for JSON management. The library helps by managing the conversions
from a simple POJO object to a string in JSON format and vice versa.
2. JAVAFX: used to generate the buttons thus interacting with them.

---

## Requirements 
The application needs Java 20 to run.