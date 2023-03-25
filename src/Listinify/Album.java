package Listinify;
import java.util.*;
public class Album{
    public String albumName;
    public String authorName;
    List<Song>songList;

    public Album(String albumName, String authorName) {
        this.albumName = albumName;
        this.authorName = authorName;
        this.songList = new ArrayList<>();
    }

    public boolean findSonginAlbum(String title){
        for(Song song : songList){
            if(song.title == title) return true;
        }
        return false;
    }

    public String addSongtoAlbum(String title, double duration){
        if(findSonginAlbum(title)){
            return "Song already exist";
        }
        songList.add(new Song(title, duration));
        return "added Successfully";
    }

    public String addSongtoPlaylist(int trackNo, LinkedList<Song> playList){

        //trackNo is sl.no of song in playList
        //trackNo's goes like 1, 2, 3, ...
        //index 0, 1, 2, 3,...
        int index = trackNo-1;
        if(index >= 0 && index < this.songList.size()){
            Song song = songList.get(index);
            playList.add(song);
            return "song added to playlist successfully";
        }
        return "Invalid track No";
    }


    public String addSongtoPlaylist(String title, LinkedList<Song> playList){

        for(Song song : songList){
            if(song.title == title) {
                playList.add(song);
                return "song added to playlist successfully";
            }
        }
        return "Invalid song";
    }




}