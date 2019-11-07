/* SongComparator.java
 * Brent Credo
 * Project 3
 * CMSC 256 Fall
 * This program sorts the albums and songs in the album
 * in alphabetical order
 */

package cmsc256;

import java.util.Comparator;
import bridges.data_src_dependent.Song;
/*
 * comparator method that sorts the album titles in alphabetical order and 
 * the songs in the album
 */
public class SongComparator implements Comparator<Song>{

	@Override

	public int compare(Song o1, Song o2) {
		/*
		 * ensures that there is an album title
		 */
		if (o1.getAlbumTitle() != null && o2.getAlbumTitle() != null) {
		/*
		 * determines if the album title is the same then it returns the song
		 * title in alphabetical order
		 * if not it returns the album title
		 */
		if (o1.getAlbumTitle().compareTo(o2.getAlbumTitle()) == 0 ) {
			return o1.getSongTitle().compareTo(o2.getSongTitle());
		}
		else {
			return o1.getAlbumTitle().compareTo(o2.getAlbumTitle());
		}
	}
		/*
		 * if the album obj doesn't match it puts the song at the end
		 */
		return o2.getSongTitle().compareTo(o1.getSongTitle());
	}
}

