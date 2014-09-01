package com.misabiko.RJ01.Resources.Sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.misabiko.RJ01.Resources.Resources;

public class Sprite {
	public String path;
	public BufferedImage img;

	public Sprite(String path) {
		this.path = Resources.resPath + path + ".png";
		try {
			img = ImageIO.read(new File(this.path));
		} catch (IOException e) {
		}
	}

	public BufferedImage getImg() {
		return img;
	}
	
	public BufferedImage getImg(int width, int height) {
		BufferedImage expanded = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		expanded.getGraphics().drawImage(img, 0, 0,width,height, null);
		
		return expanded;
	}
}
