/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class CallStackDeleteAll_StartResult
implements StartResultMethod {
    public final Storage storage = new Storage();

    public CallStackDeleteAll_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public CallStackDeleteAll_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.storage.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CallStackDeleteAll_StartResult callStackDeleteAll_StartResult = (CallStackDeleteAll_StartResult)bAPEntity;
        return this.storage.equalTo(callStackDeleteAll_StartResult.storage);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CallStackDeleteAll_StartResult:");
        stringBuffer.append("\n - Storage - ");
        stringBuffer.append(this.storage.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.storage.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.storage.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.storage.deserialize(bitStream);
    }

    public static int functionId() {
        return 50;
    }

    public int getFunctionId() {
        return CallStackDeleteAll_StartResult.functionId();
    }

    public static final class Storage
    implements BAPEntity {
        private static final int RESERVED_BIT_3__7_BITSIZE = 5;
        public boolean deleteDialedNumbers;
        public boolean deleteReceivedCalls;
        public boolean deleteMissedCalls;
        private static final int STORAGE_BITSIZE = 8;

        public Storage() {
            this.internalReset();
            this.customInitialization();
        }

        public Storage(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.deleteDialedNumbers = false;
            this.deleteReceivedCalls = false;
            this.deleteMissedCalls = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Storage storage = (Storage)bAPEntity;
            return this.deleteDialedNumbers == storage.deleteDialedNumbers && this.deleteReceivedCalls == storage.deleteReceivedCalls && this.deleteMissedCalls == storage.deleteMissedCalls;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Storage:");
            stringBuffer.append("\n - Bit 2: ");
            if (this.deleteDialedNumbers) {
                stringBuffer.append("true  (Delete dialed numbers");
            } else {
                stringBuffer.append("false  (Don't touch dialed numbers");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.deleteReceivedCalls) {
                stringBuffer.append("true  (Delete received calls");
            } else {
                stringBuffer.append("false  (Don't touch received calls");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.deleteMissedCalls) {
                stringBuffer.append("true  (Delete missed calls");
            } else {
                stringBuffer.append("false  (Don't touch missed calls");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(5);
            bitStream.pushBoolean(this.deleteDialedNumbers);
            bitStream.pushBoolean(this.deleteReceivedCalls);
            bitStream.pushBoolean(this.deleteMissedCalls);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(5);
            this.deleteDialedNumbers = bitStream.popFrontBoolean();
            this.deleteReceivedCalls = bitStream.popFrontBoolean();
            this.deleteMissedCalls = bitStream.popFrontBoolean();
        }
    }
}

