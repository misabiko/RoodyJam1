package com.misabiko.RJ01.Resources;

import com.misabiko.RJ01.Resources.Sprites.Sprite;
import com.misabiko.RJ01.Resources.Sprites.SpriteSheet;

public abstract class Resources {
	public static final String resPath = System.getProperty("user.dir")+"\\res\\";
	
	public static final SpriteSheet player_spritesheet = new SpriteSheet("player_spritesheet", ".txt");
	
	public static final Sprite player_heart = new Sprite("player_heart");
	
	public static final SpriteSheet fireball_spritesheet = new SpriteSheet("fireball_spritesheet", ".txt");
	
	public static final Sprite jerk_heart = new Sprite("jerk_heart");
	
	public static final SpriteSheet jerk_spritesheet = new SpriteSheet("jerk_spritesheet", ".txt");
}
