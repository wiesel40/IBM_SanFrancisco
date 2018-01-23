/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanfrancisogas;

import CO2Thread.CO2Thread;

/**
 *
 * @author Alexander
 */
public class SanFrancisoGas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         System.out.println("Service is running");
    new Thread(new CO2Thread()).start();
    }
    
}
