/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPhoneMobileBatteryLevel$ChargeLevel {
    private final int chargeLevelPercent;
    private final boolean isCritical;

    public CombiBAPhoneMobileBatteryLevel$ChargeLevel(int n, boolean bl) {
        this.chargeLevelPercent = n;
        this.isCritical = bl;
    }

    public int getChargeLevelPercent() {
        return this.chargeLevelPercent;
    }

    public boolean isCritical() {
        return this.isCritical;
    }

    static CombiBAPhoneMobileBatteryLevel$ChargeLevel createDefaultChargeLevel() {
        return new CombiBAPhoneMobileBatteryLevel$ChargeLevel(255, false);
    }

    public String toString() {
        return new Buffer().append(this.chargeLevelPercent).append(" ").append(this.isCritical).toString();
    }
}

