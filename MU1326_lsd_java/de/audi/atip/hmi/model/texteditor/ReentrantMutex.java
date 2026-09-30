/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

public class ReentrantMutex {
    private Thread owner = null;
    public int noEntries = 0;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean acquire() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        ReentrantMutex reentrantMutex = this;
        synchronized (reentrantMutex) {
            if (this.owner == Thread.currentThread()) {
                ++this.noEntries;
                return true;
            }
            try {
                while (this.owner != null) {
                    this.wait();
                }
                this.owner = Thread.currentThread();
                this.noEntries = 1;
            }
            catch (InterruptedException interruptedException) {
                this.notifyAll();
                throw interruptedException;
            }
            return true;
        }
    }

    public boolean attempt(long l) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        ReentrantMutex reentrantMutex = this;
        synchronized (reentrantMutex) {
            if (this.owner == null) {
                this.owner = Thread.currentThread();
                return true;
            }
            if (this.owner == Thread.currentThread()) {
                return true;
            }
            if (l <= 0L) {
                return false;
            }
            long l2 = l;
            long l3 = System.currentTimeMillis();
            try {
                do {
                    this.wait(l2);
                    if (this.owner != null) continue;
                    this.owner = Thread.currentThread();
                    return true;
                } while ((l2 = l - (System.currentTimeMillis() - l3)) > 0L);
                return false;
            }
            catch (InterruptedException interruptedException) {
                this.notifyAll();
                throw interruptedException;
            }
        }
    }

    public synchronized void release() {
        Thread thread = Thread.currentThread();
        if (this.owner == null) {
            System.out.println("!!! WARNING !!! trying to release unowned mutex th " + thread);
            return;
        }
        if (thread.equals(this.owner)) {
            --this.noEntries;
            if (this.noEntries <= 0) {
                if (this.noEntries == 0) {
                    this.owner = null;
                    this.notify();
                } else {
                    System.out.println("!!! WARNING !!! Unmatched aq/rl pairs for th " + thread);
                }
                return;
            }
        }
    }
}

