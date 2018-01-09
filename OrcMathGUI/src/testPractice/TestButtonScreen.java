package testPractice;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class TestButtonScreen extends ClickableScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 263157152027622069L;
	private ButtonJustin btn;
	private Scoreboard sb;
	private Countdown cd;
	private Timer timer;
	private int score;
	private int countDownSecs = 10;
	private int count = 10;
	
	public TestButtonScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		sb = new Scoreboard(350,100,600,200);
		cd = new Countdown(350,300,150,100);
		
		btn = new ButtonJustin(350,450,400,300, "", null, null);
		btn.updateString1("Start");
		btn.setAction(new Action() {
			
			@Override
			public void act() {
			
				count = 10;
				cd.updateTime(count);
				
				btn.updateString1("Click me!");
				btn.setAction(new Action() {
					
					@Override
					public void act() {
						
						score++;
						sb.updateScore(score);
						
					}
					
				});
				
				viewObjects.add(sb);
				viewObjects.add(cd);
				
				timer = new Timer();
			    timer.scheduleAtFixedRate(new TimerTask() {

			        public void run() {
			           
			           cd.updateTime(newTime());
			           if(count <= 0) {
			        	   timer.cancel();
			        	   sb.gameOver();
			        	   btn.updateString1("Game Over");
			        	   btn.setAction( new Action() {
							
							@Override
							public void act() {
								
							}
							
			        	   });
			           }

			        }
			    }, 1000, 1000);
				
			}
		});
		viewObjects.add(btn);

	}
	
	public int newTime() {
		count--;
		return count;
	}
	
}
