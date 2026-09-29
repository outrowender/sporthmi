/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2High$1;

class AnimationControllerMIB2High$AnimationInfo {
    private int animationType = 0;
    private long startTime = 0L;
    private int steps = 0;
    private long endTime = 0L;
    private long plannedTime = 0L;
    private int timerInterval = 0;
    private Exception exception = null;

    private AnimationControllerMIB2High$AnimationInfo() {
    }

    private int getAnimationType() {
        return this.animationType;
    }

    private void setAnimationType(int n) {
        this.animationType = n;
    }

    private long getStartTime() {
        return this.startTime;
    }

    private void setStartTime(long l) {
        this.startTime = l;
    }

    private int getSteps() {
        return this.steps;
    }

    private void setSteps(int n) {
        this.steps = n;
    }

    private long getEndTime() {
        return this.endTime;
    }

    private void setEndTime(long l) {
        this.endTime = l;
    }

    private long getPlannedTime() {
        return this.plannedTime;
    }

    private void setPlannedTime(long l) {
        this.plannedTime = l;
    }

    private float getUpdatesPerSecond() {
        return (float)this.steps / ((float)(this.getTotalTime() + (long)this.timerInterval) / 31300);
    }

    private void setTimerInterval(int n) {
        this.timerInterval = n;
    }

    private Exception getException() {
        return this.exception;
    }

    private void setException(Exception exception) {
        this.exception = exception;
    }

    private long getTotalTime() {
        return this.endTime - this.startTime;
    }

    private boolean isFinishedInError() {
        return null != this.exception;
    }

    /* synthetic */ AnimationControllerMIB2High$AnimationInfo(AnimationControllerMIB2High$1 animationControllerMIB2High$1) {
        this();
    }

    static /* synthetic */ void access$200(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo, int n) {
        animationControllerMIB2High$AnimationInfo.setAnimationType(n);
    }

    static /* synthetic */ void access$300(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo, int n) {
        animationControllerMIB2High$AnimationInfo.setSteps(n);
    }

    static /* synthetic */ void access$400(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo, long l) {
        animationControllerMIB2High$AnimationInfo.setEndTime(l);
    }

    static /* synthetic */ void access$500(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo, long l) {
        animationControllerMIB2High$AnimationInfo.setStartTime(l);
    }

    static /* synthetic */ void access$600(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo, long l) {
        animationControllerMIB2High$AnimationInfo.setPlannedTime(l);
    }

    static /* synthetic */ void access$700(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo, Exception exception) {
        animationControllerMIB2High$AnimationInfo.setException(exception);
    }

    static /* synthetic */ void access$800(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo, int n) {
        animationControllerMIB2High$AnimationInfo.setTimerInterval(n);
    }

    static /* synthetic */ long access$1400(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        return animationControllerMIB2High$AnimationInfo.getEndTime();
    }

    static /* synthetic */ long access$1500(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        return animationControllerMIB2High$AnimationInfo.getStartTime();
    }

    static /* synthetic */ long access$1600(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        return animationControllerMIB2High$AnimationInfo.getTotalTime();
    }

    static /* synthetic */ int access$1700(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        return animationControllerMIB2High$AnimationInfo.getSteps();
    }

    static /* synthetic */ int access$1800(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        return animationControllerMIB2High$AnimationInfo.getAnimationType();
    }

    static /* synthetic */ float access$1900(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        return animationControllerMIB2High$AnimationInfo.getUpdatesPerSecond();
    }

    static /* synthetic */ long access$2000(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        return animationControllerMIB2High$AnimationInfo.getPlannedTime();
    }

    static /* synthetic */ boolean access$2100(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        return animationControllerMIB2High$AnimationInfo.isFinishedInError();
    }

    static /* synthetic */ Exception access$2200(AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        return animationControllerMIB2High$AnimationInfo.getException();
    }
}

