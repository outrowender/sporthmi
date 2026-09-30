/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SupportedServiceNumbers_Status
implements StatusProperty {
    public final ServiceNumbers serviceNumbers = new ServiceNumbers();
    public static final int EXTENSION_1_MIN = 0;
    public int extension_1;
    private static final int EXTENSION_1_BITSIZE = 8;
    public static final int EXTENSION_2_MIN = 0;
    public int extension_2;
    private static final int EXTENSION_2_BITSIZE = 8;

    public SupportedServiceNumbers_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SupportedServiceNumbers_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension_1 = 0;
        this.extension_2 = 0;
    }

    public void reset() {
        this.internalReset();
        this.serviceNumbers.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        SupportedServiceNumbers_Status supportedServiceNumbers_Status = (SupportedServiceNumbers_Status)bAPEntity;
        return this.serviceNumbers.equalTo(supportedServiceNumbers_Status.serviceNumbers) && this.extension_1 == supportedServiceNumbers_Status.extension_1 && this.extension_2 == supportedServiceNumbers_Status.extension_2;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SupportedServiceNumbers_Status:");
        stringBuffer.append("\n - ServiceNumbers - ");
        stringBuffer.append(this.serviceNumbers.toString());
        stringBuffer.append("\n - Extension_1 - ");
        stringBuffer.append(this.extension_1);
        stringBuffer.append("\n - Extension_2 - ");
        stringBuffer.append(this.extension_2);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.serviceNumbers.bitSize();
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        this.serviceNumbers.serialize(bitStream);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
    }

    public void deserialize(BitStream bitStream) {
        this.serviceNumbers.deserialize(bitStream);
        this.extension_1 = bitStream.popFrontByte();
        this.extension_2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 59;
    }

    public int getFunctionId() {
        return SupportedServiceNumbers_Status.functionId();
    }

    public static final class ServiceNumbers
    implements BAPEntity {
        private static final int RESERVED_BIT_4__7_BITSIZE = 4;
        public boolean emergencyCallSupported;
        public boolean serviceCallSupported;
        public boolean infoCallSupported;
        public boolean voiceMailboxSupported;
        private static final int SERVICE_NUMBERS_BITSIZE = 8;

        public ServiceNumbers() {
            this.internalReset();
            this.customInitialization();
        }

        public ServiceNumbers(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.emergencyCallSupported = false;
            this.serviceCallSupported = false;
            this.infoCallSupported = false;
            this.voiceMailboxSupported = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            ServiceNumbers serviceNumbers = (ServiceNumbers)bAPEntity;
            return this.emergencyCallSupported == serviceNumbers.emergencyCallSupported && this.serviceCallSupported == serviceNumbers.serviceCallSupported && this.infoCallSupported == serviceNumbers.infoCallSupported && this.voiceMailboxSupported == serviceNumbers.voiceMailboxSupported;
        }

        private void customInitialization() {
        }

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

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(4);
            bitStream.pushBoolean(this.emergencyCallSupported);
            bitStream.pushBoolean(this.serviceCallSupported);
            bitStream.pushBoolean(this.infoCallSupported);
            bitStream.pushBoolean(this.voiceMailboxSupported);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(4);
            this.emergencyCallSupported = bitStream.popFrontBoolean();
            this.serviceCallSupported = bitStream.popFrontBoolean();
            this.infoCallSupported = bitStream.popFrontBoolean();
            this.voiceMailboxSupported = bitStream.popFrontBoolean();
        }
    }
}

