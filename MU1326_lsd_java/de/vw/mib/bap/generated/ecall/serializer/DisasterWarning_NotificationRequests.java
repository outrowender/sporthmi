/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DisasterWarning_NotificationRequests
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean userAlertNecessaryNormal;
    public boolean popupNecessaryImmediate;
    public boolean displayInHmi;

    public DisasterWarning_NotificationRequests() {
        this.internalReset();
        this.customInitialization();
    }

    public DisasterWarning_NotificationRequests(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.userAlertNecessaryNormal = false;
        this.popupNecessaryImmediate = false;
        this.displayInHmi = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DisasterWarning_NotificationRequests disasterWarning_NotificationRequests = (DisasterWarning_NotificationRequests)bAPEntity;
        return this.userAlertNecessaryNormal == disasterWarning_NotificationRequests.userAlertNecessaryNormal && this.popupNecessaryImmediate == disasterWarning_NotificationRequests.popupNecessaryImmediate && this.displayInHmi == disasterWarning_NotificationRequests.displayInHmi;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DisasterWarning_NotificationRequests");
        stringBuffer.append("\n - userAlertNecessaryNormal:").append(this.userAlertNecessaryNormal);
        stringBuffer.append("\n - popupNecessaryImmediate:").append(this.popupNecessaryImmediate);
        stringBuffer.append("\n - displayInHmi:").append(this.displayInHmi);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.userAlertNecessaryNormal);
        bitStream.pushBoolean(this.popupNecessaryImmediate);
        bitStream.pushBoolean(this.displayInHmi);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.userAlertNecessaryNormal = bitStream.popFrontBoolean();
        this.popupNecessaryImmediate = bitStream.popFrontBoolean();
        this.displayInHmi = bitStream.popFrontBoolean();
    }
}

