/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface IMemoryBuffer {
    public String getName();

    public boolean init(int var1, int var2) throws IllegalArgumentException, IllegalStateException;

    public boolean isInitialized();

    public boolean reset() throws IllegalStateException;

    public int size();

    public int maxSize();

    public boolean isEmpty();

    public boolean isAtFullCapacity();

    public boolean enqueue(IMemoryBufferEntry var1) throws IllegalStateException;

    public IMemoryBufferEntry dequeue() throws NoSuchElementException, IllegalStateException;

    public boolean update(IMemoryBufferEntry var1) throws IllegalStateException;

    public IMemoryBufferEntry get(int var1) throws NoSuchElementException, IllegalStateException;

    public int getIndexOfLatest();

    public IMemoryBufferEntry[] toArray() throws IllegalStateException;

    public Iterator iterator() throws IllegalStateException;
}

