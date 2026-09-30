/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SynchronousQueue
extends AbstractQueue
implements BlockingQueue,
Serializable {
    private static final long serialVersionUID = -3223113410248163686L;
    private final ReentrantLock qlock;
    private final WaitQueue waitingProducers;
    private final WaitQueue waitingConsumers;

    public SynchronousQueue() {
        this(false);
    }

    public SynchronousQueue(boolean bl) {
        if (bl) {
            this.qlock = new ReentrantLock(true);
            this.waitingProducers = new FifoWaitQueue();
            this.waitingConsumers = new FifoWaitQueue();
        } else {
            this.qlock = new ReentrantLock();
            this.waitingProducers = new LifoWaitQueue();
            this.waitingConsumers = new LifoWaitQueue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void unlinkCancelledConsumer(Node node) {
        if (this.waitingConsumers.shouldUnlink(node)) {
            this.qlock.lock();
            try {
                if (this.waitingConsumers.shouldUnlink(node)) {
                    this.waitingConsumers.unlink(node);
                }
            }
            finally {
                this.qlock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void unlinkCancelledProducer(Node node) {
        if (this.waitingProducers.shouldUnlink(node)) {
            this.qlock.lock();
            try {
                if (this.waitingProducers.shouldUnlink(node)) {
                    this.waitingProducers.unlink(node);
                }
            }
            finally {
                this.qlock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void put(Object object) throws InterruptedException {
        Node node;
        if (object == null) {
            throw new NullPointerException();
        }
        ReentrantLock reentrantLock = this.qlock;
        do {
            boolean bl;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            reentrantLock.lock();
            try {
                node = this.waitingConsumers.deq();
                bl = node == null;
                if (bl) {
                    node = this.waitingProducers.enq(object);
                }
            }
            finally {
                reentrantLock.unlock();
            }
            if (!bl) continue;
            try {
                node.waitForTake();
                return;
            }
            catch (InterruptedException interruptedException) {
                this.unlinkCancelledProducer(node);
                throw interruptedException;
            }
        } while (!node.setItem(object));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean offer(Object object, long l, TimeUnit timeUnit) throws InterruptedException {
        Node node;
        if (object == null) {
            throw new NullPointerException();
        }
        long l2 = timeUnit.toNanos(l);
        ReentrantLock reentrantLock = this.qlock;
        do {
            boolean bl;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            reentrantLock.lock();
            try {
                node = this.waitingConsumers.deq();
                bl = node == null;
                if (bl) {
                    node = this.waitingProducers.enq(object);
                }
            }
            finally {
                reentrantLock.unlock();
            }
            if (!bl) continue;
            try {
                boolean bl2 = node.waitForTake(l2);
                if (!bl2) {
                    this.unlinkCancelledProducer(node);
                }
                return bl2;
            }
            catch (InterruptedException interruptedException) {
                this.unlinkCancelledProducer(node);
                throw interruptedException;
            }
        } while (!node.setItem(object));
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object take() throws InterruptedException {
        Node node;
        Object object;
        ReentrantLock reentrantLock = this.qlock;
        do {
            boolean bl;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            reentrantLock.lock();
            try {
                node = this.waitingProducers.deq();
                bl = node == null;
                if (bl) {
                    node = this.waitingConsumers.enq(null);
                }
            }
            finally {
                reentrantLock.unlock();
            }
            if (!bl) continue;
            try {
                object = node.waitForPut();
                return object;
            }
            catch (InterruptedException interruptedException) {
                this.unlinkCancelledConsumer(node);
                throw interruptedException;
            }
        } while ((object = node.getItem()) == null);
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object poll(long l, TimeUnit timeUnit) throws InterruptedException {
        Node node;
        Object object;
        long l2 = timeUnit.toNanos(l);
        ReentrantLock reentrantLock = this.qlock;
        do {
            boolean bl;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            reentrantLock.lock();
            try {
                node = this.waitingProducers.deq();
                bl = node == null;
                if (bl) {
                    node = this.waitingConsumers.enq(null);
                }
            }
            finally {
                reentrantLock.unlock();
            }
            if (!bl) continue;
            try {
                object = node.waitForPut(l2);
                if (object == null) {
                    this.unlinkCancelledConsumer(node);
                }
                return object;
            }
            catch (InterruptedException interruptedException) {
                this.unlinkCancelledConsumer(node);
                throw interruptedException;
            }
        } while ((object = node.getItem()) == null);
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean offer(Object object) {
        Node node;
        if (object == null) {
            throw new NullPointerException();
        }
        ReentrantLock reentrantLock = this.qlock;
        do {
            reentrantLock.lock();
            try {
                node = this.waitingConsumers.deq();
            }
            finally {
                reentrantLock.unlock();
            }
            if (node != null) continue;
            return false;
        } while (!node.setItem(object));
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object poll() {
        Node node;
        Object object;
        ReentrantLock reentrantLock = this.qlock;
        do {
            reentrantLock.lock();
            try {
                node = this.waitingProducers.deq();
            }
            finally {
                reentrantLock.unlock();
            }
            if (node != null) continue;
            return null;
        } while ((object = node.getItem()) == null);
        return object;
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 0;
    }

    public int remainingCapacity() {
        return 0;
    }

    public void clear() {
    }

    public boolean contains(Object object) {
        return false;
    }

    public boolean remove(Object object) {
        return false;
    }

    public boolean containsAll(Collection collection) {
        return collection.isEmpty();
    }

    public boolean removeAll(Collection collection) {
        return false;
    }

    public boolean retainAll(Collection collection) {
        return false;
    }

    public Object peek() {
        return null;
    }

    public Iterator iterator() {
        return new EmptyIterator();
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public Object[] toArray(Object[] objectArray) {
        if (objectArray.length > 0) {
            objectArray[0] = null;
        }
        return objectArray;
    }

    public int drainTo(Collection collection) {
        Object object;
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int n = 0;
        while ((object = this.poll()) != null) {
            collection.add(object);
            ++n;
        }
        return n;
    }

    public int drainTo(Collection collection, int n) {
        Object object;
        int n2;
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        for (n2 = 0; n2 < n && (object = this.poll()) != null; ++n2) {
            collection.add(object);
        }
        return n2;
    }

    static final class Node
    implements Serializable {
        private static final long serialVersionUID = -3223113410248163686L;
        private static final int ACK = 1;
        private static final int CANCEL = -1;
        int state = 0;
        Object item;
        Node next;

        Node(Object object) {
            this.item = object;
        }

        Node(Object object, Node node) {
            this.item = object;
            this.next = node;
        }

        private Object extract() {
            Object object = this.item;
            this.item = null;
            return object;
        }

        private void checkCancellationOnInterrupt(InterruptedException interruptedException) throws InterruptedException {
            if (this.state == 0) {
                this.state = -1;
                this.notify();
                throw interruptedException;
            }
            Thread.currentThread().interrupt();
        }

        synchronized boolean setItem(Object object) {
            if (this.state != 0) {
                return false;
            }
            this.item = object;
            this.state = 1;
            this.notify();
            return true;
        }

        synchronized Object getItem() {
            if (this.state != 0) {
                return null;
            }
            this.state = 1;
            this.notify();
            return this.extract();
        }

        synchronized void waitForTake() throws InterruptedException {
            try {
                while (this.state == 0) {
                    this.wait();
                }
            }
            catch (InterruptedException interruptedException) {
                this.checkCancellationOnInterrupt(interruptedException);
            }
        }

        synchronized Object waitForPut() throws InterruptedException {
            try {
                while (this.state == 0) {
                    this.wait();
                }
            }
            catch (InterruptedException interruptedException) {
                this.checkCancellationOnInterrupt(interruptedException);
            }
            return this.extract();
        }

        private boolean attempt(long l) throws InterruptedException {
            if (this.state != 0) {
                return true;
            }
            if (l <= 0L) {
                this.state = -1;
                this.notify();
                return false;
            }
            long l2 = Utils.nanoTime() + l;
            do {
                TimeUnit.NANOSECONDS.timedWait(this, l);
                if (this.state == 0) continue;
                return true;
            } while ((l = l2 - Utils.nanoTime()) > 0L);
            this.state = -1;
            this.notify();
            return false;
        }

        synchronized boolean waitForTake(long l) throws InterruptedException {
            try {
                if (!this.attempt(l)) {
                    return false;
                }
            }
            catch (InterruptedException interruptedException) {
                this.checkCancellationOnInterrupt(interruptedException);
            }
            return true;
        }

        synchronized Object waitForPut(long l) throws InterruptedException {
            try {
                if (!this.attempt(l)) {
                    return null;
                }
            }
            catch (InterruptedException interruptedException) {
                this.checkCancellationOnInterrupt(interruptedException);
            }
            return this.extract();
        }
    }

    static abstract class WaitQueue
    implements Serializable {
        WaitQueue() {
        }

        abstract Node enq(Object var1);

        abstract Node deq();

        abstract void unlink(Node var1);

        abstract boolean shouldUnlink(Node var1);
    }

    static class EmptyIterator
    implements Iterator {
        EmptyIterator() {
        }

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    static final class FifoWaitQueue
    extends WaitQueue
    implements Serializable {
        private static final long serialVersionUID = -3623113410248163686L;
        private transient Node head;
        private transient Node last;

        FifoWaitQueue() {
        }

        Node enq(Object object) {
            Node node = new Node(object);
            this.last = this.last == null ? (this.head = node) : (this.last.next = node);
            return node;
        }

        Node deq() {
            Node node = this.head;
            if (node != null) {
                this.head = node.next;
                if (this.head == null) {
                    this.last = null;
                }
                node.next = null;
            }
            return node;
        }

        boolean shouldUnlink(Node node) {
            return node == this.last || node.next != null;
        }

        void unlink(Node node) {
            Node node2 = this.head;
            Node node3 = null;
            while (node2 != null) {
                if (node2 == node) {
                    Node node4 = node2.next;
                    if (node3 == null) {
                        this.head = node4;
                    } else {
                        node3.next = node4;
                    }
                    if (this.last != node) break;
                    this.last = node3;
                    break;
                }
                node3 = node2;
                node2 = node2.next;
            }
        }
    }

    static final class LifoWaitQueue
    extends WaitQueue
    implements Serializable {
        private static final long serialVersionUID = -3633113410248163686L;
        private transient Node head;

        LifoWaitQueue() {
        }

        Node enq(Object object) {
            this.head = new Node(object, this.head);
            return this.head;
        }

        Node deq() {
            Node node = this.head;
            if (node != null) {
                this.head = node.next;
                node.next = null;
            }
            return node;
        }

        boolean shouldUnlink(Node node) {
            return node == this.head || node.next != null;
        }

        void unlink(Node node) {
            Node node2 = this.head;
            Node node3 = null;
            while (node2 != null) {
                if (node2 == node) {
                    Node node4 = node2.next;
                    if (node3 == null) {
                        this.head = node4;
                        break;
                    }
                    node3.next = node4;
                    break;
                }
                node3 = node2;
                node2 = node2.next;
            }
        }
    }
}

