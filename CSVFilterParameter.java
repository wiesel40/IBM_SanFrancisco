package CSVParser;



/*
This class contains the movie name and the movie location
*/
public class CSVFilterParameter
{
  private String m_moviename;
  private String m_movielocation;
  
  /*
   Getter and Setter for movie name and moviel location
  */
  public String getM_moviename()
  {
    return m_moviename;
  }
  
  public void setM_moviename(String m_moviename) {
    this.m_moviename = m_moviename;
  }
 
  public String getM_movielocation()
  {
    return m_movielocation;
  }
  
  public void setM_movielocation(String m_movielocation) {
    this.m_movielocation = m_movielocation;
  }
  
  public CSVFilterParameter() {}
  
  public CSVFilterParameter(String p_moviename, String p_movielocation)
  {
    m_moviename = p_moviename;
    m_movielocation = p_movielocation;
  }
}
