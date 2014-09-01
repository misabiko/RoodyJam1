package com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities;

import com.misabiko.RJ01.GameObjects.Interactables.Movables.Movable;
import com.misabiko.RJ01.Resources.Sprites.Animation;
import com.misabiko.RJ01.Resources.Sprites.SpriteSheet;

public class Entity extends Movable{
	
	public Entity(int x, int y, SpriteSheet sheet, int spriteIndex) {
		super(x, y, sheet, spriteIndex);
	}
	
	public Entity(int x, int y, Animation ani) {
		super(x,y,ani);
	}
	
	public void update() {
		super.update();
	}
}
