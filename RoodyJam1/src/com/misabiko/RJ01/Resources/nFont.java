package com.misabiko.RJ01.Resources;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class nFont {
	
	public Font font;
	
	public nFont(String path) {
		try {
			try {
				font = Font.createFont(Font.TRUETYPE_FONT, new File(Resources.resPath+path+".ttf"));
			} catch (FontFormatException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
		}
	}
}
