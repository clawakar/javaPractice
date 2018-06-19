package com.chetan.javaPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListDemoSongsPlayListUsingInnerClassConcept {
    static Scanner scanner = new Scanner(System.in);
    static Album2 album2 = new Album2("SAD SONG");
    static PlayList2 playList = new PlayList2();


    public  static void main(String[] args) {
        boolean quit = false;
        menu();
        while (!quit) {
            System.out.println("Enter Your choice for Action");
            scanner.useDelimiter("\n");
            try {
            int action = scanner.nextInt();
            switch(action) {

                    case 0:
                        quit = true;
                        break;

                    case 1:
                        System.out.println("Enter Song Title");
                        String songTitle = scanner.next();
                        System.out.println("Enter Song Duration");
                        double songDuration = scanner.nextDouble();
                        album2.addSongInAlbum(songTitle, songDuration);
                        break;

                    case 2:
                        album2.displaySongListInAlbum();
                        System.out.println("Enter Song number which you want to add to playList");
                        int songNumber = scanner.nextInt();
                        if (songNumber > album2.getAlbumSongList().size() || songNumber < 1) {
                            System.out.println("Please enter valid number");
                        } else {
                            playList.addSongInPlayList(album2.getAlbumSongList().get(songNumber - 1));
                        }
                        break;

                    case 3:
                        playList.displaySongListInPlayList();
                        System.out.println("Enter Song number which you want to play from playList");
                        int playSongNumber = scanner.nextInt();
                        playList.playSong(playSongNumber);
                        break;

                    case 4:
                        playList.playNextSong();
                        break;

                    case 5:
                        playList.playPreviousSong();
                        break;

                    case 6:
                        playList.replySong();
                        break;

                    case 7:
                        playList.displaySongListInPlayList();
                        break;

                    case 8:
                        menu();
                        break;

                    default:
                        System.out.println("Please enter valid choice");
                        menu();

            }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Please enter correct input");
                scanner.nextLine();
                continue;
            }

        }

    }

    public static void menu() {
        System.out.println("======== Option Vailable =======");
        System.out.println("0 : quit \n" +
                "1 : add song in album \n" +
                "2 : add song play List \n" +
                "3 : play song \n" +
                "4 : play next song \n" +
                "5 : play previous song \n" +
                "6 : reply song \n" +
                "7 : display songs in playlist \n" +
                "8 : menu \n");
    }
}

class PlayList2 {
    LinkedList<Song2> playList = new LinkedList<Song2>();
    static int currentSongIndex = 0;

    public boolean addSongInPlayList(Song2 song2){
        if(!playList.contains(song2)) {
            playList.add(song2);
            System.out.println("Song2 " + song2.getSongTitle() +" added successfuly in PlayList");
            return true;
        } else {
            System.out.println("Song is already Exist in PlayList");
            return false;
        }
    }

    public void displaySongListInPlayList() {
        for(int i = 0; i < playList.size(); i++) {
            Song2 song2 = playList.get(i);
            System.out.println("[ " + (i + 1) + " ] SongTitle : " + song2.getSongTitle()
                    + " \t duration :" + song2.getSongDutationInMinit());
        }
    }

    public void playSong(int songIndex) {
        if(songIndex <= playList.size() || songIndex < 1) {
            currentSongIndex = songIndex - 1;
            System.out.println("Playing Song : " + playList.get(currentSongIndex));
        } else {
            System.out.println("Please Enter Valid Song Number");
        }
    }

    public void playNextSong() {
        if((currentSongIndex + 1) < playList.size()) {
            currentSongIndex++;
            System.out.println("Playing Song : " + playList.get(currentSongIndex).getSongTitle());
        } else {
            System.out.println("Already playing last song of the playlist. There is no next song after this song in Playlist.");
        }
    }

    public void playPreviousSong() {
        if((currentSongIndex - 1) >= 0) {
            currentSongIndex--;
            System.out.println("Playing Song : " + playList.get(currentSongIndex).getSongTitle());
        } else {
            System.out.println("Playing 1st song of the playlist. There is no previous song for current plying song in playlist");
        }
    }

    public void replySong() {
        System.out.println("Replaying Song : " + playList.get(currentSongIndex));
    }


}

class Song2 {

    private String songTitle = new String();
    private double songDutationInMinit;


    public Song2(String songTitle, double songDutationInMinit) {
        this.songTitle = songTitle;
        this.songDutationInMinit = songDutationInMinit;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public double getSongDutationInMinit() {
        return songDutationInMinit;
    }

    @Override
    public String toString() {
        return (" Song Title : " + this.songTitle +
        "\tDuration :" + this.songDutationInMinit + " min \n");
    }
}

class Album2 {
    private String albumName = new String();
    private SongList songList;

    public Album2(String albumName) {
        this.albumName = albumName;
        songList = new SongList();
    }

    private class SongList {
        private ArrayList<Song2> song2ArrayList;

        public SongList() {
            this.song2ArrayList = new ArrayList<Song2>();
        }

        private boolean findSongInAlbum(String songTitle) {
            for(Song2 song2 : song2ArrayList) {
                if(song2.getSongTitle().equalsIgnoreCase(songTitle)) {
                    return true;
                }
            }
            return false;
        }

        public boolean addSongInAlbum(String songTitle, double songDuration){
            if(!findSongInAlbum(songTitle)) {
                song2ArrayList.add(new Song2(songTitle,songDuration));
                System.out.println("Song " + songTitle +" added successfuly in Album");
                return true;
            } else {
                System.out.println("Song is already Exist in Album");
                return false;
            }
        }
    }

    public boolean addSongInAlbum(String songTitle, double songDuration){
        return this.songList.addSongInAlbum(songTitle,songDuration);
    }

    public ArrayList<Song2> getAlbumSongList(){
        return this.songList.song2ArrayList;
    }

    public void displaySongListInAlbum() {
        for(int i = 0; i < this.songList.song2ArrayList.size(); i++) {
            Song2 song2 = this.songList.song2ArrayList.get(i);
            System.out.println("[ " + (i + 1) + " ] Song Title : " + song2.getSongTitle()
                    + " \t Duration :" + song2.getSongDutationInMinit() + " min");
        }
    }
}