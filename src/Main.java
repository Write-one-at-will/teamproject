import java.nio.file.WatchEvent;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Method method;
    protected Scanner input = new Scanner(System.in);
    /////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Main main = new Main();
        main.setup();
        main.runMenu();

    }

    private void findASong(){
        input.nextLine();
        System.out.println("Which song you want to find:");
        String songName = input.nextLine();
        List<Song> result = method.fuzzySearch(method.songs, songName);
        System.out.println(result);
        ;
    }
    protected int mainMenu(){
        System.out.print("""
               Music Box Menu
               ---------
                  1) Add a Song
                  2) Find a Song
                  3) Delete a Song
                  4) Edit a Song
                  5) List All Songs in the Music Box
                  6) My List
                  0) Exit
               ==>>""");
        int option = input.nextInt();
        return option;
    }
    protected void runMenu(){
        int option = mainMenu();
        while(option != 0) {
            switch (option) {
                case 1 -> {if (isJudge()) addASong();}
                case 2 -> {if (isJudge()) findASong();}
                case 3 -> {if (isJudge()) Method.Delete();}
                case 4 -> {if (isJudge()) Method.Edit();}
                case 5 -> {if (isJudge()) printAllSongs();}
                case 6 -> {if (isJudge()) Method.myList();}

                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("\nPress enter key to continue...");

            input.nextLine();
            option = mainMenu();
        }
        System.out.println("Closing Your Music Box...");
        System.out.println("... ... ...");
        System.out.println("bye..bye..");
        System.exit(0);
    }

    private void printAllSongs() {
        System.out.println("List of Songs are:");
        System.out.println(Method.listSongs());
    }
    private void addASong(){
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.

        System.out.print("Enter the SongName:  ");
        String name = input.nextLine();
        System.out.print("Enter the SingerName:  ");
        String singerName = input.nextLine();
        System.out.println("Enter the region of the song");
        String region = input.nextLine();
        System.out.println("Enter the kind of the song");
        System.out.println("""
------------------------------------
Note: You can only select from the following kinds:
Pop , Rock , Folk , Electronic , Jazz , CountryMusic ,RB
Absolute ,Music , Rap ,Metal , WorldMusic , AmericaSoft
                """);
        Kind kind = Kind.valueOf(input.nextLine());

        Song temp = new Song(name, singerName , region , kind);
        boolean isAdded = method.add(temp);
        if (isAdded){
            System.out.println("Song Added Successfully");
        }
        else{
            System.out.println("No Song Added");
        }
    }
    private boolean isJudge() {
        System.out.println("""
                  ---------
                1) Confirm
                2) Cancel
                  """);
        int option = input.nextInt();
        boolean toJudge = false;
        switch (option) {
            case 1 -> toJudge = true;

            case 2 -> toJudge = false;
            default -> mainMenu();
        }
        return toJudge;
    }
    private void setup(){
        System.out.print("How many songs would you like to have in your Music Box?  ");
        int numberSongs = input.nextInt();
        if(isJudge()){
            method = new Method(numberSongs);
        }
        else setup();

    }
}
