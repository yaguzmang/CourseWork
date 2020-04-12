#include "directand.h"

bool directAnd (int leftExpr, int rightExpr){
  if(leftExpr != 0){
    if(rightExpr != 0){
      return true;
    }
  }
  return false;
}
