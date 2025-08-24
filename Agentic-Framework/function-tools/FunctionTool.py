
# A normal function
def get_discounted_process(price: float, discount: float) -> float:
    """Calculate discounted price"""
    return price - (price * discount / 100)


# Register function tools
tools = {
    "get_discounted_price": get_discounted_process
}

# Simulating an Agent that can call tools
class Agent:
    def __init__(self, tools: dict):
        self.tools = tools

    def act(self, task: str):
        # Very simple parser: looks for keywords in the task
        if "discount" in task.lower():
            tool = self.tools["get_discounted_price"]
            result = tool(1000, 20)  # hardcoded for example
            return f"Final price after discount = {result}"
        else:
            return "I don't know how to handle this yet."

# Run the agent
if __name__ == "__main__":
    agent = Agent(tools)
    response = agent.act("What is the price after 20% discount?")
    print(response)