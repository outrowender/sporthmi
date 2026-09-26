/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.StatisticsManager;
import java.io.File;
import java.io.FilenameFilter;

class StatisticsManager$3
implements FilenameFilter {
    private final /* synthetic */ StatisticsManager this$0;

    StatisticsManager$3(StatisticsManager statisticsManager) {
        this.this$0 = statisticsManager;
    }

    @Override
    public boolean accept(File file, String string) {
        return null != string && string.startsWith("stats_") && string.endsWith(".zip");
    }
}

