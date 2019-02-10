public class LinkedListDeque<T>{
	private static class Node<T> {
		public T item; 
		public Node<T> next;
		public Node<T> prev;
		public Node(T i,Node<T> n, Node<T> p)
		{
			next = n;
			prev = p;
			item = i;
		}
		public Node()
		{
			next = this;
			prev = this;
			item = null;
		}
	}
	private int size;
	private Node<T> sentinel;

	public LinkedListDeque(){
		size = 0;
		sentinel = new Node();
	}

	public void addFirst(T item)
	{
		sentinel.next = new Node(item, sentinel.next,sentinel);
		sentinel.next.next.prev = sentinel.next;
		++size;
	}

	public void addLast(T item)
	{
		sentinel.prev = new Node(item,sentinel,sentinel.prev);
		sentinel.prev.prev.next = sentinel.prev;
		++size;
	}

	public boolean isEmpty()
	{
		return size==0;
	}

	public int size() 
	{
		return size;
	}

	public void printDeque()
	{
		Node temp = sentinel.next;
		while(temp!=sentinel)
		{
			System.out.print(temp.item + " ");
			temp = temp.next;
		}

	}

	public T removeFirst() 
	{
		if(size==0)
			return null;
		Node<T> r = sentinel.next;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		--size;
		return r.item;
	}

	public T removeLast()
	{
		if(size==0)
			return null;
		Node<T> r = sentinel.prev;
		sentinel.prev=sentinel.prev.prev;
		sentinel.prev.next=sentinel;
		--size;
		return r.item;
	}
	public T get(int index)
	{
		Node<T> temp=sentinel.next;
		while(temp!=sentinel)
		{
			if(index == 0)
				return temp.item;
			--index; 	
			temp = temp.next;
		}
		return null;
	}

	private T getRecursive(Node<T> p, int index)
	{
		if(p==sentinel)
			return null;
		else if(index==0)
			return p.item;
		else
			return this.getRecursive(p.next, --index);
	}

	public T getRecursive(int index)
	{
		return getRecursive(sentinel.next,index);
	}
};
