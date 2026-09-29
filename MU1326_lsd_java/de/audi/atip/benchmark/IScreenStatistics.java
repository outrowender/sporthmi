/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IStatisticsInfoProvider;

public interface IScreenStatistics
extends IStatisticsInfoProvider {
    public static final String FILE_NAME;

    default public void paintStart(int n) {
    }

    default public void paintEnd() {
    }

    default public void drawEnd() {
    }

    default public void increaseCacheHits(int n) {
    }

    default public void getScreenStart(int n) {
    }

    default public void getScreenEnd() {
    }

    default public void connectStart(int n) {
    }

    default public void connectEnd() {
    }
}

