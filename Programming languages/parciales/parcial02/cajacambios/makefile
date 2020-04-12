all: cajacambios
cajacambios: main.o cambios.o helper.o automatizador.o
	$(CXX) -o $@ $^

main.o: main.cpp cambios.h  helper.h automatizador.h

cambios.o: cambios.cpp cambios.h

helper.o: helper.cpp helper.h cambios.h

automatizador.o: automatizador.cpp automatizador.h cambios.h