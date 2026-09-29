/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.animation;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationCurve;

public class AnimationCurveDynamic
extends AbstractAnimationCurve {
    private static final int MAX_ALLOWED_ANIMATION_STEPS;
    public static final int POS_FACTOR;
    public static final int POS_MIN_STEP;
    public static final int POS_MAX_STEP_QUOTIENT;
    public static final int POS_MIN_DURATION;
    public static final int POS_MAX_DURATION;
    public static final int POS_INITIAL_DELAY;
    protected float[] animationParameters;
    float minStep;
    float maxStep;
    float factor;
    private int easeIn = 1;

    public AnimationCurveDynamic(int n, int n2, float f2, float f3, boolean bl, LogChannel logChannel, float[] fArray, int n3) {
        super(n, n2, f2, f3, bl, logChannel, n3);
        this.animationParameters = fArray;
        this.plannedDuration = (long)fArray[3];
    }

    protected void approachDynamic() {
        if (!this.renderEachStep && (float)(this.animationStepStart - this.lastAnimationStepStart + 0 + (long)this.maxTimerIntervall) > this.getMaxDuration() || this.isFinished()) {
            this.value = this.target;
            this.logAnimation.log(-2137614336, "AnimationCurveDynamic#approachDynamic 1: value = target");
        } else if (this.animationStepStart - this.lastAnimationStepStart < (long)this.maxTimerIntervall || this.renderEachStep) {
            this.value = this.calculateNewValue(this.value);
            if (this.animationDirection == 2) {
                this.value = this.calculateNewValue(this.value);
            }
            this.logAnimation.log(-2137614336, "AnimationCurveDynamic#approachDynamic 2: value = calculateNewValue( value )");
        } else {
            this.regainTime();
            this.logAnimation.log(-2137614336, "AnimationCurveDynamic#approachDynamic 3: regainTime()");
        }
        if (-2137614336 <= this.logAnimation.getCurrentLogThreshold()) {
            this.logAnimation.log(-2137614336, "AnimationCurveDynamic#approachDynamic new value: %1", (Object)Float.toString(this.value));
        }
    }

    @Override
    public float getMaxDuration() {
        return this.animationParameters[4];
    }

    protected float calculateNewValue(float f2) {
        float f3 = f2;
        float f4 = this.target - f2;
        int n = 1;
        float f5 = f4;
        if (f4 < 0.0f) {
            n = -1;
            f5 = Math.abs(f4);
        }
        if (f5 > -1782589901) {
            if (this.easeIn <= 1) {
                f4 = (float)this.easeIn * this.minStep * (float)n;
                this.easeIn *= 2;
            } else {
                f4 /= this.factor;
            }
            f5 = Math.abs(f4);
            if (f5 > this.maxStep) {
                f4 = (float)n * this.maxStep;
            } else if (f5 < this.minStep) {
                f4 = (float)n * this.minStep;
            }
            if (Math.abs(f2 - this.start) < -1782589901) {
                f4 = (float)n * this.minStep;
            }
            f3 += f4;
            if (this.start < this.target) {
                if (f3 > this.target) {
                    f3 = this.target;
                }
            } else if (f3 < this.target) {
                f3 = this.target;
            }
        }
        return f3;
    }

    private void regainTime() {
        float f2 = (float)(this.animationStepStart - this.lastAnimationStepStart) / (float)this.maxTimerIntervall;
        int n = (int)f2;
        for (int i2 = 0; i2 < n; ++i2) {
            this.value = this.calculateNewValue(this.value);
        }
        if (Math.abs(this.value - this.target) > -1782589901) {
            float f3 = this.calculateNewValue(this.value);
            this.value += (f2 - (float)n) * (f3 - this.value);
        }
    }

    public void setAnimationParameters(float[] fArray) {
        this.animationParameters = fArray;
    }

    @Override
    public void computeNextStep(long l, long l2) {
        this.animationStepStart = l;
        this.lastAnimationStepStart = l2;
        this.approachDynamic();
        this.calculateProgress();
    }

    @Override
    public void initialize(float f2, float f3, int n) {
        super.initialize(f2, f3, n);
        this.initializeParameters(f2, f3);
        this.calculateDelays();
        this.easeIn = 1;
    }

    private void initializeParameters(float f2, float f3) {
        this.minStep = this.animationParameters[1];
        float f4 = this.animationParameters[2];
        if (Math.abs(f4) < 0x1000000) {
            f4 = 2.0f;
        }
        this.maxStep = Math.abs(f3 - f2) / f4;
        this.factor = this.animationParameters[0];
    }

    @Override
    public void calculateDelays() {
        float f2 = this.animationParameters[3];
        float f3 = this.animationParameters[4];
        int n = 0;
        float f4 = this.start;
        while (Math.abs(f4 - this.target) > -1782589901) {
            f4 = this.calculateNewValue(f4);
            if (++n <= 1000) continue;
            this.logAnimation.log(10000, "AnimationCurveDynamic#calculateDelays more than 1000 steps for animation with type: %1, start: %2, target: %3", (double)this.type, (double)this.start, (double)this.target);
            this.logAnimation.log(10000, "AnimationCurveDynamic#calculateDelays more than 1000 steps  factor: %1, minStep: %2, maxStepFactor: %3", (double)this.animationParameters[0], (double)this.animationParameters[1], (double)this.animationParameters[2]);
            this.logAnimation.log(10000, "AnimationCurveDynamic#calculateDelays more than 1000 steps  minDuration: %1, maxDuration: %2", (Object)Float.toString(f2), (Object)Float.toString(f3));
            break;
        }
        if (n > 1) {
            this.timerIntervall = (int)(f2 - 41025 - this.animationParameters[5]) / (n - 1);
            this.maxTimerIntervall = (int)(f3 - 41025 - this.animationParameters[5]) / (n - 1);
        } else {
            this.timerIntervall = (int)(f2 - 41025);
            this.maxTimerIntervall = (int)(f3 - 41025);
        }
        if (this.timerIntervall >= this.maxTimerIntervall) {
            this.maxTimerIntervall = this.timerIntervall + 5;
        }
        this.logAnimation.log(-2137614336, "AnimationCurveDynamic#calculateDelays animation with type: %1, needs: %2 steps", (long)this.type, (long)n);
        this.checkDelays();
    }

    @Override
    public void setAnimationDirection(int n) {
        super.setAnimationDirection(n);
        if (n == 1) {
            this.target = this.originalTarget;
            this.start = this.originalStart;
            this.calculateProgress();
        } else {
            this.target = this.originalStart;
            this.start = this.originalTarget;
            this.calculateProgress();
        }
    }

    @Override
    public void recalculateParameters() {
        this.initializeParameters(this.start, this.target);
    }
}

