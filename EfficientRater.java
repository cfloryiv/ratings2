
/**
 * Write a description of class Rater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class EfficientRater implements Rater {
    private String myID;
    HashMap<String, Double> myRatings;
 

    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<String, Double>();
    }

    public void addRating(String item, double rating) {
        myRatings.put(item, rating);
    }

    public boolean hasRating(String item) {
        if (!myRatings.containsKey(item)) {
            return false;
        } else {
            return true;
        }
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        if (!myRatings.containsKey(item)) {
            return -1.0;
        } else {
            return myRatings.get(item);
        }
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        Set<String> slist = myRatings.keySet();
        ArrayList<String> list=new ArrayList<String>();
        list.addAll(slist);
        
        return list;
    }
}
