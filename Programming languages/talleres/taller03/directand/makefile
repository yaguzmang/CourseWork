all: maindirectand

maindirectand: maindirectand.o directand.o
	$(CXX) -o $@ $^

maindirectand.o: maindirectand.cpp directand.h

directand.o: directand.cpp directand.h