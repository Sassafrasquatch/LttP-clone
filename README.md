# LttP-clone
LttP clone originally created for an OOP class.

I do not claim ownership of any of the images in the game, and it is not affilated with Nintendo in any way, shape or form.
I recorded the music personally, but did not write it.

This was initially a team project for CSC335 at the University of Arizona that I ended up writing almost singlehandedly, so I'm
tossing it up here as an example of something I'm a little proud of. LiJiangFeng wrote the majority of the junit tests, TianZeHu created the menu in GameView and the GameResources class, JiaZhuoMi wrote the initial version of MusicPlayer. I wrote everything else. 

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
