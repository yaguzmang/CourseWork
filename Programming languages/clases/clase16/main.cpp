#include "a.h"
#include <iostream>
using namespace std;

A global(123);

int
main(void){
  A unA, otroA(10);
  {
    A otroA(20);
  }
  cout << "unA.a=" << unA.getA()
       << endl;
  cout << "otroA.a=" << otroA.getA()
       << endl;
  return 0;
}
