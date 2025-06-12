import arc.*;
import java.awt.Color;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class leaderboard{
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
