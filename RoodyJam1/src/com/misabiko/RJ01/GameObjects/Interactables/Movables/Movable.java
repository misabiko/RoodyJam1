package com.misabiko.RJ01.GameObjects.Interactables.Movables;

import com.misabiko.RJ01.GameObjects.Interactables.Interactable;
import com.misabiko.RJ01.Resources.Sprites.Animation;
import com.misabiko.RJ01.Resources.Sprites.SpriteSheet;
import com.misabiko.RJ01.Vectors.Vector;

public class Movable extends Interactable{
	
	protected double speed = 3;
	public Vector vel = new Vector();
	
	public Movable(int x, int y, SpriteSheet sheet, int spriteIndex) {
		super(x, y, sheet, spriteIndex);
	}
	
	public Movable(int x, int y, Animation ani) {
		super(x,y,ani);
	}
	
	protected void move() {
		x += vel.x;
		y -= vel.y;
	}
	
	public void update() {
		move();
		da.move(x,y,x2(),y2());
	}
}
