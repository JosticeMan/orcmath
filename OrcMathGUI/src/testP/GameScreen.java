package testP;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class GameScreen extends ClickableScreen {

	private int score;
	private int countDownTime = 5;
	private int count;
	private int timerTime = 3;
	private int tCount;
	
	public GameScreen(int width, int height) {
		super(width, height);
		update();
		count = countDownTime;
		tCount = timerTime;
		score = 0;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Scoreboard sb = new Scoreboard(100,100,400,100);
		Countdowner cd = new Countdowner(100,150,400,100);
		
		Button btn = new Button(200,200);
		btn.updateString("Wait");
		
		viewObjects.add(sb);
		viewObjects.add(cd);
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				cd.updateTime("Time Left: " + tCount);
				if(tCount <= 0) {
					Timer t1 = new Timer();
					t1.scheduleAtFixedRate(new TimerTask() {
						
						@Override
						public void run() {
							cd.updateTime("Time Left: " + count);
							if(count == countDownTime) {
								cd.updateTime("Go! Time Left: " + count);
								btn.updateString("Click me!");
								btn.setAction(new Action() {
									
									@Override
									public void act() {
										score++;
										sb.updateScore(score);
									}
									
								});
							}
							if(count <= 0) {
								sb.gameOver();
								btn.updateString("Restart");
								btn.setAction(new Action() {
									
									@Override
									public void act() {
										MainGUI.app.newGame();
										MainGUI.app.setScreen(MainGUI.mScreen);
									}
								});
								t1.cancel();
							}
							count--;
						}
					}, 0, 1000);
					t.cancel();
				}
				tCount--;
			}
		}, 1000, 1000);
		
		viewObjects.add(btn);
	}

}
