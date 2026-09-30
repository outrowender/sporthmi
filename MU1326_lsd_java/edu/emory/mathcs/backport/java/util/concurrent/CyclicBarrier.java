/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.BrokenBarrierException;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;

public class CyclicBarrier {
    private final Object lock = new Object();
    private final int parties;
    private final Runnable barrierCommand;
    private Generation generation = new Generation();
    private int count;

    private void nextGeneration() {
        this.lock.notifyAll();
        this.count = this.parties;
        this.generation = new Generation();
    }

    private void breakBarrier() {
        this.generation.broken = true;
        this.count = this.parties;
        this.lock.notifyAll();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int dowait(boolean bl, long l) throws InterruptedException, BrokenBarrierException, TimeoutException {
        Object object = this.lock;
        synchronized (object) {
            int n;
            Generation generation = this.generation;
            if (generation.broken) {
                throw new BrokenBarrierException();
            }
            if (Thread.interrupted()) {
                this.breakBarrier();
                throw new InterruptedException();
            }
            if ((n = --this.count) == 0) {
                boolean bl2 = false;
                try {
                    Runnable runnable = this.barrierCommand;
                    if (runnable != null) {
                        runnable.run();
                    }
                    bl2 = true;
                    this.nextGeneration();
                    int n2 = 0;
                    return n2;
                }
                finally {
                    if (!bl2) {
                        this.breakBarrier();
                    }
                }
            }
            long l2 = bl ? Utils.nanoTime() + l : 0L;
            while (true) {
                block19: {
                    try {
                        if (!bl) {
                            this.lock.wait();
                            break block19;
                        }
                        if (l > 0L) {
                            TimeUnit.NANOSECONDS.timedWait(this.lock, l);
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        if (generation == this.generation && !generation.broken) {
                            this.breakBarrier();
                            throw interruptedException;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                if (generation.broken) {
                    throw new BrokenBarrierException();
                }
                if (generation != this.generation) {
                    return n;
                }
                if (bl && l <= 0L) {
                    this.breakBarrier();
                    throw new TimeoutException();
                }
                l = l2 - Utils.nanoTime();
            }
        }
    }

    public CyclicBarrier(int n, Runnable runnable) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.parties = n;
        this.count = n;
        this.barrierCommand = runnable;
    }

    public CyclicBarrier(int n) {
        this(n, null);
    }

    public int getParties() {
        return this.parties;
    }

    public int await() throws InterruptedException, BrokenBarrierException {
        try {
            return this.dowait(false, 0L);
        }
        catch (TimeoutException timeoutException) {
            throw new Error(timeoutException);
        }
    }

    public int await(long l, TimeUnit timeUnit) throws InterruptedException, BrokenBarrierException, TimeoutException {
        return this.dowait(true, timeUnit.toNanos(l));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isBroken() {
        Object object = this.lock;
        synchronized (object) {
            return this.generation.broken;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        Object object = this.lock;
        synchronized (object) {
            this.breakBarrier();
            this.nextGeneration();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getNumberWaiting() {
        Object object = this.lock;
        synchronized (object) {
            return this.parties - this.count;
        }
    }

    private static class Generation {
        boolean broken = false;

        private Generation() {
        }
    }
}

