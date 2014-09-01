package com.misabiko.RJ01.Core;

import javax.swing.JFrame;

import com.misabiko.RJ01.GameScenes.Game;
import com.misabiko.RJ01.GameScenes.GameScene;
import com.misabiko.RJ01.Resources.Resources;

public class GameFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private GameScene scene = new Game(this);
	
	public static void main(String[] args) {
		new GameFrame("RoodyJam1");
	}
	
	public GameFrame(String name) {
		super(name);
		setIconImage(Resources.fireball_spritesheet.sprites[0]);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		
		scene.init();
		scene.run();
	}
}
