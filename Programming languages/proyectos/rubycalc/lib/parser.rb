require 'ast'
require 'scanner'
require 'token'
require 'calcex'

class Parser
  def initialize(istream)
    @scan = Scanner.new istream
  end

  def parse
    prog
  end

  def prog
    result = expr
    t = @scan.getToken
    unless t.type == :eof
      #print "Expected EOF. Found ", t.type, ".\n"
      raise ParseError.new
    end
    result
  end

  def expr
    restExpr term
  end

  def restExpr(e)
    t = @scan.getToken
    case t.type
    when :add
      return restExpr(AddNode.new(e,term()))
    when :sub 
      return restExpr(SubNode.new(e,term()))
    end
    @scan.putBackToken
    e
  end

  def term
    restTerm storable
  end

  def restTerm(e)
    t = @scan.getToken
    case t.type
    when :times
      return restTerm(TimesNode.new(e,storable))
    when :divide
      return restTerm(DivideNode.new(e,storable))
    when :module
      return restTerm(ModNode.new(e,storable))
    end
    @scan.putBackToken
    e
  end

  def storable
    f = factor
    t = @scan.getToken
    if t.type == :keyword
      if t.lex == "S"
        return StoreNode.new f
      elsif t.lex == "P"
        return PlusNode.new f
      elsif t.lex == "M"
        return MinusNode.new f
      else
        #print "* parser error\n"
        raise ParseError.new
      end
    end
    @scan.putBackToken
    f
  end

  def factor
    t = @scan.getToken
    case t.type
    when :identifier
      key = t.lex.to_s
      return IdentifierNode.new(key)
    when :number 
      val = t.lex.to_i
      return NumNode.new(val)
    when :keyword
      if t.lex == "R"
         return RecallNode.new
      elsif t.lex == "C"
         return CleanNode.new
      elsif t.lex == "let"
         t = @scan.getToken
         unless t.type == :identifier
            #print "* parser error\n"
            raise ParseError.new
         end
         key = t.lex.to_s
         t = @scan.getToken
         unless t.type == :equals
            #print "* parser error\n"
            raise ParseError.new
         end     
         e = expr
         return AssignNode.new(e,key)
      else
        #print "* parser error\n"
        raise ParseError.new
      end
    when :lparen    
      e = expr
      t = @scan.getToken
      unless t.type == :rparent
        #print "* parser error\n"
        raise ParseError.new
      end
      return e
    else
      #print "* parser error\n"
      raise ParseError.new
    end
  end
  
end
