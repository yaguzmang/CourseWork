#pragma once
enum EstadoCambio {
  neutra,
  primera,
  segunda,
  tercera,
  cuarta,
  quinta,
  reversa
};
enum Embrague {
  libre,
  montado
};
class CajaDeCambios {
  public:
    CajaDeCambios();
  ~CajaDeCambios();
  void establecerEmbr();
  void liberarEmb();
  void ponerPrimera();
  void ponerSegunda();
  void ponerTercera();
  void ponerCuarta();
  void ponerQuinta();
  void ponerReversa();
  void ponerNeutra();
  EstadoCambio obtenerCambio() const;
  private:
    EstadoCambio estado;
  Embrague embrague;
  bool cambioPuesto;
};