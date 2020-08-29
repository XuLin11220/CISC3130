import java.io.*;
import java.util.*;
public class Name {
	public Name(String last, String first) {
		this.last = last;
		this.first = first;
	}
	public Name(String first) {this("", first);}
    public String getInitials() {return first.charAt(0) + "." + last.charAt(0) + ".";}
	public String getFormal() {return first + " " + last;}
	public String getOfficial() {return last + ", " + first;}
	public boolean equals(Name other) {return first.equals(other.first) && last .equals(other.last);}
	public String toString() {return first + " " + last;}
	public static Name read(Scanner scanner) {
		if (!scanner.hasNext()) return null;
		String last = scanner.next();
		String first = scanner.next();
		return new Name(last, first);
	}
	private String first, last;
	public static void main(String [] args) throws Exception {
		Scanner scanner = new Scanner(new File("names.text"));
		int count = 0;
		Name name = read(scanner);
		while(name != null) {
		    System.out.println("name: " + name.toString());
			System.out.println("formal: " + name.getFormal());
			System.out.println("official: " + name.getOfficial());
			System.out.println("initials: " + name.getInitials());
			System.out.println();
			count++;
			Name reader = read(scanner);
			if(reader != null)
			while(name.equals(reader) && reader != null){
	    	System.out.println("Duplicate name \"" + name.getFormal() +"\" discovered");
	        name = reader;
		    reader = read(scanner);
	    	count++;
			}
			name = reader;
		}
		System.out.println("---");
		System.out.println(count + " names processed.");
	}
} 