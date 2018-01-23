package CSVParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
This class is responsible for parsing the CSV File 
*/
public class CSVParser
{
  protected String m_filename;
  private String[] m_filearray;
  private BufferedReader m_reader;
  private FileReader m_filereader;
  private CSVFilterParameter m_csvFilter;
  private ArrayList<CSVFilterParameter> m_filterList;
  
  /*
    Getter of CSVFilterParameter List which holds the movie name and the movie location
  */
  public ArrayList<CSVFilterParameter> getM_filterList()
  {
    return m_filterList;
  }
  /*
    Getter and Setter for the filename 
  */
  public void setM_filename(String m_filename)
  {
    this.m_filename = m_filename;
  }
  
  public String getM_filename() {
    return m_filename;
  }
  
  /*
  This class is responsible for parsing the CSV File 
  */
  private CSVParser()
    throws FileNotFoundException, IOException
  {
    m_filename = "";
    m_filterList = new ArrayList();
    m_csvFilter = new CSVFilterParameter();
  }
  

  public CSVParser(String p_filename)
    throws FileNotFoundException, IOException
  {
    m_filename = p_filename;
    m_filterList = new ArrayList();
    m_csvFilter = new CSVFilterParameter();
  }
  
  /*
  Reads the CSVFile Current file 
  */
  public void readFile()
    throws FileNotFoundException, IOException
  {
    m_filereader = new FileReader(m_filename);
    m_reader = new BufferedReader(m_filereader);
    
    while ((l_line =  m_reader.readLine()) != null)
    {
      String l_moviename = "";
      String l_movieLocation = "";
     //split current line 
      String[] l_array = splitLines(l_line);
      //find out movie name and movie title 
      if (!l_array[0].equals("Title")) {
        l_moviename = l_array[0];
      }
      if (!l_array[2].equals("Locations")) {
        l_movieLocation = l_array[2];
      }
      m_csvFilter = new CSVFilterParameter(l_moviename, l_movieLocation);
      
      m_filterList.add(m_csvFilter);
    }
  }
  /*
  Splits the current line in ;
  */
  private String[] splitLines(String p_line)
  {
    m_filearray = p_line.split(";");
    return m_filearray;
  }
}
