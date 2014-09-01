package com.misabiko.RJ01.GameObjects;

import java.awt.image.BufferedImage;

import com.misabiko.RJ01.Resources.Sprites.Animation;
import com.misabiko.RJ01.Resources.Sprites.SpriteSheet;

public abstract class GameObject {
	
	public boolean visible = true;
	public BufferedImage sprite;
	public int x, y, width, height;
	private Animation ani = null;
	
	public GameObject(int x, int y,SpriteSheet sheet, int spriteIndex) {
		this.x = x;
		this.y = y;
		sprite = sheet.sprites[spriteIndex];
		this.width = sheet.sprites[spriteIndex].getWidth();
		this.height = sheet.sprites[spriteIndex].getHeight();
	}
	
	public GameObject(int x, int y,BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.width = sprite.getWidth();
		this.height = sprite.getHeight();
	}
	
	public GameObject(int x,int y,Animation ani) {
		this.x = x;
		this.y = y;
		this.ani = ani;
		sprite = ani.getImg();
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public BufferedImage getImg() {
		return ani.getImg();
	}
	public int x2() {
		return x + width;
	}
	
	public int y2() {
		return y + height;
	}
	
	public int centerX() {
		return x + (width/2);
	}
	
	public int centerY() {
		return y + (height/2);
	}
}
