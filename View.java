package DVDLibrary;

import java.util.Scanner;

import static DVDLibrary.Controller.*;

public class View {

    static boolean using = true;
    //static String FILE_PATH = "src/DVDsaves/dvd.csv";
    static String FILE_PATH = "src/DVDLibrary/dvds.txt";

    public static void menu() {

        System.out.println("=============================================");
        System.out.println("Please choose an action by entering a number:");
        System.out.println("1. Add Film  ||  2. List Films");
        System.out.println("3. Save file  ||  4. Load file");
        System.out.println("5. Search for Film  ||  6. Change Save location");
        System.out.println("7. Exit application");
        System.out.println("=============================================");

        Scanner in = new Scanner(System.in);

        int choice = in.nextInt();

        switch(choice) {
            case 1:
                addFilm();
                break;
            case 2:
                listFilm();
                break;
            case 3:
                saveFile();
                break;
            case 4:
                loadFile();
                break;
            case 5:
                searchFilm();
                break;
            case 6:
                saveLocation();
            case 7:
                exiting();
                break;
            default:
                menu();
        }
    }

    public static void addFilm() {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the film's title:");
        String title = in.nextLine();
        System.out.println("Please enter the film's release date (ddmmyyyy):");
        int date = Integer.parseInt(in.nextLine());
        System.out.println("Please enter the film's MPAA rating:");
        int mpaa = Integer.parseInt(in.nextLine());
        System.out.println("Please enter the film's director:");
        String director = in.nextLine();
        System.out.println("Please enter the film's studio:");
        String studio = in.nextLine();
        System.out.println("Please enter your comments:");
        String userRating = in.nextLine();
        addDvd(title, date, mpaa, director, studio, userRating);
        displayFilm(search(title));
    }

    public static void remFilm(DVD dvd) {

        removeDvd(dvd);
        menu();
    }

    public static void editFilm(DVD dvd) {

        Scanner in  = new Scanner(System.in);
        System.out.println("Input TITLE or leave blank to leave unchanged");
        String title = in.nextLine();

        System.out.println("Input RELEASE DATE or leave blank to leave unchanged");
        String date = in.nextLine();

        System.out.println("Input MPAA or leave blank to leave unchanged");
        String mpaa = in.nextLine();

        System.out.println("Input DIRECTOR or leave blank to leave unchanged");
        String director = in.nextLine();

        System.out.println("Input STUDIO or leave blank to leave unchanged");
        String studio = in.nextLine();

        System.out.println("Input COMMENT or leave blank to leave unchanged");
        String userRating = in.nextLine();

        editDVD(dvd, title, date, mpaa, director, studio, userRating);
        displayFilm(dvd);
    }

    public static void listFilm() {

        System.out.println("Here are all film titles...");
        list();
        menu();
    }

    public static void searchFilm() {

        System.out.println("Enter the film's title");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        System.out.println(title);
        DVD dvd = new DVD();
        try {
            dvd = search(title);
            displayFilm(dvd);
        } catch (Exception e) {
            System.out.println("Could not find film");
            menu();
        }

        System.out.println("=============================================");
        menu();
    }

    public static void displayFilm(DVD dvd) {
        System.out.println("=============================================");
        display(dvd);

        Scanner in = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("Would you like to edit or delete this film?");
        System.out.println("1. Edit");
        System.out.println("2. Delete");
        System.out.println("3. Return to menu");
        System.out.println("---------------------------------");

        int choice = in.nextInt();
        switch(choice) {
            case 1:
                editFilm(dvd);
                break;
            case 2:
                remFilm(dvd);
                break;
            case 3:
                menu();

        }

    }

    public static void loadFile() {
        try {
            loadDvds();
        } catch(Exception e) {
            System.out.println("File not found");
        }
        menu();
    }

    public static void saveFile() {
        save();
        menu();
    }

    public static void saveLocation() {
        System.out.println("Enter new file location");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();

        setFile(path);
        menu();

    }

    public static void exiting() {
        System.out.println("Goodbye!");
        exit();
    }

}
