#include <iostream>
#include <limits>
//#include <tresMayor.h>
using namespace std;
int leerEnteroCorrecto();
int tresMayor(int,int,int);

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

int tresMayor(int a, int b, int c){
  if(a >= b && a >= c){
    return a;
  } else if(b >= a && b >= c){
    return b;
  } else {
    return c;
  }
}

int
main (void){
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
