require 'set'

class BinaryNode
  attr_reader :left, :right

  def initialize(left,right)
    @left = left
    @right = right
  end
end

class UnaryNode
  attr_reader :subTree

  def initialize(subTree)
    @subTree = subTree
  end
end

class AddNode < BinaryNode
  def initialize(left, right)
    super(left,right)
  end

  def evaluate
    @left.evaluate + @right.evaluate
  end
  def eweCompile
    previousLines = @left.eweCompile + @right.eweCompile
  return previousLines + "# AddNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 + R1\n   M[SP + 0] := R0\n"
  end

end

class SubNode < BinaryNode
  def initialize(left, right)
    super(left,right)
  end

  def evaluate
    @left.evaluate - @right.evaluate
  end
  def eweCompile
  previousLines = @left.eweCompile + @right.eweCompile
  return previousLines + "# SubNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 - R1\n   M[SP + 0] := R0\n"
  end

end

class TimesNode < BinaryNode
  def initialize(left, right)
    super(left,right)
  end
  def evaluate
    @left.evaluate * @right.evaluate
  end
  def eweCompile
  previousLines = @left.eweCompile + @right.eweCompile
  return previousLines + "# TimesNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 * R1\n   M[SP + 0] := R0\n"
 end

end

class DivideNode < BinaryNode
  def initialize(left, right)
    super(left,right)
  end

  def evaluate
    @left.evaluate / @right.evaluate
  end

  def eweCompile
  previousLines = @left.eweCompile + @right.eweCompile
  return previousLines + "# DivideNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 / R1\n   M[SP + 0] := R0\n"
 end
end

class ModNode < BinaryNode
  def initialize(left, right)
    super(left,right)
  end

  def evaluate
    @left.evaluate % @right.evaluate
  end

  def eweCompile
  previousLines = @left.eweCompile + @right.eweCompile
  return previousLines + "# ModNode\n   R0 := M[SP + 1]\n   R1 := M[SP + 0]\n   SP := SP + ONE\n   R0 := R0 % R1\n   M[SP + 0] := R0\n"
  end

end

class NumNode
  def initialize(num)
    @num = num
  end

  def evaluate()
    return @num
  end

  def eweCompile
  return "# NumNode\n   SP := SP - ONE\n   R0 := #{@num.to_s}\n   M[SP + 0] := R0\n"
  end

end

class StoreNode < UnaryNode
  def initialize(sub)
    super(sub)
  end
  
  def evaluate
    $calc.memory = @subTree.evaluate
  end

  def eweCompile
    $calc.memory = @subTree.evaluate
    previousLines = @subTree.eweCompile
    return previousLines + "# StoreNode\n   MEMORY := M[SP + 0]\n"
  end

end

class RecallNode
  def evaluate
    $calc.memory
  end

  def eweCompile
     return "# RecallNode\n   SP := SP - ONE\n   M[SP + 0] := MEMORY\n"
  end

end

class CleanNode
  def evaluate
    $calc.memory=0
    $calc.memory
  end

  def eweCompile
      return "# CleanNode\n   MEMORY := ZERO\n   SP := SP - ONE\n   M[SP+0] := MEMORY\n"
  end

end

class PlusNode < UnaryNode
  def initialize(sub)
    super(sub)
  end
  def evaluate
    $calc.memory += subTree.evaluate
    $calc.memory
  end

  def eweCompile
   $calc.memory += subTree.evaluate
   previousLines = @subTree.eweCompile
   return previousLines + "# PlusNode\n   R0 := M[SP + 0]\n   MEMORY := MEMORY + R0\n   M[SP + 0] := MEMORY\n"
  end

end

class MinusNode < UnaryNode
  def initialize(sub)
    super(sub)
  end
  def evaluate
    $calc.memory -= subTree.evaluate
    $calc.memory
  end

  def eweCompile
   $calc.memory -= subTree.evaluate
   previousLines = @subTree.eweCompile
   return previousLines + "# MinusNode\n   R0 := M[SP + 0]\n   MEMORY := MEMORY - R0\n   M[SP + 0] := MEMORY\n"
  end

end

class AssignNode < UnaryNode
  def initialize(sub, k)
    super(sub)
    @key = k
  end

  def evaluate
    value=subTree.evaluate
    $calc.hashMap[@key] = value
  end

  def eweCompile
    value=subTree.evaluate
    $calc.hashMap[@key] = value
    previousLines = @subTree.eweCompile
    return previousLines + "# AssignNode\n   #{@key} := M[SP + 0]\n"
  end

end

class IdentifierNode
  def initialize(k)
    @key = k
  end
  def evaluate
  $calc.hashMap[@key]
  end

  def eweCompile
   if !$calc.hashMap.key?(@key) then
   $calc.hashMap[@key] = 0
   end
   value = $calc.hashMap[@key]
   return "# IdentifierNode\n   SP := SP - ONE\n   R0 := #{@key}\n   M[SP + 0] := R0\n"
  end
    
end
