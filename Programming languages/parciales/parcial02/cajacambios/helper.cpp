#include "cambios.h"
#include <string>

using namespace std;
void traducirEstadoCambioACadena(EstadoCambio estado, string& str) {
    if (estado == neutra) {
      str = "neutra";
    } else if (estado == reversa) {
      str = "reversa";
    } else if (estado == primera) {
      str = "primera";
    } else if (estado == segunda) {
      str = "segunda";
    } else if (estado == tercera) {
      str = "tercera";
    } else if (estado == cuarta) {
      str = "cuarta";
    } else if (estado == quinta) {
      str = "quinta";
    }
}
