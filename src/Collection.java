/**
 * @author Wesam Saleh
 */

public class Collection {
    private Album[] albums;
    private int numAlbums; // number of albums currently in the collection

    /**
     * Find the album index, or return NOT_FOUND
     * @param album - the album to find
     * @return - the index of the album if found, -1 if not
     */
    private int find(Album album) {
        return 0;
    }

    /**
     * increase the capacity of the array list by 4
     */
    private void grow() {
        return;
    }

    /**
     * Add a new album to the Collection
     * @param album - the album to add
     * @return - true if the album was successfully added, false if not
     */
    public boolean add(Album album) {
        return false;
    }

    /**
     * Remove an album from the Collection
     * @param album - the album to remove
     * @return - true if the album was successfully removed, false if not
     */
    public boolean remove(Album album) {
        return false;
    }

    /**
     * Updates the availability flag to false
     * @param album - the album being lent out
     * @return - true if the album is available and can be lent out, false if not
     */
    public boolean lendingOut(Album album) {
        return false;
    }

    /**
     * Updates the availability flag to true
     * @param album - the album that is being returned
     * @return - true if the album was not available and can be returned, false if not
     */
    public boolean returnAlbum(Album album) {
        return false;
    }

    /**
     * prints the list of albums
     */
    public void print() {
        return;
    }

    /**
     * prints the list of albums sorted by release date
     */
    public void printByReleaseDate() {
        return;
    }

    /**
     * prints the list of albums sorted by Genre
     */
    public void printByGenre() {
        return;
    }
}
