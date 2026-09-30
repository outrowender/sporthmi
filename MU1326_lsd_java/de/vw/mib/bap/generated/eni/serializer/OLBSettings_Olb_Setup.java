/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OLBSettings_Olb_Setup
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE = 6;
    public boolean driverAuthentificationPopupForOlbIsActive;
    public boolean olbTripReminderPopupIsActive;

    public OLBSettings_Olb_Setup() {
        this.internalReset();
        this.customInitialization();
    }

    public OLBSettings_Olb_Setup(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.driverAuthentificationPopupForOlbIsActive = false;
        this.olbTripReminderPopupIsActive = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        OLBSettings_Olb_Setup oLBSettings_Olb_Setup = (OLBSettings_Olb_Setup)bAPEntity;
        return this.driverAuthentificationPopupForOlbIsActive == oLBSettings_Olb_Setup.driverAuthentificationPopupForOlbIsActive && this.olbTripReminderPopupIsActive == oLBSettings_Olb_Setup.olbTripReminderPopupIsActive;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OLBSettings_Olb_Setup");
        stringBuffer.append("\n - driverAuthentificationPopupForOlbIsActive:" + this.driverAuthentificationPopupForOlbIsActive);
        stringBuffer.append("\n - olbTripReminderPopupIsActive:" + this.olbTripReminderPopupIsActive);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.driverAuthentificationPopupForOlbIsActive);
        bitStream.pushBoolean(this.olbTripReminderPopupIsActive);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.driverAuthentificationPopupForOlbIsActive = bitStream.popFrontBoolean();
        this.olbTripReminderPopupIsActive = bitStream.popFrontBoolean();
    }
}

