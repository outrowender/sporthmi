/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.AnimationStatistics$1;

class AnimationStatistics$AnimationInfo {
    private int type = 0;
    private long start = 0L;
    private int steps = 0;
    private long end = 0L;
    private long plannedTime = 0L;
    private int timerInterval = 0;
    private Exception e = null;

    private AnimationStatistics$AnimationInfo() {
    }

    /* synthetic */ AnimationStatistics$AnimationInfo(AnimationStatistics$1 animationStatistics$1) {
        this();
    }

    static /* synthetic */ int access$202(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo, int n) {
        animationStatistics$AnimationInfo.type = n;
        return animationStatistics$AnimationInfo.type;
    }

    static /* synthetic */ int access$302(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo, int n) {
        animationStatistics$AnimationInfo.steps = n;
        return animationStatistics$AnimationInfo.steps;
    }

    static /* synthetic */ long access$402(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo, long l) {
        animationStatistics$AnimationInfo.end = l;
        return animationStatistics$AnimationInfo.end;
    }

    static /* synthetic */ long access$502(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo, long l) {
        animationStatistics$AnimationInfo.start = l;
        return animationStatistics$AnimationInfo.start;
    }

    static /* synthetic */ long access$602(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo, long l) {
        animationStatistics$AnimationInfo.plannedTime = l;
        return animationStatistics$AnimationInfo.plannedTime;
    }

    static /* synthetic */ int access$702(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo, int n) {
        animationStatistics$AnimationInfo.timerInterval = n;
        return animationStatistics$AnimationInfo.timerInterval;
    }

    static /* synthetic */ Exception access$802(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo, Exception exception) {
        animationStatistics$AnimationInfo.e = exception;
        return animationStatistics$AnimationInfo.e;
    }

    static /* synthetic */ long access$400(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo) {
        return animationStatistics$AnimationInfo.end;
    }

    static /* synthetic */ long access$500(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo) {
        return animationStatistics$AnimationInfo.start;
    }

    static /* synthetic */ Exception access$800(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo) {
        return animationStatistics$AnimationInfo.e;
    }

    static /* synthetic */ int access$300(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo) {
        return animationStatistics$AnimationInfo.steps;
    }

    static /* synthetic */ int access$700(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo) {
        return animationStatistics$AnimationInfo.timerInterval;
    }

    static /* synthetic */ long access$600(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo) {
        return animationStatistics$AnimationInfo.plannedTime;
    }

    static /* synthetic */ int access$200(AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo) {
        return animationStatistics$AnimationInfo.type;
    }
}

