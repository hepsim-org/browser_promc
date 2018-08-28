package hepsim;


import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
import java.nio.file.*;
import proto.*;
import promc.io.*;


/**

 Extract logfile.

@author S.Chekanov (ANL)

**/

public class Log {



        public static void main (String[] args) {

                if (args.length > 0) {

                String surl = args[0].trim();
                FileMC promc = new  FileMC(surl,"r"); 

                 int nevent=-1;
                 if (args.length == 2) {
                        System.out.println("HepSim: Look at event "+args[1].trim());
                        try  {
                          nevent = Integer.parseInt(args[1])-1;
                        } catch (NumberFormatException e) {
                           HepSim.ErrorMessage("Error: Cannot parse event number. It is not integer number! Exit!");
                           promc.close();
                           System.exit(1);
                        }
                }



                long    version=promc.getVersion();
                String decription=promc.getDescription();
                long nev1=promc.getNEntries();
                long nev2=promc.getEvents();
                if (nev1 != nev2) {
                      HepSim.ErrorMessage("There is a problem with this file: inconsistent number of entries. The file was truncated!");
                      promc.close();
                      System.exit(1);
                }

                if (nevent>nev1){
                  HepSim.ErrorMessage("The total number of events "+Long.toString(nev1)+" is less than "+Long.toString(nevent));
                  promc.close();
                  System.exit(1);
                }

                 System.out.println(promc.readLogfile());

                 promc.close();

                 } else {
                        HepSim.ErrorMessage("Usage: It takes 1 argument:  ProMC file location (or its URL)");
                        System.exit(1);
                }


  }

}
