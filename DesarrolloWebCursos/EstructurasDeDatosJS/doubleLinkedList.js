class Node
{
	constructor(value)
	{
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}

class MyDoubleLinkedList
{
	constructor(value)
	{
		this.head =
		{
			value: value,
			next: null,
			prev: null
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
			this.tail.prev = newNode;

			this.head = newNode;
			this.length++;
			return this;
		}

		newNode.next = this.head;
		this.tail.prev = newNode;
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
			this.tail.prev = this.head;
			this.length++;
			
			return this
		}

		this.tail.next = newNode;
		newNode.prev = this.tail;
		this.tail = this.tail.next;
		
		this.length++;

		return this;
	}

	insert(index, value)
	{ 
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
		newNode.prev = firstPointer;
		holdingPointer.prev = newNode

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
		holdingPointer.prev = firstPointer;
		this.length--;

		return this;
	}

	shift()
	{
		const secondNode = this.head.next;

		this.head = secondNode;
		secondNode.prev = null;
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

let myDoubleLinkedList = new MyDoubleLinkedList(1);