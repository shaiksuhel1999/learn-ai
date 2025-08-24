package zepro;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FunctionTool {
	
	static BiFunction<Double, Double, Double> getDiscountedPrice  = (price, discount) ->
	       price - (price *discount / 100);
	       
	static class Agent {
		private Map<String, BiFunction<Double, Double, Double>> tools;
		public Agent(Map<String, BiFunction<Double, Double, Double>> tools) {
			this.tools = tools;
		}
		
		public String act(String task) {
            if (task.toLowerCase().contains("discount")) {
                double result = tools.get("getDiscountedPrice").apply(1000.0, 20.0);
                return "Final price after discount = " + result;
            }
            return "I don't know how to handle this yet.";
        }
	}
	
	public static void main(String[] args) {
        Map<String, BiFunction<Double, Double, Double>> tools = new HashMap<>();
        tools.put("getDiscountedPrice", getDiscountedPrice);

        Agent agent = new Agent(tools);
        System.out.println(agent.act("What is the price after 20% discount?"));
    }

}
