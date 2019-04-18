package Model;

/**
 * Abstract class for Obstacles, which are impassable object on
 * the map
 * 
 * @author Wes Rodgers
 *
 */
public abstract class Obstacle extends GameObject {

	protected boolean destructible;
	protected boolean destroyed = false;
	protected boolean animationDone = false;
	protected int destroyedFrame = 0;
	protected int lastFrame;
	protected boolean topImage;
	
	/**
	 * returns topImage field
	 * @return true if the obstacle has a top image, false otherwise
	 */
	public boolean hasTopImage() {
		return topImage;
	}
	
	/**
	 * getter for the obstacle's destructible flag
	 * @return true if the obstacle is destructible, false otherwise
	 */
	public boolean isDestructible() {
		return destructible;
	}

	public boolean destroyed() {
		return destroyed;
	}

	public void toggleDestroyed() {
		destroyed = true;
	}
	
	public void endAnimation() {
		animationDone = true;
	}
	
	public boolean animationDone() {
		return animationDone;
	}
	
	public int destroyedFrame() {
		destroyedFrame++;
		return destroyedFrame;
	}

	public int lastFrame() {
		return lastFrame;
	}
}
