// Author: Jonathan, Steve

// I think this is how you do it, read: https://chipyard.readthedocs.io/en/latest/Customization/Heterogeneous-SoCs.html

package chipyard

import org.chipsalliance.cde.config.{Config}

class BoomGemminiFor581Config extends Config(
  new gemmini.DefaultGemminiConfig ++                       // use Gemmini systolic array GEMM accelerator
  new boom.v4.common.WithNMediumBooms(1) ++                 // medium boom config (Compiler doesn't like this)
  // new freechips.rocketchip.rocket.WithNHugeCores(1) ++      // Huge rocket core (works but not what we want)
  new chipyard.config.WithSystemBusWidth(128) ++            // Add the bus?
  new chipyard.config.AbstractConfig)                       // I think all of them has this line at the end

class RocketGemminiFor581Config extends Config(
  new gemmini.DefaultGemminiConfig ++                       // use Gemmini systolic array GEMM accelerator
  new freechips.rocketchip.rocket.WithNHugeCores(1) ++      // Huge rocket core (works but not what we want)
  new chipyard.config.WithSystemBusWidth(128) ++            // Add the bus?
  new chipyard.config.AbstractConfig)                       // I think all of them has this line at the end


class BoomCustomGemminiFor581Config extends Config(
  //new chipyard.config.WithMultiRoCC ++
  new rerocc.WithReRoCC ++
  new gemmini.GemminiCustomConfig ++
  new boom.v4.common.WithNLargeBooms(1) ++
  new chipyard.config.WithSystemBusWidth(128) ++
  new chipyard.config.AbstractConfig)


class RocketCustomGemminiFor581Config extends Config(
  new gemmini.GemminiCustomConfig ++                       // use Gemmini systolic array GEMM accelerator
  //new boom.v4.common.WithNMediumBooms(1) ++                 // medium boom config (Compiler doesn't like this)
  new freechips.rocketchip.rocket.WithNHugeCores(1) ++      // Huge rocket core (works but not what we want)
  new chipyard.config.WithSystemBusWidth(128) ++            // Add the bus?
  new chipyard.config.AbstractConfig)                       // I think all of them has this line at the end