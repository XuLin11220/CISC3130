import java.util.ArrayList;
import java.util.LinkedList;
public class MyApp {
	public static void main(String args[]) {
		String [] myFiles = {"week1.csv","week2.cvs","week3.cvs","week4.cvs"};
		ArrayList<MyQueue> allTheWeeks = new ArrayList<MyQueue>();
		for(int i = 0; i < myFiles.length; i++) {
			MyQueue dataExtract = new MyQueue(myFiles[i]);
		    allTheWeeks.add(dataExtract);
		}
	}
	public static void addPlaylist(Playlist play, ArrayList<MyQueue> allTheWeeks) {
		for(int i = 0; i < allTheWeeks.size();i++) {
			MyQueue Q = allTheWeeks.get(i);
			LinkedList<Song> list = Q.getListOfSong();
			for(int j = 0; j < list.size(); j++) {
				play.addSong(list.get(j));
			}
		}
	}
} 