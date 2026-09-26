/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.Monitorings;

public final class Monitorings$Builder {
    private boolean geofenceEnabled;
    private boolean speedAlertEnabled;
    private boolean valetAlertEnabled;

    public Monitorings$Builder setGeofenceEnabled(boolean bl) {
        this.geofenceEnabled = bl;
        return this;
    }

    public Monitorings$Builder setSpeedAlertEnabled(boolean bl) {
        this.speedAlertEnabled = bl;
        return this;
    }

    public Monitorings$Builder setValetAlertEnabled(boolean bl) {
        this.valetAlertEnabled = bl;
        return this;
    }

    public Monitorings build() {
        return new Monitorings(this.geofenceEnabled, this.speedAlertEnabled, this.valetAlertEnabled);
    }
}

