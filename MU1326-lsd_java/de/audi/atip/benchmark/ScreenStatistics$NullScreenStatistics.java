/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IScreenStatistics;
import de.audi.atip.benchmark.ScreenStatistics$1;
import java.io.PrintStream;

final class ScreenStatistics$NullScreenStatistics
implements IScreenStatistics {
    private ScreenStatistics$NullScreenStatistics() {
    }

    @Override
    public String getName() {
        return "ScreenStatistics.csv";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
    }

    @Override
    public void reset() {
    }

    @Override
    public void paintStart(int n) {
    }

    @Override
    public void paintEnd() {
    }

    @Override
    public void drawEnd() {
    }

    @Override
    public void increaseCacheHits(int n) {
    }

    @Override
    public void getScreenStart(int n) {
    }

    @Override
    public void getScreenEnd() {
    }

    @Override
    public void connectStart(int n) {
    }

    @Override
    public void connectEnd() {
    }

    /* synthetic */ ScreenStatistics$NullScreenStatistics(ScreenStatistics$1 screenStatistics$1) {
        this();
    }
}

