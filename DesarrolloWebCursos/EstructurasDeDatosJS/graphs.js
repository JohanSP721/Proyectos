class MYGraph
{
	constructor()
	{
		this.nodes = 0;
		this.adjacentList = {};
	}

	addVertex(node)
	{
		if(this.adjacentList[node])
		{
			return this.adjacentList[node];
		}
		
		this.adjacentList[node] = [];
		this.nodes ++;

		return this;
	}

	addEdge(node1, node2)
	{
		if(!this.adjacentList[node1])
		{
			this.addVertex(node1);
		}
		else if(!this.addVertex[node2])
		{
			this.addVertex(node2)
		}
		
		this.adjacentList[node1].push(node2);
		this.adjacentList[node2].push(node1);

		return this;
	}
}

const myGraph = new MYGraph;