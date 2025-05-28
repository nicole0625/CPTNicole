import arc.*;

public class clickplay{
	public static void main(String[] args){
		Console con = new Console("PLAY START");
		String strname;
		String strSelectedTheme;
		con.println("Please enter your name:");
		strname = con.readLine();
		con.println("Hi, "+strname+"! Type in the theme you wish to play:");
		if(!strSelectedTheme.equalsIgnoreCase("foods") || !strSelectedTheme.equalsIgnoreCase("musicals") || !strSelectedTheme.equalsIgnoreCase("books") || !strSelectedTheme.equalsIgnoreCase("flowers") || !strSelectedTheme.equalsIgnoreCase("CRK")){
			con.println("Foods   ||   Musicals   ||   Books   ||   Flowers   ||   CRK");
			strSelectedTheme = con.readLine();
		}else{
			strSelectedTheme = con.readLine();
		}
		
		//creating array for selected theme
		String strword[];
		String strread;
		int intrand[];
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
		strword = new String[intthemenum+1];
		//putting each word into the array
		for(intcount = 0; intcount<=intthemenum; intcount++){
			strword[intcount] = theme2.readLine();
			intrand[intcount] = Math.random();
			con.println(intcount+" "+strword[intcount]+" random: "+intrand);
		}
		//assigning each word a random number
		
	}
}
