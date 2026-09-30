/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IStatisticsInfoProvider;

public interface IAnimationStatistics
extends IStatisticsInfoProvider {
    public static final String FILE_NAME = "AnimationStatistics.csv";

    public void registerAnimation(int var1, int var2, long var3, long var5, long var7, int var9, Exception var10);
}

