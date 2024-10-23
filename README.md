# Chipyard for BOOM for CPRE581!

This is a forked version of Chipyard for working on the BOOM core for CPRE581 final project.

### How to use?
1. Clone this repo.
2. Build it following [Chipyard's docs](https://chipyard.readthedocs.io/en/latest/Chipyard-Basics/Initial-Repo-Setup.html)
3. Build BOOM for Verilator (the simulator):  
    1. cd into sims/verilator
    2. Run: `make CONFIG=MediumBoomV4Config` (There are other BOOM configs, checkout `<chipyard root>/generators/chipyard/src/main/scala/config/BoomConfigs.scala` for the list)
    3. BOOM! You now have BOOM for simulation!
