/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.Monitorings$Builder;

public final class Monitorings {
    private final boolean geofenceEnabled;
    private final boolean speedAlertEnabled;
    private final boolean valetAlertEnabled;

    public static Monitorings$Builder builder() {
        return new Monitorings$Builder();
    }

    private Monitorings(boolean bl, boolean bl2, boolean bl3) {
        this.geofenceEnabled = bl;
        this.speedAlertEnabled = bl2;
        this.valetAlertEnabled = bl3;
    }

    public boolean isGeofenceEnabled() {
        return this.geofenceEnabled;
    }

    public boolean isSpeedAlertEnabled() {
        return this.speedAlertEnabled;
    }

    public boolean isValetAlertEnabled() {
        return this.valetAlertEnabled;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.geofenceEnabled ? 1231 : 1237);
        n = 31 * n + (this.speedAlertEnabled ? 1231 : 1237);
        n = 31 * n + (this.valetAlertEnabled ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        Monitorings monitorings = (Monitorings)object;
        if (this.geofenceEnabled != monitorings.geofenceEnabled) {
            return false;
        }
        if (this.speedAlertEnabled != monitorings.speedAlertEnabled) {
            return false;
        }
        return this.valetAlertEnabled == monitorings.valetAlertEnabled;
    }

    public String toString() {
        return new StringBuffer().append("Monitorings [geofenceEnabled=").append(this.geofenceEnabled).append(", speedAlertEnabled=").append(this.speedAlertEnabled).append(", valetAlertEnabled=").append(this.valetAlertEnabled).append("]").toString();
    }
}

