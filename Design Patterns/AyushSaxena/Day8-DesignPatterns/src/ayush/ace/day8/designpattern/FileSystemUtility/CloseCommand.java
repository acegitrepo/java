package ayush.ace.day8.designpattern.FileSystemUtility;

public class CloseCommand implements Command{

	OS thisOS;
	
	CloseCommand(OS newOS){
		
		this.thisOS = newOS;
		
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
