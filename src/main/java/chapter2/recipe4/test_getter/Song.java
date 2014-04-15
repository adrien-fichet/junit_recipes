package chapter2.recipe4.test_getter;

public class Song {
    private String name;
    private String artistName;
    private int duration;

    public Song(String name, String artistName, int duration) {
        this.name = name;
        this.artistName = artistName;
        this.duration = duration;
    }

    public double getDurationInMinutes() {
        return (double) duration / 60.d;
    }
}
