/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IStatisticsInfoProvider;

public interface IAnimationStatistics
extends IStatisticsInfoProvider {
    public static final String FILE_NAME;

    default public void registerAnimation(int n, int n2, long l, long l2, long l3, int n3, Exception exception) {
    }
}

