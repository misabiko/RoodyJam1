package com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities.Player;

import com.misabiko.RJ01.Controls.KeyHandler;
import com.misabiko.RJ01.Controls.MouseHandler;
import com.misabiko.RJ01.GameObjects.Interactables.DetectionArea;
import com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities.Entity;
import com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities.Fireball;
import com.misabiko.RJ01.GameScenes.Game;
import com.misabiko.RJ01.Resources.Resources;
import com.misabiko.RJ01.Vectors.Vector;

public class Player extends Entity{
	
	private KeyHandler k;
	private MouseHandler m;
	public Vector direction = new Vector(x,y);
	public int life = 10;
	private int invicibilityTime = 20;
	private int invicibilityIndex = 0;
	
	public Player(KeyHandler k,MouseHandler m, int x,int y) {	//TODO Find way to choose spritesheet
		super(x,y,Resources.player_spritesheet, 0);
		this.k = k;
		this.m = m;
		speed = 2;
	}
	
	protected void createDA() {
		da = new DetectionArea(x,y+7,x2(),y2());
	}
	
	public void update() {
//		Collision checking
		if (!da.getOverlappingSides(Game.Box)[0]) {
			y = Game.Box.y-7;
			vel.y = 0;
		}
		if (!da.getOverlappingSides(Game.Box)[1]) {
			x = Game.Box.x2-width;
			vel.x = 0;
		}
		if (!da.getOverlappingSides(Game.Box)[2]) {
			y = Game.Box.y2-height;
			vel.y = 0;
		}
		if (!da.getOverlappingSides(Game.Box)[3]) {
			x = Game.Box.x;
			vel.x = 0;
		}
		
//		Fireball checking
		for (int i = 0;i < Fireball.Fireballs.size();i++) {
			if (da.checkOverlapping(Fireball.Fireballs.get(i).da) && Fireball.Fireballs.get(i).hasBounced) {
				if (invicibilityIndex == 0) {
					if (life == 0) {
						Game.lose = true;
					}else {
						life--;
					}
					Fireball.Fireballs.remove(i);
					invicibilityIndex = invicibilityTime;
				}
			}
		}
		if (invicibilityIndex != 0) {
			invicibilityIndex--;
		}
		
//		WASD checking and movement
		if (k.wIsHeld != k.sIsHeld) {	//Basically XOR
			if (k.wIsHeld)
				vel.y = (int)speed;
			if (k.sIsHeld)
				vel.y = (int)-speed;
		}else {
			vel.y = 0;
		}
		if (k.aIsHeld != k.dIsHeld) {
			if (k.aIsHeld)
				vel.x = (int)-speed;
			if (k.dIsHeld)
				vel.x = (int)speed;
		}else {
			vel.x = 0;
		}
		
//		Set direction (angle)
		direction.x = (m.xPos-centerX());
		direction.y = (-(m.yPos-centerY()));
		
		if (m.clicked) {
			new Fireball(centerX()-3,centerY()-3, direction.getAngle());
			m.clicked = false;
		}
		
		move();
		da.move(x,y+7,x2(),y2());
	}
}
