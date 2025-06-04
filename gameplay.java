import arc.*;
import java.awt.Color;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class gameplay{
	public static int gameplay(Console con, String strword[][]){

		con.println("");
		int intcount;
		int score;
		int intnumofletters;
		String strguess;
		int intwrongs;
		int intrannum;

		System.out.println("SECRET WORD: "+strword[0][0]);
		intnumofletters = strword[0][0].length();
		intwrongs = 0;
		String strletters[][];
		String strhidden[][];
		strletters = new String[intnumofletters][2];
		strhidden =new String[intnumofletters][1];
		//drawing hanging pole
		con.setDrawColor(new Color(142, 106, 173));
		con.drawLine(680, 140, 790, 140);
		con.drawLine(790, 140, 790, 155);
		con.drawLine(680, 140, 680, 400);
		con.drawLine(650, 400, 830, 400);
	
			
		con.clear();
		//setting up letters of hidden word in an array to randomly select one to reveal later
		for(intcount = 0; intcount<intnumofletters; intcount++){
			strletters[intcount][0]=strword[0][0].substring(intcount,intcount+1);
			strletters[intcount][1] = Integer.toString(intcount);
			System.out.println(strletters[intcount][0]+" || "+strletters[intcount][1]);
		}
		//hidden word
		for(intcount = 0;intcount<intnumofletters; intcount++){
			strhidden[intcount][0]="_";
			con.print(strhidden[intcount][0]);
		}
		con.println("");
		con.println("Type in your guess: ");
		
		strguess = con.readLine();
		while(!strguess.equalsIgnoreCase(strword[0][0]) && intwrongs <5){
			//con.clear();
			intwrongs = intwrongs+1;
			if(intwrongs == 1){
				con.fillOval(765, 157, 50, 50); //head
			}else if(intwrongs == 2){
				con.fillRect(788, 207, 4, 85); //torso
			}else if(intwrongs == 3){
				con.drawLine(788, 213, 765, 260); //arm left
			}else if(intwrongs == 4){
				con.drawLine(792, 213, 815, 260); //arm right
			}else if(intwrongs == 5){
				con.drawLine(788, 292, 772, 350); // leg left
			}
		
			con.clear();
			//selecting random letter in word to reveal letter
			intrannum = ((int)(Math.random()*intnumofletters));
			System.out.println("Random numer: "+intrannum);
			strhidden[intrannum][0] = strword[0][0].substring(intrannum,intrannum+1);
			//printing new line with another letter revealed
			for(intcount = 0;intcount<intnumofletters; intcount++){
				con.print(strhidden[intcount][0]);
			}
			con.println(" ");
			con.println("Wrong! Guess again");
			strguess = con.readLine();

		}
		score = 0;
		if(intwrongs ==5){
			con.drawLine(792, 292, 808, 350); // leg right
			con.sleep(500);
			con.clear();
			//con.setBackgroundColor(new Color(133,21,21));
			con.println("GAME OVER");
			score = 0;
			System.out.println("SCORE: "+score);
			return score;
		}
		
		
		if(strguess.equalsIgnoreCase(strword[0][0])){
			con.sleep(500);
			con.clear();
			//con.setBackgroundColor(new Color(89,161,39));
			con.println("Congrats! You got the secret word, "+strword[0][0]);
			score = 1;
			System.out.println("SCORE: "+score);
			return score;
		}
		return score;
	}
}
