# fastmcp_tool_example.py

from fastmcp import FastMCP

# 1. Create a FastMCP server instance
mcp = FastMCP(name="UtilityServer")

# 2. Define a tool that converts USD to EUR
@mcp.tool()
def convert_usd_to_eur(amount: float, rate: float = 0.91) -> float:
    """Convert USD to EUR using provided rate."""
    return round(amount * rate, 2)

if __name__ == "__main__":
    mcp.run()  # Start the MCP server (e.g., using Streamable HTTP)
