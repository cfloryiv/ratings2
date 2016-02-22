
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    public ThirdRatings(String ratingsfile) {     //
        FirstRatings fr=new FirstRatings();
        myRaters=fr.loadRaters(ratingsfile);
    }
    public int getRaterSize() {
        return myRaters.size();
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
        ArrayList<String> movies=MovieDatabase.filterBy(new TrueFilter());
        for (String id : movies) {
            Movie movie=MovieDatabase.getMovie(id);
            double average=getAverageByID(movie.getID(), minimalRaters);
            if (average>0.0) {
                rtg.add(new Rating(movie.getID(), average));
            }
        }
        Collections.sort(rtg);
        return rtg;
    }
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
         ArrayList<Rating> rtg=new ArrayList<Rating>();
        ArrayList<String> movies=MovieDatabase.filterBy(filterCriteria);
        for (String id : movies) {
            Movie movie=MovieDatabase.getMovie(id);
            double average=getAverageByID(movie.getID(), minimalRaters);
            if (average>0.0) {
                rtg.add(new Rating(movie.getID(), average));
            }
        }
        Collections.sort(rtg);
        return rtg;
    }
}
