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
		int x=0;
		int y=0;
		int z=0;
		boolean blntrack = true;
		int mousex;
		int mousey;
		int press;
				
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,960,540);
		BufferedImage logo = con.loadImage("logo.png");
		con.drawImage(logo, 170,60);
		con.repaint();
		while(x<240){
			press = con.currentMouseButton();
			mousex = con.currentMouseX();
			mousey = con.currentMouseY();
			if(press==1){
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
		
		con.clear();
		con.setDrawColor(new Color(237,164,178));
		con.fillRect(640,130, 900,430);
		con.println("Hi, "+strname+"! Welcome to Hangman");
		int intpress;
		con.setDrawColor(new Color(245, 233, 247));
		con.fillRoundRect(30,40,440,100,20,20);
		con.fillRoundRect(490,40,440,100,20,20);
		con.repaint();
		while(blnrepeat=true){
			press = con.currentMouseButton();
			mousex = con.currentMouseX();
			mousey = con.currentMouseY();
			if(press==1 && mousex>30 && mousex<470 && mousey>40 &&mousey<140){
				clickplay.clickplay(con, strname);
			}else if(press==1 && mousex>490 && mousex<930 && mousey>40 &&mousey<140){
				clickplay.leaderboard(con);
			}
		}
		
	}
}
