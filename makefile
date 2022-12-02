default: build
	echo '[*] program compiled sucessfully'
	echo
debug: remake run
	echo '[*] debug finished'
	echo
remake: clean build
	echo '[*] finished remake'
	echo
run: build
	echo '[*] Running Optimal Matrix Chain'
	java DAK/Matrix/Matrix

	echo '[*] Running Longest Common Sub Sequence'	
	java DAK/LCSS/LCSS

	echo '[*] Running Huffman Zip Example'	
	java DAK/Huffman/Huffman

build:
	find . -name \*.java > to_build.txt
	javac @to_build.txt
clean:
	find . -name \*.class -delete
	rm to_build.txt