package Listinify;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Hindi", "Arjit Singh");

        album.addSongtoAlbum("Tum hi ho", 3.9);
        album.addSongtoAlbum("kesariya", 3.2);
        album.addSongtoAlbum("Naina", 4.5);

        albums.add(album);

        album = new Album("Latest", "Prateek kuhad");

        album.addSongtoAlbum("Baarish", 3.6);
        album.addSongtoAlbum("Tum mile", 4.2);
        album.addSongtoAlbum("Kasoor", 2.5);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addSongtoPlaylist("kesariya", playList_1);
        albums.get(0).addSongtoPlaylist("Naina", playList_1);
        albums.get(1).addSongtoPlaylist("Tum mile", playList_1);
        albums.get(1).addSongtoPlaylist("Kasoor", playList_1);

        play(playList_1);

    }

        public static void play(LinkedList<Song> playList){

            ListIterator<Song> li = playList.listIterator();

            if(playList.size() == 0) return;

            Scanner sc = new Scanner(System.in);

            printMenu();

            System.out.println("Now Playing "+li.next());

            boolean forward = true;
            boolean quit = false;

            while(!quit){
                int choice = sc.nextInt();

                switch (choice){
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        if(!forward){
                            forward = true;
                            li.next();
                        }
                        if(li.hasNext()){
                            System.out.println(li.next().toString());
                        }
                        else{
                            System.out.println("You are at the last song");
                        }
                        break;

                    case 2:
                        if(forward){
                            forward = false;
                            li.previous();
                        }
                        if(li.hasPrevious()){
                            System.out.println(li.previous().toString());
                        }
                        else{
                            System.out.println("You are already on first song");
                        }
                        break;
                    case 3:
                        if(forward){
                            forward = false;
                            System.out.println(li.previous().toString());
                        }
                        else{
                            forward = true;
                            System.out.println(li.next().toString());
                        }
                        break;
                    case 4:
                        printAllSongs(playList);
                        break;
                    case 5:
                        printMenu();
                        break;
                    case 6:
                        if (playList.size() > 0)
                        {
                            System.out.println(li.previous().toString() + " has been removed from the playlist.");
                            li.remove();
                            if (playList.size()>0 && li.hasPrevious())
                            {
                                System.out.println("Now playing " + li.next().toString());
                            }
                            else if (playList.size()>0 && li.hasNext())
                            {
                                System.out.println("Now playing " + li.previous().toString());
                            }
                        } else
                        {
                            System.out.println("The playlist is already empty.");
                        }
                        break;
                }
            }
        }

        private static void printAllSongs(LinkedList<Song> songs){
           for(Song song : songs){
               System.out.println(song.title);
           }
        }

        private static void printMenu(){
            System.out.println("Available options\n press");
            System.out.println("0 - to quit\n"+
                    "1 - to play next song\n"+
                    "2 - to play previous song\n"+
                    "3 - to replay the current song\n"+
                    "4 - list of all songs\n"+
                    "5 - print all available options\n"+
                    "6 - delete current song");
        }
}