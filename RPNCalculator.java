import java.math.BigInteger; 
// imported for you, so you can use BigInteger objects to detect integer over/underflows
// delete if you want to do this differently

public class RPNCalculator {
	private Stack<String> stack;
	private Stack<String> stack2;
	private Stack<String> stack3;
	private int size;
	
	public RPNCalculator (int initSize) {
// create a new StackArray of Strings 
// and set the size field to the provided parameter initSize
	size = initSize;
	stack = new StackArray(size);
	
	}
	 
	public int calculate(String[] expression) throws CalculatorException {
		String first_pop = "";
		String second_pop = "";
	//	String acceptable = "0123456789";
		BigInteger one;
		BigInteger two;
		BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);
		BigInteger min = BigInteger.valueOf(Integer.MIN_VALUE);
		for(int i = 0; i < expression.length; i++){
			switch(expression[i]){
				case "*":
						try{
							 first_pop = stack.pop();
							 size--;
							second_pop = stack.pop();
							size--;
							stack.push(multiply(first_pop, second_pop));
							size++;
							one = BigInteger.valueOf(Integer.parseInt(first_pop));
							two = BigInteger.valueOf(Integer.parseInt(second_pop));
							if(one.multiply(two).compareTo(max) > 0){
								throw new CalculatorException("integer overflow");
							}
							if(one.multiply(two).compareTo(min) < 0){
								throw new CalculatorException("integer underflow");
							}
						}catch(StackException e){
					//		System.out.println("error 1");
							growAndCopy(size);				
							}
							break;
				case "/": 
							try{
							first_pop = stack.pop();
							size--;
							second_pop = stack.pop();
							size--;
							if(first_pop.equals("0")){
								throw new CalculatorException("division by zero");
							}
							stack.push(divide(first_pop, second_pop));
							size++;
							}catch(StackException e){
							//	System.out.println("error 2");
								growAndCopy(size);	

						}
							break;
				case "+": 
							try{
							first_pop = stack.pop();
							size--;
							second_pop = stack.pop();
							size--;
							one = BigInteger.valueOf(Integer.parseInt(first_pop));
							two = BigInteger.valueOf(Integer.parseInt(second_pop));
							if(one.add(two).compareTo(max) > 0){
								throw new CalculatorException("integer overflow");
							}
							if(one.add(two).compareTo(min) < 0){
								throw new CalculatorException("integer underflow");
							}
							stack.push(add(first_pop, second_pop));
							size++;
							}catch(StackException e){
							//	System.out.println("error 3");
								growAndCopy(size);	
							}
							break;		
				case "-": 
							try{
							first_pop = stack.pop();
							size++;
							second_pop = stack.pop();
							size++;
							stack.push(subtract(first_pop, second_pop));
							size--;
							one = BigInteger.valueOf(Integer.parseInt(first_pop));
							two = BigInteger.valueOf(Integer.parseInt(second_pop));
							if(two.subtract(one).compareTo(max) > 0){
								throw new CalculatorException("integer overflow");
							}
							if(two.subtract(one).compareTo(min) < 0){
								throw new CalculatorException("integer underflow");
							}
							}catch(StackException e){
								//System.out.println("error 4");
								growAndCopy(size);	
							}
							break;					
				default:
							try{
								if(!isinteger(expression[i])){
									throw new CalculatorException("Invalid expression");
								}else{
								stack.push(expression[i]);
								size++;
								}
							}catch(StackException e){
								
								growAndCopy(size);	
							}
			}
		}
		// implement the main calculation algorithm here
		
		// remember: you can use Integer.parseInt(s) to convert a string to an integer
		try{
			//System.out.println("" + stack.pop());
		return Integer.parseInt(stack.pop()); // this line is only here to this compiles - replace with algorithm
		}catch(StackException e){
		//	System.out.println("error 6");
		}
		return 0;
	}
	

	private boolean isinteger(String s){
		try{
			Integer.parseInt(s);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	private void growAndCopy(int size){
		stack2 = new StackArray(size);
		for(int i = 0; i < size; i++){
			try{
			stack2.push(stack.pop());
			}catch(StackException e){

			}
		}
		stack3 = new StackArray(size * 2);
		for(int i = 0; i < size; i++){
			try{
			stack3.push(stack2.pop());
			}catch(StackException e){

			}
		}
		stack = stack3;
	}
	
	private String add(String a, String b){
		int c = Integer.parseInt(a) + Integer.parseInt(b);
		String s = Integer.toString(c);
		return s;
	}
	private String subtract(String a, String b){
		int c = Integer.parseInt(b) - Integer.parseInt(a);
		String s = Integer.toString(c);
		return s;
	}
	private String multiply(String a, String b){
		int c = Integer.parseInt(a) * Integer.parseInt(b);
		String s = Integer.toString(c);
		return s;
	}
	private String divide(String a, String b){
		int c = Integer.parseInt(b) / Integer.parseInt(a);
		String s = Integer.toString(c);
		return s;
	}

	// remember: you can define private helper methods. That improves code-readability
	// for example: we recommend that you define a private "compute" method that carries out
	// one primitive computation
	
	// private String compute (String operator, String operand1, String operand2) throws CalculatorException { ... }
	
	
}