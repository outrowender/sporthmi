/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.log.LogChannel;

public class SeatVisualizationArrowStateMachine {
    public static final int MASSAGE_PROGRAM_INTENSITY_MIN = 1;
    public static final int MASSAGE_PROGRAM_INTENSITY_MAX = 5;
    private int minIntensity;
    private int decArrowState;
    private int maxIntensity;
    private int incArrowState;
    private int intensity;
    private int prevIntensity;
    private LogChannel logChannelSeat;

    public SeatVisualizationArrowStateMachine(int n, int n2, LogChannel logChannel) {
        this.logChannelSeat = logChannel;
        this.intensity = this.minIntensity = this.trimIntensityFromBeneath(n);
        this.maxIntensity = -1;
        this.updateMaxIntensity(n2);
    }

    private int trimIntensityFromBeneath(int n) {
        if (n < 1) {
            n = 1;
        }
        return n;
    }

    public void updateMaxIntensity(int n) {
        if (this.maxIntensity != (n = this.trimIntensityFromAbove(n))) {
            this.maxIntensity = n;
            this.minIntensity = this.getNormalizedMinIntensity(this.minIntensity, this.maxIntensity);
            this.recalibrateIntensity();
        }
    }

    private int trimIntensityFromAbove(int n) {
        if (n > 5) {
            n = 5;
        }
        return n;
    }

    private int getNormalizedMinIntensity(int n, int n2) {
        return this.getNormalizedIntensity(n, n, n2);
    }

    private int getNormalizedIntensity(int n, int n2, int n3) {
        n2 = this.trimIntensityFromBeneath(n2);
        n3 = this.trimIntensityFromAbove(n3);
        if (n < n2) {
            n = n2;
        } else if (n > n3) {
            n = n3;
        }
        return n;
    }

    public SeatVisualizationArrowStateMachine(LogChannel logChannel) {
        this.logChannelSeat = logChannel;
        this.minIntensity = 1;
        this.maxIntensity = 5;
        this.setIntensity(this.minIntensity);
    }

    public void setIntensity(int n) {
        this.prevIntensity = this.intensity = this.getNormalizedIntensity(n, this.minIntensity, this.maxIntensity);
        this.logChannelSeat.log(10000000, "SeatVisualizationArrowStateMachine#setIntensity intensity = prevIntensity: %1", (long)this.intensity);
        this.updateArrowStates();
    }

    private void recalibrateIntensity() {
        this.setIntensity(this.intensity);
    }

    public void updateIntensity(int n) {
        this.intensity = this.getNormalizedIntensity(n, this.minIntensity, this.maxIntensity);
        this.logChannelSeat.log(10000000, "SeatVisualizationArrowStateMachine#updateIntensity intensity: %1", (long)this.intensity);
        if (this.intensity != this.prevIntensity) {
            this.updateArrowStates();
            this.prevIntensity = this.intensity;
            this.logChannelSeat.log(10000000, "SeatVisualizationArrowStateMachine#updateIntensity prevIntensity: %1", (long)this.prevIntensity);
        }
    }

    private void updateArrowStates() {
        this.decArrowState = this.updateSingleArrowState(this.intensity > this.minIntensity);
        this.incArrowState = this.updateSingleArrowState(this.intensity < this.maxIntensity);
        this.logChannelSeat.log(10000000, "SeatVisualizationArrowStateMachine#updateArrowStates decArrowState: %1, incArrowState: %2", (long)this.decArrowState, (long)this.incArrowState);
    }

    private int updateSingleArrowState(boolean bl) {
        int n = 0;
        if (bl) {
            n = 1;
        }
        return n;
    }

    public int getMinIntensity() {
        return this.minIntensity;
    }

    public int getMaxIntensity() {
        return this.maxIntensity;
    }

    public int getIntensity() {
        return this.intensity;
    }

    public int getDecArrowState() {
        return this.decArrowState;
    }

    public int getIncArrowState() {
        return this.incArrowState;
    }
}

