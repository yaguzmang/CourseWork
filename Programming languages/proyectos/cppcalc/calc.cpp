#include <iostream>
#include <sstream>
#include <string>
#include <fstream>
#include "calcex.h"
#include "calculator.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdio.h>
using namespace std;

Calculator* calc;

int main(int argc, char* argv[], char* env[]){

    calc = new Calculator();
    bool compileEWE = false;
// Initialization of the header and footer
    string header = "# Automatically generated, do not edit\n   SP := 40000\n   ONE := 1\n   ZERO := 0\n   MONE := ZERO - ONE\n   MEMORY := 0\n# ARG variables\n";
    string footer = "   halt\n# Memory definition\nequ ZERO M[0]\nequ ONE M[1]\nequ R0 M[2]\nequ R1 M[3]\nequ SP M[4]\nequ MONE M[5]\nequ MEMORY M[6]\n";
    int countFiles = 0;
    bool envVarPref = false;
    bool fileFound[argc];
    bool argVar = false;
// Initialization process
    for (int i = 0; i < argc; ++i){
        fileFound[i] = false;
    }
    for (int i = 1; i < argc; ++i){
       if (strncmp(argv[i], "-c", 2)==0) {
           compileEWE = true;
       }else if(strncmp(argv[i], "-e", 2)==0){
            envVarPref = true;
       }else if(strncmp(argv[i], "-v", 2)==0){
             argVar = true;
       }else{
        string varStr = argv[i];
        if (varStr.find(".expr") != std::string::npos){
            countFiles++;
            fileFound[i] = true;
        }
        if (argVar){
            // Validation of a valid variable argument
            if(varStr.find("=") != std::string::npos){
                int equalsIndex = varStr.find_first_of('=');
                string key = varStr.substr(0, equalsIndex);
                string valueStr = varStr.substr(equalsIndex+1);
                int value = stoi(valueStr);
                calc->newVariable(key,value);
                // Initialization of command variables for the ewe compiler
                if(value < 0){
                    value *= -1;
                    valueStr = to_string(value);
                    header += "   "+key+" := "+valueStr+"\n   "+key+" := "+key+" * MONE\n";
                }else{
                    header += "   "+key+" := "+valueStr+"\n";
                }
            }
            argVar = false;
        }
       }
    }
// Initialization of ENV variables taking into account the preference criteria
    header += "# ENV variables\n";
    string var;
    if(envVarPref){
      for (int i = 0; env[i]!=NULL; i++)  {
          var = env[i];
          if((var.substr(0,7).compare("CALCVAR"))==0){
                string key = var.substr(7);
                int equalsIndex = key.find_first_of('=');
                string valueStr = key.substr(equalsIndex+1);
                key = key.substr(0,equalsIndex);
                int value = stoi(valueStr);
                calc->newVariable(key,value);
                // Initialization of ENV variables for the ewe compiler
                if(value < 0){
                    value *= -1;
                    valueStr = to_string(value);
                    header += "   "+key+" := "+valueStr+"\n   "+key+" := "+key+" * MONE\n";
                }else{
                    header += "   "+key+" := "+valueStr+"\n";
                }
          }
       }
    }else{
      for (int i = 0; env[i]!=NULL; i++)  {
          var = env[i];
          if((var.substr(0,7).compare("CALCVAR"))==0){
                string key = var.substr(7);
                int equalsIndex = key.find_first_of('=');
                string valueStr = key.substr(equalsIndex+1);
                key = key.substr(0,equalsIndex);
                int value = stoi(valueStr);
                if(!calc->exitsInMap(key)){
                    calc->newVariable(key,value);
                    // Initialization of ENV variables for the ewe compiler
                    if(value < 0){
                        value *= -1;
                        valueStr = to_string(value);
                        header += "   "+key+" := "+valueStr+"\n   "+key+" := "+key+" * MONE\n";
                    }else{
                        header += "   "+key+" := "+valueStr+"\n";
                    }
                }
          }
       }
    }
// Calc execution
    bool interactiveMode = true;
    if(countFiles > 0){
        interactiveMode = false;
    }
    if(interactiveMode == false){
        bool error = false;
        for (int i = 0; i < argc; ++i){
            string resultLines = "";
            string eweLines = "";
            if(fileFound[i]){
               //
              ifstream read(argv[i]);
              string line;
              while (getline(read, line)) {
                  try {
                      if (compileEWE) {
                        eweLines += calc->eweCompile(line);
                      }else{
                        int result = calc->eval(line);
                        resultLines = resultLines + "= " + to_string(result) + "\n";
                      }
                  }catch (Exception ex) {
                     if(ex == ParseError){
                         cout << "* parser error on file: " << argv[i] << endl;
                         error = true;
                         break;
                     }else if(ex == UnrecognizedToken){
                         cout << "* scanner error on file: " << argv[i] << endl;
                         error = true;
                         break;
                     }else{
                         cout << "* unknown error on file: " << argv[i] << endl;
                         error = true;
                         break;
                     }
                  }
              }
              if (!compileEWE){
                 if(!error){
                    cout << resultLines;
                 }
              }
              if(compileEWE){
                if(!error){
                    string filePath = argv[i];
                    filePath = filePath.substr(0,filePath.size()-4) + "ewe";
                    footer += calc->getMemoryKeysDefinition();
                    ofstream file;
                    file.open(filePath);
                    file << header << eweLines << footer;
                    file.close();
                }
              }
              read.close();
               // 
            }
            error = false;
        }
    }else{
     // Interactive mode
            string line;
            while (true) {
                try {
                    cout << "> ";
                    getline(cin, line);
                    if (line == "<eof>")
                        break;
                    if (!cin)
                        break;
                    int result = calc->eval(line);
                    cout << "= " << result << endl;
                }
                catch (Exception ex) {
                if(ex == ParseError){
                    cout << "* parser error" << endl;
                }else if(ex == UnrecognizedToken){
                    cout << "* scanner error" << endl;
                }else{
                    cout << "* unknown error" << endl;
                }
            }
         }
    }
    /*
    if (argc <= 1) {
        string line;
        while (true) {
            try {
                cout << "> ";
                getline(cin, line);
                if (line == "<eof>")
                    break;
                if (!cin)
                    break;
                // line + '\n';
                int result = calc->eval(line);
                cout << "= " << result << endl;
            }
            catch (Exception ex) {
            if(ex == ParseError){
                cout << "* parser error" << endl;
            }else if(ex == UnrecognizedToken){
                cout << "* scanner error" << endl;
            }else{
                cout << "* unknown error" << endl;
            }
        }
    }
}
    else {
        ifstream read(argv[1]);
        string line;
        while (getline(read, line)) {
            try {
                int result = calc->eval(line);
                cout << "= " << result << endl;
            }
            catch (Exception ex) {
                if(ex == ParseError){
                    cout << "* parser error" << endl;
                }else if(ex == UnrecognizedToken){
                    cout << "* scanner error" << endl;
                }else{
                    cout << "* unknown error" << endl;
                }
            }
        }
        read.close();
    }
    */
    delete calc;
}

