/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OLBSettings_Olb_AvailableFunctions
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE = 6;
    public boolean driverAuthentificationPopupForOlbCanBeModified;
    public boolean olbTripReminderPopupReminderCanBeModified;

    public OLBSettings_Olb_AvailableFunctions() {
        this.internalReset();
        this.customInitialization();
    }

    public OLBSettings_Olb_AvailableFunctions(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.driverAuthentificationPopupForOlbCanBeModified = false;
        this.olbTripReminderPopupReminderCanBeModified = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        OLBSettings_Olb_AvailableFunctions oLBSettings_Olb_AvailableFunctions = (OLBSettings_Olb_AvailableFunctions)bAPEntity;
        return this.driverAuthentificationPopupForOlbCanBeModified == oLBSettings_Olb_AvailableFunctions.driverAuthentificationPopupForOlbCanBeModified && this.olbTripReminderPopupReminderCanBeModified == oLBSettings_Olb_AvailableFunctions.olbTripReminderPopupReminderCanBeModified;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OLBSettings_Olb_AvailableFunctions");
        stringBuffer.append("\n - driverAuthentificationPopupForOlbCanBeModified:" + this.driverAuthentificationPopupForOlbCanBeModified);
        stringBuffer.append("\n - olbTripReminderPopupReminderCanBeModified:" + this.olbTripReminderPopupReminderCanBeModified);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.driverAuthentificationPopupForOlbCanBeModified);
        bitStream.pushBoolean(this.olbTripReminderPopupReminderCanBeModified);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.driverAuthentificationPopupForOlbCanBeModified = bitStream.popFrontBoolean();
        this.olbTripReminderPopupReminderCanBeModified = bitStream.popFrontBoolean();
    }
}

