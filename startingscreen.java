import arc.*;
import java.awt.Color;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class startingscreen{
	public static void main(String[] args){
		Console con = new Console("HANGMAN");
		con.setBackgroundColor(new Color(237,164,178));
		
		String strname;
		int intoption=0;
		boolean blnrepeat=true;
		boolean blntrack = true;
		int x=0;
		int y=0;
		int z=0;
		int intmousex;
		int intmousey;
		int intpress;
			
		//creating fade animation in the beginning	
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,960,540);
		BufferedImage logo = con.loadImage("logo.png");
		con.drawImage(logo, 170,60);
		con.repaint();
		
		//fading into starting scren when user clicks screen
		while(x<240){
			intpress = con.currentMouseButton();
			intmousex = con.currentMouseX();
			intmousey = con.currentMouseY();
			if(intpress==1){
				while(x < 240){
					x = x+12;
					y = y +8;
					z = z+9;
					con.setDrawColor(new Color(x, y, z));
					con.fillRect(0,0,1000,800);
					con.repaint();
					con.sleep(50);
				}
			}
		}

		
		con.setTextColor(new Color(96,64,130));
		con.println("Please enter your name:");
		strname = con.readLine();
		
		//looping so buttons and text appear again if the play returns from a method
		while(blnrepeat==true){
			con.clear();
			blntrack = true;
			
			//buttons
			con.setDrawColor(new Color(245, 233, 247));
			con.fillRoundRect(30,40,440,100,20,20);
			con.fillRoundRect(490,40,440,100,20,20);
			con.fillRoundRect(710, 430,220,70,15,15);
			con.setDrawColor(new Color(96,64,130));
			con.drawString("PLAY",220,70);
			con.drawString("LEADERBOARD", 650,70);
			con.drawString("QUIT", 797, 445);
			con.repaint();
			
			//loop to continuously update mouse location for buttons
			con.println("Hi, "+strname+"! Welcome to Hangman");
			while(blntrack ==true){
				intpress = con.currentMouseButton();
				intmousex = con.currentMouseX();
				intmousey = con.currentMouseY();
				if(intpress==1 && intmousex>30 && intmousex<470 && intmousey>40 &&intmousey<140){ //go to play screen
					con.sleep(250);
					con.clear();
					clickplay.clickplay(con, strname);
					blntrack = false;
				}else if(intpress==1 && intmousex>490 && intmousex<930 && intmousey>40 && intmousey<140){ //go to leaderboard
					clickplay.leaderboard(con);
					blntrack = false;
				}else if(intpress ==1 && intmousex>710 && intmousex<930 && intmousey>430 && intmousey<500){ //quit game
					con.clear();
					//fade out before closing
					while(x>0){
						intpress = con.currentMouseButton();
						intmousex = con.currentMouseX();
						intmousey = con.currentMouseY();
						if(intpress==1){
							while(x>0){
							x = x-12;
							y = y-8;
							z = z-9;
							con.setDrawColor(new Color(x, y, z));
							con.fillRect(0,0,1000,800);
							con.repaint();
							con.sleep(50);
							}
						}
					}
					con.closeConsole();
				}
				con.sleep(50);
			}
		
		}
		
	}
}


