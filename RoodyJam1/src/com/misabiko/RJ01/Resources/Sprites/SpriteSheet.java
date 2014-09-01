package com.misabiko.RJ01.Resources.Sprites;

import java.awt.image.BufferedImage;

import com.misabiko.RJ01.Resources.Resources;

public class SpriteSheet extends Sprite {

	public BufferedImage[] sprites;
	private readFile spriteSheet;

	public SpriteSheet(String sPath, String fExtension) {
		super(sPath);

		spriteSheet = new readFile(Resources.resPath + sPath, fExtension);

		sprites = new BufferedImage[spriteSheet.data.size()];

		for (int i = 0; i < spriteSheet.data.size(); i++) {
			sprites[i] = img.getSubimage(spriteSheet.data.get(i)[0], spriteSheet.data.get(i)[1], spriteSheet.data.get(i)[2], spriteSheet.data.get(i)[3]);
		}
	}

	public SpriteSheet(String sPath, String fPath, String fExtension) {
		super(sPath);

		spriteSheet = new readFile(Resources.resPath + fPath, fExtension);

		sprites = new BufferedImage[spriteSheet.data.size()];

		for (int i = 0; i < spriteSheet.data.size(); i++) {
			sprites[i] = img.getSubimage(spriteSheet.data.get(i)[0], spriteSheet.data.get(i)[1], spriteSheet.data.get(i)[2], spriteSheet.data.get(i)[3]);
		}
	}
	
	public BufferedImage getSprite(String name) {
		return sprites[spriteSheet.names.indexOf(name)];
	}
}
