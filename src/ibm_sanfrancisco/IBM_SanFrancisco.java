/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibm_sanfrancisco;

import MovieThread.CSVMovieRunnableServiceThread;



/**
 *
 * @author wiesel40
 * Main Runnable Method 
 */
public class IBM_SanFrancisco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Starts the Service 
        System.out.println("Service is running");
      (new Thread(new CSVMovieRunnableServiceThread())).start();

    }

}
