## About

this repository contains implimentations of three different algorithms as assignment solutions for SVSU CS 316

## Contents

all code is written in java

1. Optimal Matrix Chain Multiplication
    - returns the optimal order to multiply a set of matricies, as well as the data tables used to compute said order.
    - located in [DAK/Matrix](DAK/Matrix/)
2. Longest Common Sub Sequence
    - Returns the longest common sub sequence between two strings
    - located in [DAK/LCSS](DAK/LCSS/)
3. Huffman Zip algorithm
    - returns the Huffman Encoding of a given string along with the compression ratio
    - located in [DAK/Huffman](DAK/Huffman/)
4. Cichellis Method Scratch Work
    - paper work computing Cichellis Method as an example
    - this is mostly included to be an example to anyone trying to research the subject :)
    - located in [hand_problems/prob4_perfect_hash.jpg](hand_problems/prob4_perfect_hash.jpg)
    
## Compilation

to compile all programs simply run the following command on a unix machine containing make utils, javac and java

```bash 
make build
```

## Running

Each program is built under the same name as the directory that it is stored under. Thus to run Huffman you would use the following command **from the root directory**.

```bash
java DAK/Huffman/Huffman
```

Alternativly to run each program one after another in the order listed in [contents](#contents) simply run

```bash
make run
```