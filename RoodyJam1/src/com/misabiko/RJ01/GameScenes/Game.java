package com.misabiko.RJ01.GameScenes;

import com.misabiko.RJ01.Controls.KeyHandler;
import com.misabiko.RJ01.Controls.MouseHandler;
import com.misabiko.RJ01.Core.GameFrame;
import com.misabiko.RJ01.GUI.LoseScreen;
import com.misabiko.RJ01.GUI.WinScreen;
import com.misabiko.RJ01.GameObjects.Interactables.DetectionArea;
import com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities.Fireball;
import com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities.Jerk;
import com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities.Player.Player;

public class Game extends GameScene{
	
	private GameFrame frame;
	private KeyHandler k = new KeyHandler();
	private MouseHandler m = new MouseHandler();
	public static DetectionArea Box = new DetectionArea(325, 250, 475, 350);
	public static boolean win,lose = false;
	public WinScreen winScreen;
	public LoseScreen loseScreen;
	
	public Game(GameFrame frame) {
		super(frame);
		this.frame = frame;
		frame.addKeyListener(k);
		panel.addMouseListener(m);
		panel.addMouseMotionListener(m);
		
		winScreen = new WinScreen(m,this);
		loseScreen = new LoseScreen(m,this);
		
		gameObjs.add(new Player(k, m, 400,300));
		gameObjs.add(new Jerk(400,100));
	}

	protected void update() {
		if (win) {
			winScreen.update();
		}else if (lose) {
			loseScreen.update();
		}else {
			super.update();
			for (Fireball obj : Fireball.Fireballs) {
				obj.update();
			}
		}
	}
	
	public void restart() {
		super.restart();
		Fireball.Fireballs.clear();
		
		k = new KeyHandler();
		m = new MouseHandler();
		Box = new DetectionArea(325, 250, 475, 350);
		
		frame.addKeyListener(k);
		panel.addMouseListener(m);
		panel.addMouseMotionListener(m);
		
		win = false;
		lose = false;
		
		winScreen = new WinScreen(m,this);
		loseScreen = new LoseScreen(m,this);
		
		gameObjs.add(new Player(k, m, 400,300));
		gameObjs.add(new Jerk(400,100));
	}
}
