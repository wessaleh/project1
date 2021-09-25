/**
 * @author Wesam Saleh
 */

public class Album {
    private String title;
    private String artist;
    private Genre genre; // enums
    private Date releaseDate;
    private boolean isAvailable;

    // let's add isAvailable as a parameter here
    public Album(String title, String artist, Genre genre, Date releaseDate){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = true;
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

    @Override
    public boolean equals(Object obj){
        // cast obj to album

        // Do not use the getters I created, check each instance field
        if ((this.artist.equals(obj.getArtist)) && this.title.equals(obj.getTitle)){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        // this should be a one liner. Don't use getters.
        if (this.getAvailability()){
            String stringToReturn = "" + this.getTitle() + "::" + this.getArtist() + "::" + this.getGenre() + "::" + this.getReleaseDate() + "::is available" ;
        }
        else{
            String stringToReturn = "" + this.getTitle() + "::" + this.getArtist() + "::" + this.getGenre() + "::" + this.getReleaseDate() + "::is not available" ;
        }
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

        System.out.println("Test 3: Should determine an album and a non-album to be unequal => ");
        String non_alb = "fake_object";

        if(!alb1.equals(alb2))
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 4: Should return a string representation of album => ");
        String albumString = alb1.toString();

        boolean isCorrect = albumString.equals("fake_title_2::fake_artist::" + Genre.Pop + "::" + (new Date()).toString() + ":: + true");

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

        if(alb1.getTitle() == "fake_title_2")
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 10: Should get artist correctly => ");

        if(alb1.getArtist() == "fake_artist")
            System.out.println("passed");
        else
            System.out.println("failed");
    }
}
