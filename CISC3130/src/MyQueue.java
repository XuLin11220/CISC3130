import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
public class MyQueue{
	private LinkedList<Song>list;
	//constructor that creates a linked list that stores songs from a text file
	public MyQueue(String filename) {
		//take the filename, open it and convert to queue
		list = new LinkedList<Song>();
		try {
			File file = new File(filename);
			FileReader filereader = new FileReader(file);
			BufferedReader br = new BufferedReader(filereader);
			String line;
			while(true) {
				line = br.readLine();
				if(line == null)
					break;
				Song s = new Song(line);
				list.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public LinkedList<Song> getListOfSong(){
		return list;
	}
}
