/**
 * The Collection class stores a collection of albums initially with a capacity of 4.
 * Clients of this class can add, remove, lend, and return albums in the collection.
 * Clients may also print the collection sorted (by genre or release date) or unsorted.
 * @author Wesam Saleh
 */

public class Collection {
    private Album[] albums;
    private int numAlbums; // number of albums currently in the collection

    /**
     * Constructor for collection class
     * Initially, albums array has capacity for 10 albums
     */
    public Collection() {
        albums = new Album[10];
        numAlbums = 0;
    }

    /**
     * Find the album index, or return NOT_FOUND
     * @param album - the album to find
     * @return - the index of the album if found, -1 if not
     */
    private int find(Album album) {
        for(int i = 0; i < numAlbums; i++){
            boolean hasSameTitle = albums[i].getTitle().equals(album.getTitle());
            boolean hasSameArtist = albums[i].getArtist().equals(album.getArtist());

            if(hasSameTitle && hasSameArtist){
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

        int i = 0;
        while (i < numAlbums) {
            newAlbumsList[i] = albums[i];
            i++;
        }

        albums = newAlbumsList;
    }

    /**
     * Sorts albums list by release date
     */
    private void sortByReleaseDate() {
        int earliestAlbumIndex;

        for(int i = 0; i < numAlbums - 1; i++){
            earliestAlbumIndex = i;

            for(int j = i+1; j < numAlbums; j++){
                Date currentReleaseDate = albums[j].getReleaseDate();
                Date earliestReleaseDate = albums[earliestAlbumIndex].getReleaseDate();

                if(currentReleaseDate.compareTo(earliestReleaseDate) < 0){
                    earliestAlbumIndex = j;
                }
            }

            Album temp = this.albums[i];
            this.albums[i] = this.albums[earliestAlbumIndex];
            this.albums[earliestAlbumIndex] = temp;
        }
    }

    /**
     * Sorts albums list by genre
     */
    private void sortByGenre(){
        int minimumAlbumIndex;

        for(int i = 0; i < numAlbums - 1; i++){
            minimumAlbumIndex = i;

            for(int j = i+1; j < numAlbums; j++){
                Genre currentAlbumGenre = albums[j].getGenre();
                Genre minimumGenre = albums[minimumAlbumIndex].getGenre();

                if(currentAlbumGenre.compareTo(minimumGenre) < 0){
                    minimumAlbumIndex = j;
                }
            }

            Album temp = this.albums[i];
            this.albums[i] = this.albums[minimumAlbumIndex];
            this.albums[minimumAlbumIndex] = temp;
        }
    }

    /**
     * Add a new album to the Collection
     * @param album - the album to add
     * @return - true if the album was successfully added, false if not
     */
    public boolean add(Album album) {
        boolean isInCollection = this.find(album) != -1;
        if(isInCollection){
            return false;
        }

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

        this.albums = newAlbums;
    }

    /**
     * Remove an album from the Collection
     * @param album - the album to remove
     * @return - true if the album was successfully removed, false if not
     */
    public boolean remove(Album album) {
        for(int i = 0; i < numAlbums; i++) {
            boolean hasSameTitle = albums[i].getTitle().equals(album.getTitle());
            boolean hasSameArtist = albums[i].getArtist().equals(album.getArtist());
            if (hasSameTitle && hasSameArtist) {
                albums[i] = null;
                numAlbums--;
                this.cleanUp();
                return true;
            }
        }

        return false;
    }

    /**
     * Updates the availability flag to false
     * @param album - the album being lent out
     * @return - true if the album is available and can be lent out, false if not
     */
    public boolean lendingOut(Album album) {
        boolean isAvailable = false;
        boolean isInCollection = false;

        for(int i = 0; i < numAlbums; i++) {
            Album alb = this.albums[i];
            boolean hasSameTitle = alb.getTitle().equals(album.getTitle());
            boolean hasSameArtist = alb.getArtist().equals(album.getArtist());
            if (hasSameTitle && hasSameArtist) {
                isInCollection = true;
                isAvailable = alb.getAvailability();
                alb.setAvailability(false);
            }
        }

        if(isInCollection)
            return isAvailable;
        else
            return false;
    }

    /**
     * Updates the availability flag to true
     * @param album - the album that is being returned
     * @return - true if the album was not available and can be returned, false if not
     */
    public boolean returnAlbum(Album album) {
        boolean isNotAvailable = false;
        boolean isInCollection = false;

        for(int i = 0; i < numAlbums; i++) {
            Album alb = this.albums[i];
            boolean hasSameTitle = alb.getTitle().equals(album.getTitle());
            boolean hasSameArtist = alb.getArtist().equals(album.getArtist());
            if (hasSameTitle && hasSameArtist) {
                isInCollection = true;
                isNotAvailable = !alb.getAvailability();
                alb.setAvailability(true);
            }
        }

        if(isInCollection)
            return isNotAvailable;
        else
            return false;
    }

    /**
     * prints the list of albums
     */
    public void print() {
        if(numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }

        System.out.println("*List of albums in the collection.");

        for(int i = 0; i < numAlbums; i++){
            System.out.println(albums[i].toString());
        }

        System.out.println("*End of list");
    }

    /**
     * prints the list of albums sorted by release date
     */
    public void printByReleaseDate() {
        if(numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }

        this.sortByReleaseDate();

        System.out.println("*Album collection by the release dates.");

        for(int i = 0; i < numAlbums; i++){
            System.out.println(albums[i].toString());
        }

        System.out.println("*End of list");
    }

    /**
     * prints the list of albums sorted by Genre
     */
    public void printByGenre() {
        if(numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }

        this.sortByGenre();

        System.out.println("*Album collection by genre.");

        for(int i = 0; i < numAlbums; i++){
            System.out.println(albums[i].toString());
        }

        System.out.println("*End of list");
    }

    /**
     * Checks if the given album is in the collection
     * @param album - the album to check
     * @return true if the album is in the collection, false if not
     */
    public boolean isInCollection(Album album) {
        return this.find(album) != -1;
    }

    /**
     * test bed main
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        Collection myCollection = new Collection();

        Album alb1 = new Album("fake_title_1", "fake_artist_1", Genre.Pop, new Date("01/01/2021"), true);
        Album alb2 = new Album("fake_title_2", "fake_artist_2", Genre.Classical, new Date("06/23/2019"), true);
        Album alb3 = new Album("fake_title_3", "fake_artist_3", Genre.Unknown, new Date("05/07/2020"), true);
        Album alb4 = new Album("fake_title_4", "fake_artist_4", Genre.Unknown, new Date("05/07/2020"), true);

        System.out.print("Test 1: Should grow the collection by 4 => ");
        myCollection.grow();

        if(myCollection.albums.length == 14)
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 2: Should add 3 albums to the collection => ");
        myCollection.add(alb1);
        myCollection.add(alb2);
        myCollection.add(alb3);
        boolean hasThreeAlbums = myCollection.numAlbums == 3;
        boolean hasAllThreeCorrectAlbums = myCollection.albums[0].equals(alb1) && myCollection.albums[1].equals(alb2) &&
                myCollection.albums[2].equals(alb3);
        if(hasThreeAlbums && hasAllThreeCorrectAlbums)
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 3: Should find an album in the collection => ");

        if(myCollection.find(alb2) == 1)
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 4: Should lend out an album in the collection => ");
        myCollection.lendingOut(alb2);

        if(!myCollection.albums[1].getAvailability())
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 5: Should return an album to the collection => ");
        myCollection.returnAlbum(alb2);

        if(myCollection.albums[1].getAvailability())
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 6: Should remove an album from the collection => ");
        myCollection.remove(alb2);

        boolean hasTwoAlbums = myCollection.numAlbums == 2;
        boolean hasBothCorrectAlbums = myCollection.albums[0] == alb1 && myCollection.albums[1] == alb3;

        if(hasTwoAlbums && hasBothCorrectAlbums)
            System.out.println("passed");
        else
            System.out.println("failed");

        myCollection.remove(alb3);
        myCollection.add(alb2);
        myCollection.add(alb3);

        System.out.print("Test 7: Should sort the collection by genre => ");
        myCollection.sortByGenre();
        boolean albumsSortedByGenre = myCollection.albums[0] == alb2 && myCollection.albums[1] == alb1 &&
                myCollection.albums[2] == alb3;

        if(albumsSortedByGenre)
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 8: Should sort the collection by release date => ");
        myCollection.sortByReleaseDate();
        boolean albumsSortedByReleaseDate = myCollection.albums[0] == alb2 && myCollection.albums[1] == alb3 &&
                myCollection.albums[2] == alb1;

        if(albumsSortedByReleaseDate)
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 9: Should not add an album that is already in the collection => ");

        if(!myCollection.add(alb2))
            System.out.println("passed");
        else
            System.out.println("failed");

        System.out.print("Test 10: Should not remove an album that is not in the collection => ");

        if(!myCollection.remove(alb4))
            System.out.println("passed");
        else
            System.out.println("failed");
    }
}
