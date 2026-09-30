/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IStatisticsInfoProvider;

public interface IKZBStatistics
extends IStatisticsInfoProvider {
    public static final String FILE_NAME = "KZBStatistics.csv";

    public void loadStart(int var1);

    public void loadEnd(String var1, Object var2, int var3, boolean var4);

    public String getStatisticsForScreen(int var1);
}

