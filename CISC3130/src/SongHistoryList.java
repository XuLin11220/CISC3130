public class SongHistoryList {
	private Song first;
	public SongHistoryList() {
		first = null;
	}
	public void addSonng(Song s) {
		s.setNext(first);
		first = s;
	}
	public Song LastListend() {
		Song temp = first;
		first = first.getNext();
		return temp;
		// retrieves the next song to listen to
	}
}
