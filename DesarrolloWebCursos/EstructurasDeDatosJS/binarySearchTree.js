class Node
{
	constructor(value)
	{
		this.left = null;
		this.right = null;
		this.value = value
	}
}

class MyBinarySearchTree
{
	constructor()
	{
		this.root = null;
	}

	insert(value)
	{
		const newNode = new Node(value);

		if(this.root === null)
		{
			this.root = newNode;
			
			return this;
		}
		else
		{
			let currentNode = this.root;

			while(true)
			{
				if(value < currentNode.value)
				{
					if(!currentNode.left)
					{
						currentNode.left = newNode;
						return this;
					}
					else
					{
						currentNode = currentNode.left;
					}
				}
				else
				{
					if(!currentNode.right)
					{
						currentNode.right = newNode;
						return this;
					}
					else
					{
						currentNode = currentNode.right;
					}
				}
			}
		}
	}

	search(value)
	{
		let currentNode = this.root;
		
		while(true)
		{
			

			if(currentNode === null)
			{
				console.error('The tree no has nodes');
				return;
			}
			else if(currentNode.left === null && currentNode.right === null)
			{
				if(currentNode.value != value)
				{
					console.error('The value is not in the tree');
					return;
				}
				else
				{
					return currentNode;
				}
			}
			else if(value === currentNode.value)
			{
				return currentNode;
			}
			else if(value < currentNode.value)
			{
				currentNode = currentNode.left;
			}
			else
			{
				currentNode = currentNode.right;
			}
		}
	}
}

const myBinarySearchTree = new MyBinarySearchTree;