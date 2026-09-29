/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SupportedServiceNumbers_Status$ServiceNumbers
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean emergencyCallSupported;
    public boolean serviceCallSupported;
    public boolean infoCallSupported;
    public boolean voiceMailboxSupported;
    private static final int SERVICE_NUMBERS_BITSIZE;

    public SupportedServiceNumbers_Status$ServiceNumbers() {
        this.internalReset();
        this.customInitialization();
    }

    public SupportedServiceNumbers_Status$ServiceNumbers(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.emergencyCallSupported = false;
        this.serviceCallSupported = false;
        this.infoCallSupported = false;
        this.voiceMailboxSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SupportedServiceNumbers_Status$ServiceNumbers supportedServiceNumbers_Status$ServiceNumbers = (SupportedServiceNumbers_Status$ServiceNumbers)bAPEntity;
        return this.emergencyCallSupported == supportedServiceNumbers_Status$ServiceNumbers.emergencyCallSupported && this.serviceCallSupported == supportedServiceNumbers_Status$ServiceNumbers.serviceCallSupported && this.infoCallSupported == supportedServiceNumbers_Status$ServiceNumbers.infoCallSupported && this.voiceMailboxSupported == supportedServiceNumbers_Status$ServiceNumbers.voiceMailboxSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ServiceNumbers:");
        stringBuffer.append("\n - Bit 3: ");
        if (this.emergencyCallSupported) {
            stringBuffer.append("true  (emergency call supported");
        } else {
            stringBuffer.append("false  (emergency call not supported");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.serviceCallSupported) {
            stringBuffer.append("true  (service call supported");
        } else {
            stringBuffer.append("false  (service call not supported");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.infoCallSupported) {
            stringBuffer.append("true  (info call supported");
        } else {
            stringBuffer.append("false  (info call not supported");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.voiceMailboxSupported) {
            stringBuffer.append("true  (voice mailbox supported");
        } else {
            stringBuffer.append("false  (voice mailbox not supported");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.emergencyCallSupported);
        bitStream.pushBoolean(this.serviceCallSupported);
        bitStream.pushBoolean(this.infoCallSupported);
        bitStream.pushBoolean(this.voiceMailboxSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
        this.emergencyCallSupported = bitStream.popFrontBoolean();
        this.serviceCallSupported = bitStream.popFrontBoolean();
        this.infoCallSupported = bitStream.popFrontBoolean();
        this.voiceMailboxSupported = bitStream.popFrontBoolean();
    }
}

