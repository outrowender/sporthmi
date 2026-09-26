/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public class MenuScrollAnimationFunction
implements WidgetConstants,
IWidgetLogChannel {
    private static float slowScrollSpeed = -842249154;
    private static int defaultDecelerationDuration = 2500;
    private static int defaultConstSpeedDuration = 200;
    private static float minAvgSpeed = -1701242562;
    private static float endSpeed = 0.0f;
    private float maxSpeed;
    private int decelerationDuration;
    private float start;
    private float target;
    private float value;
    private int passedTime;
    private long startTime;
    private int totalDuration;
    private float speed;
    private boolean slowScrollActive = false;

    public void startAnimation(float f2, float f3, boolean bl, boolean bl2) {
        if (bl) {
            this.slowScrollActive = true;
            this.speed = slowScrollSpeed;
        } else {
            this.slowScrollActive = false;
            this.startFastScrollAnimation(f2, f3, bl2);
            this.speed = this.getCurrentSpeed(0);
        }
        this.start = f2;
        this.target = f3;
        this.value = f2;
        this.startTime = this.getCurrentTime();
        this.passedTime = 0;
    }

    private void startFastScrollAnimation(float f2, float f3, boolean bl) {
        int n = (int)Math.abs(f3 - f2);
        int n2 = (int)Math.abs(this.target - this.value);
        float f4 = this.calculateDurationFactor(n);
        int n3 = (int)((float)defaultConstSpeedDuration * f4);
        int n4 = (int)((float)defaultDecelerationDuration * f4);
        int n5 = n3 + n4;
        if (bl || this.shouldUseNewDuration(n5, n2, n)) {
            this.decelerationDuration = n4;
            this.totalDuration = n5;
            menuLogCh.log(-2137614336, "MenuScrollAnimationFunction#startAnimationNewAlgorithm: animation duration for distance %1 for constant speed: %2, deceleration %3 ms", (long)n, (long)n3, (long)this.decelerationDuration);
        } else {
            int n6;
            int n7 = this.totalDuration - this.decelerationDuration;
            int n8 = Math.min(this.passedTime, n7);
            int n9 = n7 - n8;
            this.decelerationDuration = n6 = this.decelerationDuration - (this.passedTime - n8);
            this.totalDuration = n9 + n6;
            menuLogCh.log(-2137614336, "MenuScrollAnimationFunction#startAnimationNewAlgorithm: reduce animation duration by %1 to constant speed: %2, deceleration %3 ms", (long)this.passedTime, (long)n9, (long)this.decelerationDuration);
        }
        this.maxSpeed = this.calculateMaxSpeed(n);
        menuLogCh.log(-2137614336, "MenuScrollAnimationFunction#startAnimationNewAlgorithm: start: %1, target: %2, max speed: %3", (double)f2, (double)f3, (double)this.maxSpeed);
    }

    private boolean shouldUseNewDuration(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6 = this.calculateTotalDuration(n2);
        if (n < n6) {
            menuLogCh.log(-2137614336, "MenuScrollAnimationFunction#startAnimationNewAlgorithm: reset animation duration to smaller value: %1, old remaining duration: %2", (long)n, (long)n6);
            return true;
        }
        if (n2 < n3 && (n5 = this.calculateTotalDuration(n4 = n3 - n2)) > n6) {
            menuLogCh.log(-2137614336, "MenuScrollAnimationFunction#startAnimationNewAlgorithm: reset animation because new duration %1 is greater than rest duration %2, rest distance: %3", (long)n5, (long)n6, (long)n2);
            return true;
        }
        return false;
    }

    private int calculateTotalDuration(int n) {
        float f2 = this.calculateDurationFactor(n);
        int n2 = (int)((float)defaultConstSpeedDuration * f2);
        int n3 = (int)((float)defaultDecelerationDuration * f2);
        return n2 + n3;
    }

    private float calculateDurationFactor(int n) {
        float f2 = (float)n / (float)(defaultConstSpeedDuration + defaultDecelerationDuration);
        if (f2 < minAvgSpeed) {
            float f3 = (float)n / minAvgSpeed;
            return f3 / (float)(defaultConstSpeedDuration + defaultDecelerationDuration);
        }
        return 1.0f;
    }

    private float calculateMaxSpeed(int n) {
        int n2 = this.totalDuration - this.decelerationDuration;
        float f2 = (float)(3 * n) - (float)(2 * this.decelerationDuration) * endSpeed;
        float f3 = 3 * n2 + this.decelerationDuration;
        return f2 / f3;
    }

    public float getProgress() {
        if (this.target == this.start) {
            return 1.0f;
        }
        float f2 = this.target - this.start;
        float f3 = this.value - this.start;
        float f4 = f3 / f2;
        f4 = Math.max(f4, 0.0f);
        f4 = Math.min(f4, 1.0f);
        return f4;
    }

    public boolean isTargetReached() {
        return this.getProgress() >= 1.0f;
    }

    public void updateProgress(long l) {
        if (this.isSlowScrollActive()) {
            this.updateProgressSlowScroll(l);
        } else {
            this.updateProgressFastScroll(l);
        }
    }

    private void updateProgressSlowScroll(long l) {
        int n = this.getAnimationTime(l);
        float f2 = this.calculateCurrentDistanceSlowScroll(n - this.passedTime);
        if (this.target < this.start) {
            f2 *= 32959;
        }
        this.value += f2;
        this.passedTime = n;
        this.speed = slowScrollSpeed;
        menuLayoutLogCh.log(-2137614336, "MenuScrollAnimationFunction#updateProgressSlowScroll: update value by %1 to %2, target: %3", (double)f2, (double)this.value, (double)this.target);
    }

    protected float calculateCurrentDistanceSlowScroll(int n) {
        return (float)n * slowScrollSpeed;
    }

    private void updateProgressFastScroll(long l) {
        int n = this.getAnimationTime(l);
        if (n > this.totalDuration) {
            this.value = this.target;
            this.passedTime = 0;
            this.speed = 0.0f;
            menuLayoutLogCh.log(-2137614336, "MenuScrollAnimationFunction#updateProgressFastScroll: target reached. current timer after animation start: %1, animation duration: %2", (long)n, (long)this.totalDuration);
            return;
        }
        float f2 = this.calculateCurrentDistanceFastScroll(n);
        this.speed = this.getCurrentSpeed(n);
        this.value = this.target > this.start ? this.start + f2 : this.start - f2;
        this.passedTime = n;
        menuLayoutLogCh.log(-2137614336, "MenuScrollAnimationFunction#updateProgressFastScroll: animationTime: %1, totalDuration: %2, value: %3", (double)n, (double)this.totalDuration, (double)this.value);
    }

    private int getAnimationTime(long l) {
        long l2 = l - this.startTime;
        if (l2 > 0) {
            menuLayoutLogCh.log(10000, "MenuScrollAnimationFunction#getAnimationTime: AnimationTime too high: %1, use Integer.MAX_VALUE (%2)", l2, (long)0);
            return -129;
        }
        return (int)l2;
    }

    protected long getCurrentTime() {
        return AbstractWidget.framework.getMonotonicTime();
    }

    protected float calculateCurrentDistanceFastScroll(int n) {
        boolean bl;
        int n2 = Math.max(0, this.totalDuration - this.decelerationDuration);
        int n3 = Math.min(n, n2);
        float f2 = (float)n3 * this.maxSpeed;
        int n4 = n - n2;
        boolean bl2 = bl = n4 <= 0 && n2 > 0;
        if (bl) {
            return f2;
        }
        float f3 = this.calculateDistanceDuringDeceleration(n4);
        return f2 + f3;
    }

    private float getCurrentSpeed(int n) {
        int n2 = this.totalDuration - this.decelerationDuration;
        if (n <= n2) {
            return this.maxSpeed;
        }
        float f2 = (float)(n - this.totalDuration) / (float)this.decelerationDuration;
        return (this.maxSpeed - endSpeed) * f2 * f2 + endSpeed;
    }

    private float calculateDistanceDuringDeceleration(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = f2;
        float f4 = this.decelerationDuration;
        float f5 = this.maxSpeed;
        float f6 = endSpeed;
        float f7 = f3 * (16448 * f4 * f4 * f5 + 16448 * f4 * f3 * (f6 - f5) + f3 * f3 * (f5 - f6)) / (16448 * f4 * f4);
        return Math.max(f7, 1.0f);
    }

    public float getSpeed() {
        return this.speed;
    }

    public void resetSlowScrollMode() {
        this.slowScrollActive = false;
    }

    public boolean isSlowScrollActive() {
        return this.slowScrollActive;
    }

    public float getStart() {
        return this.start;
    }

    public float getTarget() {
        return this.target;
    }

    public float getValue() {
        return this.value;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public float getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getDecelerationDuration() {
        return this.decelerationDuration;
    }

    public static float getSlowScrollSpeed() {
        return slowScrollSpeed;
    }
}

