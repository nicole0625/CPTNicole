import arc.*;

public class clickplay{
	public static void main(String[] args){
		Console con = new Console("PLAY START");
		String strname;
		String strSelectedTheme;
		con.println("Please enter your name:");
		strname = con.readLine();
		strSelectedTheme = "";
		con.println("Hi, "+strname+"! Type in the theme you wish to play:");
		if(!strSelectedTheme.equalsIgnoreCase("foods") || !strSelectedTheme.equalsIgnoreCase("musicals") || !strSelectedTheme.equalsIgnoreCase("books") || !strSelectedTheme.equalsIgnoreCase("flowers") || !strSelectedTheme.equalsIgnoreCase("CRK")){
			con.println("Foods   ||   Musicals   ||   Books   ||   Flowers   ||   CRK");
			strSelectedTheme = con.readLine();
		}else{
			strSelectedTheme = con.readLine();
		}
		
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
			con.println(intcount+" "+strword[intcount][0]+" random: "+strword[intcount][1]);
		}
		con.println("Testing");
		//bubble sort
		Console con2 = new Console("array",700, 1000);
		String strtempword;
		int intcount2;
		//for(intcount2 = 0; intcount2<intthemenum-1; intcount2++){
			for(intcount = 0; intcount<intthemenum-1; intcount++){
				con2.println("Testing in for loop");
				if(Integer.parseInt(strword[intcount][1])>Integer.parseInt(strword[intcount+1][1])){
					con2.println("Testing in if statement");
					strtempword = strword[intcount][0];
					con2.println("   Going up: "+strtempword+strword[intcount][1]);
					strword[intcount][0] = strword[intcount+1][0];
					con2.println("   New down: "+strword[intcount][0]+strword[intcount+1][1]);
					strword[intcount+1][0] = strtempword;
				}else{
					con2.println("No swap... bigger: "+strword[intcount+1][0]+strword[intcount+1][1]+" smaller: "+strword[intcount][0]+strword[intcount][1]);
				}
			}


	}
}
