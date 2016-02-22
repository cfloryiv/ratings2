
/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {
    public ArrayList<Rater> loadRaters(String filename) {
        ArrayList<Rater> raters = new ArrayList<Rater>();
        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        for (CSVRecord currentRow : parser) {
            //Rating rating=new Rating(currentRow.get("movie_id"), Double.parseDouble(currentRow.get("rating")));
            Double rating=Double.parseDouble(currentRow.get("rating"));
            String movieID=currentRow.get("movie_id");
            String raterID=currentRow.get("rater_id");
            Rating rtg=new Rating(movieID, rating);
            boolean found=false;
            Rater rtrx=null;
            for (Rater rtr : raters) {
                if (rtr.getID().equals(raterID)) {
                    found=true;
                    rtrx=rtr;
                    break;
                }
            }
            if (found) {
                rtrx.addRating(movieID, rating);
                int ndx=raters.indexOf(rtrx);
                raters.set(ndx, rtrx);
            } else {
                Rater rtr=new EfficientRater(raterID);
                rtr.addRating(movieID, rating);
                raters.add(rtr);
            }
        }
        return raters;
    }
    public void testLoadRaters() {
        ArrayList<Rater>raters = loadRaters("./data/ratings.csv");
        System.out.println("There are "+raters.size()+" raters");
        //for (Rater rtr : raters) {
         //   System.out.println(rtr.getID());
        //}
        int maxRatings=0;
        String maxRater="";
        String movieID="1798709";
        int numberRatings=0;
        ArrayList<String> uniqueMovies=new ArrayList<String>();
        for (Rater rtr : raters) {
            if (rtr.getID().equals("193")) {
                System.out.println("There are "+rtr.numRatings()+" ratings");
            }
            if (rtr.numRatings()>maxRatings) {
                maxRater=rtr.getID();
                maxRatings=rtr.numRatings();
            }
            if (rtr.hasRating(movieID))
                numberRatings++;
            ArrayList<String> movies=rtr.getItemsRated();
            for (String movie : movies) {
                if (!uniqueMovies.contains(movie)) {
                    uniqueMovies.add(movie);
                }
            }
        }
        System.out.println("max rater = "+maxRater+" with # ratings = "+maxRatings);
        System.out.println("Movie "+movieID+" has "+numberRatings+" ratings");
        System.out.println("There were "+uniqueMovies.size()+" movies rated");
    }
    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        for (CSVRecord currentRow : parser) {
            Movie movie=new Movie(currentRow.get("id"),
                currentRow.get("title"),
                currentRow.get("year"),
                currentRow.get("genre"),
                currentRow.get("director"),
                currentRow.get("country"),
                currentRow.get("poster"),
                Integer.parseInt(currentRow.get("minutes")));
             movies.add(movie);
        }
        return movies;
    }
    public void testLoadMovies() {
        
        ArrayList<Movie> movies=loadMovies("./data/ratedmoviesfull.csv");
        System.out.println("There are "+movies.size()+" movies loaded.");
        //for (Movie movie : movies) {
        //    System.out.println(movie);
       // }
       int numberComedies=0;
       int numberLong=0;
       int maxDirs=1;
       HashMap<String, Integer> directors=new HashMap<String, Integer>();
       for (Movie movie : movies) {
           if (movie.getGenres().indexOf("Comedy")>=0)   
                numberComedies++;
           if (movie.getMinutes()>150)
                numberLong++;
           String[] dirs=movie.getDirector().split(",");
           for (String dir : dirs) {
               dir=dir.trim();
               if (directors.containsKey(dir)) {
                    int value=directors.get(dir);
                    directors.put(dir, value+1);
                    if (value+1 > maxDirs)
                        maxDirs=value+1;
                } else {
                    directors.put(dir, 1);
                    
                }
            }
                    
       }
        System.out.println("# comedies = "+numberComedies);
        System.out.println("# movies > 150 minutes = "+numberLong);
        System.out.println("Direcors who directed "+maxDirs+"  movies:");
        for (String dir : directors.keySet()) {
            if (directors.get(dir) >= maxDirs) {
                System.out.println(dir);
            }
        }
    }
}
