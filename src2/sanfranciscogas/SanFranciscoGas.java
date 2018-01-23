
package sanfranciscogas;

import CO2Thread.CO2Thread;


public class SanFranciscoGas {
    
    public static void main(String[] args) {
         System.out.println("Service is running");
    new Thread(new CO2Thread()).start();
    }
    
}
