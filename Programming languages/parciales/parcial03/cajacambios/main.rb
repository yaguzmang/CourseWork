#!/usr/bin/ruby
require "./automatizador.rb"
require "./helper.rb"
require "./cambios.rb"

def hacerOperacion(automatizador, operacion)
  case operacion
  when "subir"
    automatizador.subir
  when "bajar"
    automatizador.bajar
  when "neutralizar"
    automatizador.neutralizar
  when "reversar"
    automatizador.reversar
  end
end

# Main

cajas = [CajaDeCambios.new, CajaDeCambios.new, CajaDeCambios.new]

automatizador = [AutomatizadorCambios.new(cajas[0]), AutomatizadorCambios.new(cajas[1]), AutomatizadorCambios.new(cajas[2])]

until STDIN.eof?
  linea = STDIN.gets.chomp
  is,operacion = linea.split(" ")

  i = is.to_i
  hacerOperacion(automatizador[i], operacion)
  puts "Caja: #{i} #{traducirEstadoCambioACadena(automatizador[i].obtenerCambio)}"
end
