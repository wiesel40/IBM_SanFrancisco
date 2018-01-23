package MovieThread;

import CSVParser.CSVFilterParameter;
import CSVParser.CSVParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/*
Starts the Runnable thread 
*/
public class CSVMovieRunnableServiceThread
  implements Runnable
{
  public CSVMovieRunnableServiceThread() {}
  
  @Override
  public void run()
  {
    try
    {
    //some Path
      CSVParser l_parser = new CSVParser("IBM_SanFrancisco\\src\\inputfile\\Film_Locations_in_San_Francisco.csv");
      
      l_parser.readFile();
      
      /*
        Read File 
      */
      System.out.println("Reading is successful");
      ArrayList<CSVFilterParameter> l_list = l_parser.getM_filterList();
      for (int i = 0; i < l_list.size(); i++) {
        System.out.println("CSV line " + i);
        
        CSVFilterParameter l_CSVParameter = (CSVFilterParameter)l_list.get(i);
        System.out.println("Movie Name " + l_CSVParameter.getM_moviename());
        System.out.println("Movie Location " + l_CSVParameter.getM_movielocation());
      }
      System.out.println("End Of File");
    }
    catch (FileNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
