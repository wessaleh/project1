/**
 * @author Wesam Saleh
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {
    StringTokenizer st;
    Collection albumCollection;

    /**
     * Constructor for Collection Manager
     */
    public CollectionManager(){
        albumCollection = new Collection();
    }

    /**
     * Runs a while loop to allow user to keep entering commands
     */
    public void run() {
        System.out.println("Collection Manager starts running.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while(!input.equals("Q")){
            executeCommand(input);
            input = scanner.nextLine();
        }

        System.out.println("Collection Manager terminated.");
    }

    /**
     * Parses the command from the input and executes the given command
     * @param input - the input from the user
     */
    private void executeCommand(String input) {
        st = new StringTokenizer(input, ",");

        String command  = st.nextToken();
        switch(command) {
            case "A" :
                addAlbumToCollection(st);
                break;
            case "D" :
                deleteAlbumFromCollection(st);
                break;
            case "L" :
                lendAlbum(st);
                break;
            case "R" :
                returnAlbum(st);
                break;
            case "P" :
                printCollection(st);
                break;
            case "PD" :
                printCollectionByDate(st);
                break;
            case "PG" :
                printCollectionByGenre(st);
                break;
            default : System.out.println("Invalid command!");
        }
    }

    /**
     * Adds an album to the collection
     * @param st - the rest of the string tokens
     */
    private void addAlbumToCollection(StringTokenizer st) {
        String title = st.nextToken();
        String artist = st.nextToken();
        Genre genre;
        switch(st.nextToken()){
            case "classical" :
                genre = Genre.Classical;
                break;
            case "country" :
                genre = Genre.Country;
                break;
            case "jazz" :
                genre = Genre.Jazz;
                break;
            case "pop" :
                genre = Genre.Pop;
                break;
            default : genre = Genre.Unknown;
        }
        Date releaseDate = new Date(st.nextToken());

        if(releaseDate.isValid()) {
            Album albumToAdd = new Album(title, artist, genre, releaseDate, true);
            boolean added = albumCollection.add(albumToAdd);

            if(added)
                System.out.println(albumToAdd.toString() + " >> added.");
            else
                System.out.println(albumToAdd.toString() + " >> is already in the collection.");

        }else{
            System.out.println("Invalid Date!");
        }
    }

    /**
     * Deletes an album from the collection
     * @param st - the rest of the tokens
     */
    private void deleteAlbumFromCollection(StringTokenizer st) {
        String title = st.nextToken();
        String artist = st.nextToken();

        Album albumToRemove = new Album(title, artist, Genre.Unknown, new Date(), true);

        if(!albumCollection.isInCollection(albumToRemove)) {
            System.out.println(title + "::" + artist + " >> is not in the collection.");
            return;
        }

        boolean removed = albumCollection.remove(albumToRemove);

        if(removed)
            System.out.println(title + "::" + artist + " >> deleted.");
        else
            System.out.println(title + "::" + artist + " >> return cannot be completed.");
    }

    /**
     * Lends out an album from the collection
     * @param st - the rest of the tokens
     */
    private void lendAlbum(StringTokenizer st) {
        String title = st.nextToken();
        String artist = st.nextToken();

        Album albumToLend = new Album(title, artist, Genre.Unknown, new Date(), true);

        boolean lentOut = this.albumCollection.lendingOut(albumToLend);

        if(lentOut)
            System.out.println(title + "::" + artist + " >> lending out and set to not available.");
        else
            System.out.println(title + "::" + artist + " >> is not available.");
    }

    /**
     * Returns album to the collection
     * @param st - the rest of the tokens
     */
    private void returnAlbum(StringTokenizer st) {
        String title = st.nextToken();
        String artist = st.nextToken();

        Album albumToReturn = new Album(title, artist, Genre.Unknown, new Date(), true);

        boolean returned = this.albumCollection.returnAlbum(albumToReturn);

        if(returned)
            System.out.println(title + "::" + artist + " >> returning and set to available.");
        else
            System.out.println(title + "::" + artist + " >> return cannot be completed.");
    }

    private void printCollection(StringTokenizer st){
        this.albumCollection.print();
    }

    private void printCollectionByDate(StringTokenizer st){
        this.albumCollection.printByReleaseDate();
    }

    private void printCollectionByGenre(StringTokenizer st){
        this.albumCollection.printByGenre();
    }
}
