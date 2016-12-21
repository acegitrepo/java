package ayush.ace.day8.designpattern.FileSystemUtility;

public class Unix implements OS {

	@Override
	public void open() {
		System.out.println("Unix File Opened");
		
	}

	@Override
	public void close() {
		System.out.println("Unix File Closed");
		
	}

	@Override
	public void write() {
	 	System.out.println("Unix File Written");
		
	}

}
