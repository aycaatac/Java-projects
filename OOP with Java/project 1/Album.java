public class Album {
    private int ID = 0;
    private String name;
    private String company = "Undefined";
    private int noOfTracks = 0;

    public Album(String name)
    {
        this.name = name;
        this.ID++;
    }

    public void addTrack(TrackWed newTrackWed)
    {
        newTrackWed.setAlbum(this); 
        newTrackWed.setMyAlbumID(this.ID);
        noOfTracks++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getNoOfTracks() {
        return noOfTracks;
    }

    public void setNoOfTracks(int noOfTracks) {
        this.noOfTracks = noOfTracks;
    }

    public String toString()
    {
        return "*************************************\n" + "Album with " + this.getNoOfTracks() + " tracks\n" + "Name: " + this.getName() +
         "\n" + "Released by: " + this.getCompany() + "\n" + "************************************* \n"; 

    }

    
    
}
