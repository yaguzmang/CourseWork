#include "automatizador.h"
#include "cambios.h"
AutomatizadorCambios::AutomatizadorCambios(CajaDeCambios caja): caja(caja) {}

AutomatizadorCambios::~AutomatizadorCambios() {}
void neutralizar();
void reversar();
void subir();
void bajar();
void AutomatizadorCambios::neutralizar() {
  if (caja.obtenerCambio() == reversa) {
    bajar();
  } else {
    if (caja.obtenerCambio() != neutra) {
      caja.establecerEmbr();
      caja.ponerNeutra();
      caja.liberarEmb();
    }
  }
}

void AutomatizadorCambios::reversar() {
  if (caja.obtenerCambio() != reversa) {
    if (caja.obtenerCambio() != neutra) {
      neutralizar();
    }
    caja.establecerEmbr();
    caja.ponerReversa();
    caja.liberarEmb();
  }
}

void AutomatizadorCambios::subir() {
    if (caja.obtenerCambio() == neutra) {
      caja.establecerEmbr();
      caja.ponerPrimera();
      caja.liberarEmb();
    } else if (caja.obtenerCambio() == primera) {
      caja.establecerEmbr();
      caja.ponerSegunda();
      caja.liberarEmb();
    } else if (caja.obtenerCambio() == segunda) {
      caja.establecerEmbr();
      caja.ponerTercera();
      caja.liberarEmb();
	} else if (caja.obtenerCambio() == tercera) {
        caja.establecerEmbr();
        caja.ponerCuarta();
        caja.liberarEmb();
      } else if (caja.obtenerCambio() == cuarta) {
        caja.establecerEmbr();
        caja.ponerQuinta();
        caja.liberarEmb();
      }
    }

    void AutomatizadorCambios::bajar() {
        if (caja.obtenerCambio() == reversa) {
          caja.establecerEmbr();
          caja.ponerNeutra();
          caja.liberarEmb();
        } else if (caja.obtenerCambio() == primera) {
		  neutralizar();
        } else if (caja.obtenerCambio() == segunda) {
          caja.establecerEmbr();
          caja.ponerPrimera();
          caja.liberarEmb();
		}else if (caja.obtenerCambio() == tercera) {
            caja.establecerEmbr();
            caja.ponerSegunda();
            caja.liberarEmb();
          } else if (caja.obtenerCambio() == cuarta) {
            caja.establecerEmbr();
            caja.ponerTercera();
            caja.liberarEmb();
          } else if (caja.obtenerCambio() == quinta) {
            caja.establecerEmbr();
            caja.ponerCuarta();
            caja.liberarEmb();
          }
        }
	
         EstadoCambio AutomatizadorCambios::obtenerCambio() const {
          return caja.obtenerCambio();
        }