/**
 * @author Wesam Saleh
 */

public class Album {
    private String title;
    private String artist;
    private Genre genre; // enums
    private Date releaseDate;
    private boolean isAvailable;


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
}
