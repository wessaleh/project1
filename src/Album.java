/**
 * @author Wesam Saleh
 */

public class Album {
    private String title;
    private String artist;
    private Genre genre; // enums
    private Date releaseDate;
    private boolean isAvailable;

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

    @Override
    /**
     * checks if this album is equal to the object passed in
     * @param obj - the album to check against
     */
    public boolean equals(Object obj){
        return false;
    }

    @Override
    /**
     * returns the Album in string form
     */
    public String toString(){
        return null;
    }

    /**
     * test bed main
     * @param args - command line arguments
     */
    public static void main(String[] args) {

    }
}
