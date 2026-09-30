/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticCallForwarding_Status
implements StatusProperty {
    public final DivertState divertState = new DivertState();

    public AutomaticCallForwarding_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticCallForwarding_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.divertState.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        AutomaticCallForwarding_Status automaticCallForwarding_Status = (AutomaticCallForwarding_Status)bAPEntity;
        return this.divertState.equalTo(automaticCallForwarding_Status.divertState);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AutomaticCallForwarding_Status:");
        stringBuffer.append("\n - DivertState - ");
        stringBuffer.append(this.divertState.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.divertState.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.divertState.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.divertState.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    public int getFunctionId() {
        return AutomaticCallForwarding_Status.functionId();
    }

    public static final class DivertState
    implements BAPEntity {
        private static final int RESERVED_BIT_8__15_BITSIZE = 8;
        public boolean fowardingAllDataCalls;
        public boolean forwardingAllFaxCalls;
        public boolean forwardingAllVoiceCalls;
        public boolean forwardingIfNotAvailable;
        public boolean forwardingIfOutOfReach;
        public boolean forwardingIfNotAnswered;
        public boolean forwardingIfBusy;
        public boolean forwardingStateValid;
        private static final int DIVERT_STATE_BITSIZE = 16;

        public DivertState() {
            this.internalReset();
            this.customInitialization();
        }

        public DivertState(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.fowardingAllDataCalls = false;
            this.forwardingAllFaxCalls = false;
            this.forwardingAllVoiceCalls = false;
            this.forwardingIfNotAvailable = false;
            this.forwardingIfOutOfReach = false;
            this.forwardingIfNotAnswered = false;
            this.forwardingIfBusy = false;
            this.forwardingStateValid = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            DivertState divertState = (DivertState)bAPEntity;
            return this.fowardingAllDataCalls == divertState.fowardingAllDataCalls && this.forwardingAllFaxCalls == divertState.forwardingAllFaxCalls && this.forwardingAllVoiceCalls == divertState.forwardingAllVoiceCalls && this.forwardingIfNotAvailable == divertState.forwardingIfNotAvailable && this.forwardingIfOutOfReach == divertState.forwardingIfOutOfReach && this.forwardingIfNotAnswered == divertState.forwardingIfNotAnswered && this.forwardingIfBusy == divertState.forwardingIfBusy && this.forwardingStateValid == divertState.forwardingStateValid;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("DivertState:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.fowardingAllDataCalls) {
                stringBuffer.append("true  (fowarding all data calls");
            } else {
                stringBuffer.append("false  (forwarding all data calls inactive");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.forwardingAllFaxCalls) {
                stringBuffer.append("true  (forwarding all fax calls");
            } else {
                stringBuffer.append("false  (fowarding all fax calls inactive");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.forwardingAllVoiceCalls) {
                stringBuffer.append("true  (forwarding all voice calls (CF unconditional for voice calls)");
            } else {
                stringBuffer.append("false  (forwarding inactive");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.forwardingIfNotAvailable) {
                stringBuffer.append("true  (forwarding if not available");
            } else {
                stringBuffer.append("false  (forwarding inactive");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.forwardingIfOutOfReach) {
                stringBuffer.append("true  (forwarding if out of reach");
            } else {
                stringBuffer.append("false  (forwarding inactive");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.forwardingIfNotAnswered) {
                stringBuffer.append("true  (forwarding if not answered (CF no reply)");
            } else {
                stringBuffer.append("false  (forwarding inactive");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.forwardingIfBusy) {
                stringBuffer.append("true  (forwarding if busy (CF busy)");
            } else {
                stringBuffer.append("false  (forwarding if busy inactive");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.forwardingStateValid) {
                stringBuffer.append("true  (forwarding state valid");
            } else {
                stringBuffer.append("false  (forwarding state invalid / unknown");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 16;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(8);
            bitStream.pushBoolean(this.fowardingAllDataCalls);
            bitStream.pushBoolean(this.forwardingAllFaxCalls);
            bitStream.pushBoolean(this.forwardingAllVoiceCalls);
            bitStream.pushBoolean(this.forwardingIfNotAvailable);
            bitStream.pushBoolean(this.forwardingIfOutOfReach);
            bitStream.pushBoolean(this.forwardingIfNotAnswered);
            bitStream.pushBoolean(this.forwardingIfBusy);
            bitStream.pushBoolean(this.forwardingStateValid);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(8);
            this.fowardingAllDataCalls = bitStream.popFrontBoolean();
            this.forwardingAllFaxCalls = bitStream.popFrontBoolean();
            this.forwardingAllVoiceCalls = bitStream.popFrontBoolean();
            this.forwardingIfNotAvailable = bitStream.popFrontBoolean();
            this.forwardingIfOutOfReach = bitStream.popFrontBoolean();
            this.forwardingIfNotAnswered = bitStream.popFrontBoolean();
            this.forwardingIfBusy = bitStream.popFrontBoolean();
            this.forwardingStateValid = bitStream.popFrontBoolean();
        }
    }
}

