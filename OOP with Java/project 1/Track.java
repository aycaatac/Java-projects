/**
 * This program stores a number of active or inactive tracks and their IDs,
 * titles, album and artis IDs, lengths, genres, play counts
 * and release dates
 * Author @ Ayca Candan Atac
 */

public class Track {
    // static variables
    private static int count = 0;
    private static int allCount = 0;

    // instant variables
    private int ID;
    private String title;
    private int album;
    private int artist;
    private String releaseDate;
    private int duration;
    private String genre = "Unspecified";
    private boolean isActive = true;
    private int playCount = 0;
    private String durationStr;
    

    // setter for genre
    public void setGenre(String genre) {

        if (genre.equals("PO") || genre.equals("RO")
                || genre.equals("JA") || genre.equals("OT")) {
            if (genre.equals("PO")) {
                this.genre = "Popular";
            }
            if (genre.equals("RO")) {
                this.genre = "Rock";
            }
            if (genre.equals("JA")) {
                this.genre = "Jazz";
            }
            if (genre.equals("OT")) {
                this.genre = "Other";
            }
        } else {
            this.genre = "Unspecified";
        }
    }

    // getters
    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getAlbum() {
        return album;
    }

    public int getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getDurationStr() {
        return durationStr;
    }

    public int getCount() {
        return count;
    }

    public int getAllCount() {
        return allCount;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getPlayCount() {
        return playCount;
    }

    // setting the constructor
    public Track(String title, int album, int artist, String releaseDate, int duration) {
        Track.register();
        if (album >= 0 && artist > 0) {
            this.title = title;
            this.album = album;
            this.artist = artist;
            this.releaseDate = releaseDate;
            this.duration = duration;
            durationStr = Integer.toString(duration);
            int minutes = (duration / 60);
            int seconds = duration - minutes * 60;
            durationStr = minutes + " min and " + seconds + " sec";
            ID = allCount;
        }
    }

    // register, unregister and isActive methods
    public static void register() {
        count++;
        allCount++;
    }

    public void unregister() {
        count--;
        this.isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    /**
     * This methods takes a date as a string and inverts it
     * 
     * @param str - date
     * @return inverted date
     */
    public String invertString(String str) {
        String year = str.substring(6);
        String month = str.substring(3, 5);
        String day = str.substring(0, 2);

        return year + "/" + month + "/" + day;
    }

    /**
     * This method checks if a date is before another date
     * 
     * @param track1
     * @return boolean
     */
    public boolean isBefore(Track track1) {
        boolean isBefore = false;
        String str1 = track1.getReleaseDate();
        String str2 = this.getReleaseDate();
        String date1 = invertString(str1);
        String date2 = invertString(str2);
        if (date1.compareTo(date2) > 0) {
            isBefore = true;
        }
        return isBefore;
    }

    // play methods
    public void play() {
        if (this.isActive == true) {

            this.playCount++;
        }
    }

    public void playBatch(int countToIncrement) {
        this.playCount += countToIncrement;
    }

    /**
     * This method returns the information about the track
     */
    public String toString() {
        if (isActive == true) {
            return "*************************************\n" + "Active track " + this.ID + " among " + count
                    + " active tracks\n"
                    + "Title:   " + this.title + "\n"
                    + ("Album:   " + this.album + "\n")
                    + ("Release: " + this.releaseDate + "\n")
                    + ("Length:  " + this.durationStr + "\n")
                    + ("Genre:   " + this.genre + "\n")
                    + ("Played:  " + getPlayCount() + "\n")
                    + ("*************************************\n");
        } else {
            return ("play() called on inactive track!\n") +
                    ("*************************************\n") +
                    ("Inactive track " + this.ID + " among " + allCount + " tracks\n")
                    + "Title:   " + this.title + "\n"
                    + ("Album:   " + this.album + "\n")
                    + ("Release: " + this.releaseDate + "\n")
                    + ("Length:  " + this.durationStr + "\n")
                    + ("Genre:   " + this.genre + "\n")
                    + ("Played:  " + getPlayCount() + "\n")
                    + ("*************************************\n");
        }

    }

    public static void main(String[] args) {
        Track t1 = new Track("Love over gold", 123, 234, "12/08/1982", (short) 2473);
        t1.setGenre("RO");
        Track t2 = new Track("Gozleri aska gulen", 0, 98, "18/04/2018", (short) 257);
        t2.setGenre("PO");
        Track t3 = new Track("Down to the waterline", 123, 234, "09/06/1978", (short) 235);
        System.out.println("Is t1 before t2? " + t1.isBefore(t2));
        System.out.println("Is t2 before t3? " + t2.isBefore(t3));
        t1.play();
        t3.play();
        t3.play();
        t1.playBatch(100);
        t3.playBatch(10);
        t1.play();
        t2.playBatch(50);
        t1.unregister();
        t1.play();
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
    

    }
}
