import arc.*;
import java.awt.Color;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class clickplay{
	public static Console clickplay(Console con, String strname){
		con.setBackgroundColor(new Color(237,164,178));
		
		int intscore;
		String strSelectedTheme="";
		boolean plyagain;
		
		con.setTextColor(new Color(96,64,130));
		strSelectedTheme = "";
		/*if(!strSelectedTheme.equalsIgnoreCase("foods") || !strSelectedTheme.equalsIgnoreCase("musicals") || !strSelectedTheme.equalsIgnoreCase("books") || !strSelectedTheme.equalsIgnoreCase("flowers") || !strSelectedTheme.equalsIgnoreCase("CRK")){
			con.clear();
			con.println("Type in the theme you wish to play:");
			con.println("Foods   ||   Musicals   ||   Books   ||   Flowers   ||   CRK");
			strSelectedTheme = con.readLine();
		}*/
		
		con.println("Choose a theme!");
		int mousex;
		int mousey;
		int intpress;
		con.setDrawColor(new Color(245, 233, 247));
		//buttons
		con.fillRoundRect(20,80,176,200,15,15);
		con.fillRoundRect(206,80,176,200,15,15);
		con.fillRoundRect(392,80,176,200,15,15);
		con.fillRoundRect(578,80,176,200,15,15);
		con.fillRoundRect(764,80,176,200,15,15);
		con.setDrawColor(new Color(131, 96, 166));
		//icons
		BufferedImage foodicon = con.loadImage("iconfood.png");
		con.drawImage(foodicon, 30,90);
		con.drawString("Foods",75,245);
		
		BufferedImage musicalicon = con.loadImage("iconmusical.png");
		con.drawImage(musicalicon, 216,90);
		con.drawString("Musicals",245,245);
		
		BufferedImage bookicon = con.loadImage("iconbook.png");
		con.drawImage(bookicon, 402,90);
		con.drawString("Books",448,245);
		
		BufferedImage flowericon = con.loadImage("iconflower.png");
		con.drawImage(flowericon, 588,90);
		con.drawString("Flowers",625,245);
		
		BufferedImage crkicon = con.loadImage("iconcrk.png");
		con.drawImage(crkicon, 774,90);
		con.drawString("CRK",830,245);
		
		con.repaint();
		while(strSelectedTheme.equals("")){
			intpress = con.currentMouseButton();
			mousex = con.currentMouseX();
			mousey = con.currentMouseY();
			if(intpress==1 &&  mousey>90 && mousey<249 && mousex>30 && mousex<189){
				strSelectedTheme = "foods";
			}else if(intpress==1 &&  mousey>90 && mousey<249 && mousex>216 && mousex<375){
				strSelectedTheme = "musicals";
			}else if(intpress==1 &&  mousey>90 && mousey<249 && mousex>402 && mousex<561){
				strSelectedTheme = "books";
			}else if(intpress==1 &&  mousey>90 && mousey<249 && mousex>588 && mousex<747){
				strSelectedTheme = "flowers";
			}else if(intpress==1 &&  mousey>90 && mousey<249 && mousex>774 && mousex<933){
				strSelectedTheme = "CRK";
			}
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
			TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt",true);
			leaderboard.println(strname);
			leaderboard.println(intscore);
			con.println("Thank you for playing!"); 
		}
		con.sleep(2000);
		return con;
		
	}
	public static Console leaderboard(Console con){
		
		String strreturn = "0";
		String player[][];
		String strline;
		String tempplay;
		String tempscore;
		int numofplayers=0;
		int intcount=0;
		int intcount2;
		System.out.println("Test");
		
		con.setBackgroundColor(new Color(237,164,178));
		TextInputFile board2 = new TextInputFile("leaderboard.txt");
		while(board2.eof()==false){
			strline = board2.readLine();
			numofplayers++;
		}
		System.out.println(numofplayers);
		board2.close();
		
		player = new String[numofplayers/2][2];
		TextInputFile board = new TextInputFile("leaderboard.txt");
		while(board.eof()==false){
			player[intcount][0] = board.readLine();
			player[intcount][1] = board.readLine();
			System.out.println(player[intcount][0]+" "+player[intcount][1]);
			intcount = intcount +1;	
		}

		for(intcount2 = 0; intcount2 <(numofplayers/2)-1; intcount2++){
			for(intcount = 0; intcount<(numofplayers/2)-1; intcount++){
				if(Integer.parseInt(player[intcount+1][1])>Integer.parseInt(player[intcount][1])){
					tempplay = player[intcount][0];
					player[intcount][0] = player[intcount+1][0];
					player[intcount+1][0] = tempplay;
					
					tempscore = player[intcount][1];
					player[intcount][1] = player[intcount+1][1];
					player[intcount+1][1] = tempscore;
				}
			}
		}
		for(intcount = 0; intcount<(numofplayers/2); intcount++){
			con.println(player[intcount][0]+" "+player[intcount][1]);
		}
		
		while(!strreturn.equals("1")){
			con.println("Return to main screen? (Enter 1)");
			strreturn = con.readLine();
		}
		if(strreturn.equals("1")){
			return con;
		}
		return con;
	}
	

}
