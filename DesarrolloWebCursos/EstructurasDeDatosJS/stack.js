class Node
{
	constructor(value)
	{
		this.value = value;
		this.next = null;
	}
}

class MyStack
{
	constructor()
	{
		this.top = null;
		this.bottom = null;
		this.length = 0;
	}

	peek()
	{
		return this.top;
	}

	push(value)
	{
		const newNode = new Node(value);
		
		if(this.length === 0)
		{
			this.top = newNode;
			this.bottom = newNode;
		}
		else
		{
			const holdingPointer = this.top;
			this.top = newNode;
			this.top.next = holdingPointer;
		}

		this.length++;
		
		return this;
	}

	pop()
	{
		const removeTopNode = this.top;

		if(this.length === 0)
		{
			console.error('El stack no tiene nodos');
			return;
		}
		else if(this.length === 1)
		{
			this.top = null;
			this.bottom = null;
		}
		else
		{
			this.top = this.top.next;
		}

		this.length--;

		return removeTopNode;
	}
}

const myStack = new MyStack;