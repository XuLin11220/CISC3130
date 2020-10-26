public class Playlist {
	private Song first;
	public Playlist() {
		//constructors to creating a new list
		first = null;
	}
	public void addSong(Song s) {
		//if list is empty
		if(first == null) {
			s.setNext(first);
			first = s;
			return;
		}//add song at the end of the list
		Song temp = first;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(s);
	}//return song from the head of the list
	public Song listenToSong() {
		Song temp = first;
		first = first.getNext();
		return temp;
		// retrieves the next song to listen to
	}
}
class Song{
	private String track;
	private Song next;
	public Song() {
		//constructors
		track = "";
		next = null;
	}
	public Song(String track) {
		this.track = track;
		next = null;
	}
	public Song getNext() {
		return next;
	}
	public void setNext(Song next) {
		this.next = next;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
}
