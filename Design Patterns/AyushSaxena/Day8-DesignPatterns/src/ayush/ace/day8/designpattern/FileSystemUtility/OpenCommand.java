package ayush.ace.day8.designpattern.FileSystemUtility;

public class OpenCommand implements Command {

	OS thisOS;
	
	OpenCommand(OS newOS){
		
		this.thisOS = newOS;
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		thisOS.open();
		
	}
	
	

}
