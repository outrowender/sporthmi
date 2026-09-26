/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.sysapp.SpeedThresholdListener;

class GeneralVehicleStateHandler$SpeedHandler {
    final SpeedThresholdListener listener;

    GeneralVehicleStateHandler$SpeedHandler(SpeedThresholdListener speedThresholdListener) {
        this.listener = speedThresholdListener;
        if (speedThresholdListener == null) {
            throw new IllegalArgumentException();
        }
    }

    private final void fireThresholdExceeded(int n) {
        if (this.listener != null) {
            this.listener.exceedsUpperThreshold(n);
        }
    }

    private final void fireThresholdOk(int n) {
        if (this.listener != null) {
            this.listener.belowLowerThreshold(n);
        }
    }

    final void fireThreshold(int n, boolean bl) {
        if (bl) {
            this.fireThresholdExceeded(n);
        } else {
            this.fireThresholdOk(n);
        }
    }
}

