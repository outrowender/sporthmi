/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IStatisticsInfoProvider;

public interface IKZBStatistics
extends IStatisticsInfoProvider {
    public static final String FILE_NAME;

    default public void loadStart(int n) {
    }

    default public void loadEnd(String string, Object object, int n, boolean bl) {
    }

    default public String getStatisticsForScreen(int n) {
    }
}

