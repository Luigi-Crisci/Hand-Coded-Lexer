# Hand-Coded Lexer

This is a simple java implementation of a Lexer.

## Structure

In this section we'll describe what symbols our lexer can recognize and the class structure we have chosen.

### Lexemes

For our lexer we have considered the following tokens:  
- *Delimiters*
- *Keywords*
- *Identifiers*
- *Literals*
- *Separators (like brackets, colon etc.)*
- *Operators* 

For some of this, we have defined some simple regex: 

- Identifiers: *([a-zA-Z])+[a-zA-Z0-9]**
- Literals:
    - *INT:* (([1-9]+[0-9]\*)|0)
    - *FLOAT:* INT(\.[0-9]+) 
- Operators: 
    - *AS*: *<--*
    - *EQ*: *=*
    - *GT*: *>* 
    - *GEQ*: *>=*
    - *LT*: *<*
    - *LEQ*: *<=*
    - *DIF*: *!=*
    - *PLUS*: *+*
    - *SUB*: *-*
    - *MUL*: *
    - *DIV*: *\/*
    - *MOD*: *%*
    - *POW*: *^*
    - *AND*: *&&*
    - *OR*: *||*
    - *NOT*: *!*
- Separators:
  - *L_PAR*: *(*
  - *R_PAR*: *)*
  - *L_CUR*: *{*
  - *R_CUR*: *}*
  - *COM*: *,*
  - *S_COM*: *;*
  
### Class Structure

In accord with a classic Lexer structure, we've defined a `Lexer` class, which wrap a `ByteBuffer` object referring to the source code target file.  
The only method exposed is `getToken()`, which read enough character from the buffer to recognize a `Token` object and return it to the caller.  

Every *lexeme* in our language are identified by a `LexemeAnalyzer`, specialized foreach lexeme. Every analyzer expose a method `check(ByteBuffer)` to check if the next characters found in the buffer correspond to the lexeme that it represents: on success, it returns a `RecognizedToken` object, which is a *data structure* composed of a `Token` and an `int numCharRead` representing the characters read by the analyzer to find the lexeme, or an `ERROR TOKEN` object, a static `RecognizedToken` object used to warn about an error.

## Authors
- *Luigi Crisci*
- *Alessio Cuccurullo*
