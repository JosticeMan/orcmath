package justin.playground;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import guiPlayer.Book;
import guiPlayer.Sampler;
import guiPlayer.Sampler.SampleScreen;
import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Checkbox;
import guiTeacher.components.Graphic;
import guiTeacher.components.RadioButton;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CharacterSelection {
	
	public static Scanner in;
	
	private ArrayList<Character> animatedCharacters;
	
	public CharacterSelection() {
		
		//super(width, height);
		animatedCharacters = new ArrayList<Character>();
		
	}


	public static void main(String[] args) {
		CharacterSelection cs = new CharacterSelection();
		in = new Scanner(System.in);
		cs.menu();
	}
	
	private static void displayMessage(String message){
		System.out.println(message);
	}
	
	private void menu() {
		displayMessage("Would you like to \"load\" a save file or \"create\" a new list? ");
		String[] allowedEntry = {"load","create"};
		String input = getEntry(allowedEntry);
		if(input.equals("load")){
			load();
		}else{
			create();
		}
	}
	
	private void create() {
		
		boolean running = true;
		while(running){
			showCatalog();
			displayMessage("Would you like to \"add\", \"save\", or \"quit\"?");
			String[] allowedEntry = {"add","save","quit"};
			String selection = getEntry(allowedEntry);
			if(selection.equals("add")){
				add();
			}else if(selection.equals("save")){
				save();
			}else{
				running = false;
			}
		}
	}
	
	private void add() {
		String type = null;
		int armrpt;
		int strpt;
		displayMessage("Please enter a Character");
		type = getStringInput();
		displayMessage("How much armor does this Character have?");
		armrpt = getIntegerInput();
		displayMessage("How much strength does this Character have?");
		strpt = getIntegerInput();
		addCharacter(new Character(type, armrpt, strpt));
	}
	
	private int getIntegerInput() {
		String text = in.nextLine();
		int value = 0;
		boolean valid = false;
		while(!valid){
			try{
				value = Integer.parseInt(text);
				valid = true;
			}catch(NumberFormatException nfe){
				displayMessage("You must enter an integer.");
			}
		}
		return value;
	}
	
	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			displayMessage("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}
	
	private void addCharacter(Character c){
		animatedCharacters.add(c);
	}
	
	private void save() {
		try{    
			FileWriter fw=new FileWriter("CharacterCatalog.csv");
			for(Character c: animatedCharacters){
				fw.write(c+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"CharacterCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	private static String getEntry(String[] allowedEntry) {
		String input = in.nextLine();
		while(!matchesEntry(input, allowedEntry)){
			displayMessage("You must enter one of these words: ");
			for(String s: allowedEntry){
				System.out.print(s+" ");
			}
			displayMessage("\n");
			input = in.nextLine();
		}
		return input;
	}

	private static boolean matchesEntry(String text, String[] list){
		for(String l: list){
			if(l.equals(text))return true;
		}
		return false;
	}

	private  void showCatalog() {
		displayMessage("The catalog contains these Characters:\n");
		for(Character c: animatedCharacters){
			displayMessage("   "+c.toString()+"\n");
		}
	}

	private void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		animatedCharacters = new ArrayList<Character>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read the file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {

					String[] param = line.split(",");
					//add a new Book for each line in the save file
					animatedCharacters.add(new Character(param[0],Integer.parseInt(param[1]),Integer.parseInt(param[2])));



				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		create();

	}
	

	/*
	@Override
	public void initScreen() {
		SampleScreen s = new SampleScreen(getWidth(), getHeight());
		setScreen(s);
	}
	
	public class SampleScreen extends FullFunctionScreen{

		private static final long serialVersionUID = 258186143576427947L;
		
		public SampleScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			//Set styles
			StyledComponent.setButtonOutline(true);
			setCustomFont();
			
			TextBox box = new TextBox(25, 50, 200, 100, "Enter your character names here!");
			viewObjects.add(box);
			
			TextArea display = new TextArea(250, 50, 200, 150, "Would you like to add a character to our catalogs?");
			viewObjects.add(display);
			
			
			Button b = new Button(25,150, 200, 30,"Submit", new Action() {
				
				@Override
				public void act() {
					int armrpt = (int) (Math.random() * 10);
					int strpt = (int) (Math.random() * 10);
					animatedCharacters.add(new Character(0, 0, 10 , 10, box.getText(), armrpt, strpt));
					display.setText("Sucess! You added " + box.getText() + " with " + armrpt + " defense points and " + strpt + " strength points! To add another character, enter another character name you want to add!");
				}
			});
			viewObjects.add(b);
			
			TextArea display1 = new TextArea(25, 250, 100, 50, "Your Characters: ");
			viewObjects.add(display1);
			
			Character c = new Character(150, 150, 40 , 60, "Mario", 10, 10);
			viewObjects.add(c);
		}
		
		private void setCustomFont(){
			InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("AdventPro-Medium.ttf");
			try {
				Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(14f);
				StyledComponent.setBaseFont(font);
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	*/
	
	public String getCSVContent() {
		String data = "";
		for(Character c: animatedCharacters) {
			data += c;
			data += "\n";
		}
		return data;
	}
	
}
