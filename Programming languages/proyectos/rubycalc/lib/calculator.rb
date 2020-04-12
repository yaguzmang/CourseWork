require 'parser'
require 'ast'

class Calculator
  attr_accessor :memory
  attr_accessor :hashMap
  attr_accessor :interactiveMode
  attr_accessor :compileEWE
  def initialize()
    @memory = 0
    @hashMap = Hash.new(0)
    @interactiveMode = true
    @compileEWE = false
  end

  def eval(expr)
    parser = Parser.new(StringIO.new(expr))
    ast = parser.parse()
    return ast.evaluate()
  end

  def eweCompile(expr)
    parser = Parser.new(StringIO.new(expr))
    ast = parser.parse()
    result = ast.eweCompile()
    return result+"# Print value produced\n   R0 := M[SP + 0]\n   SP := SP - ONE\n   writeInt(R0)\n"
  end

end
