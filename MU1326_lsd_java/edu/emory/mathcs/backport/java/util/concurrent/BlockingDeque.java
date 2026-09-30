/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.Deque;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.util.Iterator;

public interface BlockingDeque
extends BlockingQueue,
Deque {
    public void addFirst(Object var1);

    public void addLast(Object var1);

    public boolean offerFirst(Object var1);

    public boolean offerLast(Object var1);

    public void putFirst(Object var1) throws InterruptedException;

    public void putLast(Object var1) throws InterruptedException;

    public boolean offerFirst(Object var1, long var2, TimeUnit var4) throws InterruptedException;

    public boolean offerLast(Object var1, long var2, TimeUnit var4) throws InterruptedException;

    public Object takeFirst() throws InterruptedException;

    public Object takeLast() throws InterruptedException;

    public Object pollFirst(long var1, TimeUnit var3) throws InterruptedException;

    public Object pollLast(long var1, TimeUnit var3) throws InterruptedException;

    public boolean removeFirstOccurrence(Object var1);

    public boolean removeLastOccurrence(Object var1);

    public boolean add(Object var1);

    public boolean offer(Object var1);

    public void put(Object var1) throws InterruptedException;

    public boolean offer(Object var1, long var2, TimeUnit var4) throws InterruptedException;

    public Object remove();

    public Object poll();

    public Object take() throws InterruptedException;

    public Object poll(long var1, TimeUnit var3) throws InterruptedException;

    public Object element();

    public Object peek();

    public boolean remove(Object var1);

    public boolean contains(Object var1);

    public int size();

    public Iterator iterator();

    public void push(Object var1);
}

