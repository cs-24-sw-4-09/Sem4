package Interpreter;

import Interpreter.Nodes.*;
import java.util.*;

public class SymbolTable {
    private final Map<String, Symbol> hashmap = new HashMap<>();

    public void enterSymbol(String name, ASTNode value) {
        Symbol newSymbol = new Symbol(name, value);

        if (containsSymbol(newSymbol.name)) {
            delete(newSymbol.name);
        } 
        add(newSymbol);
    }


    public void add(Symbol symbol){
        hashmap.put(symbol.name, symbol);
    }

    public void delete(String name){
        hashmap.remove(name);
    }

    public ASTNode retrieveSymbol(String name){
        if (hashmap.containsKey(name)) {
            return hashmap.get(name).value;
        } else {
            return null;
        }
    }

    public ASTNode retrieveSymbolValue(String name){
        return hashmap.get(name).value;
    }
    
    public boolean containsSymbol(String name){
        return hashmap.containsKey(name);
    }

    private class Symbol {
        private final String name;
        private final ASTNode value;

        private Symbol(String name, ASTNode value) {
            this.name = name;
            this.value = value;
        }
    }
  
}