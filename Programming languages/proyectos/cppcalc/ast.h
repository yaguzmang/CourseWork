#pragma once
#include <string>
using namespace std;

class AST {
 public:
   AST();
   virtual ~AST() = 0;
   virtual int evaluate() = 0;
   virtual string eweCompile() = 0;
};

class BinaryNode : public AST {
 public:
   BinaryNode(AST* left, AST* right);
   ~BinaryNode();

   AST* getLeftSubTree() const;
   AST* getRightSubTree() const;

 private:
   AST* leftTree;
   AST* rightTree;
};

class UnaryNode : public AST {
 public:
   UnaryNode(AST* sub);
   ~UnaryNode();

   AST* getSubTree() const;

 private:
   AST* subTree;
};

class AddNode : public BinaryNode {
 public:
   AddNode(AST* left, AST* right);
   
   int evaluate();
   string eweCompile();
};

class SubNode : public BinaryNode {
 public:
   SubNode(AST* left, AST* right);

   int evaluate();
   string eweCompile();
};

class TimesNode : public BinaryNode {
 public:
   TimesNode(AST* left, AST* right);

   int evaluate(); 
   string eweCompile();
};

class DivideNode : public BinaryNode {
 public:
   DivideNode(AST* left, AST* right);

   int evaluate();
   string eweCompile();
};

class ModNode : public BinaryNode {
 public:
  ModNode(AST* left, AST* right);

  int evaluate();
  string eweCompile();
};

class NumNode : public AST {
 public:
   NumNode(int n);

   int evaluate();
   string eweCompile();

 private:
   int val;
};

class StoreNode : public UnaryNode {
 public:
   StoreNode(AST* sub);
   ~StoreNode();
   int evaluate();
   string eweCompile();
};

class RecallNode : public AST {
 public:
   RecallNode();
   ~RecallNode();
   int evaluate();
   string eweCompile();
};

class PlusNode : public UnaryNode {
 public:
   PlusNode(AST* sub);
   ~PlusNode();
   int evaluate();
   string eweCompile();
};

class MinusNode : public UnaryNode {
 public:
   MinusNode(AST* sub);
   ~MinusNode();
   int evaluate();
   string eweCompile();
};

class AssignNode : public UnaryNode {
 public:
   AssignNode(AST* sub, string k);
   ~AssignNode();
   int evaluate();
   string eweCompile();
   private:
   string key;
};

class CleanNode : public AST {
 public:
   CleanNode();
   ~CleanNode();
   int evaluate();
   string eweCompile();
};

class IdentifierNode : public AST {
 public:
   IdentifierNode(string k);
   ~IdentifierNode();
   int evaluate();
   string eweCompile();
   private:
   string key;
};