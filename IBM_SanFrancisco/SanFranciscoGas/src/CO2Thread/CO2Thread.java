
package CO2Thread;

import CSVCO2Filter.CO2FilterParameter;
import CSVCO2Filter.CSVCO2Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
Creats a CO2Thread
 */
public class CO2Thread  implements Runnable{

    @Override
    public void run() {
       {
    try
    {
        //current data 
      CSVCO2Parser l_parser = new CSVCO2Parser("C:\\Users\\wiesel40\\Documents\\NetBeansProjects\\SanFranciscoGas\\src\\GasFile\\San_Francisco_Municipal_Greenhouse_Gas_Inventory.csv");
      
      l_parser.readFile();
      
      /*
        Read File 
      */
      System.out.println("Reading is successful");
      ArrayList<CO2FilterParameter > l_list = l_parser.getCO2FilterParameter();
      for (int i = 0; i < l_list.size(); i++) {
        System.out.println("CSV line " + i);
        
        CO2FilterParameter  l_CSVParameter = (CO2FilterParameter)l_list.get(i);
        System.out.println("Department " + l_CSVParameter.getM_Department());
        System.out.println("Source_Type " + l_CSVParameter.getM_SourceType());
        System.out.println("Emissions_mtCO2e " + l_CSVParameter.getM_Emissions_mtCO2e());
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

}
