package justin.playground;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;

public class GIF extends AnimatedComponent {

	public GIF() {
		super(40, 40, 55, 75);
		addSequence("resources/goku.png", 150, 0, 0, 55, 69, 9);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}

	@Override
	public void update(Graphics2D g) {
		super.update(g);
	}

}
