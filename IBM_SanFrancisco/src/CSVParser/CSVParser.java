package CSVParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;















public class CSVParser
{
  protected String m_filename;
  private String[] m_filearray;
  private BufferedReader m_reader;
  private FileReader m_filereader;
  private CSVFilterParameter m_csvFilter;
  private ArrayList<CSVFilterParameter> m_filterList;
  
  public ArrayList<CSVFilterParameter> getM_filterList()
  {
    return m_filterList;
  }
  


  public void setM_filename(String m_filename)
  {
    this.m_filename = m_filename;
  }
  
  public String getM_filename() {
    return m_filename;
  }
  

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
  


  public void readFile()
    throws FileNotFoundException, IOException
  {
    m_filereader = new FileReader(m_filename);
    m_reader = new BufferedReader(m_filereader);
    while (m_reader.readLine() != null)
    {
      String l_moviename = "";
      String l_movieLocation = "";
      
      String[] l_array = splitLines(m_reader.readLine());
      
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
  


  private String[] splitLines(String p_line)
  {
    m_filearray = p_line.split(";");
    return m_filearray;
  }
}
