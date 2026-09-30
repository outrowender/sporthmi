/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceList_UserSettings
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE = 6;
    public boolean serviceAllowedByVehicle;
    public boolean serviceActivatedAllowedByDriver;

    public ServiceList_UserSettings() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceList_UserSettings(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceAllowedByVehicle = false;
        this.serviceActivatedAllowedByDriver = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceList_UserSettings serviceList_UserSettings = (ServiceList_UserSettings)bAPEntity;
        return this.serviceAllowedByVehicle == serviceList_UserSettings.serviceAllowedByVehicle && this.serviceActivatedAllowedByDriver == serviceList_UserSettings.serviceActivatedAllowedByDriver;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ServiceList_UserSettings");
        stringBuffer.append("\n - serviceAllowedByVehicle:" + this.serviceAllowedByVehicle);
        stringBuffer.append("\n - serviceActivatedAllowedByDriver:" + this.serviceActivatedAllowedByDriver);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.serviceAllowedByVehicle);
        bitStream.pushBoolean(this.serviceActivatedAllowedByDriver);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.serviceAllowedByVehicle = bitStream.popFrontBoolean();
        this.serviceActivatedAllowedByDriver = bitStream.popFrontBoolean();
    }
}

