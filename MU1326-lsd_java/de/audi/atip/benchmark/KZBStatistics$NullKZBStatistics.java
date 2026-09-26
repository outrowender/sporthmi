/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IKZBStatistics;
import de.audi.atip.benchmark.KZBStatistics$1;
import java.io.PrintStream;

final class KZBStatistics$NullKZBStatistics
implements IKZBStatistics {
    private KZBStatistics$NullKZBStatistics() {
    }

    @Override
    public void reset() {
    }

    @Override
    public String getName() {
        return "KZBStatistics.csv";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
    }

    @Override
    public void loadStart(int n) {
    }

    @Override
    public void loadEnd(String string, Object object, int n, boolean bl) {
    }

    @Override
    public String getStatisticsForScreen(int n) {
        return "";
    }

    /* synthetic */ KZBStatistics$NullKZBStatistics(KZBStatistics$1 kZBStatistics$1) {
        this();
    }
}

