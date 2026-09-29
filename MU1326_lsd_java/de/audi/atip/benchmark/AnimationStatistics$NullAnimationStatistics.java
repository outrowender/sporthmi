/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.AnimationStatistics$1;
import de.audi.atip.benchmark.IAnimationStatistics;
import java.io.PrintStream;

final class AnimationStatistics$NullAnimationStatistics
implements IAnimationStatistics {
    private AnimationStatistics$NullAnimationStatistics() {
    }

    @Override
    public String getName() {
        return "AnimationStatistics.csv";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
    }

    @Override
    public void reset() {
    }

    @Override
    public void registerAnimation(int n, int n2, long l, long l2, long l3, int n3, Exception exception) {
    }

    /* synthetic */ AnimationStatistics$NullAnimationStatistics(AnimationStatistics$1 animationStatistics$1) {
        this();
    }
}

