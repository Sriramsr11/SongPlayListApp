package playListApp;
import java.util.*;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song>s;
	
	public Album(String name,String artist) {
		this.name=name;
		this.artist=artist;
		this.s=new ArrayList<Song>();
	}
	public Album() {
		
	}
	public Song findSong(String title) {
		for(Song checkedSong: s) {
			if(checkedSong.getTitle().equals(title)) return checkedSong;
		}return null;
	}	
	
	public boolean addSong(String title,double duration) {
		if(findSong(title)==null) {
			s.add(new Song(title,duration));
			//System.out.println(title+"successfully added to the list");
			return true;
		}else {
			//System.out.println("Song with name "+title+" already exist int the list");
			return false;
		}		
	}
	public boolean addToPlayList(int trackNumber,LinkedList<Song>PlayList) {
		int index=trackNumber-1;
		if(index>0&&index<=this.s.size()) {
			PlayList.add(this.s.get(index));
			return true;
		}
		//System.out.println("This album does not have song with trackNumber "+trackNumber);
		return false;
	}
	public boolean addToPlayList(String title,LinkedList<Song>PlayList) {
		for(Song checkedSong:this.s) {
			if(checkedSong.getTitle().equals(title)) {
				PlayList.add(checkedSong);
				return true;
			}
		}
		//System.out.println(title+"There is no such song in the album");
		return false;
	}
	
	
	
	
	
	
	
	

}
