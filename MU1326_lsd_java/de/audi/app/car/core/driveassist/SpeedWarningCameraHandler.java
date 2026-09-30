/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

public class SpeedWarningCameraHandler {
    private volatile boolean state = false;
    private volatile int valueState;
    private volatile float value;
    private volatile int unit = 0;
    private static final float KMH_STEP_OFF = 0.0f;
    private static final float KMH_STEP_1 = 0.0f;
    private static final float KMH_STEP_2 = 5.0f;
    private static final float KMH_STEP_3 = 10.0f;
    private static final float KMH_STEP_4 = 15.0f;
    private static final float MPH_STEP_OFF = 0.0f;
    private static final float MPH_STEP_1 = 0.0f;
    private static final float MPH_STEP_2 = 3.0f;
    private static final float MPH_STEP_3 = 5.0f;
    private static final float MPH_STEP_4 = 10.0f;

    protected SpeedWarningCameraHandler() {
    }

    protected void setCurrentValues(boolean bl, int n, float f2, int n2) {
        this.state = bl;
        this.valueState = n;
        this.value = f2;
        this.unit = n2;
    }

    protected boolean unitIsMPH() {
        return this.unit == 1;
    }

    protected int getStep() {
        if (!this.state) {
            return 0;
        }
        if (this.unitIsMPH()) {
            if (this.value == 0.0f) {
                return 1;
            }
            if (this.value == 3.0f) {
                return 2;
            }
            if (this.value == 5.0f) {
                return 3;
            }
            if (this.value == 10.0f) {
                return 4;
            }
            return 1;
        }
        if (this.value == 0.0f) {
            return 1;
        }
        if (this.value == 5.0f) {
            return 2;
        }
        if (this.value == 10.0f) {
            return 3;
        }
        if (this.value == 15.0f) {
            return 4;
        }
        return 1;
    }

    protected float getValueForStep(int n) {
        switch (n) {
            case 0: {
                return this.unitIsMPH() ? 0.0f : 0.0f;
            }
            case 1: {
                return this.unitIsMPH() ? 0.0f : 0.0f;
            }
            case 2: {
                return this.unitIsMPH() ? 3.0f : 5.0f;
            }
            case 3: {
                return this.unitIsMPH() ? 5.0f : 10.0f;
            }
            case 4: {
                return this.unitIsMPH() ? 10.0f : 15.0f;
            }
        }
        return this.unitIsMPH() ? 0.0f : 0.0f;
    }

    protected boolean getStateForStep(int n) {
        return n != 0;
    }

    protected int getValueStateForStep(int n) {
        return this.valueState;
    }

    protected int getUnit() {
        return this.unit;
    }
}

