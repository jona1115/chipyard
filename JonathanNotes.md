# My (Jonathan) notes:
> This is a centralized notes for myself and anyone else doing exactly what I am doing (modifying Gemmini for BOOM)

### Benchmark/test programs
As far as I can tell there are two places where you can find them:
- `<chipyard>/tests` folder (there is a README in there tell you how to compile)
- `$RISCV/riscv64-unknown-elf/share/riscv-tests/benchmarks/` folder (Note `$RISCV` is `<chipyard>/.conda-env/riscv-tools`)

This has a pretty cool animation: https://github.com/JD-14/MSU_SP23_EEGR463/blob/main/chipyardlab.md

./simulator-chipyard.harness-RocketGemminiFor581Config $RISCV/riscv64-unknown-elf/share/riscv-tests/benchmarks/vvadd.riscv