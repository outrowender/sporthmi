/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

final class NhtsaEvaluationRequirements {
    private final boolean carTypeIsAutomatic;
    private final int transmission;
    private final boolean clutchIsClutchedIn;
    private final int currentGear;
    private final boolean isNGearDetectionPossible;
    private final boolean vehicleSpeedExceeded;
    private final boolean parkingBrakeEngaged;

    public NhtsaEvaluationRequirements(boolean bl, int n, boolean bl2, int n2, boolean bl3, boolean bl4, boolean bl5) {
        this.carTypeIsAutomatic = bl;
        this.transmission = n;
        this.clutchIsClutchedIn = bl2;
        this.currentGear = n2;
        this.isNGearDetectionPossible = bl3;
        this.vehicleSpeedExceeded = bl4;
        this.parkingBrakeEngaged = bl5;
    }

    public boolean isCarTypeAutomatic() {
        return this.carTypeIsAutomatic;
    }

    public int getTransmission() {
        return this.transmission;
    }

    public boolean isClutchClutchedIn() {
        return this.clutchIsClutchedIn;
    }

    public int getCurrentGear() {
        return this.currentGear;
    }

    public boolean isNGearDetectionPossible() {
        return this.isNGearDetectionPossible;
    }

    public boolean isVehicleSpeedExceeded() {
        return this.vehicleSpeedExceeded;
    }

    public boolean isParkingBrakeEngaged() {
        return this.parkingBrakeEngaged;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("NhtsaEvaluationRequirements [");
        stringBuffer.append("\tcarTypeIsAutomatic=");
        stringBuffer.append(this.carTypeIsAutomatic);
        stringBuffer.append(", ");
        stringBuffer.append("\ttransmission=");
        stringBuffer.append(this.transmission);
        stringBuffer.append(", ");
        stringBuffer.append("\tclutchIsClutchedIn=");
        stringBuffer.append(this.clutchIsClutchedIn);
        stringBuffer.append(", ");
        stringBuffer.append("\tcurrentGear=");
        stringBuffer.append(this.currentGear);
        stringBuffer.append(", ");
        stringBuffer.append("\tisNGearDetectionPossible=");
        stringBuffer.append(this.isNGearDetectionPossible);
        stringBuffer.append(", ");
        stringBuffer.append("\tvehicleSpeedExceeded=");
        stringBuffer.append(this.vehicleSpeedExceeded);
        stringBuffer.append(", ");
        stringBuffer.append("\tparkingBrakeEngaged=");
        stringBuffer.append(this.parkingBrakeEngaged);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

