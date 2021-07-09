/* 1 --> 2 --> 3 --> 4 --> null;

let singleLinkedLink =
{
	head:
	{
		value: 1,
		next:
		{
			value: 2,
			next:
			{
				value: 3,
				next:
				{
					value: 4,
					next: null
				}
			}
		}
	}
}; */

class Node
{
	constructor(value)
	{
		this.value = value;
		this.next = null;
	}
}

class MySingleLinkedList
{
	constructor(value)
	{
		this.head =
		{
			value: value,
			next: null
		};

		this.tail = this.head;

		this.length = 1;
	}

	prepend(value)
	{
		const newNode = new Node(value);
		const head = this.head.value;
		
		if(this.tail === this.head)
		{
			newNode.next = new Node(head);

			this.tail = newNode.next;

			this.head = newNode;
			this.length++;
			return this;
		}

		newNode.next = this.head;
		this.head = newNode;
		this.length++;

		return this;
	}

	append(value)
	{
		const head = this.head.value;
		const newNode = new Node(value);

		if(this.tail === this.head)
		{
			this.head = new Node(head);
			this.tail = this.head;

			this.tail.next = newNode;
			this.tail = this.tail.next;
			this.length++;
			
			return this
		}

		this.tail.next = newNode;
		this.tail = this.tail.next;
		this.length++;

		return this;
	}

	insert(index, value)
	{
		const head = this.head.value;

		this.head = new Node(head);
		
		if(index === 0)
		{
			return this.prepend(value);
		}
		
		if(index >= this.length)
		{
			return  this.append(value);
		}

		const newNode = new Node(value);
		const firstPointer = this.getIndex(index - 1);
		const holdingPointer = firstPointer.next;

		firstPointer.next = newNode;
		newNode.next = holdingPointer;

		this.length++;

		return this;
	}

	getIndex(index)
	{
		let currentNode = this.head;

		for(let i = 0; i < index; i++)
		{
			currentNode = currentNode.next;
		}

		return currentNode;

	}

	delete(index)
	{
		if(index <= 0)
		{
			return this.shift();
		}

		if(index >= this.length)
		{
			return this.pop();
		}
		
		const firstPointer = this.getIndex(index - 1);
		const holdingPointer = this.getIndex(index + 1);

		firstPointer.next = holdingPointer;
		this.length--;

		return this;
	}

	shift()
	{
		const secondNode = this.head.next;

		this.head = secondNode;
		this.length--;

		return this
	}

	pop()
	{
		const prevLastNode = this.getIndex(this.length - 2);

		this.tail = prevLastNode;
		prevLastNode.next = null;
		this.length--;

		return this;
	}
}

let mySingleLinkedList = new MySingleLinkedList(1);