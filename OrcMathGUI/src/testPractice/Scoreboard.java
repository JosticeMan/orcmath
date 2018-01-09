package testPractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Scoreboard extends Component {

	private boolean gameOver;
	private int score;
	
	public Scoreboard(int x, int y, int w, int h) {
		super(x, y, w, h);
		gameOver = false;
		update();
	}

	public void updateScore(int points) {
		score = points;
		update();
	}
	
	public void gameOver() {
		gameOver = true;
		update();
	}
	
	@Override
	public void update(Graphics2D g) {
		super.clear();
		Font myFont = new Font("Helvetica", Font.PLAIN, 20);
		g.setFont(myFont);
		g.setColor(Color.BLACK);
		FontMetrics fm = g.getFontMetrics();
		if(gameOver) {
			g.drawString("Game Over! You finished with a score of " + score + "!", 0, fm.getHeight());
		}
		else {
			g.drawString("Score: " + score, 0, fm.getHeight());
		}
	}

}
