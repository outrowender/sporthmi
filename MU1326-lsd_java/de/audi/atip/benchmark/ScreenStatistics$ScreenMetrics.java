/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.ScreenStatistics$1;

class ScreenStatistics$ScreenMetrics {
    int screenDraws;
    long screenPaintTime;
    long guiDrawTime;
    int worstPaintTime;
    int worstGuiDrawTime;
    int cacheHits;
    int createdCount;
    int worstCreateTime;
    long totalCreateTime;
    int connectCount;
    int worstConnectTime;
    long connectTotalTime;

    private ScreenStatistics$ScreenMetrics() {
    }

    /* synthetic */ ScreenStatistics$ScreenMetrics(ScreenStatistics$1 screenStatistics$1) {
        this();
    }
}

