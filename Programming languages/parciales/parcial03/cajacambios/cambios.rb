
class CajaDeCambios
	def initialize
		@estado = :neutra
		@embrague = :libre
		@cambio_puesto = false
	end
	def establecerEmb
	  if @embrague == :libre
    	@embrague = :montado
      end
	end
	def liberarEmb
	  if @cambioPuesto
   		@embrague == :libre
        @cambioPuesto = false
   	  end
	end
		def ponerNeutra
		if @embrague == :montado 
    	@estado = :neutra
		end
	end

	def ponerPrimera
		if @embrague == :montado 
    	@estado = :primera
		end
	end
	def ponerSegunda
		if @embrague == :montado
			@estado = :segunda
		end
	end
	def ponerTercera
		if @embrague == :montado
			@estado = :tercera
		end
	end
	def ponerCuarta
		if @embrague == :montado
			@estado = :cuarta
		end
	end
	def ponerQuinta
		if @embrague == :montado
			@estado = :quinta
		end
	end
	def ponerReversa
		if @embrague == :montado
			@estado = :reversa
		end
	end
	def obtenerCambio
		@estado
	end
end
