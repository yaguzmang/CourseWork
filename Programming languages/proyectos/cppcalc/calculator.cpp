#include "calculator.h"
#include "parser.h"
#include "ast.h"
#include <string>
#include <iostream>
#include <sstream>


Calculator::Calculator():
   memory(0)

{}

int Calculator::eval(string expr) {

   Parser* parser = new Parser(new istringstream(expr));
   
   AST* tree = parser->parse();
   
   int result = tree->evaluate();
   
   delete tree;
   
   delete parser;
   
   return result;
}

string Calculator::eweCompile(string expr) {

   Parser* parser = new Parser(new istringstream(expr));
   
   AST* tree = parser->parse();
   
   string result = tree->eweCompile();
   
   delete tree;
   
   delete parser;
   
   return result + "# Print value produced\n   R0 := M[SP + 0]\n   SP := SP - ONE\n   writeInt(R0)\n";
}

void Calculator::store(int val) {
   memory = val;
}

int Calculator::recall() {
   return memory;
}

int Calculator::getValue(string key){
	return hashMap[key];
}

bool Calculator::exitsInMap(string key) {
  auto iter = hashMap.find(key);
  if (iter != hashMap.end()) {
    return true;
  }
  return false;
}

void Calculator::newVariable(string key, int value){
	hashMap[key] = value;
}

string Calculator::getMemoryKeysDefinition() {
  int equPos = 7;
  string memoryDef;
  for(map<string, int>::iterator it = hashMap.begin(); it != hashMap.end(); ++it){
    memoryDef = memoryDef + "equ " + it->first + " M[" + to_string(equPos)+ "]\n";
    equPos++;
  }
  return memoryDef;
}