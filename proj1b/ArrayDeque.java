public class ArrayDeque<T> implements Deque<T>{
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
		T[] newItems = (T[]) new Object[size*4];
		copyToNewArray(newItems);
		items = null; 
		items = newItems;
		nextFirst = minusOne(0);
		nextLast = size;
	}

	@Override
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

	@Override
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


	@Override
	public boolean isEmpty()
	{
		return size==0;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public void printDeque()
	{
		for(int i = 0; i < size; ++i)
		{
			System.out.print(get(i) + " ");
		}
	}

	@Override
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

	@Override
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

	@Override
	public T get(int index)
	{
		return index >= size ? null : items[Math.floorMod(nextFirst + index + 1,items.length)];
	}

};