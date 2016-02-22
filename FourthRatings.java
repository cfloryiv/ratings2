
/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class FourthRatings {
    private double getAverageByID(String id, int minimalRaters) {
        int numberRaters=0;
        double totalValue=0.0;
        ArrayList<Rater> myRaters=RaterDatabase.getRaters();
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
    private double dotProduct(Rater me, Rater r) {
        double product=0.0;
        ArrayList<String> items=me.getItemsRated();
        for (String id : items) {
            double myRating=me.getRating(id)-5.0;
            if (r.hasRating(id)) {
                double rRating=r.getRating(id)-5.0
                ;
                product+=myRating*rRating;
            }
        }
        return product;
    }
    private ArrayList<Rating> getSimiliarities(String id) {
        ArrayList<Rating> alr=new ArrayList<Rating>();
        ArrayList<Rater> rtrs=RaterDatabase.getRaters();
        Rater myRtr=RaterDatabase.getRater(id);
        for (Rater rtr : rtrs) {
            if (rtr.getID()!=id) {
                double product=dotProduct(myRtr, rtr);
                //if (product>0.0) {
                    alr.add(new Rating(rtr.getID(), product));
               // }
            }
        }
        Collections.sort(alr);
        return alr;
    }
    public ArrayList<Rating> getSimiliarRatings(String id, int numSimiliarRaters, int minimalRaters) {
        ArrayList<Rating> rtgs=getSimiliarities(id);
        ArrayList<Rating> output=new ArrayList<Rating>();
        for(String movie_id : MovieDatabase.filterBy(new TrueFilter())) {
            double totalValue=0.0;
            int numberRaters=0;
            int numSim=0;
            for (int ii=rtgs.size()-2; ii>=0; ii--) {
                numSim++;
                if (numSim>numSimiliarRaters) break;
                String rtr_id=rtgs.get(ii).getItem();
                double factor=rtgs.get(ii).getValue();
                Rater rtr=RaterDatabase.getRater(rtr_id);
                double rating=rtr.getRating(movie_id);
                if (rating>=0) {
                    numberRaters++;
                    
                    totalValue+=rating*factor;
                }
            }
            if (numberRaters>=minimalRaters) {
                output.add(new Rating(movie_id, totalValue/numberRaters));
            }

        }
        Collections.sort(output);
        return output;
    }
     public ArrayList<Rating> getSimiliarRatingsByFilter(String id, int numSimiliarRaters, int minimalRaters, Filter f) {
         ArrayList<Rating> rtgs=getSimiliarities(id);
        ArrayList<Rating> output=new ArrayList<Rating>();
        for(String movie_id : MovieDatabase.filterBy(f)) {
            double totalValue=0.0;
            int numberRaters=0;
            int numSim=0;
            for (int ii=rtgs.size()-2; ii>=0; ii--) {
                numSim++;
                if (numSim>numSimiliarRaters) break;
                String rtr_id=rtgs.get(ii).getItem();
                double factor=rtgs.get(ii).getValue();
                Rater rtr=RaterDatabase.getRater(rtr_id);
                double rating=rtr.getRating(movie_id);
                if (rating>=0) {
                    numberRaters++;
                    
                    totalValue+=rating*factor;
                }
            }
            if (numberRaters>=minimalRaters) {
                output.add(new Rating(movie_id, totalValue/numberRaters));
            }
        }
        Collections.sort(output);
        return output;
    }
}


