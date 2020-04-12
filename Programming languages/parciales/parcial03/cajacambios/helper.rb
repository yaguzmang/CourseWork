
def traducirEstadoCambioACadena(estado)
	if (estado == :neutra) 
      "neutra"
     elsif (estado == :reversa) 
      "reversa"
     elsif (estado == :primera) 
      "primera"
     elsif (estado == :segunda) 
      "segunda"
     elsif (estado == :tercera) 
      "tercera"
     elsif (estado == :cuarta) 
      "cuarta"
     elsif (estado == :quinta) 
      "quinta"
	end
end
#puts traducirEstadoCambioACadena(:neutra) 