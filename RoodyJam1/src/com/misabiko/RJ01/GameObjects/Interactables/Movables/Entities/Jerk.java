package com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities;

import com.misabiko.RJ01.GameObjects.Interactables.DetectionArea;
import com.misabiko.RJ01.GameScenes.Game;
import com.misabiko.RJ01.Resources.Resources;

public class Jerk extends Entity{
	
	public int life = 10;
	private int invicibilityTime = 20;
	private int invicibilityIndex = 0;
	public DetectionArea scanAreaUp = new DetectionArea(	x-10,	y-3,	x2()+10,	y+7		);
	public DetectionArea scanAreaDown = new DetectionArea(	x-10,	y2(),	x2()+10,	y2()+10	);
	public DetectionArea scanAreaLeft = new DetectionArea(	x-10,	y-3,	x,			y2()+10	);
	public DetectionArea scanAreaRight = new DetectionArea(	x2(),	y-3,	x2()+10,	y2()+10	);
	
	public Jerk( int x,int y) {
		super(x,y,Resources.jerk_spritesheet, 0);
		speed = 2;
	}
	
	protected void createDA() {
		da = new DetectionArea(x,y+7,x2(),y2());
	}
	
	public void update() {
		
//		Fireball checking
		for (int i = 0;i < Fireball.Fireballs.size();i++) {
			if (scanAreaDown.checkOverlapping(Fireball.Fireballs.get(i).da)) {
				vel.y = (int)speed;
				vel.x = (int)-speed;
			} else if (scanAreaUp.checkOverlapping(Fireball.Fireballs.get(i).da)) {
				vel.y = (int)-speed;
				vel.x = (int)speed;
			}
			if (scanAreaRight.checkOverlapping(Fireball.Fireballs.get(i).da)) {
				vel.x = (int)-speed;
				vel.y = (int)speed;
			} if (scanAreaLeft.checkOverlapping(Fireball.Fireballs.get(i).da)) {
				vel.x = (int)speed;
				vel.y = (int)-speed;
			}
			if (da.checkOverlapping(Fireball.Fireballs.get(i).da)) {
				if (invicibilityIndex == 0) {
					if (life == 0) {
						Game.win = true;
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
		
//		Box Checking
//		if (scanAreaLeft.checkOverlapping(Game.Box)) {
//			System.out.println("Left");
//			vel.mirrorX();
//		}else
//		if (scanAreaUp.checkOverlapping(Game.Box)) {
//			System.out.println("Up");
//			vel.mirrorY();
//		}else
//		if (scanAreaRight.checkOverlapping(Game.Box)) {
//			System.out.println("Right");
//			vel.mirrorX();
//		}else
//		if (scanAreaDown.checkOverlapping(Game.Box)) {
//			System.out.println("Down");
//			vel.mirrorY();
//		}
		
//		Wall Checking
		if (x <= 10) {
			vel.mirrorX();
		}
		if (y <= 10) {
			vel.mirrorY();
		}
		if (x2() >= 790) {
			vel.mirrorX();
		}
		if (y2() >= 570) {
			vel.mirrorY();
		}
		
		
		move();
		da.move(x,y+7,x2(),y2());
		scanAreaUp.move(	x-10,	y-3,	x2()+10,	y+7		);
		scanAreaDown.move(	x-10,	y2(),	x2()+10,	y2()+10	);
		scanAreaLeft.move(	x-10,	y-3,	x,			y2()+10	);
		scanAreaRight.move(	x2(),	y-3,	x2()+10,	y2()+10	);
	}
}
