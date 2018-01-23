/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSVCO2Filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Provides a CSV Parser for parsing the data
 */
public class CSVCO2Parser {

    private String[] m_filearray;
    private BufferedReader m_reader;
    private FileReader m_filereader;
    // CO2FilterParameter contians Department , Source_Type; Emissions_mtCO2 data
    private CO2FilterParameter m_filterparameter;
    private ArrayList<CO2FilterParameter> m_filter;
    private String m_filename;

    /*
     Returns a ArrayList with the CO2FilterParameter class
     */
    public ArrayList<CO2FilterParameter> getCO2FilterParameter() {
        return m_filter;
    }

    /*
     Getter and Setter Current File Name 
     */
    public String getFilename() {
        return m_filename;
    }

    public void setFilename(String m_filename) {
        this.m_filename = m_filename;
    }

    private CSVCO2Parser() throws FileNotFoundException, IOException {
        m_filename = "";
        m_filter = new ArrayList();
        m_filterparameter = new CO2FilterParameter();
    }

    public CSVCO2Parser(String p_filename) throws FileNotFoundException, IOException {
        this.m_filename = p_filename;
        m_filter = new ArrayList();
        m_filterparameter = new CO2FilterParameter();
    }

    /*
   reads the CSV File 
     */
    public void readFile() throws FileNotFoundException, IOException, NumberFormatException {
        m_filereader = new FileReader(m_filename);
        m_reader = new BufferedReader(m_filereader);

        String l_line = "";
        while ((l_line = m_reader.readLine()) != null) {
            String l_Department = "";
            String l_Emissions_mtCO2e = "";
            String l_sourceType = "";
            //split current line 
            String[] l_array = splitLines(l_line);
            //find out movie name and movie title 
            for (String l_str : l_array) {
                if (l_str.equals("Department")) {
                    l_Department = l_str;
                }
                if (l_str.equals("Source_Type")) {
                    l_sourceType = l_str;
                }
                String l_emissons = "";
                if (l_str.equals("Emissions_mtCO2e")) {
                    l_Emissions_mtCO2e = l_str;

                    if (filterValue(l_Emissions_mtCO2e) != 0.0) {
                        l_emissons = l_Emissions_mtCO2e;
                    }
                }
                m_filterparameter = new CO2FilterParameter(l_Department, l_sourceType, l_Emissions_mtCO2e);
                m_filter.add(m_filterparameter);
            }
        }
    }

    /*
    splits the String in ;
     */
    private String[] splitLines(String p_line) {
        m_filearray = p_line.split(";");
        return m_filearray;
    }

    /*
        Checks for 0.00
     */
    private Double filterValue(String p_line) {
        Double l_Emissions_mtCO2e = 1.0;
        if (p_line.equals("0.00")) {
            l_Emissions_mtCO2e = 0.0;
        }
        return l_Emissions_mtCO2e;
    }
}
