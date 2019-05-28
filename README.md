# LttP-clone
LttP-like game originally created for an OOP class.
The spec given to us required at least: a playable character, 3 collectible items, health, a weapon, 9 screens of content, a map, win/loss conditions, obstacles (grass, rocks, etc), 3 unique enemy types, a menu, and background music.

I do not claim ownership of any of the images in the game and it is not affilated with Nintendo in any way, shape or form.
I recorded and edited the music with an Epiphone SG Pro, an Orange amp, and Audacity, but did not write it.

This was initially a team project for CSC335 at the University of Arizona that I ended up writing almost singlehandedly, so I'm
tossing it up here as an example of something I'm a little proud of. LiJiangFeng (unknown github name) wrote the majority of the junit tests, TianZeHu (https://github.com/tianzehu) created the menu in GameView and the GameResources class, JiaZhuoMi (https://github.com/jiazhuomi) wrote the initial version of MusicPlayer. I wrote everything else, including actually implementing the save/load feature and fixing the MusicPlayer class so it actually worked. 

The .jar file is the complete version of the game with menu and win/lose conditions implemented. For some reason even with the font
in the same folder as the rest of my resources and read in with Class.getResource() it doesn't load correctly in the executable .jar file.
This causes a non-fatal exception that is only seen in the underlying console.

JavaFX, Java 1.8.202

CONTROLS
=======================
P - pauses the game and pulls up a map of the overland area

M - pulls up a simple game menu

left click - swings the sword in the direction the player is facing

right click - shoots an arrow in the direction the player is facing

WASD - movement
