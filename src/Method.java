import java.util.ArrayList;
import java.util.Scanner;


public class Method {

    private static final Main main = new Main();
    static Song[] songs;
    static int total = 0;
    public Song find(String name) {
        Song foundSong = null;
        if (!isEmpty()) {
            for (int i = 0; i < total; i++) {
                if (songs[i].getName().equals(name)) foundSong = songs[i];
            }
        } else return null;
        return foundSong;
    }
    public Method(int numberItems){
        songs=new Song[numberItems];
    }
    public boolean add(Song aSong){
        if (isFull()){
            return false;
        }else{
            songs[total]=aSong;
            total++;
            return true;
        }
    }
    public void Classification() {
        int t = 0;
        int x = 0;
        int r = 0;
        Song s1 = new Song();
        if (s1.getKind().equals("popular")) {
            t++;
        } else if (s1.getKind().equals("blues")) {
            x++;
        } else {
            r++;
        }
        System.out.println(t);
        System.out.println(x);
        System.out.println(r);
    }
    public void deleteSongs(Song[] songs){
        this.songs = songs;
    }
    public static void Delete(){
        System.out.println("Please choose the song you want to delete");
        while (true) {
            String name = main.input.next();
            int index = -1;
            for (int i = 0; i < Method.songs.length; i++) {
                Song s = songs[i];
                if ( s!=null && s.getName().equals(name)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("歌曲不存在");
            } else {
                songs[index] = null;
                System.out.println("删除成功");
                break;
            }
        }

    }
    public static String listSongs() {
        if (isEmpty()) {
            return "No songs in the list";
        } else {
            String listOfSongs = "";
            for (int i = 0; i < total; i++) {
                listOfSongs += i + ": " + songs[i] + "\n";
            }
            return listOfSongs;
        }
    }
    public static void Edit() {
        System.out.println("please choose the song you want to edit");
        while (true) {
            String name = main.input.next();
            int index = -1;
            for (int i = 0; i < Method.songs.length; i++) {
                Song s = Method.songs[i];
                if (s != null && s.getName().equals(name)) {
                    index = i;
                    break;
                }
            }
                if (index == -1) {
                    System.out.println("the song does not exit");
                }
                else {
                    Song a =Method.songs[index];
                    System.out.println("please input the song's name");
                    String changeName = main.input.next();
                    System.out.println("please input the kind of the song");
                    String kind = main.input.next();
                    System.out.println("please input the singer's name");
                    String changeSingerName = main.input.next();

                    a.setKind(kind);
                    a.setName(changeName);
                    a.setSingerName(changeSingerName);
                    System.out.println("edit successfully");
                    break;


                }
            }
        }




    private boolean isFull() {
        return total == songs.length;
    }

    private static boolean isEmpty() {
        return total == 0;
    }
    private static int mainMenu1(){
        System.out.println("""
                Mylist Menu
               ---------
               1) Creat my list
               2) List my list
               3) Clear my list
               4) Back
               0) Compulsory Withdrawal
                """);
        int option = main.input.nextInt();
        return option;


    }

    public static void myList() {
        Scanner input = new Scanner(System.in);
        int option = mainMenu1();
        while (option != 0) {
            switch (option) {
                case 1 -> creatMyList();
                case 2 -> creatMyList().listIterator();
                case 3 -> creatMyList().clear();
                case 4 -> {
                    main.mainMenu();
                    main.runMenu();
                }
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("\nPress enter key to continue...");
            input.nextLine();

            input.nextLine();
            option = mainMenu1();
        }
        System.out.println("Forcing Exit...");
        System.exit(0);

    }
        private static ArrayList<Song> creatMyList() {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your adding song");
            String songName = input.nextLine();
            ArrayList<Song> myList = new ArrayList<>();
            if (!isEmpty()) {
                for (int i = 0; i < total; i++) {
                    if (songs[i].getName().equals(songName)) {
                        System.out.println("Added the Song Successfully");
                        myList.add(songs[i]);
                        System.out.println(myList);
                        System.out.println(myList);
                        System.out.println("\nPress enter key to continue...");
                        input.nextLine();

                        input.nextLine();
                    } else {
                        System.out.println("""
                                Adding the Song Failed.
                                Please Add It to the Song Library first.
                                        """);
                        return null;

                    }
                    mainMenu1();
                }
            }
            return myList;
        }
    }