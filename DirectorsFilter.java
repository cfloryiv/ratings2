
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter {
    private String[] directors;
    
    public DirectorsFilter(String dirs) {
        directors=dirs.split(",");
    }
    
    @Override
    public boolean satisfies(String id) {
        for (String dir : directors) {
            if (MovieDatabase.getDirector(id).indexOf(dir)>=0) {
                return true;
            }
        }
        return false;
    }
}
