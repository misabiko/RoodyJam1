package com.misabiko.RJ01.GUI;

import java.awt.Color;
import java.util.ArrayList;

import com.misabiko.RJ01.Controls.MouseHandler;
import com.misabiko.RJ01.GameObjects.Interactables.DetectionArea;

public abstract class GUI {
	public int x,y,width,height;
	public MouseHandler m;
	public ArrayList<DetectionArea> buttons = new ArrayList<DetectionArea>();
	public ArrayList<String> buttonTexts = new ArrayList<String>();
	public Color color, buttonColor;
	public String text;
	
	public GUI(MouseHandler m, int x, int y, int width, int height, Color color, Color buttonColor, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.m = m;
		this.color = color;
		this.text = text;
		this.buttonColor = buttonColor;
	}
	
	protected void action(int actionID) {
		
	}
	
	public void update() {
		for (int i = 0; i< buttons.size();i++) {
			if (m.clicked) {
				if (buttons.get(i).isInside(m.x, m.y)) {
					action(i);
				}
				m.clicked = false;
			}
		}
	}
}
