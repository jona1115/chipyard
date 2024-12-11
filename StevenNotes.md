To run sbt scala tests, the following command must be issued from /generators/gemmini in order to deal with java versioning issue

sbt -Djava.security.manager=allow

from chipyard root you can run

sbt 

project gemmini

clean
compile
test

To test specific tests

testOnly / gemmini.TypeTest


Software Test Commands

|`spike --extension=gemmini ~/chipyard/generators/gemmini/software/gemmini-rocc-tests/build/bareMetalC/MaMA_test-baremetal` | anywhere | Simulate our matmul gemmini 

|`./simulator-chipyard.harness-RocketCustomGemminiFor581Config ~/chipyard/generators/gemmini/software/gemmini-rocc-tests/build/bareMetalC/MaMA_test-baremetal` | `<chipyard>/sims/verilator` | This is to run test code |