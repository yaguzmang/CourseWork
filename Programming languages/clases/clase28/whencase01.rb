#!/usr/bin/ruby

def verificarTipo(valor)
  case valor
  when 10
    puts "diez"
  when "hola"
    puts "hola"
  when true
    puts "verdadero"
  else
    puts "no coincidence"
  end
end
