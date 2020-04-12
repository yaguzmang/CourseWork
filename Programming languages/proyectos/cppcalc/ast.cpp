#include "ast.h"
#include <iostream>
#include "calculator.h"
#include <string>

// for debug information uncomment
//#define debug

AST::AST() {}

AST::~AST() {}

BinaryNode::BinaryNode(AST* left, AST* right):
   AST(),
   leftTree(left),
   rightTree(right)
{}

BinaryNode::~BinaryNode() {
#ifdef debug
   cout << "In BinaryNode destructor" << endl;
#endif

   try {
      delete leftTree;
   } catch (...) {}

   try {
      delete rightTree;
   } catch(...) {}
}
   
AST* BinaryNode::getLeftSubTree() const {
   return leftTree;
}

AST* BinaryNode::getRightSubTree() const {
   return rightTree;
}

UnaryNode::UnaryNode(AST* sub):
   AST(),
   subTree(sub)
{}

UnaryNode::~UnaryNode() {
#ifdef debug
   cout << "In UnaryNode destructor" << endl;
#endif

   try {
      delete subTree;
   } catch (...) {}
}
   
AST* UnaryNode::getSubTree() const {
   return subTree;
}

AddNode::AddNode(AST* left, AST* right):
   BinaryNode(left,right)
{}

int AddNode::evaluate() {
   return getLeftSubTree()->evaluate() + getRightSubTree()->evaluate();
}

string AddNode::eweCompile() {
   string previousLines = getLeftSubTree()->eweCompile() + getRightSubTree()->eweCompile();
   return previousLines +  "# AddNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 + R1\n   M[SP + 0] := R0\n";
}

SubNode::SubNode(AST* left, AST* right):
   BinaryNode(left,right)
{}

int SubNode::evaluate() {
   return getLeftSubTree()->evaluate() - getRightSubTree()->evaluate();
}

string SubNode::eweCompile() {
   string previousLines = getLeftSubTree()->eweCompile() + getRightSubTree()->eweCompile();
   return previousLines + "# SubNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 - R1\n   M[SP + 0] := R0\n";
}

TimesNode::TimesNode(AST* left, AST* right):
  BinaryNode(left, right)
{}

int TimesNode::evaluate() {
   return getLeftSubTree()->evaluate() * getRightSubTree()->evaluate();
}
string
 TimesNode::eweCompile() {
   string previousLines = getLeftSubTree()->eweCompile() + getRightSubTree()->eweCompile();
   return previousLines + "# TimesNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 * R1\n   M[SP + 0] := R0\n";
}

DivideNode::DivideNode(AST* left, AST* right):
  BinaryNode(left, right)
{}

int DivideNode::evaluate() {
   return getLeftSubTree()->evaluate() / getRightSubTree()->evaluate();
}

string DivideNode::eweCompile() {
   string previousLines = getLeftSubTree()->eweCompile() + getRightSubTree()->eweCompile();
   return previousLines + "# DivideNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 / R1\n   M[SP + 0] := R0\n";
}


ModNode::ModNode(AST* left, AST* right):
  BinaryNode(left, right)
{}

int ModNode::evaluate() {
   return getLeftSubTree()->evaluate() % getRightSubTree()->evaluate();
}

string ModNode::eweCompile() {
   string previousLines = getLeftSubTree()->eweCompile() + getRightSubTree()->eweCompile();
   return previousLines + "# ModNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 % R1\n   M[SP + 0] := R0\n";
}

NumNode::NumNode(int n) :
   AST(),
   val(n)
{}

int NumNode::evaluate() {
   return val;
}

string NumNode::eweCompile() {
   std::string valStr = std::to_string(val);
  return "# NumNode\n   SP := SP - ONE\n   R0 := "+valStr+"\n   M[SP + 0] := R0\n";
}


StoreNode::StoreNode(AST* sub):
  UnaryNode(sub) {}

StoreNode::~StoreNode() {}

int StoreNode::evaluate() {
  int result = getSubTree()->evaluate();
  calc->store(result);

  return result;
}

string StoreNode::eweCompile() {
  int result = getSubTree()->evaluate();
  calc->store(result);
  string previousLines = getSubTree()->eweCompile();
    return previousLines + "# StoreNode\n   MEMORY := M[SP + 0]\n";
}


RecallNode::RecallNode(): AST() {}

RecallNode::~RecallNode(){}

int RecallNode::evaluate(){
  return calc->recall();
}

string RecallNode::eweCompile() {
  return "# RecallNode\n   SP := SP - ONE\n   M[SP + 0] := MEMORY\n";
}


PlusNode::PlusNode(AST* sub):
  UnaryNode(sub) {}

PlusNode::~PlusNode() {}

int PlusNode::evaluate() {
  int result = getSubTree()->evaluate();
  int recall = calc->recall();
  calc->store(result + recall);
  return result + recall;
}

string PlusNode::eweCompile() {
  int result = getSubTree()->evaluate();
  int recall = calc->recall();
  result = result + recall;
  calc->store(result);
  string previousLines = getSubTree()->eweCompile();
  return previousLines + "# PlusNode\n   R0 := M[SP + 0]\n   MEMORY := MEMORY + R0\n   M[SP + 0] := MEMORY\n";
}


MinusNode::MinusNode(AST* sub):
  UnaryNode(sub) {}

MinusNode::~MinusNode() {}

int MinusNode::evaluate() {
  int result = getSubTree()->evaluate();
  int recall = calc->recall();
  calc->store(recall - result);
  return recall - result;
}

string MinusNode::eweCompile() {
  int result = getSubTree()->evaluate();
  int recall = calc->recall();
  result = recall - result;
  calc->store(result);
  string previousLines = getSubTree()->eweCompile();
  return previousLines + "# MinusNode\n   R0 := M[SP + 0]\n   MEMORY := MEMORY - R0\n   M[SP + 0] := MEMORY\n";
}

CleanNode::CleanNode(): AST() {}

CleanNode::~CleanNode(){}

int CleanNode::evaluate(){
  calc->store(0);
  return 0;
}

string CleanNode::eweCompile() {
  return "# CleanNode\n   MEMORY := ZERO\n   SP := SP - ONE\n   M[SP+0] := MEMORY\n";
}

AssignNode::AssignNode(AST* sub, string k): 
UnaryNode(sub),
key(k) {}

AssignNode::~AssignNode() {}

int AssignNode::evaluate() {
  int value = getSubTree()->evaluate();
  calc->newVariable(key, value);
  return value;
}

string AssignNode::eweCompile() {
  int value = getSubTree()->evaluate();
  calc->newVariable(key, value);
  string previousLines = getSubTree()->eweCompile();
  return previousLines + "# AssignNode\n   "+key+" := M[SP + 0]\n";
}

IdentifierNode::IdentifierNode(string k):    
AST(),
key(k) {}

IdentifierNode::~IdentifierNode() {}

int IdentifierNode::evaluate() {
  int result = calc->getValue(key);
  return result;
}

string IdentifierNode::eweCompile() {
  if(!calc->exitsInMap(key)){
    calc->newVariable(key, 0);
  }
  return "# IdentifierNode\n   SP := SP - ONE\n   R0 := "+key+"\n   M[SP + 0] := R0\n";
}

