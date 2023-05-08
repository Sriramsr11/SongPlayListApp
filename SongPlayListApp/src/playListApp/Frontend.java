package playListApp;
import java.util.*;

public class Frontend {
	private static ArrayList<Album>al=new ArrayList<>();
	public static void main(String[]args) {		
			
		Album a=new Album("Album1","sri");
		a.addSong("TNT", 4.5);
		a.addSong("Highway", 3.5);
		a.addSong("naatu", 5.0);
		al.add(a);
		
		a=new Album("Album2","ram");
		a.addSong("Rap Song", 3.7);
		a.addSong("God", 4.0);
		a.addSong("Lose", 4.6);
		al.add(a);
		
		LinkedList<Song>playList_1=new LinkedList<>();
		al.get(0).addToPlayList("TNT", playList_1);
		al.get(0).addToPlayList("naatu", playList_1);
		al.get(1).addToPlayList("God", playList_1);
		al.get(1).addToPlayList("Lose", playList_1);
		
		play(playList_1);
		
	}
	private static void play(LinkedList<Song>playList) {
		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song>listIterator=playList.listIterator();
		
		if(playList.size()==0) {
			System.out.println("This Playlist is empty");
		}else {
			System.out.println("Now Playing "+listIterator.next().toString());
			printMenu();
		}
		while(!quit) {
			int action=sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("Playlist Completed");
				quit=true;
				break;
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}forward=true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now Playing "+listIterator.next().toString());
				}else {
					System.out.println("No Song available, reached to the end os he list");
					forward=false;
				}
				break;
			case 2:
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}forward=false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now Playing "+listIterator.previous().toString());
				}else {
					System.out.println("We are at the first song");
				}
				break;
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now Playing "+listIterator.previous().toString());
						forward=false;
					}else {
						System.out.println("We are at the start of the list");
					}
				}else {
					if(listIterator.hasNext()) {
						System.out.println("Now Playing "+listIterator.next().toString());
						forward=true;
					}else {
						System.out.println("We have reached to the end of the list");
					}
				}
				break;
			case 4:
				printList(playList);
				break;
			case 5:
				printMenu();
				break;
			case 6:
				if(playList.size()>0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now Playing "+listIterator.next().toString());
					}else {
						if(listIterator.hasPrevious()) {
							System.out.println("Now Playing "+listIterator.previous().toString());
						}
					}
				}				
			}
		}
	}
	private static void printMenu() {
		System.out.println("Available options\n press");
		System.out.println("0 - to quit\n"+
		"1 - to play next song\n"+
		"2 - to play previous song\n"+
		"3 - to replay the current song\n"+
		"4 - list of all songs\n"+
		"5 - print all available options\n"+
		"6 - delete current song");
	}
	private static void printList(LinkedList<Song>playList) {
		Iterator<Song>it=playList.iterator();
		System.out.println("--------------------------------------");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("--------------------------------------");
	}
	
	
	
}
