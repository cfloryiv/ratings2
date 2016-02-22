
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerWithFilters {
    public void printAverageRatings() {
        ThirdRatings sc=new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ArrayList<Rating> rtgs=sc.getAverageRatings(35);
        System.out.println("There are "+sc.getRaterSize()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getTitle(rtg.getItem()));
        }
    }
     public void printAverageRatingsByYear() {
        ThirdRatings sc=new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        Filter filter=new YearAfterFilter(2000);
        ArrayList<Rating> rtgs=sc.getAverageRatingsByFilter(20, filter);
        System.out.println("There are "+sc.getRaterSize()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getYear(rtg.getItem())+" "+MovieDatabase.getTitle(rtg.getItem()));
        }
    }
       public void printAverageRatingsByGenre() {
        ThirdRatings sc=new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        Filter filter=new GenreFilter("Comedy");
        ArrayList<Rating> rtgs=sc.getAverageRatingsByFilter(20, filter);
        System.out.println("There are "+sc.getRaterSize()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getYear(rtg.getItem())+" "+MovieDatabase.getTitle(rtg.getItem()));
            System.out.println(MovieDatabase.getGenres(rtg.getItem()));
        }
    }
       public void printAverageRatingsByMinutes() {
        ThirdRatings sc=new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        Filter filter=new MinutesFilter(105, 135);
        ArrayList<Rating> rtgs=sc.getAverageRatingsByFilter(5, filter);
        System.out.println("There are "+sc.getRaterSize()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getYear(rtg.getItem())+" Time: "+MovieDatabase.getMinutes(rtg.getItem())+" "+MovieDatabase.getTitle(rtg.getItem()));
        }
    }
       public void printAverageRatingsByDirectors() {
        ThirdRatings sc=new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        Filter filter=new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        ArrayList<Rating> rtgs=sc.getAverageRatingsByFilter(4, filter);
        System.out.println("There are "+sc.getRaterSize()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getYear(rtg.getItem())+" Time: "+MovieDatabase.getMinutes(rtg.getItem())+" "+MovieDatabase.getTitle(rtg.getItem()));
            System.out.println(MovieDatabase.getDirector(rtg.getItem()));
        }
    }
       public void printAverageRatingsByYearAfterAndGenre() {
        ThirdRatings sc=new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        Filter filter1=new YearAfterFilter(1990);
        Filter filter2=new GenreFilter("Drama");
        AllFilters af=new AllFilters();
        af.addFilter(filter1);
        af.addFilter(filter2);
        ArrayList<Rating> rtgs=sc.getAverageRatingsByFilter(8, af);
        System.out.println("There are "+sc.getRaterSize()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getYear(rtg.getItem())+" Time: "+MovieDatabase.getMinutes(rtg.getItem())+" "+MovieDatabase.getTitle(rtg.getItem()));
            System.out.println(MovieDatabase.getGenres(rtg.getItem()));
        }
    }
       public void printAverageRatingsByDirectorsAndMinutes() {
        ThirdRatings sc=new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        Filter filter1=new MinutesFilter(90, 180);
        Filter filter2=new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack");
        AllFilters af=new AllFilters();
        af.addFilter(filter1);
        af.addFilter(filter2);
        ArrayList<Rating> rtgs=sc.getAverageRatingsByFilter(3, af);
        System.out.println("There are "+sc.getRaterSize()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getYear(rtg.getItem())+" Time: "+MovieDatabase.getMinutes(rtg.getItem())+" "+MovieDatabase.getTitle(rtg.getItem()));
            System.out.println(MovieDatabase.getDirector(rtg.getItem()));
        }
    }
}
