/* SongList.java
 * Brent Credo
 * Project 3
 * CMSC 256 Fall
 * This program sorts the albums and songs in the album
 * in alphabetical order
 */


package cmsc256;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SongList {
	/*
	 * main method that prompts user for the artist name
	 * if one is not entered it prompts for a name
	 * 
	 * calls the getSongsByArtist method using the name given
	 * in the command line argument
	 */
	public static void main(String[]args) {
		
		System.out.println("Please enter the artist name");
		Scanner scnr = new Scanner(System.in); 
		String nameArtist = scnr.nextLine();
		
		if(nameArtist == null) {
			System.out.print("Please enter an artist's name");
		}
		else {
			SongList art = new SongList();
			art.getSongsByArtist(nameArtist);
		}
	}
	/*
	 * reads song data from the bridges song dataset and is put into a list
	 * then uses the collections class to sort data based
	 * on the name of the artist
	 * 
	 */
	public String getSongsByArtist(String artist) {
		
		Bridges bridges = new Bridges(5, "brentcredo", "284655397948");
		DataSource ds = bridges.getDataSource();
		List<Song> songData = null;
		try {
			songData = ds.getSongData();
		}
		catch (Exception e) {
			System.out.println("Unable to connect to Bridges.");
		}
		/* goes through the datasource using a enhanced for loop
		 * if the artist matches the info in the datasource then
		 * it formats info of the artist
		 * takes the title of the song, name of the artist, and 
		 * name of the album and sets it equal to a string
		 */
		Collections.sort(songData, new SongComparator());
		int empty = 0;
		String result = "";
		for (Song data: songData) {
			String artName = data.getArtist();
			if(artName.equals(artist)) {
				result = result + ("Title: " + data.getSongTitle() + " Artist: " + data.getArtist() + " Album: " + data.getAlbumTitle())+ "\n";
				empty = 1;
			}
		}
		/*
		 * ensures that if there is no artist, it states that there
		 * is no artist
		 */
		if (empty == 0) {
			System.out.println("Artist not there");
		}
		/*
		 * returns the formatted string
		 */
		return result;
	}
}