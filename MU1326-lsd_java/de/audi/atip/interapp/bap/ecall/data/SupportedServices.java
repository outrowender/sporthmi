/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.audi.atip.interapp.bap.ecall.data.SupportedServices$Builder;

public final class SupportedServices {
    private final boolean breakdownCallSupported;
    private final boolean accidentalDamageManagementSupported;
    private final boolean infoCallSupported;
    private final boolean automaticCrashNotificationSupported;
    private final boolean manualEmergencyCallSupported;
    private final boolean testModeSupported;

    public static SupportedServices$Builder builder() {
        return new SupportedServices$Builder();
    }

    private SupportedServices(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.breakdownCallSupported = bl;
        this.accidentalDamageManagementSupported = bl2;
        this.infoCallSupported = bl3;
        this.automaticCrashNotificationSupported = bl4;
        this.manualEmergencyCallSupported = bl5;
        this.testModeSupported = bl6;
    }

    public boolean isBreakdownCallSupported() {
        return this.breakdownCallSupported;
    }

    public boolean isAccidentalDamageManagementSupported() {
        return this.accidentalDamageManagementSupported;
    }

    public boolean isInfoCallSupported() {
        return this.infoCallSupported;
    }

    public boolean isAutomaticCrashNotificationSupported() {
        return this.automaticCrashNotificationSupported;
    }

    public boolean isManualEmergencyCallSupported() {
        return this.manualEmergencyCallSupported;
    }

    public boolean isTestModeSupported() {
        return this.testModeSupported;
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
        SupportedServices supportedServices = (SupportedServices)object;
        if (this.accidentalDamageManagementSupported != supportedServices.accidentalDamageManagementSupported) {
            return false;
        }
        if (this.automaticCrashNotificationSupported != supportedServices.automaticCrashNotificationSupported) {
            return false;
        }
        if (this.breakdownCallSupported != supportedServices.breakdownCallSupported) {
            return false;
        }
        if (this.infoCallSupported != supportedServices.infoCallSupported) {
            return false;
        }
        if (this.manualEmergencyCallSupported != supportedServices.manualEmergencyCallSupported) {
            return false;
        }
        return this.testModeSupported == supportedServices.testModeSupported;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.accidentalDamageManagementSupported ? 1231 : 1237);
        n = 31 * n + (this.automaticCrashNotificationSupported ? 1231 : 1237);
        n = 31 * n + (this.breakdownCallSupported ? 1231 : 1237);
        n = 31 * n + (this.infoCallSupported ? 1231 : 1237);
        n = 31 * n + (this.manualEmergencyCallSupported ? 1231 : 1237);
        n = 31 * n + (this.testModeSupported ? 1231 : 1237);
        return n;
    }

    public String toString() {
        return new StringBuffer().append("SupportedServices [breakdownCallSupported=").append(this.breakdownCallSupported).append(", accidentalDamageManagementSupported=").append(this.accidentalDamageManagementSupported).append(", infoCallSupported=").append(this.infoCallSupported).append(", automaticCrashNotificationSupported=").append(this.automaticCrashNotificationSupported).append(", manualEmergencyCallSupported=").append(this.manualEmergencyCallSupported).append(", testModeSupported=").append(this.testModeSupported).append("]").toString();
    }
}

