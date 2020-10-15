# Hand-Coded Lexer

A simple java implementation of a Lexer in pure Java.

## Build  

### Requirements

- Java 11
- Maven

### IntelliJ Configuratiom

This project is provided with an *IntelliJ Configuration:* 

> To run it just import it as a *Maven project* and click *Run*

### Maven Build

Alternatively you can compile manually typing: 

> mvn package

The *jar* file will be placed under the *target/* directory.  
To run the `Tester` main function, type:

> java -cp target/Lexer-Crisci-Cuccurullo-1.0-SNAPSHOT.jar lexer.com.compiler.Tester FILEPATH

## Structure

In this section it will be described which symbols the Lexer object can recognize and its class structure.

### Lexemes

This Lexer implementation recognizes the following Tokens:  
- *Delimiters*
- *Keywords*
- *Identifiers*
- *Literals*
- *Separators (like brackets, colon etc.)*
- *Operators* 

</br> 

### Regular definitions
 In the following one can find the regular definition of each Token. Each component of the Lexical Analyzer behaves just as the respective Finite State Machines provided after every regular definition.   
  
</br>

- Identifiers: *([a-zA-Z])+[a-zA-Z0-9]**
  <details>
  <summary>ID Finite State Machine</summary>
  <img src="./img/ID_DFA.svg" width="60%" height="60%"/> </br>
  </details>
  <br>
- Literals:
    - *INT:* (([1-9]+[0-9]\*)|0)
    - *FLOAT:* INT(\.[0-9]+) 
  <details>
  <summary>LIT Finite State Machine</summary>
  <img src="./img/NUM_DFA.svg" width="60%" height="60%"/> </br>
  </details>
  </br>
  
- Strings:
    - *STR:* *"[^"]"*
  <details>
  <summary>STR Finite State Machine</summary>
  <img src="./img/STR_DFA.svg" width="60%" height="60%"/> </br>
  </details>
  </br>
- Operators:  
  - Assignment: 
    - *AS*: *<--*
  
- Binary operators
    - *GT*: *>* 
    - *GEQ*: *>=*
    - *LT*: *<*
    - *LEQ*: *<=*
    - *EQ*: *=*
    - *DIF*: *!=*
  
- Arithmetic operators  
    - *PLUS*: *+*
    - *SUB*: *-*
    - *MUL*: *
    - *DIV*: *\/*
    - *MOD*: *%*
    - *POW*: *^*

- Logical operators
    - *AND*: *&&*
    - *OR*: *||*
    - *NOT*: *!*
  <details>
  <summary>OP Finite State Machine</summary>
  <img src="./img/OP_DFA.svg" width="70%" height="70%"/> </br>
  </details>    
  </br>

- Separators:
  - *L_PAR*: *(*
  - *R_PAR*: *)*
  - *L_CUR*: *{*
  - *R_CUR*: *}*
  - *COM*: *,*
  - *S_COM*: *;*
  

  <details>
  <summary>SEP Finite State Machine</summary>
  <img src="./img/SEP_DFA.svg" width="50%" height="50%"/> </br>
  </details>  
  </br>

### Class Structure
  
In accord with a classic Lexer structure, a `Lexer` class has been defined. It wraps a `ByteBuffer` object referring to the source code target file.  
The only exposed method is `getToken()`, which reads enough characters from the buffer in order to recognize a `Token` object and return it to the caller.  

Every *lexeme* in this example language is identified by a `LexemeAnalyzer` object. Each one of these is a specialization of the `AbstractLexemeAnalyzer` class. An analyzer exposes a method `check(ByteBuffer)`, which detects whether (or not) the next characters read in the buffer correspond to the lexeme that it represents.
It returns a `RecognizedToken` object, which is a *data structure* composed of a `Token` and an `int numCharRead` representing the lexeme lenght.

> The value `numCharRead` is used to define the priorities among the tokens: when a literal matches 2 or more patterns, the longest one is chosen. When 2 or more recognized tokens have the same lenght, the most significant Token in the language specification in chosen.

The `Lexer` object uses a support structure `StringTable`, which is a simple redenomination for a `HashMap<Integer,String>`. This structure holds a single copy for each *identifier* string found during the analysis phase, whose position in the structure is saved in the `attribute` field of `Token` object.  

> For example, if a string *"variable"* is found and saved in the `StringTable` at position 0, a `Token`  *<ID,0>* will be returned to the caller.

Two causes of failure have been dealt with during the lexical analysis: 
- firstly, the character sequence that has been analyzed does not match any of the patterns, in which case an `ERROR` Token object is returned to the caller;
- secondly, at the very end of the analysis, the Buffer object on which the Lexer is operating will be empty and a static `EMPTY TOKEN` object is returned to the caller. This will prevent infinite loops and the whole process will terminate.

## Authors
- *Luigi Crisci*
- *Alessio Cuccurullo*