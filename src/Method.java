import java.util.*;


public class Method {

    private static final Main main = new Main();
    static Song[] songs;
    static int total = 0;


    public static List<Song> fuzzySearch(Song[] songs, String target) {
        if(!isEmpty()){
        List<Song> result = new ArrayList<>();//Define a set
        for (int i = 0; i < total; i++) {
            if (songs[i].getName().contains(target)) {
                result.add(songs[i]);
            }
        }
        return result;
        }//First check if the array is empty to prevent errors caused by Method. song [I] being null
        else return null;
    }



    public Method(int numberItems) {
        songs = new Song[numberItems];
    }

    public boolean add(Song aSong) {
        if (isFull()) {
            return false;
        } else {
            songs[total] = aSong;
            total++;//Determine array length
            return true;
        }
    }

    private void deleteSongs(Song[] songs) {
        Method.songs = songs;
    }

    public static void Delete() {
        System.out.println("Please Choose the Song You Want to Delete");
        while (true) {
            String name = main.input.next();
            int index = -1;//Define initial value
            for (int i = 0; i < total; i++) {
                if (songs[i] != null && songs[i].getName().equals(name)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("The Song Does Not Exist");
            } else {
                songs[index] = null;
                System.out.println("Delete Successfully");
                break;
            }
        }

    }

    public static String listSongs() {
        if (isEmpty()) {
            return "No songs in the list";
        } else {
            StringBuilder listOfSongs = new StringBuilder();
            for (int i = 0; i < total; i++) {
                listOfSongs.append(i).append(": ").append(songs[i]).append("\n");//Optimize memory
            }
            return String.valueOf(listOfSongs);
        }
    }

    public static void Edit() {
        System.out.println("please choose the song you want to edit");
        while (true) {
            String name = main.input.next();
            int index = -1;
            for (int i = 0; i < total; i++) {
                if (songs[i] != null && songs[i].getName().equals(name)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("the song does not exit");
            } else {
                Song a = Method.songs[index];
                System.out.println("please input the song's name");
                String changeName = main.input.next();
                System.out.println("please input the kind of the song");
                Kind kind = Kind.valueOf(main.input.next());
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
    }//Define a method to determine whether an array is empty

    private static int mainMenu1() {
        System.out.println("""
                 My List Menu
                ---------
                1) Creat my list
                2) List my list
                3) Clear my list
                4) Back
                0) Compulsory Withdrawal
                 """);
        return main.input.nextInt();


    }

    public static void myList() {
        Scanner input = new Scanner(System.in);
        int option = mainMenu1();
        ArrayList myList = new ArrayList();
        while (option != 0) {
            switch (option) {
                case 1-> addSong(myList);
                case 2-> setTop(myList);
                case 3-> moveSong(myList);
                case 4-> deleteSong(myList);
                case 5-> {
                    main.mainMenu();
                    main.runMenu();
                }
                default-> System.out.println("Invalid option entered: " + option);

            }
            System.out.println("\nPress enter key to continue...");
            input.nextLine();

            input.nextLine();
            option = mainMenu1();
        }
        System.out.println("Forcing Exit...");
        System.exit(0);

    }
    public static void addSong(ArrayList myList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the song name you want to add and press Enter to end the input.");
        String songName = input.nextLine();
        myList.add(songName);
        System.out.println("Added song:" + songName);
        System.out.println("The current playlist list is:" + myList);
    }

        public static void deleteSong(ArrayList myList){
            System.out.println("Please enter the song name that needs to be deleted and press Enter to end the input.");
            String songName = new Scanner(System.in).nextLine();
            int location = myList.indexOf(songName);
            if (location<0){
                System.out.println("The song you want to delete does not exist in the playlist!");
            }else {
                myList.remove(songName);
                System.out.println("Delete successful!");
                System.out.println("The current playlist list is:"+myList);
            }
        }
        public static void moveSong(ArrayList myList){
            System.out.println("Please enter the name of the song you want to move forward by one digit, " +
                    "and press Enter to end the input.");
            String name = new Scanner(System.in).nextLine();
            int location = myList.indexOf(name);
            if (location<0){
                System.out.println("The song you need to move forward was not found");
            }else if (location == 0){
                System.out.println("Your song is already in the first position and cannot be moved forward.");
            }else {
                myList.remove(name);
                myList.add(location-1,name);
            }
            System.out.println("The current playlist list is："+ myList);
        }

        public static void setTop(ArrayList myList){
            System.out.println("Please enter the name of the song you want to top and " +
                    "press Enter to end the input.");
            String songName = new Scanner(System.in).nextLine();
            int location = myList.indexOf(songName);//Get the current song index
            if (location<0){//Check if there are any songs entered by the user in the playlist
                System.out.println("I couldn't find your song!");
            } else if (location==0) {
                System.out.println("Your song has been topped!");
            }else {
                myList.remove(songName);//Delete the original playlist first, then insert it into the desired location
                myList.add(0,songName);
            }
            System.out.println("The current playlist is："+myList);
        }
}
