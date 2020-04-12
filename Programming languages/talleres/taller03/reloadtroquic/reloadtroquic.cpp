#include <iostream> 
#include <string.h>
  using namespace std;
int main() {
  int produced = 0;
  int countRight = 0;
  int countWrong = 0;
  char string[100];
  cin.getline(string, 100, '\n');
  char first;
  char second;
  int lowerC1 = 'a';
  int lowerC2 = 'z';
  int upperC1 = 'A';
  int upperC2 = 'Z';
  for (int i = 0; i < strlen(string) - 1; i = i + 2) {
    first = string[i];
    second = string[i + 1];
    if (((first >= upperC1 && first <= upperC2) && (second >= lowerC1 && second <= lowerC2)) ||
      ((first >= lowerC1 && first <= lowerC2) && (second >= upperC1 && second <= upperC2))) {
      countRight++;
    } else {
      countWrong++;
      cout << "Baldosa con patrón incorrecto en el índice: " << i << endl;
    }
    produced++;
  }
  cout << "Baldosas producidas: " << produced << "\n" << "Buenas: " << countRight << "\n" << "Malas: " << countWrong << endl;
  return 0;
}