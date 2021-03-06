package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * The main model class for the game,
 * has fields and methods to access and update
 * them for all of the various parts of the model
 * paradigm
 * 
 * @author Wes Rodgers
 */

public class GameModel extends Observable implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Player player;
	private Area currArea;
	private GameMap map;
	private GameMap dungeon;
	private boolean inDungeon = false;
	private int gameClock = 0;
	private ArrayList<GameObject> animations = new ArrayList<GameObject>();
	
	public GameModel() { 
		player = new Player();
		map = new GameMap();
		dungeon = new GameMap(true);
		currArea = map.getStartArea();
		setChanged();
		notifyObservers();
	}
	
	/**
	 * returns whether the player is in the dungeon or not
	 * @return true if we're in a dungeon, false otherwise
	 */
	public boolean inDungeon() {
		return inDungeon;
	}
	
	/**
	 * toggles the indungeon flag
	 */
	public void toggleInDungeon() {
		inDungeon = !inDungeon;
	}
	
	/**
	 * getter for the Player
	 * 
	 * @return the Player object
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * moves the player character
	 * 
	 * @param d the amount to move along the x-axis
	 * @param e the amount to move along the y-axis
	 */
	public void updatePlayerPosition(double d, double e) {
		player.updatePosition(d, e);
		setChanged();
		notifyObservers(currArea);
	}
	
	/**
	 * sets the player's anchor point (top left corner) to (x,y)
	 * @param x the x coordinate to set the anchor point to
	 * @param y the y coordinate to set the anchor point to
	 */
	public void setPlayerPosition(int x, int y) {
		player.setLocation(x, y);
		setChanged();
		notifyObservers(currArea);
	}
	/**
	 * returns the Area that the player is currently in
	 * @return the Area that the player is currently in
	 */
	public Area getCurrentArea() {
		return currArea;
	}
	
	/**
	 * shifts the current area in the GameMap by (area[0], area[1])
	 * @param area the int[2] array that holds (x,y) coordinates to shift the area by
	 */
	public void shiftCurrentArea(int[] area) {
		int x = currArea.getCoords()[0];
		int y = currArea.getCoords()[1];
		
		Area old = currArea;
		if(inDungeon) {
			currArea = dungeon.getArea(x + area[0],  y + area[1]);
		}
		else {
			currArea = map.getArea(x + area[0], y + area[1]);
		}
		
		//when we change screens, first remove all animations on screen
		ArrayList<GameObject> toRemove = new ArrayList<GameObject>();
		for(GameObject o : getAnimations()) {
			toRemove.add(o);
		}
		getAnimations().removeAll(toRemove);
		
		//then remove all loot objects
		toRemove = new ArrayList<GameObject>();
		for(GameObject o : old.getLoot()) {
			toRemove.add(o);
		}
		old.getLoot().removeAll(toRemove);
		
		//finally, remove all projectiles
		toRemove = new ArrayList<GameObject>();
		for(GameObject proj : old.getProjectiles()) {
			toRemove.add(proj);
		}
		currArea.getProjectiles().removeAll(toRemove);
		
		for(Enemy enemy : old.getEnemies()) {
			enemy.setActive(false);
		}
		
		
		setChanged();
		notifyObservers(currArea);
	}

	/**
	 * adds an obstacle to the list of things that need to be animated
	 * @param obstacle the obstacle to add to the animations list
	 */
	public void addAnimation(GameObject obstacle) {
		animations.add(obstacle);
		
	}

	/**
	 * removes all of the passed in objects from the animations array list
	 * @param objects the objects to be removed from the animations list
	 */
	public void removeAnimations(ArrayList<GameObject> objects) {
		animations.removeAll(objects);
	}
	
	/**
	 * increments the game clock by 1
	 */
	public void incrementGameClock() {
		gameClock++;
		
	}

	/**
	 * returns the current tick the game clock is on
	 * @return the current tick the game clock is on
	 */
	public int getGameClock() {
		return gameClock;
	}

	/**
	 * returns an ArrayList of GameObject that need to be animated
	 * @return an ArrayList of GameObjects that need to be animated
	 */
	public ArrayList<GameObject> getAnimations() {
		return animations;
	}

	/**
	 * sets our current area to the dungeon map and puts
	 * our player in the right spot on the map
	 */
	public void swapToDungeon() {
		Iterator<GameObject> itr = getAnimations().iterator();
		while(itr.hasNext()) {
			itr.next();
			itr.remove();
		}
		currArea = dungeon.getArea(0, 0);
		player.setLocation(400, 60);
	}

	/**
	 * sets our current area to the overland map and puts our
	 * player in the right spot on the map
	 */
	public void swapToOverland() {
		currArea = map.getArea(2, 2);
		player.setLocation(753, 424);
	}

	/**
	 * returns the dungeon's GameMap
	 * @return the dungeon's GameMap
	 */
	public GameMap getDungeonMap() {
		return dungeon;
	}

	/**
	 * returns the overland GameMap
	 * @return the overland GameMap
	 */
	public GameMap getOverlandMap() {
		return map;
	}	
}
