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
		//Paintingwithchocolate-K5mo.ttf
		int intscore;
		String strname;
		String strSelectedTheme;
		con.setTextColor(new Color(96,64,130));
		con.println("Please enter your name:");
		strname = con.readLine();
		strSelectedTheme = "";
		if(!strSelectedTheme.equalsIgnoreCase("foods") || !strSelectedTheme.equalsIgnoreCase("musicals") || !strSelectedTheme.equalsIgnoreCase("books") || !strSelectedTheme.equalsIgnoreCase("flowers") || !strSelectedTheme.equalsIgnoreCase("CRK")){
			con.clear();
			con.println("Hi, "+strname+"! Type in the theme you wish to play:");
			con.println("Foods   ||   Musicals   ||   Books   ||   Flowers   ||   CRK");
			strSelectedTheme = con.readLine();
		}
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
			TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt",true);
			leaderboard.println(strname+" | Score: "+intscore);
			con.println("Thank you for playing!");
		}
		
	}

}
