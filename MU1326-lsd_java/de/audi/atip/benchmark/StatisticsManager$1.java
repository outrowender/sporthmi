/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.StatisticsManager;

class StatisticsManager$1
implements Runnable {
    private final /* synthetic */ String val$desc;
    private final /* synthetic */ StatisticsManager this$0;

    StatisticsManager$1(StatisticsManager statisticsManager, String string) {
        this.this$0 = statisticsManager;
        this.val$desc = string;
    }

    @Override
    public void run() {
        StatisticsManager.access$100(this.this$0, this.val$desc);
    }

    public String toString() {
        return "[DumpingGatheredStatistics]";
    }
}

