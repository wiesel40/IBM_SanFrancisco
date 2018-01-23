package ibm_sanfrancisco;

import MovieThread.CSVMovieRunnableServiceThread;
import java.io.PrintStream;
/* 
Main class which starts the thread
*/
public class IBM_SanFrancisco
{
  public IBM_SanFrancisco() {}
  
  public static void main(String[] args)
  {
    System.out.println("Service is running");
    new Thread(new CSVMovieRunnableServiceThread()).start();
  }
}
