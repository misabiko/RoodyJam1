package com.misabiko.RJ01.Resources.Sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private int frameSkip;
	private int firstSprite;
	private int lastSprite;
	private SpriteSheet sheet;
	private int currSprite;
	private int skipIndex = 0;
	private boolean reverse = false;

	public Animation(int frameSkip, int firstSprite, int lastSprite,
			SpriteSheet sheet) {
		this.frameSkip = frameSkip;
		this.firstSprite = firstSprite;
		this.lastSprite = lastSprite;
		this.sheet = sheet;
		currSprite = firstSprite;
	}

	public void draw(Graphics g, int x, int y) {
		g.drawImage(sheet.sprites[currSprite], x, y, null);
		if (skipIndex == frameSkip) {
			skipIndex = 0;
			if (currSprite == lastSprite) {
				currSprite = firstSprite;
			} else {
				currSprite++;
			}
		} else {
			skipIndex++;
		}
	}

	public void drawBF(Graphics g, int x, int y) {
		g.drawImage(sheet.sprites[currSprite], x, y, null);
		if (skipIndex == frameSkip) {
			skipIndex = 0;
			System.out.println("Current sprite is " + currSprite);
			if (!reverse) {
				if (currSprite == lastSprite) {
					reverse = !reverse;
					currSprite--;
				} else {
					currSprite++;
				}
			} else {
				if (currSprite == firstSprite) {
					reverse = !reverse;
					currSprite++;
				} else {
					currSprite--;
				}
			}
		} else {
			skipIndex++;
		}
	}

	public BufferedImage getImg() {
		if (skipIndex == frameSkip) {
			skipIndex = 0;
			if (currSprite == lastSprite) {
				currSprite = firstSprite;
			} else {
				currSprite++;
			}
		} else {
			skipIndex++;
		}

		return sheet.sprites[currSprite];
	}

	public void reset() {
		currSprite = firstSprite;
		skipIndex = 0;
	}
}
