/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieThread;

import CSVParser.CSVFilterParameter;
import CSVParser.CSVParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author wiesel40 Creates a running thread
 *
 */
public class CSVMovieRunnableServiceThread implements Runnable {

    @Override
    public void run() {
        try {
            /*
            Just for testing purposes the url is added here 
             */
            CSVParser l_parser = new CSVParser("C:\\Users\\Alexander\\Documents\\NetBeansProjects\\IBM_SanFrancisco\\src\\inputfile\\Film_Locations_in_San_Francisco.csv");

            l_parser.readFile();

            /*
            Read the CSV Filter 
             */
            System.out.println("Reading is successful");
            ArrayList<CSVFilterParameter> l_list = l_parser.getM_filterList();
            for (int i = 0; i < l_list.size(); i++) {
                System.out.println("CSV line " + i);
                CSVFilterParameter l_CSVParameter;
                l_CSVParameter = l_list.get(i);
                System.out.println("Movie Name " + l_CSVParameter.getM_moviename());
                System.out.println("Movie Location " + l_CSVParameter.getM_movielocation());
            }
            System.out.println("End Of File");

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
