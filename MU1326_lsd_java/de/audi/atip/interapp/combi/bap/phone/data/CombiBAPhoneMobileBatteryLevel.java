/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPhoneMobileBatteryLevel {
    public static final int BATTERY_LEVEL_UNKNOWN_DEVICE_NOT_CONNECTED = 255;
    public static final int BATTERY_LEVEL_UNKNOWN_LEVEL_NOT_RECEIVED = 254;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_0 = 0;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_0_19 = 19;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_20_39 = 39;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_40_59 = 59;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_60_79 = 79;
    public static final int BATTERY_LEVEL_CHARGE_LEVEL_80_100 = 100;
    private final ChargeLevel mobileChargeLevel1;
    private final ChargeLevel mobileChargeLevel2;
    private final ChargeLevel handsetChargeLevel1;
    private final ChargeLevel handsetChargeLevel2;

    public CombiBAPhoneMobileBatteryLevel(ChargeLevel chargeLevel, ChargeLevel chargeLevel2, ChargeLevel chargeLevel3, ChargeLevel chargeLevel4) {
        this.mobileChargeLevel1 = chargeLevel;
        this.mobileChargeLevel2 = chargeLevel2;
        this.handsetChargeLevel1 = chargeLevel3;
        this.handsetChargeLevel2 = chargeLevel4;
    }

    public static CombiBAPhoneMobileBatteryLevel create(ChargeLevel chargeLevel, ChargeLevel chargeLevel2, ChargeLevel chargeLevel3, ChargeLevel chargeLevel4) {
        return new CombiBAPhoneMobileBatteryLevel(chargeLevel, chargeLevel2, chargeLevel3, chargeLevel4);
    }

    public static CombiBAPhoneMobileBatteryLevel createOnlyMobileChargeLevel1(ChargeLevel chargeLevel) {
        return new CombiBAPhoneMobileBatteryLevel(chargeLevel, ChargeLevel.createDefaultChargeLevel(), ChargeLevel.createDefaultChargeLevel(), ChargeLevel.createDefaultChargeLevel());
    }

    public ChargeLevel getMobileChargeLevel1() {
        return this.mobileChargeLevel1;
    }

    public ChargeLevel getMobileChargeLevel2() {
        return this.mobileChargeLevel2;
    }

    public ChargeLevel getHandsetChargeLevel1() {
        return this.handsetChargeLevel1;
    }

    public ChargeLevel getHandsetChargeLevel2() {
        return this.handsetChargeLevel2;
    }

    public String toString() {
        return new Buffer("CombiBAPhoneMobileBatteryLevel [mobileChargeLevel1=").append(this.mobileChargeLevel1).append(", mobileChargeLevel2=").append(this.mobileChargeLevel2).append(", handsetChargeLevel1=").append(this.handsetChargeLevel1).append(", handsetChargeLevel2=").append(this.handsetChargeLevel2).append("]").toString();
    }

    public static final class ChargeLevel {
        private final int chargeLevelPercent;
        private final boolean isCritical;

        public ChargeLevel(int n, boolean bl) {
            this.chargeLevelPercent = n;
            this.isCritical = bl;
        }

        public int getChargeLevelPercent() {
            return this.chargeLevelPercent;
        }

        public boolean isCritical() {
            return this.isCritical;
        }

        static ChargeLevel createDefaultChargeLevel() {
            return new ChargeLevel(255, false);
        }

        public String toString() {
            return new Buffer().append(this.chargeLevelPercent).append(" ").append(this.isCritical).toString();
        }
    }
}

