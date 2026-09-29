/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_Status$FctList_2
implements BAPEntity {
    public boolean fctCustomerDownloadStateIsToBeSynchronised;
    public boolean fctOnlineMusic_StateIsToBeSynchronised;
    public boolean fct_CommonListIsNotToBeSynchronised;
    public boolean fctCurrentStation_Handle2IsToBeSynchronised;
    public boolean fctPlayPositionIsToBeSynchronised;
    private static final int RESERVED_BIT_5__7_BITSIZE;
    private static final int FCT_LIST_2_BITSIZE;

    public FunctionSynchronisation_Status$FctList_2() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_Status$FctList_2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fctCustomerDownloadStateIsToBeSynchronised = false;
        this.fctOnlineMusic_StateIsToBeSynchronised = false;
        this.fct_CommonListIsNotToBeSynchronised = false;
        this.fctCurrentStation_Handle2IsToBeSynchronised = false;
        this.fctPlayPositionIsToBeSynchronised = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_Status$FctList_2 functionSynchronisation_Status$FctList_2 = (FunctionSynchronisation_Status$FctList_2)bAPEntity;
        return this.fctCustomerDownloadStateIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fctCustomerDownloadStateIsToBeSynchronised && this.fctOnlineMusic_StateIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fctOnlineMusic_StateIsToBeSynchronised && this.fct_CommonListIsNotToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_CommonListIsNotToBeSynchronised && this.fctCurrentStation_Handle2IsToBeSynchronised == functionSynchronisation_Status$FctList_2.fctCurrentStation_Handle2IsToBeSynchronised && this.fctPlayPositionIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fctPlayPositionIsToBeSynchronised;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FctList_2:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.fctCustomerDownloadStateIsToBeSynchronised) {
            stringBuffer.append("true  (Fct \"CustomerDownloadState\" is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct \"CustomerDownloadState\" is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.fctOnlineMusic_StateIsToBeSynchronised) {
            stringBuffer.append("true  (Fct \"OnlineMusic_State\" is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct \"OnlineMusic_State\" is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.fct_CommonListIsNotToBeSynchronised) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (Fct. \"CommonList\" is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.fctCurrentStation_Handle2IsToBeSynchronised) {
            stringBuffer.append("true  (Fct \"CurrentStation_Handle2\" is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct \"CurrentStation_Handle2\" is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.fctPlayPositionIsToBeSynchronised) {
            stringBuffer.append("true  (Fct \"PlayPosition\" is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct \"PlayPosition\" is not to be synchronised");
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
        bitStream.pushBoolean(this.fctCustomerDownloadStateIsToBeSynchronised);
        bitStream.pushBoolean(this.fctOnlineMusic_StateIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_CommonListIsNotToBeSynchronised);
        bitStream.pushBoolean(this.fctCurrentStation_Handle2IsToBeSynchronised);
        bitStream.pushBoolean(this.fctPlayPositionIsToBeSynchronised);
        bitStream.resetBits(3);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.fctCustomerDownloadStateIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctOnlineMusic_StateIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fct_CommonListIsNotToBeSynchronised = bitStream.popFrontBoolean();
        this.fctCurrentStation_Handle2IsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctPlayPositionIsToBeSynchronised = bitStream.popFrontBoolean();
        bitStream.discardBits(3);
    }
}

