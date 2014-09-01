package com.misabiko.RJ01.Core;

import javax.swing.JPanel;

import com.misabiko.RJ01.GUI.GUI;
import com.misabiko.RJ01.GameObjects.GameObject;
import com.misabiko.RJ01.GameObjects.Interactables.DetectionArea;
import com.misabiko.RJ01.GameObjects.Interactables.Interactable;
import com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities.Fireball;
import com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities.Jerk;
import com.misabiko.RJ01.GameObjects.Interactables.Movables.Entities.Player.Player;
import com.misabiko.RJ01.GameScenes.Game;
import com.misabiko.RJ01.GameScenes.GameScene;
import com.misabiko.RJ01.Resources.Resources;

import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Graphics g;
	private GameScene scene;
	
	public GamePanel(GameScene scene) {
		this.scene = scene;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.setBackground(Color.BLACK);
		this.g = g;
		
		if (Game.win) {
			drawGUI(((Game)scene).winScreen);
		}else if (Game.lose) {
			drawGUI(((Game)scene).loseScreen);
		}else {
			g.setColor(Color.WHITE);
			g.drawRect(Game.Box.x,Game.Box.y,Game.Box.x2-Game.Box.x,Game.Box.y2-Game.Box.y);
			if (DetectionArea.showDetectionAreas) {
				g.setColor(new Color(0,0,255,100));
				g.fillRect(Game.Box.x,Game.Box.y,Game.Box.x2-Game.Box.x,Game.Box.y2-Game.Box.y);
			}
			
			draw(scene.gameObjs);
			drawFireballs();
		}
	}
	
	private void draw(GameObject obj) {
		if (obj instanceof Fireball){
			g.drawImage(((Fireball)obj).getImg(),obj.x,obj.y,null);
		}else {
			g.drawImage(obj.sprite, obj.x, obj.y, null);
		}
	}
	
	private void drawGUI(GUI gui) {
		g.setColor(gui.color);
		g.fillRect(gui.x,gui.y,gui.width,gui.height);
		
		g.setColor(Color.WHITE);
		g.drawString(gui.text, gui.x+50, gui.y+25);
		
		for (int i = 0; i<gui.buttons.size();i++) {
			g.setColor(gui.buttonColor);
			g.fillRect(gui.buttons.get(i).x, gui.buttons.get(i).y, gui.buttons.get(i).x2-gui.buttons.get(i).x, gui.buttons.get(i).y2-gui.buttons.get(i).y);
			g.setColor(Color.WHITE);
			g.drawString(gui.buttonTexts.get(i),gui.buttons.get(i).x+50,gui.buttons.get(i).y+10);
		}
	}
	
	private void drawFireballs() {
		for (Fireball obj : Fireball.Fireballs) {
			draw(obj);
			if (DetectionArea.showDetectionAreas) {
				g.setColor(new Color(0,0,255,100));
				g.fillRect(obj.da.x,obj.da.y,obj.da.x2-obj.da.x,obj.da.y2-obj.da.y);
			}
		}
	}
	
	private void draw(ArrayList<GameObject> objs) {
		for (GameObject obj : objs) {
			draw(obj);
			if (obj instanceof Player) {
				for (int i = 0; i<((Player)obj).life;i++) {
					g.drawImage(Resources.player_heart.getImg(33,30),2+(i*Resources.player_heart.getImg(33,30).getWidth()),2,null);
				}
			}
			if (obj instanceof Jerk) {
				for (int i = 0; i<((Jerk)obj).life;i++) {
					g.drawImage(Resources.jerk_heart.getImg(33,30),(795-Resources.jerk_heart.getImg(33,30).getWidth())-((i*Resources.jerk_heart.getImg(33,30).getWidth())+2),2,null);
				}
			}
			if (DetectionArea.showDetectionAreas && obj instanceof Interactable) {
				g.setColor(new Color(0,0,255,100));
				g.fillRect(((Interactable)obj).da.x,((Interactable)obj).da.y,((Interactable)obj).da.x2-((Interactable)obj).da.x,((Interactable)obj).da.y2-((Interactable)obj).da.y);
				if (obj instanceof Jerk) {
					g.fillRect(((Jerk)obj).scanAreaUp.x,((Jerk)obj).scanAreaUp.y,((Jerk)obj).scanAreaUp.x2-((Jerk)obj).scanAreaUp.x,((Jerk)obj).scanAreaUp.y2-((Jerk)obj).scanAreaUp.y);
					g.fillRect(((Jerk)obj).scanAreaDown.x,((Jerk)obj).scanAreaDown.y,((Jerk)obj).scanAreaDown.x2-((Jerk)obj).scanAreaDown.x,((Jerk)obj).scanAreaDown.y2-((Jerk)obj).scanAreaDown.y);
					g.fillRect(((Jerk)obj).scanAreaLeft.x,((Jerk)obj).scanAreaLeft.y,((Jerk)obj).scanAreaLeft.x2-((Jerk)obj).scanAreaLeft.x,((Jerk)obj).scanAreaLeft.y2-((Jerk)obj).scanAreaLeft.y);
					g.fillRect(((Jerk)obj).scanAreaRight.x,((Jerk)obj).scanAreaRight.y,((Jerk)obj).scanAreaRight.x2-((Jerk)obj).scanAreaRight.x,((Jerk)obj).scanAreaRight.y2-((Jerk)obj).scanAreaRight.y);
				}
			}
		}
	}
	
//	private void rotate(BufferedImage img, double degrees) {
//		BufferedImage rotated = img;
//		Graphics2D rotatedG = (Graphics2D)rotated.getGraphics();
//		rotatedG.rotate(Math.toRadians(degrees), img.getWidth()/2,img.getHeight()/2);
//		rotatedG.drawImage(img, 0, 0, this);
//		img = rotated;
//		rotatedG.finalize();
//	}
}
