class Node
{
	constructor(value)
	{
		this.value = value;
		this.next = null;
	}
}

class MyQueue
{
	constructor()
	{
		this.first = null;
		this.last = null;
		this.length = 0;
	}

	peek()
	{
		return this.first;
	}

	queue(value)
	{
		const newNode = new Node(value);
		
		if(this.length === 0)
		{
			this.first = newNode;
			this.last = newNode;
		}
		else
		{
			this.last.next = newNode;
			this.last = newNode;
		}

		this.length++;

		return this;
	}

	dequeue()
	{
		const removeFirstNode = this.first;
		
		if(this.length === 0)
		{
			console.error('the queue has no nodes');
			return;
		}
		else if(this.length === 1)
		{
			this.first = null;
			this.last = null;
		}
		else
		{
			this.first = this.first.next;
		}

		this.length--;

		return removeFirstNode;
	}
}

const myQueue = new MyQueue;