/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPhoneMobileBatteryLevel$ChargeLevel;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPhoneMobileBatteryLevel {
    public static final int BATTERY_LEVEL_UNKNOWN_DEVICE_NOT_CONNECTED;
    public static final int BATTERY_LEVEL_UNKNOWN_LEVEL_NOT_RECEIVED;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_0;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_0_19;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_20_39;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_40_59;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_60_79;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_80_100;
    private final CombiBAPhoneMobileBatteryLevel$ChargeLevel mobileChargeLevel1;
    private final CombiBAPhoneMobileBatteryLevel$ChargeLevel mobileChargeLevel2;
    private final CombiBAPhoneMobileBatteryLevel$ChargeLevel handsetChargeLevel1;
    private final CombiBAPhoneMobileBatteryLevel$ChargeLevel handsetChargeLevel2;

    public CombiBAPhoneMobileBatteryLevel(CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel, CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel2, CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel3, CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel4) {
        this.mobileChargeLevel1 = combiBAPhoneMobileBatteryLevel$ChargeLevel;
        this.mobileChargeLevel2 = combiBAPhoneMobileBatteryLevel$ChargeLevel2;
        this.handsetChargeLevel1 = combiBAPhoneMobileBatteryLevel$ChargeLevel3;
        this.handsetChargeLevel2 = combiBAPhoneMobileBatteryLevel$ChargeLevel4;
    }

    public static CombiBAPhoneMobileBatteryLevel create(CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel, CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel2, CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel3, CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel4) {
        return new CombiBAPhoneMobileBatteryLevel(combiBAPhoneMobileBatteryLevel$ChargeLevel, combiBAPhoneMobileBatteryLevel$ChargeLevel2, combiBAPhoneMobileBatteryLevel$ChargeLevel3, combiBAPhoneMobileBatteryLevel$ChargeLevel4);
    }

    public static CombiBAPhoneMobileBatteryLevel createOnlyMobileChargeLevel1(CombiBAPhoneMobileBatteryLevel$ChargeLevel combiBAPhoneMobileBatteryLevel$ChargeLevel) {
        return new CombiBAPhoneMobileBatteryLevel(combiBAPhoneMobileBatteryLevel$ChargeLevel, CombiBAPhoneMobileBatteryLevel$ChargeLevel.createDefaultChargeLevel(), CombiBAPhoneMobileBatteryLevel$ChargeLevel.createDefaultChargeLevel(), CombiBAPhoneMobileBatteryLevel$ChargeLevel.createDefaultChargeLevel());
    }

    public CombiBAPhoneMobileBatteryLevel$ChargeLevel getMobileChargeLevel1() {
        return this.mobileChargeLevel1;
    }

    public CombiBAPhoneMobileBatteryLevel$ChargeLevel getMobileChargeLevel2() {
        return this.mobileChargeLevel2;
    }

    public CombiBAPhoneMobileBatteryLevel$ChargeLevel getHandsetChargeLevel1() {
        return this.handsetChargeLevel1;
    }

    public CombiBAPhoneMobileBatteryLevel$ChargeLevel getHandsetChargeLevel2() {
        return this.handsetChargeLevel2;
    }

    public String toString() {
        return new Buffer("CombiBAPhoneMobileBatteryLevel [mobileChargeLevel1=").append(this.mobileChargeLevel1).append(", mobileChargeLevel2=").append(this.mobileChargeLevel2).append(", handsetChargeLevel1=").append(this.handsetChargeLevel1).append(", handsetChargeLevel2=").append(this.handsetChargeLevel2).append("]").toString();
    }
}

