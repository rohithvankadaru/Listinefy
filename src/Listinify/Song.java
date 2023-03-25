package Listinify;

public class Song {
    public String title;
    public double duration;

    Song(String title, double duration){
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
