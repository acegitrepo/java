package com.examples.producerconsumerusingcustomlist;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class CustomList<T>
{
	private int size;
	private Object[] objects = null;
	private transient int capacity = 10;
	final transient ReentrantLock lock = new ReentrantLock();

	public CustomList()
	{
		objects = new Object[capacity];
	}

	public CustomList(int capacity)
	{
		this.capacity = capacity;
		objects = new Object[capacity];
	}

	public void add(T element)
	{
		final ReentrantLock lock = this.lock;
		lock.lock();

		try
		{
			if (size >= objects.length)
			{

				int newLength = objects.length + (capacity * 3) / 4;
				Object[] newElements = Arrays.copyOf(objects, newLength);
				objects = newElements;
			}

			if (size == 0)
			{
				objects[0] = element;
			}
			else
			{
				objects[size] = element;
			}

			size++;
		}
		finally
		{
			lock.unlock();
		}
	}

	@SuppressWarnings("unchecked")
	public T get()
	{
		final ReentrantLock lock = this.lock;
		lock.lock();
		T object = null;

		try
		{
			if (size != 0)
			{
				object = (T) objects[0];
				Object[] newElements = Arrays.copyOfRange(objects, 1, objects.length);
				objects = newElements;
				size--;
			}
			else
			{
				objects = new Object[10];
			}

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}

		return object;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if (size != 0)
		{
			sb.append(objects[0]);
		}

		for (int i = 1; i < size; i++)
		{
			sb.append("," + objects[i]);
		}

		return "CustomList [objects=" + sb.toString() + "]";
	}
}
