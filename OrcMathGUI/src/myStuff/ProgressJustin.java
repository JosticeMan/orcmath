package myStuff;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJustin extends Component implements ProgressInterfaceJustin {

	public ProgressJustin(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void updateRoundNumber(int num) {
		SimonScreenJustin.getLabel().setText("This is round " + num);
	}

	@Override
	public void updateSequenceCount(int count) {
		SimonScreenJustin.getLabel().setText(SimonScreenJustin.getLabel().getText() + "n/The sequence is of length " + count);
	}

	@Override
	public void gameOver() {
		SimonScreenJustin.getLabel().setText("You have lost the game");
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
