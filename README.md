# Chipyard for BOOM for CPRE581!

This is a forked version of Chipyard for working on the BOOM core for CPRE581 final project.

### How to use?
1. Clone this repo.
2. Build it following [Chipyard's docs](https://chipyard.readthedocs.io/en/latest/Chipyard-Basics/Initial-Repo-Setup.html)
3. You need to source the start-up script everytime: `source env.sh`
4. Build BOOM for Verilator (the simulator):  
    1. cd into sims/verilator
    2. Run: `make CONFIG=MediumBoomV4Config` (There are other BOOM configs, checkout `<chipyard root>/generators/chipyard/src/main/scala/config/BoomConfigs.scala` for the list)
    3. BOOM! You now have BOOM for simulation! Now you can:  
        1. Run one of the riscv-tools assembly tests: `./simulator-chipyard.harness-MediumBoomV4Config $RISCV/riscv64-unknown-elf/share/riscv-tests/isa/rv64ui-p-simple`
        2. Run simulations, see the [Chipyard Docs](https://chipyard.readthedocs.io/en/latest/Simulation/Software-RTL-Simulation.html#sw-rtl-sim-intro) for more details.

### Links to submodules also forked by our team:
- BOOM: [https://github.com/jona1115/riscv-boom](https://github.com/jona1115/riscv-boom)
