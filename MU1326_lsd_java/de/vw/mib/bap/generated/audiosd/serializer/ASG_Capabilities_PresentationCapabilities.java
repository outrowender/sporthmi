/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ASG_Capabilities_PresentationCapabilities
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE = 6;
    public boolean sdarsLongPs;
    public boolean dabLongPs;
    private static final int ASG_CAPABILITIES_PRESENTATION_CAPABILITIES_BITSIZE = 8;

    public ASG_Capabilities_PresentationCapabilities() {
        this.internalReset();
        this.customInitialization();
    }

    public ASG_Capabilities_PresentationCapabilities(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sdarsLongPs = false;
        this.dabLongPs = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ASG_Capabilities_PresentationCapabilities aSG_Capabilities_PresentationCapabilities = (ASG_Capabilities_PresentationCapabilities)bAPEntity;
        return this.sdarsLongPs == aSG_Capabilities_PresentationCapabilities.sdarsLongPs && this.dabLongPs == aSG_Capabilities_PresentationCapabilities.dabLongPs;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ASG_Capabilities_PresentationCapabilities:");
        stringBuffer.append("\n - Bit 1: ");
        if (this.sdarsLongPs) {
            stringBuffer.append("true  (SDARS long PS (max. 16 chars, DF4.1)");
        } else {
            stringBuffer.append("false  (SDARS short PS (max. 8 chars, DF4.1)");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.dabLongPs) {
            stringBuffer.append("true  (DAB long PS (max. 16 chars)");
        } else {
            stringBuffer.append("false  (DAB short PS (max. 8 chars)");
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.sdarsLongPs);
        bitStream.pushBoolean(this.dabLongPs);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.sdarsLongPs = bitStream.popFrontBoolean();
        this.dabLongPs = bitStream.popFrontBoolean();
    }
}

