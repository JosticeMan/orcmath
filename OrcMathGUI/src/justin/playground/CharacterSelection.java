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
	
	private ArrayList<Character> animatedCharacters;
	private boolean asking;
	
	public CharacterSelection(int width, int height) {
		
		//super(width, height);
		animatedCharacters = new ArrayList<Character>();
		
		Scanner in = new Scanner(System.in);
		asking = true;
		System.out.println("Would you like to add a character to our catalogs?");
		triggerAsking(in.nextLine());
		while(asking) {
			System.out.println("What character would you like to add?");
			String name = in.nextLine();
			System.out.println("How much armor does this character have?");
			int armrpt = Integer.parseInt(in.nextLine());
			System.out.println("How much strength does this character have?");
			int strpt = Integer.parseInt(in.nextLine());
			animatedCharacters.add(new Character(0, 0, 10 , 10, name, armrpt, strpt));
			System.out.println("Sucess! Would you like to add another character?");
			triggerAsking(in.nextLine());
		}
		
		try {    

			 String fileName = "Character List";
			
			 FileWriter fw= new FileWriter(fileName);    

			 fw.write(getCSVContent());    

			 fw.close();    

			 System.out.println("Success! File \""+fileName+"\" saved!");

		}catch(IOException e){

			 System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}
	}

	private void triggerAsking(String nextLine) {
		if(nextLine.equalsIgnoreCase("yes")) {
			asking = true;
		}
		else {
			asking = false;
		}
	}

	public static void main(String[] args) {
		CharacterSelection cs = new CharacterSelection(800, 550);
		//Thread go = new Thread(cs);
		//go.start();

		 String fileName;
		 
		 List<String> content = new ArrayList<String>();

		 //use this boolean to control the while loop. The user should have multiple chances to enter a correct filename

		 boolean opened = false;

		 while(!opened){

			 try {
		
				 fileName = "Character List";
		
				 FileReader fileReader = new FileReader(new File(fileName));
		
				 String line = "";
		
				 //a BufferedReader enables us to read teh file one line at a time
		
				 BufferedReader br = new BufferedReader(fileReader);
		
				 while ((line = br.readLine()) != null) {
	
					 content.add(line);
	
					 /*
			
					  * useful later:
			
					  * split only a comma that has an even number of quotes ahead of it
			
					 String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			
					  */
				 }
		
				 br.close();
		
				 opened = true;

		 }catch (IOException e) {

		 System.out.println("The file name you specified does not exist."); 
		 }
		}
		
		System.out.println("Now viewing your csv file!");
		 
		for(String item : content){

			 System.out.println(item);

		}
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
