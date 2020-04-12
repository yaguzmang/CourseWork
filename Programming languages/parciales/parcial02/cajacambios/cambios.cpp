#include "cambios.h"

CajaDeCambios::CajaDeCambios(): estado(neutra), embrague(libre), cambioPuesto(false) {}

CajaDeCambios::~CajaDeCambios() {}

void CajaDeCambios::establecerEmbr() {
  if (embrague == libre) {
    embrague = montado;
  }
}

void CajaDeCambios::liberarEmb() {
  if (cambioPuesto) {
    embrague = libre;
    cambioPuesto = false;
  }
}

void CajaDeCambios::ponerPrimera() {
  if (embrague == montado) {
    estado = primera;
  }
}

void CajaDeCambios::ponerSegunda() {
  if (embrague == montado) {
    estado = segunda;
  }
}

void CajaDeCambios::ponerTercera() {
  if (embrague == montado) {
    estado = tercera;
  }
}

void CajaDeCambios::ponerCuarta() {
  if (embrague == montado) {
    estado = cuarta;
  }
}

void CajaDeCambios::ponerQuinta() {
  if (embrague == montado) {
    estado = quinta;
  }
}

void CajaDeCambios::ponerReversa() {
  if (embrague == montado) {
    estado = reversa;
  }
}

void CajaDeCambios::ponerNeutra() {
  if (embrague == montado) {
    estado = neutra;
  }
}
EstadoCambio CajaDeCambios::obtenerCambio() const {
  return estado;
}