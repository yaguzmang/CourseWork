#include<iostream>
using namespace std;

int main(void) {
  int c;
  int v = 0;
  while (std::cin >> c) {
    if (c > v) {
      cout << "+" << endl;
    } else if (c < v) {
      cout << "-" << endl;
    } else {
      cout << "=" << endl;
    }
    v = c;
    std::cout << c << std::endl;
  }
  return 0;
}

