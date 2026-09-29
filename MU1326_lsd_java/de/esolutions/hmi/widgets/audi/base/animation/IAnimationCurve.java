/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

public interface IAnimationCurve {
    public static final int ANIMATION_DIRECTION_FORWARD;
    public static final int ANIMATION_DIRECTION_BACKWARD;
    public static final float MIN_DIFFERENCE;
    public static final int APPROX_MIN_TIME_FOR_STEP;

    default public int getAnimationDirection() {
    }

    default public float getStart() {
    }

    default public float getTarget() {
    }

    default public void setValue(float f2) {
    }

    default public void setFinished(boolean bl) {
    }

    default public int getTimerIntervall() {
    }

    default public void setTimerIntervall(int n) {
    }

    default public long getPlannedDuration() {
    }

    default public void setTarget(float f2) {
    }

    default public boolean isFinished() {
    }

    default public void setAnimationDirection(int n) {
    }

    default public float getProgress() {
    }

    default public float getValue() {
    }

    default public void initialize(float f2, float f3, int n) {
    }

    default public void computeNextStep(long l, long l2) {
    }
}

