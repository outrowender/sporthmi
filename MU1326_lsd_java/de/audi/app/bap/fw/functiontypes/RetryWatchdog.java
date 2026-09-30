/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.RetryConfig;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractArrayRequest;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicInteger;

public final class RetryWatchdog {
    private final LogChannel logChannel;
    private final RetryConfig retryConfig;
    private final ErrorMethod errorMethod;
    private final Timer retryTimer;
    private volatile AbstractArrayRequest request = null;
    private final AtomicInteger retryCount = new AtomicInteger();

    public RetryWatchdog(LogChannel logChannel, RetryConfig retryConfig, ErrorMethod errorMethod) {
        this.logChannel = logChannel;
        this.retryConfig = retryConfig;
        this.errorMethod = errorMethod;
        this.retryTimer = new Timer("RetryWatchdog", retryConfig.getRetryTimeoutMs(), false, new TimerListener(){

            public void fireTimer(Timer timer) {
                RetryWatchdog.this.timerFired();
            }

            public void cancelTimer(Timer timer) {
            }
        });
    }

    public synchronized void activate(AbstractArrayRequest abstractArrayRequest) {
        this.logChannel.log(10000000, "[RetryWatchdog#activate]");
        if (this.retryConfig.getRetryCount() > 0) {
            this.request = abstractArrayRequest;
            this.retryCount.set(0);
            this.retryTimer.start();
        }
    }

    public synchronized void deactivate() {
        this.logChannel.log(10000000, "[RetryWatchdog#deactivate]");
        this.retryTimer.cancel();
        this.request = null;
        this.retryCount.set(0);
    }

    private synchronized void timerFired() {
        this.logChannel.log(100000, "[RetryWatchdog#timerFired] retryCount: %1", (Object)this.retryCount);
        if (this.retryCount.get() == this.retryConfig.getRetryCount()) {
            this.logChannel.log(100000, "[RetryWatchdog#timerFired] retryCount: %1. No Response From FSG. Stopping retries.", (Object)this.retryCount);
            this.errorMethod.error();
            this.retryTimer.cancel();
        } else {
            this.logChannel.log(100000, "[RetryWatchdog#timerFired] retryCount: %1. Retrying.", (Object)this.retryCount);
            if (this.request != null) {
                this.request.send();
                this.retryTimer.restart();
            }
        }
        this.retryCount.incrementAndGet();
    }

    public static interface ErrorMethod {
        public void error();
    }
}

