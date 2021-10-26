package DVDLibrary;

public class DVD {

    private String title; //Film title
    private int date; //date released
    private int mpaa; //Age rating
    private String director; //Director's name
    private String studio; //Publishing Studio
    private String userRating; //User Rating

    public DVD() {
        System.out.println("Inadequate data to create dvd");
    }

    public DVD(String title, int date, int mpaa, String director, String userRating) {
        this.title = title;
        this.date = date;
        this.mpaa = mpaa;
        this.director = director;
        this.userRating = userRating;
        this.studio = "Unknown";
    }

    public DVD(String title, int date, int mpaa, String director, String studio, String userRating) {
        this.title = title;
        this.date = date;
        this.mpaa = mpaa;
        this.director = director;
        this.studio = studio;
        this.userRating = userRating;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMpaa() {
        return mpaa;
    }

    public void setMpaa(int mpaa) {
        this.mpaa = mpaa;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
