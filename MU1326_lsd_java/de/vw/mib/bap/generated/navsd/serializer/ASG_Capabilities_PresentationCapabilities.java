/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ASG_Capabilities_PresentationCapabilities
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE;
    public boolean __5DSymbolPresentation;
    private static final int ASG_CAPABILITIES_PRESENTATION_CAPABILITIES_BITSIZE;

    public ASG_Capabilities_PresentationCapabilities() {
        this.internalReset();
        this.customInitialization();
    }

    public ASG_Capabilities_PresentationCapabilities(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.__5DSymbolPresentation = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ASG_Capabilities_PresentationCapabilities aSG_Capabilities_PresentationCapabilities = (ASG_Capabilities_PresentationCapabilities)bAPEntity;
        return this.__5DSymbolPresentation == aSG_Capabilities_PresentationCapabilities.__5DSymbolPresentation;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ASG_Capabilities_PresentationCapabilities:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.__5DSymbolPresentation) {
            stringBuffer.append("true  (2.5D symbol presentation");
        } else {
            stringBuffer.append("false  (2D symbol presentation");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 4;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.__5DSymbolPresentation);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.__5DSymbolPresentation = bitStream.popFrontBoolean();
    }
}

