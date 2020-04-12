
Gem::Specification.new do |s|
  s.name    = 'rubycalc'
  s.version = '0.1.0.3'
  s.date    = '2018-10-19'
  s.summary = 'Another calculator in ruby'
  s.description = 'An calculator implementation on ruby'
  s.author  = 'Kent D. Lee - Juan Francisco Cardona Mc - Yhoan Alejandro Guzman Garcia'
  s.email   = 'fcardona@eafit.edu.co'
  s.homepage = 'http://www1.eafit.edu.co/fcardona/cursos/st0244/rubycal'
  s.files    = ["lib/token.rb",
                "lib/scanner.rb",
                "lib/ast.rb",
                "lib/parser.rb",
                "lib/calculator.rb",
                "lib/calcex.rb"]
  s.license  = 'Artistic-2.0'
  s.executables << 'rubycalc'
end
