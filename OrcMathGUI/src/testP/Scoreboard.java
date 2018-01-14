package testP;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Scoreboard extends Component {

	private int score;
	private boolean gameOver;
	
	public Scoreboard(int x, int y, int w, int h) {
		super(x, y, w, h);
		update();
	}

	public void gameOver() {
		gameOver = true;
		update();
	}
	
	public void updateScore(int s) {
		score = s;
		update();
	}
	
	@Override
	public void update(Graphics2D g) {
		super.clear();
		g.setColor(Color.BLACK);
		Font f = new Font("Arial", Font.PLAIN, 12);
		g.setFont(f);
		FontMetrics fm = g.getFontMetrics();
		if(gameOver) {
			
			g.drawString("Game Over! You finished with a score of " + score, 0, fm.getHeight());
			
		} else {
			
			g.drawString("Score: " + score, 0, fm.getHeight());
			
		}
	}

}
