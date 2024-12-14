To run sbt scala tests, the following command must be issued from /generators/gemmini in order to deal with java versioning issue

sbt -Djava.security.manager=allow

^ Really we have no reason to run it from the gemmini directory anymore

from the chipyard root you can run

sbt 

project gemmini

clean
compile
test

To test specific tests

testOnly / gemmini.TypeTest


As an example; to make a test with viewable WAVs might look something like this

class MyModuleTest extends AnyFlatSpec with ChiselScalatestTester {
  "MyModule" should "do something" in {
    test(new MyModule).withAnnotations(Seq(WriteVcdAnnotation /*VerilatorBackendAnnotation allows us to simulate with verilator*/ )) { c =>
      c.io.in.poke(3.S)
      c.io.out.expect(4.S)
      // Treadle backend will automatically generate VCD if configured
      c.drawFramebuffer()  // Generates the waveform in VCD format
    }
  }
}

For the MeshWithDelaysUnitTest, the test call is a bit of a monster..

    test(new MeshWithDelays(inputType, spatialArrayOutputType, accType, (new LocalMeshTag).cloneType, dataflow, tree_reduce, tile_lat, output_lat, tileRows, tileColumns, meshRows, meshColumns, shifter_banks, shifter_banks)).withAnnotations(Seq(WriteVcdAnnotation)).runPeekPoke(new WSMeshWithDelaysUnitTest(_, Seq.fill(1)(MeshTesterInput(rand(meshColumns), identity(meshColumns), zero(meshColumns), true)), () => 0, verbose = true))

.runPeekPoke(new UnitTest(_)) allows us to call tester classes outside of our tester, we can write tests in a very java-like way, the mesh tests use several structures for inputting and outputting  matrix data 

To run the test we can run the following command from the chipyard directory

sbt "project gemmini" testOnly / gemmini.MeshWithDelaysTester

NOTE: MeshWithDelaysTester is the name of the tester class and not the file, you can also run specific tests within the tester such as SimpleMeshWithDelaysTester

To view the WAV files we can go to the directory

cd chipyard/test_run_dir/SimpleMeshWithDelaysTester_should_work

then run 

gtkwave MeshWithDelays.vcd (optionally append this with the argument waveformview.sav as this has a view of control signals already saved)


Software Test Commands Shortcut

./build.sh from chipyard/generators/gemmini/software/gemmini-rocc-tests

for spike 

./scripts/build-spike.sh from chipyard/generators/gemmini/

|`spike --extension=gemmini ~/chipyard/generators/gemmini/software/gemmini-rocc-tests/build/bareMetalC/MaMA_test-baremetal` | anywhere | Simulate our matmul gemmini 

|`./simulator-chipyard.harness-RocketCustomGemminiFor581Config ~/chipyard/generators/gemmini/software/gemmini-rocc-tests/build/bareMetalC/MaMA_test-baremetal` | `<chipyard>/sims/verilator` | This is to run test code |