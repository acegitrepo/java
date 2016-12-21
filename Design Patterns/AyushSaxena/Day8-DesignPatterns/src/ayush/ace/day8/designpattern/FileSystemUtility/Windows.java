package ayush.ace.day8.designpattern.FileSystemUtility;

public class Windows implements OS {

	@Override
	public void open() {
		System.out.println("Windows File Opened");
		
	}

	@Override
	public void close() {
		System.out.println("Windows File Closed");
		
	}

	@Override
	public void write() {
		System.out.println("Windows File Written");
		
	}

}
