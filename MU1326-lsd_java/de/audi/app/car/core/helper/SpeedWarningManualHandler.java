/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.helper;

import de.audi.atip.log.LogChannel;

public class SpeedWarningManualHandler {
    public final int offKMH;
    public final int maxKMH;
    public final int stepKMH;
    public final int offMPH;
    public final int maxMPH;
    public final int stepMPH;
    private volatile boolean currentState;
    private volatile int currentSpeedWarningValue;
    private volatile int currentSpeedWarningUnit;
    private boolean unitChanged;
    private final LogChannel logChannel;

    public SpeedWarningManualHandler(int n, int n2, int n3, int n4, int n5, int n6, LogChannel logChannel) {
        this.offKMH = n;
        this.maxKMH = n2;
        this.stepKMH = n3;
        this.offMPH = n4;
        this.maxMPH = n5;
        this.stepMPH = n6;
        this.logChannel = logChannel;
    }

    public void setCurrentValues(boolean bl, int n, int n2) {
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[SpeedWarningHandler#setCurrentValues] received values: state='%1', speedWarningValue='%2', speedWarningUnit='%3'", (Object)Boolean.toString(bl), (long)n, (long)n2);
        }
        if (n2 != this.currentSpeedWarningUnit) {
            this.unitChanged = true;
            this.currentSpeedWarningUnit = n2;
        }
        n = this.roundSpeedWarningValue(n, n2);
        if (n2 == 0 && n > this.maxKMH) {
            this.currentSpeedWarningValue = this.maxKMH;
            this.currentState = true;
        } else if (n2 == 0 && n <= this.offKMH) {
            this.currentSpeedWarningValue = this.offKMH;
            this.currentState = false;
        } else if (n2 == 1 && n > this.maxMPH) {
            this.currentSpeedWarningValue = this.maxMPH;
            this.currentState = true;
        } else if (n2 == 1 && n <= this.offMPH) {
            this.currentSpeedWarningValue = this.offMPH;
            this.currentState = false;
        } else {
            this.currentSpeedWarningValue = n;
            this.currentState = true;
        }
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, "[SpeedWarningHandler#setCurrentValues] calculated values: state='%1', speedWarningValue='%2', speedWarningUnit='%3'", (Object)Boolean.toString(this.currentState), (long)this.currentSpeedWarningValue, (long)this.currentSpeedWarningUnit);
        }
    }

    public boolean unitHasChanged() {
        if (this.unitChanged) {
            this.unitChanged = false;
            return true;
        }
        return false;
    }

    public boolean getState() {
        return this.currentState;
    }

    public int getSpeedWarningValue() {
        return this.currentSpeedWarningValue;
    }

    public int getSpeedWarningUnit() {
        return this.currentSpeedWarningUnit;
    }

    public int getOffValue() {
        switch (this.currentSpeedWarningUnit) {
            case 1: {
                return this.offMPH;
            }
        }
        return this.offKMH;
    }

    public int getMaxValue() {
        switch (this.currentSpeedWarningUnit) {
            case 1: {
                return this.maxMPH;
            }
        }
        return this.maxKMH;
    }

    public int getStepValue() {
        switch (this.currentSpeedWarningUnit) {
            case 1: {
                return this.stepMPH;
            }
        }
        return this.stepKMH;
    }

    private int roundSpeedWarningValue(int n, int n2) {
        int n3;
        this.logChannel.log(1078071040, "roundSpeedWarningValue BEFORE rounding (%1)", (long)n);
        int n4 = n;
        if (n2 == 1) {
            int n5 = n % this.stepMPH;
            if (n5 != 0) {
                n4 = n5 <= 2 ? n - n5 : n + (this.stepMPH - n5);
            }
        } else if (n2 == 0 && (n3 = n % this.stepKMH) != 0) {
            n4 = n3 <= 4 ? n - n3 : n + (this.stepKMH - n3);
        }
        this.logChannel.log(1078071040, "roundSpeedWarningValue AFTER rounding (%1)", (long)n4);
        return n4;
    }
}

