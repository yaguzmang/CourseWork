#pragma once
#include "cambios.h"

class AutomatizadorCambios {
  public:
  AutomatizadorCambios(CajaDeCambios);
  ~AutomatizadorCambios();
  void neutralizar();
  void reversar();
  void subir();
  void bajar();	
  EstadoCambio obtenerCambio() const;
  private:
  CajaDeCambios caja;
};