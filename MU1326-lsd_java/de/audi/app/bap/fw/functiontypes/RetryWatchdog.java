/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.RetryConfig;
import de.audi.app.bap.fw.functiontypes.RetryWatchdog$1;
import de.audi.app.bap.fw.functiontypes.RetryWatchdog$ErrorMethod;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractArrayRequest;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicInteger;

public final class RetryWatchdog {
    private final LogChannel logChannel;
    private final RetryConfig retryConfig;
    private final RetryWatchdog$ErrorMethod errorMethod;
    private final Timer retryTimer;
    private volatile AbstractArrayRequest request = null;
    private final AtomicInteger retryCount = new AtomicInteger();

    public RetryWatchdog(LogChannel logChannel, RetryConfig retryConfig, RetryWatchdog$ErrorMethod errorMethod) {
        this.logChannel = logChannel;
        this.retryConfig = retryConfig;
        this.errorMethod = errorMethod;
        this.retryTimer = new Timer("RetryWatchdog", retryConfig.getRetryTimeoutMs(), false, new RetryWatchdog$1(this));
    }

    public synchronized void activate(AbstractArrayRequest abstractArrayRequest) {
        this.logChannel.log(-2137614336, "[RetryWatchdog#activate]");
        if (this.retryConfig.getRetryCount() > 0) {
            this.request = abstractArrayRequest;
            this.retryCount.set(0);
            this.retryTimer.start();
        }
    }

    public synchronized void deactivate() {
        this.logChannel.log(-2137614336, "[RetryWatchdog#deactivate]");
        this.retryTimer.cancel();
        this.request = null;
        this.retryCount.set(0);
    }

    private synchronized void timerFired() {
        this.logChannel.log(-1601830656, "[RetryWatchdog#timerFired] retryCount: %1", (Object)this.retryCount);
        if (this.retryCount.get() == this.retryConfig.getRetryCount()) {
            this.logChannel.log(-1601830656, "[RetryWatchdog#timerFired] retryCount: %1. No Response From FSG. Stopping retries.", (Object)this.retryCount);
            this.errorMethod.error();
            this.retryTimer.cancel();
        } else {
            this.logChannel.log(-1601830656, "[RetryWatchdog#timerFired] retryCount: %1. Retrying.", (Object)this.retryCount);
            if (this.request != null) {
                this.request.send();
                this.retryTimer.restart();
            }
        }
        this.retryCount.incrementAndGet();
    }

    static /* synthetic */ void access$000(RetryWatchdog retryWatchdog) {
        retryWatchdog.timerFired();
    }
}

