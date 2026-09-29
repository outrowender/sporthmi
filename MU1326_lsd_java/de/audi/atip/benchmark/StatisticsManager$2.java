/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.StatisticsManager;

class StatisticsManager$2
implements Runnable {
    private final /* synthetic */ int val$flags;
    private final /* synthetic */ StatisticsManager this$0;

    StatisticsManager$2(StatisticsManager statisticsManager, int n) {
        this.this$0 = statisticsManager;
        this.val$flags = n;
    }

    @Override
    public void run() {
        this.this$0.doStartGathering(this.val$flags);
    }

    public String toString() {
        return "[EnablingStatistics]";
    }
}

