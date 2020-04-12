#!/usr/bin/ruby

def leerEntrada
    c = gets.chomp.to_i
    puts "Error en la entrada" unless c >= 0
end
