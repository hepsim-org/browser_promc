# ProMC Browser for the HepSim repository

A Java browser for MC events stored in the ProMCformat tuned to the HepSim repository.

The goal of this repository is to compile the file "browser_promc.jar".
You need to have updated file "lib/promc-protobuf.jar"  frome the ProMC project and the apache ant tool.
All dependensies are in the "lib" directory.

To build the jar file, type "ant". Then you can test this file on a ProMC file as:

```
java -cp browser_promc.jar hepsimproio.browser.Main [file] # shows GUI
java -cp browser_promc.jar hepsimproio.Info [file]
java -cp browser_promc.jar hepsimproio.Info [file] 10
```

Here are more examples:

```
# list files
java -cp browser_promc.jar  hepsim.Ls tev100_ttbar_mg5%rfast001
# (or)
java -cp browser_promc.jar  hepsim.Ls http://mc.hep.anl.gov/asc/hepsim/events/pp/100tev/ttbar_mg5

# get files
java -cp browser_promc.jar  hepsim.Get tev100_ttbar_mg5%rfast001
java -cp browser_promc.jar  hepsim.GetMirrors tev100_ttbar_mg5%rfast001
java -cp browser_promc.jar  hepsim.Get http://mc.hep.anl.gov/asc/hepsim/events/pp/100tev/ttbar_mg5
```

S.Chekanov (ANL)
