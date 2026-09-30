/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

public interface IAnimationCurve {
    public static final int ANIMATION_DIRECTION_FORWARD = 1;
    public static final int ANIMATION_DIRECTION_BACKWARD = 2;
    public static final float MIN_DIFFERENCE = 1.0E-7f;
    public static final int APPROX_MIN_TIME_FOR_STEP = 20;

    public int getAnimationDirection();

    public float getStart();

    public float getTarget();

    public void setValue(float var1);

    public void setFinished(boolean var1);

    public int getTimerIntervall();

    public void setTimerIntervall(int var1);

    public long getPlannedDuration();

    public void setTarget(float var1);

    public boolean isFinished();

    public void setAnimationDirection(int var1);

    public float getProgress();

    public float getValue();

    public void initialize(float var1, float var2, int var3);

    public void computeNextStep(long var1, long var3);
}

