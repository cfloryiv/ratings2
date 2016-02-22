
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerAverage {
    public void printAverageRatings() {
        SecondRatings sc=new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
        ArrayList<Rating> rtgs=sc.getAverageRatings(12);
        System.out.println("There are "+sc.getMovieSize()+" movies");
        System.out.println("There are "+sc.getRaterSize()+" raters");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+sc.getTitle(rtg.getItem()));
        }
    }
    public void getAverageRatingOneMovie() {
        SecondRatings sc=new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
        ArrayList<Rating> rtgs=sc.getAverageRatings(1);
        String id=sc.getID("Vacation");
        for (Rating rtg : rtgs) {
            if (rtg.getItem().equals(id)) {
                System.out.println("Average Rating is "+rtg.getValue());
                return;
            }
        }
        System.out.println("Cannot locate movie");
    }
}
