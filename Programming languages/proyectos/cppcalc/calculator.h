#pragma once

#include <string>
#include <map>
 
using namespace std;


class Calculator {
 public:
   Calculator();

   int eval(string expr);
   string eweCompile(string expr);
   void store(int val);
   int recall();
   int getValue(string key);
   bool exitsInMap(string key);
   void newVariable(string key, int value);
   string getMemoryKeysDefinition();
 private:
   int memory;
   map<string, int> hashMap;
};

extern Calculator* calc;



