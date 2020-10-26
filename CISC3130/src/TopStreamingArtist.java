import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
public class TopStreamingArtist {
	private Artist first;
	private Artist last;
	class Artist{
		private String name;
		private Artist next;
		//Artist class constructor
		public Artist(String name) {
			this.name = name;
			this.next = null;
		}
	}
	//TopSreamingArtist class constructor
	public TopStreamingArtist(){
		first = null;
		last = null;
	}
	//check if the first name is empty or not 
	public boolean isEmpty() {
		return (first == null);
	}
	// insert metod
	public void insert(String name) {
		Artist newlist = new Artist(name);
		if(this.isEmpty()) {
			first = newlist;
			last = newlist;
		}
		else {
			last.next = newlist;
			last = newlist;
		}
	}
	// sort the list
	public void sort() {
		//set up list, index and temp
		Artist list = first, index = null;
		String temp;
		if(this.isEmpty()) {
			return;
		}
		//if list is not empty, setting index to list next.
		else {
			while(list != null) {
				index = list.next;
				while(index != null) {
					//compare two name, if list name is higher than index name, swap.
					if(list.name.compareTo(index.name) > 0) {
						temp = list.name;
						list.name = index.name;
						index.name = temp;
					}
					//increase position
					index = index.next;
				}
				//increase position
				list = list.next;
			}
		}
	}
	//display method
	public void displayNames() {
		Artist list = first;
		this.sort();
		//call sort method
		// if list is empty, let the user know
		// otherwise starts to print out the name
		if(this.isEmpty()) {
			System.out.println("Empty!");
			return;
		}
		while(list != null) {
			System.out.println(list.name);
			list = list.next;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		TopStreamingArtist artistNames = new TopStreamingArtist();
		int row = 200;
		int col = 5;
		String [] []link = new String[row][col]; 
		String [] names = new String[row];
		File data = new File("data.txt");
		Scanner scan = new Scanner(data);
		while(scan.hasNextLine()) {
			for(int i = 0; i < row; i++) {
				String [] line =scan.nextLine().trim().split(",");
					for(int j = 0; j < col; j++) {
					link[i][j] = line[j];
				}
			}
		}
		for(int i = 0; i < row; i++) {
			names[i] = link[i][2];
		}
		for(int i = 0; i < row; i++) {
			artistNames.insert(names[i]);
		}
		artistNames.displayNames();
	}
}
