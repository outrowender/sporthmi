/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.audi.atip.interapp.bap.ecall.data.SupportedServices;

public final class SupportedServices$Builder {
    private boolean breakdownCallSupported;
    private boolean accidentalDamageManagementSupported;
    private boolean infoCallSupported;
    private boolean automaticCrashNotificationSupported;
    private boolean manualEmergencyCallSupported;
    private boolean testModeSupported;

    public SupportedServices$Builder setBreakdownCallSupported(boolean bl) {
        this.breakdownCallSupported = bl;
        return this;
    }

    public SupportedServices$Builder setAccidentalDamageManagementSupported(boolean bl) {
        this.accidentalDamageManagementSupported = bl;
        return this;
    }

    public SupportedServices$Builder setInfoCallSupported(boolean bl) {
        this.infoCallSupported = bl;
        return this;
    }

    public SupportedServices$Builder setAutomaticCrashNotificationSupported(boolean bl) {
        this.automaticCrashNotificationSupported = bl;
        return this;
    }

    public SupportedServices$Builder setManualEmergencyCallSupported(boolean bl) {
        this.manualEmergencyCallSupported = bl;
        return this;
    }

    public SupportedServices$Builder setTestModeSupported(boolean bl) {
        this.testModeSupported = bl;
        return this;
    }

    public SupportedServices build() {
        return new SupportedServices(this.breakdownCallSupported, this.accidentalDamageManagementSupported, this.infoCallSupported, this.automaticCrashNotificationSupported, this.manualEmergencyCallSupported, this.testModeSupported);
    }
}

