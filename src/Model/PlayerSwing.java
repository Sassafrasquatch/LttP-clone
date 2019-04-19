package Model;

public class PlayerSwing extends Character {
	
	public PlayerSwing(int direction) {
		imageArray[0] = "/style/playerSprites/sword attack north.png";
		imageArray[1] = "/style/playerSprites/sword attack left.png";
		imageArray[2] = "/style/playerSprites/sword attack south.png";
		imageArray[3] = "/style/playerSprites/sword right.png";
		this.direction = direction;
		width = 75;
		height = 73;
	}

}
