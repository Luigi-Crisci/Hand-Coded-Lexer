# Hand-Coded Lexer

This is a simple java implementation of a Lexer.

## Structure  

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
    - *POW*: *^* (optional) 
    - *AND*: *&&*
    - *OR*: *||*
    - *NOT*: *!*
    
## Authors
- *Luigi Crisci*
- *Alessio Cuccurullo*
