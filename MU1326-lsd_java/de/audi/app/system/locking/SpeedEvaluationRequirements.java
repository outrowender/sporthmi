/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

final class SpeedEvaluationRequirements {
    private final boolean vehicleSpeedExceeded;

    public SpeedEvaluationRequirements(boolean bl) {
        this.vehicleSpeedExceeded = bl;
    }

    public boolean isVehicleSpeedExceeded() {
        return this.vehicleSpeedExceeded;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("SpeedEvaluationRequirements [");
        stringBuffer.append("\tvehicleSpeedExceeded=");
        stringBuffer.append(this.vehicleSpeedExceeded);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

