package DVDLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    static ArrayList<DVD> dvds = new ArrayList<>();

    public static void main(String args[]) {

        String FILE = "src/DVDLibrary/dvds.txt";
        //String FILE = "src/DVDsaves/dvd.csv";

        try {
            loadDvds(FILE);
        } catch (Exception e) {
            System.out.println("File not loaded");
        }

        View view = new View();

        while(view.using) {
            view.menu();
        }

        list();
        save();

    }

    public static void display(DVD dvd) {
        System.out.println("Title: " + dvd.getTitle());
        System.out.println("Release Date: " + dvd.getDate());
        System.out.println("MPAA: " + dvd.getMpaa());
        System.out.println("Director: " + dvd.getDirector());
        System.out.println("Studio: " + dvd.getStudio());
        System.out.println("User Comment: " + dvd.getUserRating());
    }

    public static void list() {

        for (DVD dvd : dvds) {
            System.out.println(dvd.getTitle());
        }
    }

    public static DVD search(String title) {
        for (DVD dvd : dvds) {
            if (title.toLowerCase().equals(dvd.getTitle().toLowerCase())) {
                return dvd;
            }
        }

        return null;
    }

    public static void addDvd(String title, int date, int mpaa, String director, String studio, String userRating) {
        if (!dupCheck(title)) {
            DVD dvd = new DVD(title, date, mpaa, director, studio, userRating);
            dvds.add(dvd);
            save();
        } else {
            System.out.println("Film already in list");
        }
    }

    public static void removeDvd(DVD dvd) {
        System.out.println("Deleting " + dvd.getTitle());
        dvds.remove(dvd);
        //save();
    }

    public static void editDVD(DVD dvd, String title, String date, String mpaa, String director, String studio, String userRating) {

        if (!title.equals("")) {
            dvd.setTitle(title);
        }

        if (!date.equals("")) {
            dvd.setDate(Integer.parseInt(date));
        }

        if (!mpaa.equals("")) {
            dvd.setMpaa(Integer.parseInt(mpaa));
        }

        if (!director.equals("")) {
            dvd.setDirector(director);
        }

        if (!studio.equals("")) {
            dvd.setStudio(studio);
        }

        if (!userRating.equals("")) {
            dvd.setUserRating(userRating);
        }
        save();
    }

    public static void loadDvds(String file) throws FileNotFoundException {
        System.out.println("Loading from " + file);
        File txt = new File(file);
        //Scanner loader = new Scanner(new FileReader(file));

        Scanner loader = new Scanner(txt);

        ArrayList<DVD> dvdss = new ArrayList<>();

        while (loader.hasNextLine()) {
            String line = loader.nextLine();

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            String title = lineScanner.next();
            int date = lineScanner.nextInt();
            int mpaa = lineScanner.nextInt();
            String director = lineScanner.next();
            String studio = lineScanner.next();
            try {
                String userRating = lineScanner.next();
                DVD dvd = new DVD(title, date, mpaa, director, studio, userRating);
                dvdss.add(dvd);
            } catch(Exception e) {
                DVD dvd = new DVD(title, date, mpaa, director, studio);
                dvdss.add(dvd);
            }
        }

        //System.out.println("DVDs loaded: ");
        //list();
        dvds = dvdss;

    }

    public static void save() {
        System.out.println("Saving...");
        try {
            FileWriter writer = new FileWriter("src/DVDsaves/dvd.csv");

            for (DVD dvd : dvds) {
                String inputDvd = dvd.getTitle() + "," + Integer.toString(dvd.getDate()) + "," +
                        Integer.toString(dvd.getMpaa()) + "," + dvd.getDirector() + "," +
                        dvd.getStudio() + "," + dvd.getUserRating();
                writer.write(inputDvd);
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("File not saved");
        }
    }

    public static boolean dupCheck(String title) {

        for (DVD dvd : dvds) {
            if (dvd.getTitle().toLowerCase().equals(title.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public static void exit() {
        System.exit(0);
    }

}
