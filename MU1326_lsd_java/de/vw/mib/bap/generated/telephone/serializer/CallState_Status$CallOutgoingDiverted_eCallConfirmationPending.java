/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CallState_Status$CallOutgoingDiverted_eCallConfirmationPending
implements BAPEntity {
    public boolean eCallConfirmationPending;
    public boolean call6Diverted;
    public boolean call5Diverted;
    public boolean call4Diverted;
    public boolean call3Diverted;
    public boolean call2Diverted;
    public boolean call1Diverted;
    public boolean call0Diverted;
    private static final int CALL_OUTGOING_DIVERTED_E_CALL_CONFIRMATION_PENDING_BITSIZE;

    public CallState_Status$CallOutgoingDiverted_eCallConfirmationPending() {
        this.internalReset();
        this.customInitialization();
    }

    public CallState_Status$CallOutgoingDiverted_eCallConfirmationPending(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.eCallConfirmationPending = false;
        this.call6Diverted = false;
        this.call5Diverted = false;
        this.call4Diverted = false;
        this.call3Diverted = false;
        this.call2Diverted = false;
        this.call1Diverted = false;
        this.call0Diverted = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallState_Status$CallOutgoingDiverted_eCallConfirmationPending callState_Status$CallOutgoingDiverted_eCallConfirmationPending = (CallState_Status$CallOutgoingDiverted_eCallConfirmationPending)bAPEntity;
        return this.eCallConfirmationPending == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending && this.call6Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call6Diverted && this.call5Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call5Diverted && this.call4Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call4Diverted && this.call3Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call3Diverted && this.call2Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call2Diverted && this.call1Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call1Diverted && this.call0Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call0Diverted;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CallOutgoingDiverted_eCallConfirmationPending:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.eCallConfirmationPending) {
            stringBuffer.append("true  (eCall confirmation pending");
        } else {
            stringBuffer.append("false  (no confirmation pending");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.call6Diverted) {
            stringBuffer.append("true  (call 6 diverted");
        } else {
            stringBuffer.append("false  (call 6 not diverted");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.call5Diverted) {
            stringBuffer.append("true  (call 5 diverted");
        } else {
            stringBuffer.append("false  (call 5 not diverted");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.call4Diverted) {
            stringBuffer.append("true  (call 4 diverted");
        } else {
            stringBuffer.append("false  (call 4 not diverted");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.call3Diverted) {
            stringBuffer.append("true  (call 3 diverted");
        } else {
            stringBuffer.append("false  (call 3 not diverted");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.call2Diverted) {
            stringBuffer.append("true  (call 2 diverted");
        } else {
            stringBuffer.append("false  (call 2 not diverted");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.call1Diverted) {
            stringBuffer.append("true  (call 1 diverted");
        } else {
            stringBuffer.append("false  (call 1 not diverted");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.call0Diverted) {
            stringBuffer.append("true  (call 0 diverted");
        } else {
            stringBuffer.append("false  (call 0 not diverted");
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
        bitStream.pushBoolean(this.eCallConfirmationPending);
        bitStream.pushBoolean(this.call6Diverted);
        bitStream.pushBoolean(this.call5Diverted);
        bitStream.pushBoolean(this.call4Diverted);
        bitStream.pushBoolean(this.call3Diverted);
        bitStream.pushBoolean(this.call2Diverted);
        bitStream.pushBoolean(this.call1Diverted);
        bitStream.pushBoolean(this.call0Diverted);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.eCallConfirmationPending = bitStream.popFrontBoolean();
        this.call6Diverted = bitStream.popFrontBoolean();
        this.call5Diverted = bitStream.popFrontBoolean();
        this.call4Diverted = bitStream.popFrontBoolean();
        this.call3Diverted = bitStream.popFrontBoolean();
        this.call2Diverted = bitStream.popFrontBoolean();
        this.call1Diverted = bitStream.popFrontBoolean();
        this.call0Diverted = bitStream.popFrontBoolean();
    }
}

