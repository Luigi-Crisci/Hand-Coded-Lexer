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

In accord with a classic Lexer structure, we've defined a '''Lexer''' 

## Authors
- *Luigi Crisci*
- *Alessio Cuccurullo*
