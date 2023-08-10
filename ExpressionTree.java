import java.util.List;
import java.util.Scanner;

public class ExpressionTree {
	
	private String postfixExpression;
	
	private boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
	}
	
	// Takes a postfix expression and creates an expression tree out of it
	public Node convert(String x) {
				
		this.postfixExpression = x;
				
		List<String> tokens = ParserHelper.parse(this.postfixExpression.toCharArray());
		//LinkedStack<Node> stack = new LinkedStack<>();
		ArrayStack<Node> stack = new ArrayStack<>();
		Node t1, t2, temp;
				
		// Loop through each token in the postfix expression created by your converter
		for (String token : tokens) {
					
			// If the token is a number
			if (!isOperator(token)) {
				// Create a new expression tree node that represents that number
				temp = new Node(token);
				// Push the number onto the stack
				stack.push(temp);
				}
					
			// If the token is an operator
			else {
				// Create a new expression tree node that represents that operator
				temp = new Node(token);
						
				// Pop two expressions off the top of the stack
				t2 = stack.pop();
				t1 = stack.pop();
						
				// Set them as children of this new node
				temp.leftChild = t1;
				temp.rightChild = t2;
						
				// Push the node onto the stack
				stack.push(temp);
			}
		}
		
		// Pop the expression tree
		temp = stack.pop();
		// Return the expression tree
		return temp;	
		
	}
	
	// Preorder traversal
	public static void prefix(Node root) {
		if (root != null) {
			System.out.print(root.element);
			prefix(root.leftChild);
			prefix(root.rightChild);
		}
	}
	
	// Inorder traversal
	public static void infix(Node root) {
		
        if (root != null) {
        	
        	if (root.leftChild == null && root.rightChild == null) {
        		System.out.print(root.element);
        	}
        	
        	else {
        		boolean isOperator = root.leftChild != null && root.rightChild != null;
        		
        		if (isOperator) {
        			System.out.print("(");
        		}
	        	
	        	infix(root.leftChild);
	        	System.out.print(root.element);
	        	infix(root.rightChild);
	        	
	        	if (isOperator) {
	        		System.out.print(")");
	        	}
        	}
     
        }
	}
	
	// Postorder traversal
	public static void postfix(Node root) {
		if (root != null) {
			postfix(root.leftChild);
			postfix(root.rightChild);
			System.out.print(root.element);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Type your expression: ");
		String expression = input.nextLine();
		
		// Convert infix expression to postfix expression
		Converter test = new Converter(expression);
		String postfixExpression = test.toPostFix();
		System.out.println("Converted to postfix: " + postfixExpression);
		System.out.println();
		
		// Convert postfix expression to an expression tree
		ExpressionTree tree = new ExpressionTree();
		Node r = tree.convert(postfixExpression);
		
		// Prints out preorder traversal
		System.out.print("Prefix: ");
		tree.prefix(r);
		System.out.println();
		
		// Prints out inorder traversal
		System.out.print("Infix: " );
		tree.infix(r);
		System.out.println();
		
		// Prints out postorder traversal
		System.out.print("Postfix: ");
		tree.postfix(r);
	}
	
}
	
	/** Node for a binary tree **/
	class Node {
		
		public Object element;
		
		public Node leftChild;
		public Node rightChild;
		
		public Node (Object o) {
			this (o, null, null);
		}
		
		public Node (Object o, Node l, Node r) {
			element = o;
			leftChild = l;
			rightChild = r;
		}
		
		public String toString() {
			return element.toString();
		}
		
	}
	
	
	
		
	   
		
	
	
	

	
		
		
		
		
		
		





