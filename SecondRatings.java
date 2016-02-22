
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    public SecondRatings(String moviefile, String ratingsfile) {     //
        FirstRatings fr=new FirstRatings();
        myMovies=fr.loadMovies(moviefile);
        myRaters=fr.loadRaters(ratingsfile);
    }
    public int getMovieSize() {
       return myMovies.size();
    }
    public int getRaterSize() {
        return myRaters.size();
    }
    public String getTitle(String id) {
        for (Movie movie : myMovies) {
            if (movie.getID().equals(id)) {
                return movie.getTitle();
            }
        }
        return "movie "+id+" not found";
    }
    public String getID(String title) {
        for (Movie movie : myMovies) {
            if (movie.getTitle().equals(title)) {
                return movie.getID();
            }
        }
        return "NO SUCH TITLE";
    }
    private double getAverageByID(String id, int minimalRaters) {
        int numberRaters=0;
        double totalValue=0.0;
        for (Rater rtr: myRaters) {
            double rating=rtr.getRating(id);
            if (rating>=0) {
                numberRaters++;
                totalValue+=rating;
            }
        }
        if (numberRaters>=minimalRaters) {
            return (totalValue/numberRaters);
        } else {
            return 0.0;
        }
    }
    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> rtg=new ArrayList<Rating>();
        for (Movie movie : myMovies) {
            double average=getAverageByID(movie.getID(), minimalRaters);
            if (average>0.0) {
                rtg.add(new Rating(movie.getID(), average));
            }
        }
        Collections.sort(rtg);
        return rtg;
    }
}
