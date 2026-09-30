/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IStatisticsInfoProvider;

public interface IScreenStatistics
extends IStatisticsInfoProvider {
    public static final String FILE_NAME = "ScreenStatistics.csv";

    public void paintStart(int var1);

    public void paintEnd();

    public void drawEnd();

    public void increaseCacheHits(int var1);

    public void getScreenStart(int var1);

    public void getScreenEnd();

    public void connectStart(int var1);

    public void connectEnd();
}

