import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWords {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("D://textFile.txt");
		
		BufferedReader br = new BufferedReader(fr);
		String line="";
		int count=0;
		
		while((line =br.readLine())!=null)
				{
			count=count+line.split(" ").length;
			
				}
				br.close();
				fr.close();
		System.out.println("count "+count);
		
	}
}