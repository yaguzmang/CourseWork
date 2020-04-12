#include "tresMayor.h"
#include <iostream>
#include <limits>
using namespace std;
int leerEnteroCorrecto(){
  int a;
  cin >> a;
  while (cin.fail()){
    cin.clear();
    cin.ignore(numeric_limits< streamsize >::max(),'\n');
    cin >> a;
  }
  return a;
}
int main (void){
  int a;
  cout << "leer a" << endl;
  a = leerEnteroCorrecto();
  int b;
  cout << "leer b" << endl;
  b = leerEnteroCorrecto();
  int c;
  cout << "leer c" << endl;
  c = leerEnteroCorrecto();
  int mayor = tresMayor(a, b, c);
  cout << "El mayor es: " << mayor
       << endl;
  return 0;
}