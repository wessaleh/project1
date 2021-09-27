package collection;

/**
 * This class stores all information for albums.
 * @author Wesam Saleh
 */

public class Album {
    private final String title;
    private final String artist;
    private final Genre genre; // enums
    private final Date releaseDate;
    private boolean isAvailable;

    /**
     * Constructor for Album class
     * @param title - the title of the album
     * @param artist - the artist
     * @param genre - the genre
     * @param releaseDate - the release date
     * @param isAvailable - the availability of the album
     */
    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
    }

    /**
     * Getter for isAvailable
     * @return the availability of this album
     */
    public boolean getAvailability() {
        return isAvailable;
    }

    /**
     * Setter for isAvailable
     * @param available - the value to set
     */
    public void setAvailability(boolean available) {
        isAvailable = available;
    }

    /**
     * Getter for release date
     * @return release date
     */
    public Date getReleaseDate(){
        return releaseDate;
    }

    /**
     * Getter for genre
     * @return genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Getter for title
     * @return - title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for artist
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Checks if the given object is equal to this album
     * @param obj - the album to check
     * @return true if the two albums are equal, false if not
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;

        Album objToAlbum = (Album) obj;

        boolean hasSameArtist = this.artist.equals(objToAlbum.artist);
        boolean hasSameTitle = this.title.equals(objToAlbum.title);
        return hasSameArtist && hasSameTitle;
    }

    /**
     * Converts the album to string form
     * @return the string representation of the album
     */
    @Override
    public String toString(){
        String stringToReturn;

        if (this.isAvailable)
            stringToReturn = "" + this.title + "::" + this.artist + "::" + this.genre + "::" + this.releaseDate + "::is available";
        else
            stringToReturn = "" + this.title + "::" + this.artist + "::" + this.genre + "::" + this.releaseDate + "::is not available";

        return stringToReturn;
    }

    /**
     * test bed main
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        Album alb1 = new Album("fake_title", "fake_artist", Genre.Pop, new Date(), true);
        Album alb2 = new Album("fake_title", "fake_artist", Genre.Pop, new Date(), true);

        System.out.print("Test 1: Should determine two albums to be equal => ");

        if(alb1.equals(alb2))
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 2: Should determine two albums to be unequal => ");
        alb1 = new Album("fake_title_2", "fake_artist", Genre.Pop, new Date(), true);

        if(!alb1.equals(alb2))
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 3: Should determine an album and a non-album to be unequal => ");

        if(!alb1.equals(alb2))
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 4: Should return a string representation of album => ");
        String albumString = alb1.toString();

        boolean isCorrect = albumString.equals("fake_title_2::fake_artist::" + Genre.Pop + "::" + (new Date()) + "::is available");

        if(isCorrect)
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 5: Should get album availability correctly => ");
        if(alb1.getAvailability())
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 6: Should set album availability correctly => ");
        alb1.setAvailability(false);
        if(!alb1.getAvailability())
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 7: Should get release date correctly => ");

        if(alb1.getReleaseDate().compareTo(new Date()) == 0)
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 8: Should get genre correctly => ");

        if(alb1.getGenre() == Genre.Pop)
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 9: Should get title correctly => ");

        if(alb1.getTitle().equals("fake_title_2"))
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 10: Should get artist correctly => ");

        if(alb1.getArtist().equals("fake_artist"))
            System.out.println("passed");
        else
            System.out.println("failed");
    }
}
