import arc.*;
import java.awt.Color;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class clickplay{
	public static Console clickplay(Console con, String strname){
		int intscore;
		String strSelectedTheme="";
		boolean blnrepeat = true;
		int intmousex;
		int intmousey;
		int intpress;
		
		con.setBackgroundColor(new Color(237,164,178));
		con.setTextColor(new Color(96,64,130));

	
		while(blnrepeat ==true){
			con.setDrawColor(new Color(245, 233, 247));
			con.drawString("Choose a theme!",380,28);
			//drawing buttons
			con.fillRoundRect(20,80,176,200,15,15); //food
			con.fillRoundRect(206,80,176,200,15,15); //musicals
			con.fillRoundRect(392,80,176,200,15,15); //books
			con.fillRoundRect(578,80,176,200,15,15); //flowers
			con.fillRoundRect(764,80,176,200,15,15); //crk
			con.fillRoundRect(20,290,455,100,15,15); //add custom
			con.fillRoundRect(485,290,455,100,15,15); //choose custom
			
			con.setDrawColor(new Color(131, 96, 166));
			//icons & text
			con.drawString("Add Custom Theme",145,320);
			con.drawString("Select Custom Theme",590,320);
			
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
			
			con.setDrawColor(new Color(245, 233, 247));
			con.fillRoundRect(730,430,200,70,15,15);
			con.setDrawColor(new Color(131, 96, 166));
			con.drawString("RETURN HOME",760,445);
			
			con.repaint();
			
			//loop to track mouse for buttons
			while(strSelectedTheme.equals("")){
				intpress = con.currentMouseButton();
				intmousex = con.currentMouseX();
				intmousey = con.currentMouseY();
				if(intpress==1 &&  intmousey>90 && intmousey<249 && intmousex>30 && intmousex<189){
					strSelectedTheme = "foods";
					blnrepeat =false;
				}else if(intpress==1 &&  intmousey>90 && intmousey<249 && intmousex>216 && intmousex<375){
					strSelectedTheme = "musicals";
					blnrepeat =false;
				}else if(intpress==1 &&  intmousey>90 && intmousey<249 && intmousex>402 && intmousex<561){
					strSelectedTheme = "books";
					blnrepeat =false;
				}else if(intpress==1 &&  intmousey>90 && intmousey<249 && intmousex>588 && intmousex<747){
					strSelectedTheme = "flowers";
					blnrepeat =false;
				}else if(intpress==1 &&  intmousey>90 && intmousey<249 && intmousex>774 && intmousex<933){
					strSelectedTheme = "CRK";
					blnrepeat =false;
				}else if(intpress==1 &&  intmousey>290 && intmousey<390 && intmousex>20 && intmousex<475){
					Entercustom(con);
				}else if(intpress==1 &&  intmousey>290 && intmousey<390 && intmousex>485 && intmousex<940){
					strSelectedTheme = ChooseCustom(con);
					blnrepeat =false;
				}
				if(intpress==1 && intmousex>730 && intmousex<930 && intmousey>430 &&intmousey<500){
					con.setBackgroundColor(new Color(237,164,178));
					return con;
				}
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
						
						
					}
				}
			}
			
			//Checking to make sure words are sorted properly
			for(intcount = 0; intcount<=intthemenum; intcount++){
				System.out.println(strword[intcount][0]+" "+strword[intcount][1]);
			}
			
			//starting gameplay 
			intscore = intscore + gameplay.gameplay(con, strword);
			//ask to play again
			con.println("Play again? (Please type in yes or no)");
			strplay = con.readLine();
		}
		
		if(strplay.equalsIgnoreCase("no")){
			TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt",true);
			leaderboard.println(strname);
			leaderboard.println(intscore);
			con.println("Thank you for playing!"); 
			con.sleep(2000);
			con.setBackgroundColor(new Color(237,164,178));
			return con;
		}

		return con;
		
	}

	public static Console leaderboard(Console con){
		boolean constant = true;
		String player[][];
		String strline;
		String tempplay;
		String tempscore;
		int numofplayers=0;
		int intcount=0;
		int intcount2;
		System.out.println("Test");
		con.setBackgroundColor(new Color(237,164,178));
		
		//opening leaderboard file and checking how many players
		TextInputFile board2 = new TextInputFile("leaderboard.txt");
		while(board2.eof()==false){
			strline = board2.readLine();
			numofplayers++;
		}
		System.out.println(numofplayers);
		board2.close();
		
		//opening it again to give value to the player array
		player = new String[(numofplayers/2)][2];
		TextInputFile board = new TextInputFile("leaderboard.txt");
		while(board.eof()==false){
			player[intcount][0] = board.readLine();
			player[intcount][1] = board.readLine();
			System.out.println(player[intcount][0]);
			System.out.println(player[intcount][1]);
			//System.out.println(player[intcount][0]+" || "+player[intcount][1]);
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
			con.println(player[intcount][0]+": "+player[intcount][1]);
		}
		con.setDrawColor(new Color(245, 233, 247));
		con.fillRoundRect(730,430,200,70,15,15);
		con.setDrawColor(new Color(131, 96, 166));
		con.drawString("RETURN HOME",760,445);
		while(constant = true){
			int press = con.currentMouseButton();
			int intmousex = con.currentMouseX();
			int intmousey = con.currentMouseY();
			if(press==1 && intmousex>730 && intmousex<930 && intmousey>430 &&intmousey<500){
				con.setBackgroundColor(new Color(237,164,178));
				return con;
			}
		}
		
		return con;
	}

	public static Console Entercustom(Console con){
		con.setBackgroundColor(new Color(237,164,178));
		String strnewTheme;
		String strThemes[][];
		int keepadding = 1;
		int wordnum;
		int intcount;
		boolean constant = true;

		con.setBackgroundColor(new Color(237,164,178));
		con.println("Please enter the new theme you wish to create: ");
		strnewTheme = con.readLine();
		TextOutputFile customtheme = new TextOutputFile("customThemes.txt",true);
		customtheme.println(strnewTheme);
		TextOutputFile wordbank = new TextOutputFile(strnewTheme+".txt",true);
		
		con.println("How many words do you want to put into this theme?");
		wordnum = con.readInt();
		strThemes = new String[wordnum][1];
		
		for(intcount =0; intcount<wordnum;intcount++){
			con.println("Enter a word matching the theme ("+(intcount+1)+"): ");
			strThemes[intcount][0] = con.readLine();
			wordbank.println(strThemes[intcount][0]);
		}
		con.println("Added theme... "+strnewTheme);
		con.setDrawColor(new Color(245, 233, 247));
		con.fillRoundRect(730,430,200,70,15,15);
		con.setDrawColor(new Color(131, 96, 166));
		con.drawString("RETURN HOME",750,450);
		while(constant = true){
			int press = con.currentMouseButton();
			int intmousex = con.currentMouseX();
			int intmousey = con.currentMouseY();
			if(press==1 && intmousex>730 && intmousex<930 && intmousey>430 &&intmousey<500){
				System.out.println("button pressed");
				con.clear();
				con.setBackgroundColor(new Color(237,164,178));
				return con;
			}
		}

		return con;
	}
	public static String ChooseCustom(Console con){
		String stroptions;
		String selectedtheme;
		con.setBackgroundColor(new Color(237,164,178));
		con.println("These are the custom themes available: ");
		TextInputFile customt = new TextInputFile("customThemes.txt");
		while(customt.eof()== false){
			stroptions = customt.readLine();
			con.println(stroptions);
		}
		customt.close();
		con.println("Please enter the theme you wish to play, spelt exactly");
		selectedtheme = con.readLine();
		return selectedtheme;
	}
}


