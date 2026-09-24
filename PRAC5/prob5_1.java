
class Node {
    String song;
    Node prev;
    Node next;

    Node(String song) {
        this.song = song;
        this.prev = null;
        this.next = null;
    }
}

class Playlist {
    Node head;
    Node tail;

    // Add song at the beginning
    void addFirst(String song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        display();
    }

    // Add song at the end
    void addLast(String song) {
        Node newNode = new Node(song);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        display();
    }

    // Insert song after a specific song
    void insertAfter(String existingSong, String newSong) {
        Node temp = head;

        // Search for the existing song
        while (temp != null && !temp.song.equals(existingSong)) {
            temp = temp.next;
        }

        // Song not found
        if (temp == null) {
            System.out.println("Song " + existingSong + " not found.");
            display();
            return;
        }

        Node newNode = new Node(newSong);

        // Insert after the found node
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;

        display();
    }

    // Remove the first song
    void removeFirst() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("Removed: " + head.song);

        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        display();
    }

    // Count songs
    void countSongs() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total songs: " + count);
    }

    // Display playlist from first to last
    void display() {
        Node temp = head;

        System.out.print("Playlist: ");

        while (temp != null) {
            System.out.print(temp.song + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

public class prob5_1 {
    public static void main(String[] args) {

        Playlist p = new Playlist();

        // Add songs at the end
        p.addLast("Song A");
        p.addLast("Song B");

        // Add song at beginning
        p.addFirst("Song C");

        // Insert after a specific song
        p.insertAfter("Song A", "Song D");

        // Count songs
        p.countSongs();

        // Remove first song
        p.removeFirst();

        // Insert after a song
        p.insertAfter("Song B", "Song E");

        // Try inserting after a song that does not exist
        p.insertAfter("Song X", "Song F");

        // Final count
        p.countSongs();
    }
}