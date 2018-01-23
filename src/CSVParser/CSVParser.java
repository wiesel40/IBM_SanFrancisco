/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSVParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author wiesel40 Parses the CSV File which contains the information of the
 * movie name and movie location
 */
public class CSVParser {

    protected String m_filename;
    private String[] m_filearray;

    private BufferedReader m_reader;
    private FileReader m_filereader;
    //class which holds the movie name and movie location
    private CSVFilterParameter m_csvFilter;
    private ArrayList<CSVFilterParameter> m_filterList;

    /*
        CSVFilterParameter array which contains the movie name and movie location
     */
    public ArrayList<CSVFilterParameter> getM_filterList() {
        return m_filterList;
    }

    /*
        Filename getter and setter 
     */
    public void setM_filename(String m_filename) {
        this.m_filename = m_filename;
    }

    public String getM_filename() {
        return m_filename;
    }

    /*
        Create a CSV Parser instance 
     */
    private CSVParser() throws FileNotFoundException, IOException {
        this.m_filename = "";
        m_filterList = new ArrayList<CSVFilterParameter>();
        m_csvFilter = new CSVFilterParameter();
    }

    /*
        Create a CSV Parser instance 
     */
    public CSVParser(String p_filename) throws FileNotFoundException, IOException {
        this.m_filename = p_filename;
        m_filterList = new ArrayList<CSVFilterParameter>();
        m_csvFilter = new CSVFilterParameter();
    }

    /*
        Reads CSV File 
        and parses each line 
     */
    public void readFile() throws FileNotFoundException, IOException {
        m_filereader = new FileReader(m_filename);
        m_reader = new BufferedReader(m_filereader);
        while (m_reader.readLine() != null) {

            String l_moviename = "";
            String l_movieLocation = "";
            //Split one line 
            String[] l_array = splitLines(m_reader.readLine());

            if (l_array[0].equals("Title") == false) {
                l_moviename = l_array[0];
            }
            if (l_array[2].equals("Locations") == false) {
                l_movieLocation = l_array[2];
            }
            m_csvFilter = new CSVFilterParameter(l_moviename, l_movieLocation);
            //adds the values of CSVFilterParameter in the list
            m_filterList.add(m_csvFilter);
        }
    }

    /*
        Splits one line with ; 
     */
    private String[] splitLines(String p_line) {
        m_filearray = p_line.split(";");
        return m_filearray;
    }

}
