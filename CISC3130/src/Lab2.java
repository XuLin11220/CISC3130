import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
public class Lab2 {
	public static void main(String args[]) throws FileNotFoundException{
		data check = new data();
		check.read();
		check.Artists();
	}
}
class data{
	int col;
	int row;
	String [][] infor;
	public data() {
		//set up for the size of array
		this.col = 5;
		this.row = 200;
		this.infor = new String[row][col];
	}
	public void read(){
		File text = new File("data.txt");
		Scanner scan;
		try {
			scan = new Scanner(text);
			while(scan.hasNextLine()) {
				for(int i = 0; i < row; i++) {
					String [] line =scan.nextLine().split(",");
 					for(int j = 0; j < col; j++) {
						infor[i][j] = line[j];
					}
				}
			}


		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	public void Artists(){
		PrintWriter reportOfCount = null;
		PrintWriter reportOfStream = null;
		try {
			reportOfCount = new PrintWriter(new FileWriter("Artist.txt"));
			reportOfStream = new PrintWriter(new FileWriter("Stream.txt"));
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found!");
		}catch(IOException e) {
			System.out.println("Unable to access file");
		}
		String [] singer = new String[row];
		int [] count = new int[row];
		int [] StreamCount = new int [row];
		int position = 0;
		int index = -1;
		for(int i = 0; i < row; i++) {
			index = check(singer,infor[i][2]);
			if(index < 0) {//if index is -1 means that the singer only appears once
				singer[position] = infor[i][2];
				count[position] = count[position]+1;
				StreamCount[position] = StreamCount[position] + Integer.parseInt(infor[i][3]);
				position++;
			}else {
				count[index] = count[index]+1;// if index is positive means that singer appears multiple times.
				StreamCount[index] = StreamCount[index]+Integer.parseInt(infor[i][3]);
			}
		}
		//out put the file
		for(int i = 0; i < position; i++) {
			reportOfCount.write(singer[i]+","+count[i]);
			reportOfStream.write(singer[i]+","+StreamCount[i]);
		}
	}
	//checking for the name of singer
	public int check(String [] arr, String singer) {
		int ans = -1;
		for(int i = 0; i < row; i++) {
			if(singer.equals(arr[i])) {
				return i;
			}
		}
		return ans;
	}
}
