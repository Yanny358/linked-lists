## Implement an abstract data type "Stack of long integers" (LIFO) using linkedlists. String representation of a stack (provided by toString method) must be ordered from bottom to top (tos is the last element). 

*List of compulsory operations:*

Constructor for a new stack:  <code>LongStack()</code>

Copy of the stack: <code>Object clone()</code>

Check whether the stack is empty: <code>boolean stEmpty()</code>

Adding an element to the stack: <code>void push (long a)</code>

Removing an element from the stack: <code>long pop()</code>

Arithmetic operations(+ - * /) between two
topmost elements of the stack (result is left on top): <code>void op (String s)</code>

Reading the top without removing it: <code>long tos()</code>

Check whether two stacks are equal: <code>boolean equals (Object o)</code>

*Conversion of the stack to string (top last): String toString()*

**Write a method**

**public static long interpret (String pol) 
to calculate the value of an arithmetic expression pol in RPN
(Reverse Polish Notation) using this stack type. 
Expression is a string which contains long integers (including negative and
multi-digit numbers) and arithmetic operations + - * / 
separated by whitespace symbols. The result must be a long integer value of 
the expression or throwing a RuntimeException in case the expression 
is not correct. Expression is not correct if it contains illegal symbols, 
leaves redundant elements on top of stack or causes stack underflow.

### Example <code>LongStack.interpret ("2 15 -")</code> should return -13
