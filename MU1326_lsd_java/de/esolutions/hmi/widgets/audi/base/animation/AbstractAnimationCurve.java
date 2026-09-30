/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.IAnimationCurve;

public abstract class AbstractAnimationCurve
implements IAnimationCurve {
    protected static final int MIN_DIFFERENCE_TO_MAX_TIMER_INTERVALL = 5;
    protected int animationDirection;
    protected float value;
    protected float oldValue;
    protected float originalStart;
    protected float start;
    protected float target;
    protected float originalTarget;
    protected float progress;
    protected int maxTimerIntervall;
    private boolean isFinished = false;
    protected long plannedDuration;
    protected int timerIntervall;
    protected boolean renderEachStep;
    protected LogChannel logAnimation;
    protected long animationStepStart;
    protected long lastAnimationStepStart;
    protected int type;
    private int mininumTimerIntervall;

    public AbstractAnimationCurve(int n, int n2, float f2, float f3, boolean bl, LogChannel logChannel, int n3) {
        this.type = n;
        this.animationDirection = n2;
        this.value = f2;
        this.start = f2;
        this.originalStart = f2;
        this.target = f3;
        this.originalTarget = f3;
        this.renderEachStep = bl;
        this.logAnimation = logChannel;
        this.mininumTimerIntervall = n3;
    }

    public abstract void computeNextStep(long var1, long var3);

    public abstract float getMaxDuration();

    public void recalculateParameters() {
    }

    public void initialize(float f2, float f3, int n) {
        this.value = f2;
        this.start = f2;
        this.originalStart = f2;
        this.target = f3;
        this.originalTarget = f3;
        this.animationDirection = n;
    }

    public float getValue() {
        return this.value;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setAnimationDirection(int n) {
        this.animationDirection = n;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public int getAnimationDirection() {
        return this.animationDirection;
    }

    public float getStart() {
        return this.start;
    }

    public float getTarget() {
        return this.target;
    }

    public void setTarget(float f2) {
        this.target = f2;
        this.start = this.value;
        this.oldValue = this.value;
        this.recalculateParameters();
        this.calculateDelays();
        this.setFinished(false);
        this.calculateProgress();
    }

    public long getPlannedDuration() {
        return this.plannedDuration;
    }

    public void setValue(float f2) {
        this.value = f2;
    }

    public void setTimerIntervall(int n) {
        this.timerIntervall = n;
    }

    public int getTimerIntervall() {
        return this.timerIntervall;
    }

    public void setFinished(boolean bl) {
        if (bl) {
            this.progress = 1.0f;
            this.value = this.animationDirection == 1 ? this.target : this.start;
        }
        this.isFinished = bl;
    }

    protected void calculateProgress() {
        if (Math.abs(this.value - this.target) < 1.0E-7f) {
            this.setFinished(true);
        } else {
            this.progress = (Math.abs(this.target - this.start) - Math.abs(this.target - this.value)) / Math.abs(this.target - this.start);
        }
    }

    protected void checkDelays() {
        if (this.timerIntervall < this.mininumTimerIntervall) {
            this.logAnimation.log(10000000, "AnimationCurve#checkDelay changed minDelay for type: %1 from: %2 to: %3", (long)this.type, (long)this.timerIntervall, (long)this.mininumTimerIntervall);
            this.timerIntervall = this.mininumTimerIntervall;
        }
        if (this.maxTimerIntervall < 1) {
            this.logAnimation.log(100000, "AnimationCurve#checkDelay changed maxDelay for type: %1 from: %2 to: %3", (long)this.type, (long)this.maxTimerIntervall, (long)this.mininumTimerIntervall);
            this.maxTimerIntervall = this.mininumTimerIntervall;
        }
    }

    public abstract void calculateDelays();
}

