package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJustin extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9141981357720287918L;
	
	private ProgressInterfaceJustin progress;
	
	//SETTINGS FOR GAME
	private int moveIndex;
	
	//Add Simon's moves to this list and compare it to the player's. 
	private ArrayList<MoveInterfaceJustin> moves;
	private int roundNumber;
	private boolean acceptingUserInput;
	
	//Rather than having one variable per button, might aswell put them in an array
	private ButtonInterfaceJustin[] buttons;
	
	//This is where we will be updating the user with their progress in the game
	private TextLabel label;
	
	private int lastSelectedButton;

	public SimonScreenJustin(int width, int height) {
		super(width, height);
		//Since this screen will be updating the player with information, we will need to make a thread
		Thread screen = new Thread(this);
		screen.start();
	}

	//Simon plays not the PLAYER
	//Choose random buttons 
	//Update round number
	public void run() {
	    label.setText("");
	    nextRound();
	}
	
	private void nextRound() {
		acceptingUserInput = false;
		roundNumber++;
		moves.add(randomMove());
		progress.updateRoundNumber(roundNumber);
		progress.updateSequenceCount(moves.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence(); 
		changeText("Your turn");
		acceptingUserInput = true;
		moveIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceJustin b = null;
		for(int i = 0; i < moves.size(); i++) {
			if(b != null) {
				b.normalizeButton();
			}
			b = moves.get(i).getButton();
			b.highlightButton();
			//Shorter the more rounds
			int sleepTime = 1000 / roundNumber; //(Math.PI / (3 * Math.pow(Math.E, roundNumber))));
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.normalizeButton();
	}
	
	private void changeText(String s) {
		label.setText(s);
		update();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		roundNumber = 0;
		//Code to add the buttons to the array we created above
		addGameButtons();
		//Add buttons to the list of visible objects
		for(ButtonInterfaceJustin b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = (new TextLabel(300,400,300,80,"It's time to play Simon's Game!"));
		//This will track the moves that Simon makes
		moves = new ArrayList<MoveInterfaceJustin>();
		//Starting moves according to the preset number, sequenceCount
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	//WAIT FOR PARTNER
	private ProgressInterfaceJustin getProgress() {
		return new ProgressJustin(400, 400, 300, 100);
	}

	public void addGameButtons() {
		Color[] colors = {Color.BLUE, Color.yellow, Color.green, Color.red};
		buttons = new ButtonInterfaceJustin[4]; 
		for(int i = 0; i < buttons.length; i++) {
			final ButtonInterfaceJustin b = getAButton();
			double cx = b.getWidth() / 2;
			double cy = b.getHeight() / 2;
			double angle = (i * (2 * Math.PI)) / buttons.length;
		    double x = cx + 110.0 * Math.cos(angle);                
		    double y = cy + 110.0 * Math.sin(angle);                
			b.setColor(colors[i]); 
		    b.setX(200+x);
		    b.setY(200+y);
		    b.setAction(new Action() {

		    	public void act() {
		    		
		    		if(acceptingUserInput) {
		    			
		    			Thread blink = new Thread(new Runnable() {

		    				public void run() {
		    					
		    					b.highlightButton();
		    					try {
			    					Thread.sleep(800);
		    					} catch (InterruptedException e) {
			    					e.printStackTrace();
		    					}
		    					b.normalizeButton();
		    					
		    				}

		    			});
		    			
		    			blink.start();
		    			
		    			//Checks if the user clicked the same button as the one that Simon clicked
		    			if(b == moves.get(moveIndex).getButton()) {
		    				
		    				moveIndex++;
		    			
		    			}
		    			else {
		    				
		    				progress.gameOver();
		    				
		    			}
		    			if(moveIndex == moves.size()) { 
		    			    Thread nextRound = new Thread(SimonScreenJustin.this); 
		    			    nextRound.start(); 
		    			    
		    			}
		    			
		    		}
		    		
		    	}

		    });
			buttons[i] = b;
		}
	}

	//WAIT FOR PARTNER
	private ButtonInterfaceJustin getAButton() {
		return new ButtonJustin(0, 0, 40, 40, "", Color.red, null);
	}

	private MoveInterfaceJustin randomMove() {
	    int moveIndex = (int) (Math.random() * buttons.length);
	    while(moveIndex == lastSelectedButton){
	        moveIndex = (int)(Math.random() * buttons.length);
	    }
	    lastSelectedButton = moveIndex;
	    return getMove(moveIndex);
	}
	
	//WAIT FOR PARTNER
	private MoveInterfaceJustin getMove(int bIndex) {
	    return new MoveJustin(buttons[bIndex]);
	}
}
