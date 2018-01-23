
package CSVParser;

/**
 *
 * @author wiesel40 Contains getter and setter methods for the movie name and movie location.
 * This class is used to store a movie name and a movie location. 
 * location
 */
public class CSVFilterParameter {

    private String m_moviename;
    private String m_movielocation;

    /*
            getter and setter for the moviename
     */
    public String getM_moviename() {
        return m_moviename;
    }

    public void setM_moviename(String m_moviename) {
        this.m_moviename = m_moviename;
    }

    /*
            getter and setter for movielocation
     */
    public String getM_movielocation() {
        return m_movielocation;
    }

    public void setM_movielocation(String m_movielocation) {
        this.m_movielocation = m_movielocation;
    }

    /*
        Creates an CSVFilterParameter instance 
     */
    public CSVFilterParameter() {
    }

    /*
        Creates an CSVFilterParameter instance 
     */

    public CSVFilterParameter(String p_moviename, String p_movielocation) {
        this.m_moviename = p_moviename;
        this.m_movielocation = p_movielocation;
    }
};
