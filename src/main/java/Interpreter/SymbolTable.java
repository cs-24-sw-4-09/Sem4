package Interpreter;

import Interpreter.Nodes.*;
import java.util.*;

public class SymbolTable {
    private final Map<String, Symbol> hashmap = new HashMap<>();

    public void enterSymbol(String name, ASTNode value) {
        Symbol newSymbol = new Symbol(name, value);
        add(newSymbol);
    }


    public void add(Symbol symbol){
        System.out.println("Adding symbol: " + symbol.name + " to the symbol table");
        hashmap.put(symbol.name, symbol);
    }

    public ASTNode retrieveSymbol(String name){
        if (hashmap.containsKey(name)) {
            System.out.println("Retrieving symbol: " + name + " from the symbol table");
            return hashmap.get(name).value;
        } else {
            System.out.println("Symbol: " + name + " not found in the symbol table");
            return null;
        }
    }

    public ASTNode retrieveSymbolValue(String name){
        return hashmap.get(name).value;
    }

    // public ASTNode retrieveSymbolValue(Symbol symbol){
    //     System.out.println(symbol.value);
    //     return symbol.value;
    // }

    private class Symbol {
        private final String name;
        private final ASTNode value;

        private Symbol(String name, ASTNode value) {
            this.name = name;
            this.value = value;
        }
    }
  
}