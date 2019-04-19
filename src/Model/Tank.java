package Model;

public class Tank extends Enemy{
	
	public Tank(int x, int y) {
		currentHP = 4;
		maxHP = 4;
		damage = 1;
		speed = 4;
		location[0] = x;
		location[1] = y;
		width = 40;
		height = 74;
		imageArray[2] = "/style/tank down.png";
		direction = 3;
		topHeight = 0;
		idleImage = "/style/tank idle.png";
		active = false;
	}

	@Override
	public boolean playerIsVisible() {
		// TODO Auto-generated method stub
		return false;
	}

}
