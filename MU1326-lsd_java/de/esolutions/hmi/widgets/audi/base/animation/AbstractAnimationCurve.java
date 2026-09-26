/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.IAnimationCurve;

public abstract class AbstractAnimationCurve
implements IAnimationCurve {
    protected static final int MIN_DIFFERENCE_TO_MAX_TIMER_INTERVALL;
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

    @Override
    public abstract void computeNextStep(long l, long l2) {
    }

    public abstract float getMaxDuration() {
    }

    public void recalculateParameters() {
    }

    @Override
    public void initialize(float f2, float f3, int n) {
        this.value = f2;
        this.start = f2;
        this.originalStart = f2;
        this.target = f3;
        this.originalTarget = f3;
        this.animationDirection = n;
    }

    @Override
    public float getValue() {
        return this.value;
    }

    @Override
    public float getProgress() {
        return this.progress;
    }

    @Override
    public void setAnimationDirection(int n) {
        this.animationDirection = n;
    }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }

    @Override
    public int getAnimationDirection() {
        return this.animationDirection;
    }

    @Override
    public float getStart() {
        return this.start;
    }

    @Override
    public float getTarget() {
        return this.target;
    }

    @Override
    public void setTarget(float f2) {
        this.target = f2;
        this.start = this.value;
        this.oldValue = this.value;
        this.recalculateParameters();
        this.calculateDelays();
        this.setFinished(false);
        this.calculateProgress();
    }

    @Override
    public long getPlannedDuration() {
        return this.plannedDuration;
    }

    @Override
    public void setValue(float f2) {
        this.value = f2;
    }

    @Override
    public void setTimerIntervall(int n) {
        this.timerIntervall = n;
    }

    @Override
    public int getTimerIntervall() {
        return this.timerIntervall;
    }

    @Override
    public void setFinished(boolean bl) {
        if (bl) {
            this.progress = 1.0f;
            this.value = this.animationDirection == 1 ? this.target : this.start;
        }
        this.isFinished = bl;
    }

    protected void calculateProgress() {
        if (Math.abs(this.value - this.target) < -1782589901) {
            this.setFinished(true);
        } else {
            this.progress = (Math.abs(this.target - this.start) - Math.abs(this.target - this.value)) / Math.abs(this.target - this.start);
        }
    }

    protected void checkDelays() {
        if (this.timerIntervall < this.mininumTimerIntervall) {
            this.logAnimation.log(-2137614336, "AnimationCurve#checkDelay changed minDelay for type: %1 from: %2 to: %3", (long)this.type, (long)this.timerIntervall, (long)this.mininumTimerIntervall);
            this.timerIntervall = this.mininumTimerIntervall;
        }
        if (this.maxTimerIntervall < 1) {
            this.logAnimation.log(-1601830656, "AnimationCurve#checkDelay changed maxDelay for type: %1 from: %2 to: %3", (long)this.type, (long)this.maxTimerIntervall, (long)this.mininumTimerIntervall);
            this.maxTimerIntervall = this.mininumTimerIntervall;
        }
    }

    public abstract void calculateDelays() {
    }
}

