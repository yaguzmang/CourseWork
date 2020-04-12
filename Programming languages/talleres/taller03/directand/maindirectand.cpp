#include "directand.h"

int main(){
  int a = 10000;
  int b = 20000;
  int c;
  int e;
  int d;
  cin >> c >> d >> e;
  if(directAnd(((a = c - d)>0),((b = d - e)>0))){
    cout << "a y b son mayores que cero" << endl;
  }
  cout << "a: " << a
       << "b: " << b
       << endl;
  
    return 0;
}

