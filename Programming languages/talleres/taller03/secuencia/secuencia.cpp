#include <iostream>
  using namespace std;
int
main() {
  int count = 0;
  float value;
  float times;
  float av = 0;
  cin >> times;
  while(times==0){
	  cout << "El factor no puede ser 0" << endl;
	  cin >> times;
  }
  cout << "times: " << times << endl;
  while (std::cin >> value) {
	   count++;
      if (value > av) {
        av = av + (value / times);
      } else {
        av = av + (value * times);
      }
      av = av/count;
      cout << "average: " << av << endl;
    }
  return 0;
}