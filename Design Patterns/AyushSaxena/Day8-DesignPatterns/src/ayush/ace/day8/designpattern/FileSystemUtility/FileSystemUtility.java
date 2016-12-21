package ayush.ace.day8.designpattern.FileSystemUtility;

public class FileSystemUtility {
	
	public static void main(String[] args){
		
		OS win = new Windows();
		OpenCommand openWin= new OpenCommand(win);
		
		OS uni = new Unix();
		
		CommandSubmitter submitter = new CommandSubmitter(openWin);
		submitter.submitCommand();
		
		OpenCommand openUni = new OpenCommand(uni);
		
		CommandSubmitter submitter1 = new CommandSubmitter(openUni);
		submitter1.submitCommand();
		
		
		
		
		
	}

}
