/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import java.util.Iterator;

public interface IMemoryBuffer {
    default public String getName() {
    }

    default public boolean init(int n, int n2) {
    }

    default public boolean isInitialized() {
    }

    default public boolean reset() {
    }

    default public int size() {
    }

    default public int maxSize() {
    }

    default public boolean isEmpty() {
    }

    default public boolean isAtFullCapacity() {
    }

    default public boolean enqueue(IMemoryBufferEntry iMemoryBufferEntry) {
    }

    default public IMemoryBufferEntry dequeue() {
    }

    default public boolean update(IMemoryBufferEntry iMemoryBufferEntry) {
    }

    default public IMemoryBufferEntry get(int n) {
    }

    default public int getIndexOfLatest() {
    }

    default public IMemoryBufferEntry[] toArray() {
    }

    default public Iterator iterator() {
    }
}

