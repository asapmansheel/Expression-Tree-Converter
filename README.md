# Expression Tree Converter

This project demonstrates the conversion of infix expressions to postfix expressions and the creation of expression trees from postfix expressions. It includes classes for handling conversions and building expression trees, along with traversals to explore the trees.

## Introduction

The Expression Tree project showcases the process of converting infix expressions to postfix expressions and creating expression trees from postfix expressions. Expression trees are a powerful way to represent mathematical expressions for evaluation or analysis. This project provides a hands-on example of how to perform these conversions and manipulations.

## Project Structure

The project is structured as follows:

- `Converter`: This class is responsible for converting infix expressions to postfix expressions. It contains methods to identify operators, manage operator precedence, and perform the conversion.

- `ExpressionTree`: This class handles the creation of expression trees from postfix expressions. It uses a stack-based approach to build the tree by processing each token in the postfix expression and arranging them into nodes.

## Usage

To use the Expression Tree project:

1. Compile the Java source files using a Java compiler. You can use a command like `javac *.java` in your project directory.

2. Run the `ExpressionTree` class using the command line or an IDE.

3. You will be prompted to enter an infix expression. For example, you can input `(5 + 3) * 2`.

4. The program will perform the following steps:
   - Convert the infix expression to postfix using the `Converter` class.
   - Build an expression tree from the postfix expression using the `ExpressionTree` class.
   - Perform prefix, infix, and postfix traversals on the expression tree.
