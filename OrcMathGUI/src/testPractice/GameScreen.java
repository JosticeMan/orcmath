package testPractice;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class GameScreen extends ClickableScreen {

	private ButtonJustin btn;
	private Scoreboard sb;
	private Countdown cd;
	private Timer timer;
	private Timer timer1;
	private int score;
	private int countDownSecs = 5;
	private int count = 5;
	private int timerCountDown = 3;
	private int tCount = 3;
	
	public GameScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		sb = new Scoreboard(350,100,600,200);
		cd = new Countdown(350,300,150,100);
		
		btn = new ButtonJustin(350,450,400,300, "", null, null);
		btn.updateString1("Wait");
		
		viewObjects.add(sb);
		viewObjects.add(cd);
		
		timer1 = new Timer();
		timer1.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				cd.updateTime("" + tCount);
				
				if(tCount <= 0) {
					
					cd.updateTime("Go!");
					timer1.cancel();
					btn.updateString1("Click me!");
					btn.setAction(new Action() {
						
						@Override
						public void act() {
						
							score++;
							sb.updateScore(score);
							
						}
						
					});
					
					timer = new Timer();
				    timer.scheduleAtFixedRate(new TimerTask() {

				        public void run() {
				           cd.updateTime("Time Left: " + count);
				           if(count <= 0) {
				        	   timer.cancel();
				        	   sb.gameOver();
				        	   btn.updateString1("Restart");
				        	   btn.setAction( new Action() {
								
								@Override
								public void act() {
									TestMain.app.newGame();
									TestMain.app.setScreen(TestMain.buttonScreen);
								}
								
				        	   });
				           }
					       newTime();
				        }
				    }, 1000, 1000);
				    
				}
				tTime();
			}
		}, 1000, 1000);
		viewObjects.add(btn);
	}
	
	public void newTime() {
		count--;
	}

	public void tTime() {
		tCount--;
	}
}
