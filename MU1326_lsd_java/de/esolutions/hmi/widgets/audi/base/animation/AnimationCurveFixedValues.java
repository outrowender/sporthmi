/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationCurve;

public class AnimationCurveFixedValues
extends AbstractAnimationCurve {
    public static final int POS_MIN_DURATION = 3;
    public static final int POS_MAX_DURATION = 4;
    public static final int POS_INITIAL_DELAY = 5;
    protected int fixedValueStep;
    protected float[] animationParameters;
    protected float[] fixedValues;
    private boolean isEndlessAnimation = false;
    private boolean fastRollBack = false;

    public AnimationCurveFixedValues(int n, int n2, float f2, float f3, boolean bl, LogChannel logChannel, float[] fArray, float[] fArray2, boolean bl2, int n3) {
        super(n, n2, f2, f3, bl, logChannel, n3);
        this.animationParameters = fArray;
        this.plannedDuration = (long)fArray[3];
        this.fixedValues = fArray2;
        this.isEndlessAnimation = bl2;
    }

    public void computeNextStep(long l, long l2) {
        this.animationStepStart = l;
        this.lastAnimationStepStart = l2;
        if (!this.isEndlessAnimation) {
            try {
                this.approachDynamic();
                this.calculateProgress();
            }
            catch (Exception exception) {
                this.logAnimation.log(10000000, "AnimationCurveFixedValues#computeNextStep catching exception, ensure that animationstep is correctly increased", (Throwable)exception);
            }
            if (this.animationDirection == 2) {
                this.fixedValueStep = this.fastRollBack ? (this.fixedValueStep -= 2) : --this.fixedValueStep;
                if (this.fixedValueStep < 0) {
                    this.fixedValueStep = 0;
                }
            } else {
                ++this.fixedValueStep;
            }
        }
    }

    protected void approachDynamic() {
        if (this.animationDirection == 2 && this.fixedValueStep == 0 || this.isFinished()) {
            this.value = this.start;
            return;
        }
        if (!this.renderEachStep && (float)(this.animationStepStart - this.lastAnimationStepStart + 20L + (long)this.maxTimerIntervall) > this.getMaxDuration()) {
            this.value = this.target;
            this.logAnimation.log(10000000, "AnimationCurveFixedValues#approachDynamic 1: value = target");
        } else if (this.animationStepStart - this.lastAnimationStepStart <= (long)this.maxTimerIntervall || this.renderEachStep) {
            this.value = this.getFixedValue(this.fixedValueStep);
            this.logAnimation.log(10000000, "AnimationCurveFixedValues#approachDynamic 2: value = calculateNewValue( value )");
        } else {
            this.regainTime();
            this.logAnimation.log(10000000, "AnimationCurveFixedValues#approachDynamic 3: regainTime()");
        }
        if (10000000 <= this.logAnimation.getCurrentLogThreshold()) {
            this.logAnimation.log(10000000, "AnimationCurveFixedValues#approachDynamic new value: %1", (Object)Float.toString(this.value));
        }
    }

    private void regainTime() {
        int n = (int)((this.animationStepStart - this.lastAnimationStepStart) / (long)this.maxTimerIntervall);
        if (this.animationDirection == 2) {
            this.fixedValueStep -= n;
            if (this.fixedValueStep < 0) {
                this.fixedValueStep = 0;
            }
        } else {
            this.fixedValueStep += n;
        }
        this.value = this.getFixedValue(this.fixedValueStep);
    }

    public void initialize(float f2, float f3, int n) {
        super.initialize(f2, f3, n);
        this.calculateDelays();
        this.fixedValueStep = 0;
    }

    public void recalculateParameters() {
        this.fixedValueStep = 0;
    }

    private float getFixedValue(int n) {
        float f2 = n < this.fixedValues.length ? this.fixedValues[n] : 1.0f;
        return this.start + (this.target - this.start) * f2;
    }

    public float getMaxDuration() {
        return this.animationParameters[4];
    }

    public void calculateDelays() {
        if (!this.isEndlessAnimation) {
            float f2 = this.animationParameters[3];
            float f3 = this.animationParameters[4];
            int n = this.fixedValues.length;
            if (n > 1) {
                this.timerIntervall = (int)(f2 - 20.0f - this.animationParameters[5]) / (n - 1);
                this.maxTimerIntervall = (int)(f3 - 20.0f - this.animationParameters[5]) / (n - 1);
            } else {
                this.timerIntervall = (int)(f2 - 20.0f);
                this.maxTimerIntervall = (int)(f3 - 20.0f);
            }
            if (this.timerIntervall >= this.maxTimerIntervall) {
                this.maxTimerIntervall = this.timerIntervall + 5;
            }
            this.logAnimation.log(10000000, "AnimationCurveFixedValues#calculateDelays animation with type: %1, needs: %2 steps", (long)this.type, (long)n);
        }
        this.checkDelays();
    }

    protected void calculateProgress() {
        if (this.animationDirection == 2 && Math.abs(this.value - this.start) < 1.0E-7f) {
            this.setFinished(true);
        } else {
            super.calculateProgress();
        }
    }

    public void setAnimationDirection(int n) {
        if (n == 2) {
            this.fixedValueStep = this.fastRollBack ? (this.fixedValueStep -= 2) : --this.fixedValueStep;
            if (this.fixedValueStep < 0) {
                this.fixedValueStep = 0;
            }
        } else {
            ++this.fixedValueStep;
        }
        super.setAnimationDirection(n);
    }

    public void setFastRollBack(boolean bl) {
        this.fastRollBack = bl;
    }
}

