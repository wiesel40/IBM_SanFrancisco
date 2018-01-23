
package sanfrancisogas;

import CO2Thread.CO2Thread;

/**
 *
 * Main start 
 */
public class SanFrancisoGas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         System.out.println("Service is running");
    new Thread(new CO2Thread()).start(); // create a CO2Thread
    }
    
}
