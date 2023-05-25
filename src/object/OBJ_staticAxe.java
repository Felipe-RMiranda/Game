package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_staticAxe extends Entity{
	public OBJ_staticAxe(GamePanel gamePanel) {
		super(gamePanel);
		name = "staticAxe";
		down1 = setup("/weapons/axe");
	}
}
