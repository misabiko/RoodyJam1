package com.misabiko.RJ01.GUI;

import java.awt.Color;

import com.misabiko.RJ01.Controls.MouseHandler;
import com.misabiko.RJ01.GameObjects.Interactables.DetectionArea;
import com.misabiko.RJ01.GameScenes.GameScene;

public class LoseScreen extends GUI{
	private GameScene scene;
	
	public LoseScreen(MouseHandler m, GameScene scene) {
		super(m, 275, 175, 250, 250, Color.BLUE, Color.RED, "You lost");
		this.scene = scene;
		
		buttons.add(new DetectionArea(300,250,500,275));
		buttonTexts.add("Restart");
		
		buttons.add(new DetectionArea(300,350,500,375));
		buttonTexts.add("Exit Game WIP");
	}
	
	protected void action(int actionID) {
		switch (actionID) {
		case 0:	//Restart
			scene.restart();
			break;
		case 1:	//Exit Game
			System.exit(0);
			break;
		default:
			break;
		}
	}
}
