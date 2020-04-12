
class AutomatizadorCambios
	def initialize(caja)
		@caja = caja
	end
	def neutralizar
		if @caja.obtenerCambio == :reversa
			bajar
		elsif @caja.obtenerCambio != :neutra
			 @caja.establecerEmb
     		 @caja.ponerNeutra
   		     @caja.liberarEmb
		end
	end
	def reversar
		if @caja.obtenerCambio != :reversa 
    		if @caja.obtenerCambio != :neutra
     		 neutralizar
     		end
		     @caja.establecerEmb
   			 @caja.ponerReversa
   			 @caja.liberarEmb
   		end
  end

	def subir
		if @caja.obtenerCambio == :neutra
	    @caja.establecerEmb
        @caja.ponerPrimera
        @caja.liberarEmb
        elsif (@caja.obtenerCambio == :primera) 
        @caja.establecerEmb
        @caja.ponerSegunda
        @caja.liberarEmb
        elsif (@caja.obtenerCambio == :segunda)
        @caja.establecerEmb
        @caja.ponerTercera
        @caja.liberarEmb
	    elsif (@caja.obtenerCambio == :tercera) 
        @caja.establecerEmb
        @caja.ponerCuarta
        @caja.liberarEmb
        elsif (@caja.obtenerCambio == :cuarta) 
        @caja.establecerEmb
        @caja.ponerQuinta
        @caja.liberarEmb
      end
  end
  def bajar 
        if (@caja.obtenerCambio == :reversa) 
          @caja.establecerEmb
          @caja.ponerNeutra
          @caja.liberarEmb
        elsif (@caja.obtenerCambio == :primera) 
		  neutralizar
        elsif (@caja.obtenerCambio == :segunda) 
          @caja.establecerEmb
          @caja.ponerPrimera
          @caja.liberarEmb
		elsif (@caja.obtenerCambio == :tercera) 
            @caja.establecerEmb
            @caja.ponerSegunda
            @caja.liberarEmb
          elsif (@caja.obtenerCambio == :cuarta) 
            @caja.establecerEmb
            @caja.ponerTercera
            @caja.liberarEmb
          elsif (@caja.obtenerCambio == :quinta) 
            @caja.establecerEmb
            @caja.ponerCuarta
            @caja.liberarEmb
          end
   end
   def obtenerCambio
   	@caja.obtenerCambio
   end
end
