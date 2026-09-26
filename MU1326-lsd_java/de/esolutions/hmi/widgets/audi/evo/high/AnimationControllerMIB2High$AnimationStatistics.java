/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2High$1;

class AnimationControllerMIB2High$AnimationStatistics {
    private volatile int count = 0;
    private volatile long totalSteps = 0L;
    private volatile long totalTime = 0L;
    private volatile int errCount = 0;

    private AnimationControllerMIB2High$AnimationStatistics() {
    }

    /* synthetic */ AnimationControllerMIB2High$AnimationStatistics(AnimationControllerMIB2High$1 animationControllerMIB2High$1) {
        this();
    }

    static /* synthetic */ int access$1004(AnimationControllerMIB2High$AnimationStatistics animationControllerMIB2High$AnimationStatistics) {
        return ++animationControllerMIB2High$AnimationStatistics.count;
    }

    static /* synthetic */ int access$1104(AnimationControllerMIB2High$AnimationStatistics animationControllerMIB2High$AnimationStatistics) {
        return ++animationControllerMIB2High$AnimationStatistics.errCount;
    }

    static /* synthetic */ long access$1214(AnimationControllerMIB2High$AnimationStatistics animationControllerMIB2High$AnimationStatistics, long l) {
        return animationControllerMIB2High$AnimationStatistics.totalSteps += l;
    }

    static /* synthetic */ long access$1314(AnimationControllerMIB2High$AnimationStatistics animationControllerMIB2High$AnimationStatistics, long l) {
        return animationControllerMIB2High$AnimationStatistics.totalTime += l;
    }

    static /* synthetic */ long access$1300(AnimationControllerMIB2High$AnimationStatistics animationControllerMIB2High$AnimationStatistics) {
        return animationControllerMIB2High$AnimationStatistics.totalTime;
    }

    static /* synthetic */ int access$1000(AnimationControllerMIB2High$AnimationStatistics animationControllerMIB2High$AnimationStatistics) {
        return animationControllerMIB2High$AnimationStatistics.count;
    }

    static /* synthetic */ long access$1200(AnimationControllerMIB2High$AnimationStatistics animationControllerMIB2High$AnimationStatistics) {
        return animationControllerMIB2High$AnimationStatistics.totalSteps;
    }

    static /* synthetic */ int access$1100(AnimationControllerMIB2High$AnimationStatistics animationControllerMIB2High$AnimationStatistics) {
        return animationControllerMIB2High$AnimationStatistics.errCount;
    }
}

