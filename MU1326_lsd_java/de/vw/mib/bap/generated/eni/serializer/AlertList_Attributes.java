/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class AlertList_Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE = 6;
    public boolean alwaysOn;
    public boolean alertIsActivated;

    public AlertList_Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public AlertList_Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.alwaysOn = false;
        this.alertIsActivated = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        AlertList_Attributes alertList_Attributes = (AlertList_Attributes)bAPEntity;
        return this.alwaysOn == alertList_Attributes.alwaysOn && this.alertIsActivated == alertList_Attributes.alertIsActivated;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AlertList_Attributes");
        stringBuffer.append("\n - alwaysOn:" + this.alwaysOn);
        stringBuffer.append("\n - alertIsActivated:" + this.alertIsActivated);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.alwaysOn);
        bitStream.pushBoolean(this.alertIsActivated);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.alwaysOn = bitStream.popFrontBoolean();
        this.alertIsActivated = bitStream.popFrontBoolean();
    }
}

