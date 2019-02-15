public class ArrayDeque<T>{
	private int size;
	private int nextFirst;
	private int nextLast;
	private T [] items;

	public ArrayDeque()
	{
		size = 0;
		nextFirst = 0;
		nextLast = 1;
		items = (T[]) new Object[8];
	}

	private int minusOne(int index)
	{
		return Math.floorMod(index - 1 + items.length,items.length);
	}

	private int plusOne(int index)
	{
		return Math.floorMod(index + 1 + items.length,items.length);
	}

	private void copyToNewArray(T[] arr)
	{
		for(int index = 0; index <size; ++index)
		{
			arr[index] = items[Math.floorMod(nextFirst + index + 1,items.length)];
		}
	}

	private void resize()
	{
		printFromIndex(size-1, 1);
		T[] newItems = (T[]) new Object[size*4];
		copyToNewArray(newItems);
		items = null; 
		items = newItems;
		nextFirst = minusOne(0);
		nextLast = size;
		printFromIndex(size-1, 1);
	}

	public void addFirst(T item)
	{
		if(size == items.length)
		{
			resize();
		}
		items[nextFirst] = item;
		nextFirst = minusOne(nextFirst);
		++size;
	}

	public void addLast(T item)
	{
		if(size == items.length)
		{
			resize();
		}
		items[nextLast] = item;
		nextLast = plusOne(nextLast);
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
		for(int i = 0; i < size; ++i)
		{
			System.out.print(get(i) + " ");
		}
		System.out.println();
	}

	public T removeFirst() 
	{
		if(size == 0) return null;
		nextFirst = plusOne(nextFirst);
		--size;
		T firstItem = items[nextFirst];
		items[nextFirst] = null;
		if(items.length > 16 && size < items.length / 4.0)
		{
			resize();
		}
		return firstItem;
	}

	public T removeLast()
	{	
		if(size == 0) return null;
		nextLast = minusOne(nextLast);
		--size;
		T lastItem = items[nextLast];
		items[nextLast] = null;
		if(items.length > 16 && size < items.length / 4.0)
		{
			resize();
		}
		return lastItem;
	}

	public T get(int index)
	{
		return index >= size ? null : items[Math.floorMod(nextFirst + index + 1,items.length)];
	}

	private void under(int i)
	{
		System.out.println("Next First underlying " + nextFirst);
		System.out.println("Wanted index " + i );
		System.out.println("Wanted underlying index " + Math.floorMod(nextFirst + i + 1,items.length));
		System.out.println("Size " + size );
		System.out.println("Length " + items.length);
		System.out.println("Ratio " + items.length/4.0);
	}

	public void printFromIndex(int index, int size)
	{
		for(int i = 0; i < size; ++i)
		{
			under(index + i);
			System.out.print(get(index + i) + " ");
		}
		System.out.println();
	}
};