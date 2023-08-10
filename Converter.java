import java.util.List;

public class Converter {

	private String infixExpression;
		
	public Converter(String x) {
		this.infixExpression = x;
	}
	
	private boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
	}
		
	private boolean operatorPrecedence(String x, String y) {
		if (x.equals("^")) {
			return true;
		}
		else if (y.equals("^")) {
			return false;
		}
		else if (x.equals("*") || x.equals("/")) {
			return true;
		}
		else if (y.equals("*") || y.equals("/")) {
			return false;
			}
		else {
			return true;
		}
	}
		
	public String toPostFix() {
			
		List<String> tokens = ParserHelper.parse(this.infixExpression.toCharArray());
		LinkedStack<String> stack = new LinkedStack<String>();
		String output = "";
			
		for (String token : tokens) {
				
			if (isOperator(token)) {
				while (!stack.isEmpty() && !stack.top().equals("(") && operatorPrecedence(stack.top(), token)) {
					output += stack.pop() + " ";	
				}
				stack.push(token);
			}
				
			else if (token.equals("(")) {
				stack.push(token);
			}
				
			else if (token.equals(")")) {
				while(!stack.isEmpty() && !stack.top().equals("(")) {
					output += stack.pop() + " ";
				}
				stack.pop();
			}
				
			else {
				output += token + " ";
			}
				
		}
			
		while (!stack.isEmpty()) {
			output += stack.pop() + " ";
		}
			
		return output.trim();
			
	}
		
}
