package com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities;

import java.util.ArrayList;

import com.misabiko.RJ01.Resources.Resources;
import com.misabiko.RJ01.Resources.Sprites.Animation;

public class Fireball extends Entity{
	
	public static ArrayList<Fireball> Fireballs = new ArrayList<Fireball>();
	public boolean hasBounced = false;
	public boolean isHitting = false;
	public Fireball(int x, int y, double angle) {
		super(x, y, new Animation(10,0,3,Resources.fireball_spritesheet));
		Fireballs.add(this);
		
		speed = 2;
		
		vel.setLength(speed);
		vel.setAngle(angle);
	}
	
	public void update() {
		if (x <= 0 || x >= 790-width) {
			vel.mirrorX();
			hasBounced = true;
		}
		if (y <= 0 || y >= 570-height) {
			vel.mirrorY();
			hasBounced = true;
		}
		
//		if (da.checkOverlapping(player.da)) {
//			isHitting = true;
//		}else {
//			isHitting = false;
//		}
		
		super.update();
	}
}
