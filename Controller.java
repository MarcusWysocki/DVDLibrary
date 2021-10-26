package DVDLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    static ArrayList<DVD> dvds = new ArrayList<>();

    public static void main(String args[]) {

        String FILE = "src/DVDLibrary/dvd.csv";

        try {
            dvds = load(FILE);
        } catch (Exception e) {
            System.out.println("No file found");
        }

        String remDvd = "The Terminator";

        if (search(remDvd) != null) {
            removeDvd(search(remDvd));
        }
        list();
    }

    public static void display(DVD dvd) {
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
        dvds.remove(dvd);
        save();
    }

    public static ArrayList<DVD> load(String file) throws FileNotFoundException {
        File txt = new File(file);
        //Scanner loader = new Scanner(new FileReader(file));

        Scanner loader = new Scanner(txt);

        ArrayList<DVD> dvds = new ArrayList<>();

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
                dvds.add(dvd);
            } catch(Exception e) {
                DVD dvd = new DVD(title, date, mpaa, director, studio);
                dvds.add(dvd);
            }
        }

        return dvds;

    }

    public static void save() {
        try {
            FileWriter writer = new FileWriter("src/DVDLibrary/dvd.csv");

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

}
