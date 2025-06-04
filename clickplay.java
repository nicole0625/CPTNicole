import arc.*;
import java.awt.Color;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class clickplay{
	public static void main(String[] args){
		Console con = new Console("PLAY START");
		con.setBackgroundColor(new Color(237,164,178));
		
		int intscore;
		String strname;
		String strSelectedTheme;
		con.println("Please enter your name:");
		strname = con.readLine();
		strSelectedTheme = "";
		if(!strSelectedTheme.equalsIgnoreCase("foods") || !strSelectedTheme.equalsIgnoreCase("musicals") || !strSelectedTheme.equalsIgnoreCase("books") || !strSelectedTheme.equalsIgnoreCase("flowers") || !strSelectedTheme.equalsIgnoreCase("CRK")){
			con.clear();
			con.println("Hi, "+strname+"! Type in the theme you wish to play:");
			con.println("Foods   ||   Musicals   ||   Books   ||   Flowers   ||   CRK");
			strSelectedTheme = con.readLine();
		}
		boolean blnplay;
		intscore= 0;
		String strplay = "yes";
		while(strplay.equalsIgnoreCase("yes")){
			//creating array for selected theme
			String strword[][];
			String strread;
			int intthemenum;
			intthemenum = -1;
			int intcount;
			intcount = -1;
			
			TextInputFile theme = new TextInputFile(strSelectedTheme+".txt");
			while(theme.eof()==false){
				//getting the number of words of the selected theme
				strread = theme.readLine();
				intthemenum = intthemenum+1;
			}
			theme.close();
			TextInputFile theme2 = new TextInputFile(strSelectedTheme+".txt");
			
			//setting the number of arrays for strword to be the number of words in the themes file
			strword = new String[intthemenum+1][2];
			
			//putting each word into the array
			for(intcount = 0; intcount<=intthemenum; intcount++){
				strword[intcount][0] = theme2.readLine();
				strword[intcount][1] = Integer.toString((int)(Math.random()*10000));
				System.out.println(intcount+" "+strword[intcount][0]+" random: "+strword[intcount][1]);
			}
			//bubble sort
			String strtempword;
			String strtempnum;
			int intcount2;
			for(intcount2 = 0; intcount2<intthemenum-1; intcount2++){
				for(intcount = 0; intcount<=intthemenum-1; intcount++){
					System.out.println("Testing in for loop");
					if(Integer.parseInt(strword[intcount][1])>Integer.parseInt(strword[intcount+1][1])){
						strtempnum = strword[intcount][1];
						strword[intcount][1] = strword[intcount+1][1];
						strword[intcount+1][1] = strtempnum;
						
						System.out.println("Testing in if statement");
						strtempword = strword[intcount][0];
						System.out.println("   Going up: "+strtempword+strword[intcount][1]);
						strword[intcount][0] = strword[intcount+1][0];
						System.out.println("   New down: "+strword[intcount][0]+strword[intcount+1][1]);
						strword[intcount+1][0] = strtempword;
						
						
					}else{
						
					}
				}
			}
			
			for(intcount = 0; intcount<=intthemenum; intcount++){
				System.out.println(strword[intcount][0]+" "+strword[intcount][1]);
			}
			
				intscore = intscore + gameplay.gameplay(con, strword);
				con.println("Play again? (Please type in yes or no)");
				strplay = con.readLine();
		}
		
		if(strplay.equalsIgnoreCase("no")){
			con.println(intscore);
			con.println("Thank you for playing!");
		}
		
	/*GAME PLAY
		con.println("");
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
		if(intwrongs ==5){
			con.drawLine(792, 292, 808, 350); // leg right
			con.sleep(500);
			con.clear();
			con.setBackgroundColor(new Color(133,21,21));
			con.println("GAME OVER");
		}
		
		
		if(strguess.equalsIgnoreCase(strword[0][0])){
			con.sleep(500);
			con.clear();
			con.setBackgroundColor(new Color(89,161,39));
			con.println("Congrats! You got the secret word, "+strword[0][0]);
		}*/
	}

}
