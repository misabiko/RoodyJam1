package com.misabiko.RJ01.GameObjects.Interactables;

import com.misabiko.RJ01.GameObjects.GameObject;
import com.misabiko.RJ01.Resources.Sprites.Animation;
import com.misabiko.RJ01.Resources.Sprites.SpriteSheet;

public class Interactable extends GameObject{
	
	public DetectionArea da;
	
	public Interactable(int x, int y,SpriteSheet sheet, int spriteIndex) {
		super(x, y, sheet, spriteIndex);
		createDA();
	}
	
	public Interactable(int x, int y, Animation ani) {
		super(x,y,ani);
		createDA();
	}

	protected void createDA() {	//Just here to be overridden
		da = new DetectionArea(x,y,x2(),y2());
	}
}
