package DVDLibrary;

import java.util.Scanner;

import static DVDLibrary.Controller.*;

public class View {

    static boolean using = true;

    public static void menu() {

        System.out.println("Please choose an action by entering a number:");
        System.out.println("1. Add Film");
        System.out.println("2. Remove Film");
        System.out.println("3. Edit Film");
        System.out.println("4. List Film");
        System.out.println("5. Save file");
        System.out.println("6. Load file");
        System.out.println("7. Search for Film");
        System.out.println("8. Exit application");

        Scanner in = new Scanner(System.in);

        int choice = in.nextInt();

        switch(choice) {
            case 1:
                addFilm();
                break;
            case 2:
                remFilm();
                break;
            case 3:
                editFilm();
                break;
            case 4:
                listFilm();
                break;
            case 5:
                saveFile();
                break;
            case 6:
                loadFile();
                break;
            case 7:
                searchFilm();
                break;
            case 8:
                exiting();
                break;
        }
    }

    public static void addFilm() {

        System.out.println("Adding film...");
        menu();
    }

    public static void remFilm() {

        System.out.println("Removing film...");
        menu();
    }

    public static void editFilm() {

        System.out.println("Editing film...");
        menu();
    }

    public static void listFilm() {

        System.out.println("Here are all film titles...");
        list();
        menu();
    }

    public static void searchFilm() {

        System.out.println("Searching film...");
        menu();
    }

    public static void loadFile() {
        try {
            load("src/DVDLibrary/dvd.csv");
        } catch(Exception e) {
            System.out.println("File not found");
        }
        menu();
    }

    public static void saveFile() {
        save();
        menu();
    }

    public static void exiting() {
        System.out.println("Goodbye!");
        using = false;
    }

}
