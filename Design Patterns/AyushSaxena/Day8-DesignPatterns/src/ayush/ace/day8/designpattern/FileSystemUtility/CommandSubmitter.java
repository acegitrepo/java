package ayush.ace.day8.designpattern.FileSystemUtility;

public class CommandSubmitter {

	Command thisCommand;
	
	CommandSubmitter(Command newCommand){
		
		thisCommand = newCommand;
	}
	
	public void submitCommand(){
		
		thisCommand.execute();
		
	}
	
	
}
