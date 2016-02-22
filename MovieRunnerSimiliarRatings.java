
/**
 * Write a description of MovieRunnerSimiliarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerSimiliarRatings {
 public void printAverageRatings() {
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings sc=new FourthRatings();
        ArrayList<Rating> rtgs=sc.getAverageRatings(35);
        System.out.println("There are "+RaterDatabase.size()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getTitle(rtg.getItem()));
        }
    }
        public void printAverageRatingsByYearAfterAndGenre() {
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings sc=new FourthRatings();
        Filter filter1=new YearAfterFilter(1990);
        Filter filter2=new GenreFilter("Drama");
        AllFilters af=new AllFilters();
        af.addFilter(filter1);
        af.addFilter(filter2);
        ArrayList<Rating> rtgs=sc.getAverageRatingsByFilter(8, af);
        System.out.println("There are "+RaterDatabase.size()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getYear(rtg.getItem())+" Time: "+MovieDatabase.getMinutes(rtg.getItem())+" "+MovieDatabase.getTitle(rtg.getItem()));
            System.out.println(MovieDatabase.getGenres(rtg.getItem()));
        }
    }
     public void printSimiliarRatings() {
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings sc=new FourthRatings();
        ArrayList<Rating> rtgs=sc.getSimiliarRatings("71", 20, 5);
        System.out.println("There are "+RaterDatabase.size()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getTitle(rtg.getItem()));
        }
    }
     public void printSimiliarRatingsByGenre() {
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings sc=new FourthRatings();
        Filter filter=new GenreFilter("Mystery");
         ArrayList<Rating> rtgs=sc.getSimiliarRatingsByFilter("964", 20, 5, filter);
        System.out.println("There are "+RaterDatabase.size()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getTitle(rtg.getItem()));
            System.out.println(MovieDatabase.getGenres(rtg.getItem()));
        }
    }
    public void printSimiliarRatingsByDirector() {
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings sc=new FourthRatings();
        Filter filter=new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
         ArrayList<Rating> rtgs=sc.getSimiliarRatingsByFilter("120", 10, 2, filter);
        System.out.println("There are "+RaterDatabase.size()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getTitle(rtg.getItem()));
            System.out.println(MovieDatabase.getDirector(rtg.getItem()));
        }
    }
     public void printSimiliarRatingsByGenreAndMinutes() {
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings sc=new FourthRatings();
        Filter filter1=new MinutesFilter(80, 160);
        Filter filter2=new GenreFilter("Drama");
        AllFilters af=new AllFilters();
        af.addFilter(filter1);
        af.addFilter(filter2);
        ArrayList<Rating> rtgs=sc.getSimiliarRatingsByFilter("168", 10, 3, af);
        System.out.println("There are "+RaterDatabase.size()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getTitle(rtg.getItem()));
            System.out.println(MovieDatabase.getGenres(rtg.getItem()));
        }
    }
    public void printSimiliarRatingsByYearAfterAndMinutes() {
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings sc=new FourthRatings();
        Filter filter1=new YearAfterFilter(1975);
        Filter filter2=new MinutesFilter(70, 200);
        AllFilters af=new AllFilters();
        af.addFilter(filter1);
        af.addFilter(filter2);
        ArrayList<Rating> rtgs=sc.getSimiliarRatingsByFilter("314", 10, 5, af);
        System.out.println("There are "+RaterDatabase.size()+" raters");
        System.out.println("There are "+MovieDatabase.size()+" movies");
        System.out.println("There are "+rtgs.size()+" ratings");
        for (Rating rtg : rtgs) {
            System.out.println(rtg.getValue()+" "+MovieDatabase.getTitle(rtg.getItem()));
            System.out.println(MovieDatabase.getGenres(rtg.getItem()));
        }
    }
}
