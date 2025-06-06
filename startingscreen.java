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
		int intoption;
		boolean blnrepeat;
		int x;
		
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1000,800);
		x=0;
		while(x < 100){
			x = x+20;
			System.out.println(x);
			con.setDrawColor(new Color(x, x, x));
			con.fillRect(x,0,200,200);
			con.repaint();
			con.sleep(500);
		}
		
		con.setTextColor(new Color(96,64,130));
		con.println("Please enter your name:");
		strname = con.readLine();
		while(blnrepeat = true){
			con.clear();
			con.setDrawColor(new Color(237,164,178));
			con.fillRect(640,130, 900,430);
			con.println("Hi, "+strname+"! Welcome to Hangman. PLAY(1), leaderboard(2)");
			intoption = con.readInt();
			if(intoption == 1){
				clickplay.clickplay(con, strname);
			}else if(intoption == 2){
				clickplay.leaderboard(con);
			}
		}
	}
}
