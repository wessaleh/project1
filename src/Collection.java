/**
 * @author Wesam Saleh
 */

public class Collection {
    private Album[] albums;
    private int numAlbums; // number of albums currently in the collection

    /**
     * Constructor for collection class
     * Initially, albums array has capacity for 10 albums
     */
    public Collection(){
        albums = new Album[10];
        numAlbums = 0;
    }

    /**
     * Find the album index, or return NOT_FOUND
     * @param album - the album to find
     * @return - the index of the album if found, -1 if not
     */
    private int find(Album album) {
        for(int i = 0; i < albums.length; i++){
            if(albums[i].equals(album)){
                return i;
            }
        }

        return -1;
    }

    /**
     * increase the capacity of the array list by 4
     */
    private void grow() {
        Album[] newAlbumsList = new Album[albums.length + 4];

        for(int i = 0; i < albums.length; i++){
            newAlbumsList[i] = albums[i];
        }

        albums = newAlbumsList;
    }

    /**
     * Add a new album to the Collection
     * @param album - the album to add
     * @return - true if the album was successfully added, false if not
     */
    public boolean add(Album album) {
        boolean notEnoughSpace = !(numAlbums < albums.length);
        if(notEnoughSpace){
            this.grow();
        }

        albums[numAlbums] = album;
        numAlbums++;
        return true;
    }

    /**
     * Cleans up the collection of albums
     * Removes any empty spaces between albums
     */
    private void cleanUp(){
        Album[] newAlbums = new Album[albums.length];

        int newAlbumsIndex = 0;
        for(Album currentAlbum: albums){
            if(currentAlbum == null)
                continue;

            newAlbums[newAlbumsIndex] = currentAlbum;
            newAlbumsIndex++;
        }
    }

    /**
     * Remove an album from the Collection
     * @param album - the album to remove
     * @return - true if the album was successfully removed, false if not
     */
    public boolean remove(Album album) {
        int albumIndex = this.find(album);

        if(albumIndex == -1){
            return false; // album is not in the collection
        }

        albums[albumIndex] = null;
        numAlbums--;
        this.cleanUp();

        return true;
    }

    /**
     * Updates the availability flag to false
     * @param album - the album being lent out
     * @return - true if the album is available and can be lent out, false if not
     */
    public boolean lendingOut(Album album) {
        album.setAvailability(false); // availability should be set to false anyway
        boolean isAvailable = album.getAvailability();

        if(isAvailable){
            return true; // can be lent out
        }else{
            return false; // can not be lent out
        }
    }

    /**
     * Updates the availability flag to true
     * @param album - the album that is being returned
     * @return - true if the album was not available and can be returned, false if not
     */
    public boolean returnAlbum(Album album) {
        album.setAvailability(true); // availability should be set to true anyway
        boolean isAvailable = album.getAvailability();

        if(isAvailable){
            return false; // already returned
        }else{
            return true; // can be returned
        }
    }

    /**
     * prints the list of albums
     */
    public void print() {
        System.out.print("Collection: [ ");

        for(int i = 0; i < numAlbums; i++){
            System.out.print(albums[i]);
            int lastAlbumIndex = numAlbums - 1;
            boolean isLastAlbum = i == lastAlbumIndex;

            if(!isLastAlbum){
                System.out.print(" , ");
            }
        }

        System.out.println(" ]");
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
