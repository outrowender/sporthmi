/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.HybridStatisticsTypeFactory;
import de.audi.app.car.core.hybrid.IMemoryBuffer;
import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StatisticsMemoryBuffer
implements IMemoryBuffer {
    private final String name;
    private boolean initialized;
    private IMemoryBufferEntry[] elements;
    private String entryClassName;
    private String[] entryFields;
    private int maxElements;
    private int start;
    private int end;
    private boolean full = false;

    public StatisticsMemoryBuffer(String string) {
        this.name = string;
        this.initialized = false;
        this.maxElements = 0;
        this.start = 0;
        this.end = 0;
        this.elements = null;
        this.entryClassName = null;
    }

    private int increment(int n) {
        if (++n >= this.maxElements) {
            n = 0;
        }
        return n;
    }

    private int decrement(int n) {
        if (--n < 0) {
            n = this.maxElements - 1;
        }
        return n;
    }

    private IMemoryBufferEntry createEntry() {
        if (null != this.entryClassName) {
            Object object = null;
            try {
                Class clazz = Class.forName(this.entryClassName);
                object = clazz.newInstance();
            }
            catch (Exception exception) {
                return null;
            }
            return object instanceof IMemoryBufferEntry ? (IMemoryBufferEntry)object : null;
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public synchronized boolean init(int n, int n2) throws IllegalArgumentException, IllegalStateException {
        if (this.initialized) {
            throw new IllegalStateException("Buffer already initialized!");
        }
        if (0 >= n2) {
            throw new IllegalArgumentException("Invalid buffer size!");
        }
        if (HybridStatisticsTypeFactory.isSupported(n)) {
            this.initialized = true;
            this.maxElements = n2;
            this.elements = HybridStatisticsTypeFactory.create(n, n2);
            this.entryClassName = HybridStatisticsTypeFactory.getEntryClassName(n);
            this.entryFields = HybridStatisticsTypeFactory.create(n).getFields();
            return true;
        }
        throw new IllegalArgumentException("Invalid entry type!");
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public synchronized boolean reset() throws IllegalStateException {
        if (this.initialized) {
            this.full = false;
            this.start = 0;
            this.end = 0;
            for (int i2 = 0; i2 < this.maxElements; ++i2) {
                this.elements[i2] = null;
            }
            return true;
        }
        throw new IllegalStateException("Buffer not initialized!");
    }

    public int size() {
        int n = 0;
        n = this.end < this.start ? this.maxElements - this.start + this.end : (this.end == this.start ? (this.full ? this.maxElements : 0) : this.end - this.start);
        return n;
    }

    public int maxSize() {
        return this.maxElements;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean isAtFullCapacity() {
        return this.size() == this.maxElements;
    }

    public boolean enqueue(IMemoryBufferEntry iMemoryBufferEntry) throws IllegalStateException {
        if (this.initialized) {
            if (null == iMemoryBufferEntry) {
                return false;
            }
            if (this.isAtFullCapacity()) {
                this.dequeue();
            }
            this.elements[this.end++] = iMemoryBufferEntry;
            if (this.end >= this.maxElements) {
                this.end = 0;
            }
            if (this.end == this.start) {
                this.full = true;
            }
            return true;
        }
        throw new IllegalStateException("Buffer not initialized!");
    }

    public IMemoryBufferEntry dequeue() throws NoSuchElementException, IllegalStateException {
        if (this.initialized) {
            if (this.isEmpty()) {
                throw new NoSuchElementException("Buffer is empty!");
            }
            IMemoryBufferEntry iMemoryBufferEntry = this.elements[this.start];
            if (null != iMemoryBufferEntry) {
                this.elements[this.start++].setDefaultValues();
                if (this.start >= this.maxElements) {
                    this.start = 0;
                }
                this.full = false;
            }
            return iMemoryBufferEntry;
        }
        throw new IllegalStateException("Buffer not initialized!");
    }

    public boolean update(IMemoryBufferEntry iMemoryBufferEntry) throws IllegalStateException {
        if (this.initialized) {
            if (null == iMemoryBufferEntry) {
                return false;
            }
            if (this.isEmpty()) {
                return this.enqueue(iMemoryBufferEntry);
            }
            this.elements[this.getIndexOfLatest()] = iMemoryBufferEntry;
            return true;
        }
        throw new IllegalStateException("Buffer not initialized!");
    }

    public IMemoryBufferEntry get(int n) throws NoSuchElementException, IllegalStateException {
        if (this.initialized) {
            int n2 = this.size();
            if (0 > n || n >= n2) {
                throw new NoSuchElementException("The specified index is outside the available range!");
            }
            int n3 = (this.start + n) % this.maxElements;
            return this.elements[n3];
        }
        throw new IllegalStateException("Buffer not initialized!");
    }

    public int getIndexOfLatest() {
        return this.size() - 1;
    }

    public IMemoryBufferEntry[] toArray() throws IllegalStateException {
        if (this.initialized) {
            int n = this.maxSize();
            IMemoryBufferEntry[] iMemoryBufferEntryArray = new IMemoryBufferEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                IMemoryBufferEntry iMemoryBufferEntry;
                if (i2 < this.size()) {
                    iMemoryBufferEntry = this.get(i2);
                    if (null != iMemoryBufferEntry) {
                        iMemoryBufferEntryArray[i2] = iMemoryBufferEntry.copy();
                        continue;
                    }
                    iMemoryBufferEntry = this.createEntry();
                    if (null == iMemoryBufferEntry) continue;
                    iMemoryBufferEntry.setDefaultValues();
                    iMemoryBufferEntryArray[i2] = iMemoryBufferEntry;
                    continue;
                }
                iMemoryBufferEntry = this.createEntry();
                if (null == iMemoryBufferEntry) continue;
                iMemoryBufferEntry.setDefaultValues();
                iMemoryBufferEntryArray[i2] = iMemoryBufferEntry;
            }
            return iMemoryBufferEntryArray;
        }
        throw new IllegalStateException("Buffer not initialized!");
    }

    public Iterator iterator() throws IllegalStateException {
        if (this.initialized) {
            return new Iterator(){
                private int index;
                private int lastReturnedIndex;
                private boolean isFirst;
                {
                    this.index = StatisticsMemoryBuffer.this.start;
                    this.lastReturnedIndex = -1;
                    this.isFirst = StatisticsMemoryBuffer.this.full;
                }

                public boolean hasNext() {
                    return this.isFirst || this.index != StatisticsMemoryBuffer.this.end;
                }

                public Object next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.isFirst = false;
                    this.lastReturnedIndex = this.index;
                    this.index = StatisticsMemoryBuffer.this.increment(this.index);
                    return StatisticsMemoryBuffer.this.elements[this.lastReturnedIndex];
                }

                public void remove() {
                    if (this.lastReturnedIndex == -1) {
                        throw new IllegalStateException();
                    }
                    if (this.lastReturnedIndex == StatisticsMemoryBuffer.this.start) {
                        StatisticsMemoryBuffer.this.dequeue();
                        this.lastReturnedIndex = -1;
                        return;
                    }
                    int n = this.lastReturnedIndex + 1;
                    if (StatisticsMemoryBuffer.this.start < this.lastReturnedIndex && n < StatisticsMemoryBuffer.this.end) {
                        System.arraycopy((Object)StatisticsMemoryBuffer.this.elements, n, (Object)StatisticsMemoryBuffer.this.elements, this.lastReturnedIndex, StatisticsMemoryBuffer.this.end - n);
                    } else {
                        while (n != StatisticsMemoryBuffer.this.end) {
                            if (n >= StatisticsMemoryBuffer.this.maxElements) {
                                ((StatisticsMemoryBuffer)StatisticsMemoryBuffer.this).elements[n - 1] = StatisticsMemoryBuffer.this.elements[0];
                                n = 0;
                                continue;
                            }
                            ((StatisticsMemoryBuffer)StatisticsMemoryBuffer.this).elements[((StatisticsMemoryBuffer)StatisticsMemoryBuffer.this).decrement((int)n)] = StatisticsMemoryBuffer.this.elements[n];
                            n = StatisticsMemoryBuffer.this.increment(n);
                        }
                    }
                    this.lastReturnedIndex = -1;
                    StatisticsMemoryBuffer.this.end = StatisticsMemoryBuffer.this.decrement(StatisticsMemoryBuffer.this.end);
                    ((StatisticsMemoryBuffer)StatisticsMemoryBuffer.this).elements[((StatisticsMemoryBuffer)StatisticsMemoryBuffer.this).end] = null;
                    StatisticsMemoryBuffer.this.full = false;
                    this.index = StatisticsMemoryBuffer.this.decrement(this.index);
                }
            };
        }
        throw new IllegalStateException("Buffer not initialized!");
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("StatisticsMemoryBuffer: ");
        if (this.initialized) {
            int n;
            buffer.append("Current Size='").append(this.size()).append("', ");
            buffer.append("Maximum Size='").append(this.maxSize()).append("'");
            buffer.append("\n");
            Buffer[] bufferArray = new Buffer[this.entryFields.length];
            for (n = 0; n < this.maxSize(); ++n) {
                String[] stringArray = n < this.size() ? this.get(n).getValuesAsString() : this.createEntry().getValuesAsString();
                for (int i2 = 0; i2 < this.entryFields.length; ++i2) {
                    if (0 == n) {
                        bufferArray[i2] = new Buffer();
                        bufferArray[i2].append(this.entryFields[i2]);
                    }
                    bufferArray[i2].append(" | ").append(stringArray[i2]);
                }
            }
            for (n = 0; n < bufferArray.length; ++n) {
                buffer.append(bufferArray[n]).append("\n");
            }
        } else {
            buffer.append("Buffer NOT initialized yet!");
        }
        return buffer.toString();
    }
}

