/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStation_Handle2_Status
implements StatusProperty {
    public int commonList_FsgHandle;
    private static final int COMMON_LIST_FSG_HANDLE_BITSIZE;
    public int commonList_FsgHandle_absolutePosition;
    private static final int COMMON_LIST_FSG_HANDLE_ABSOLUTE_POSITION_BITSIZE;
    public static final int EXTENSION1_MIN;
    public int extension1;
    private static final int EXTENSION1_BITSIZE;
    public static final int EXTENSION2_MIN;
    public int extension2;
    private static final int EXTENSION2_BITSIZE;

    public CurrentStation_Handle2_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStation_Handle2_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.commonList_FsgHandle = 0;
        this.commonList_FsgHandle_absolutePosition = 0;
        this.extension1 = 0;
        this.extension2 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStation_Handle2_Status currentStation_Handle2_Status = (CurrentStation_Handle2_Status)bAPEntity;
        return this.commonList_FsgHandle == currentStation_Handle2_Status.commonList_FsgHandle && this.commonList_FsgHandle_absolutePosition == currentStation_Handle2_Status.commonList_FsgHandle_absolutePosition && this.extension1 == currentStation_Handle2_Status.extension1 && this.extension2 == currentStation_Handle2_Status.extension2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CurrentStation_Handle2_Status:");
        stringBuffer.append("\n - CommonList_FsgHandle - ");
        stringBuffer.append(this.commonList_FsgHandle);
        stringBuffer.append("\n - CommonList_FsgHandle_absolutePosition - ");
        stringBuffer.append(this.commonList_FsgHandle_absolutePosition);
        stringBuffer.append("\n - Extension1 - ");
        stringBuffer.append(this.extension1);
        stringBuffer.append("\n - Extension2 - ");
        stringBuffer.append(this.extension2);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 16;
        n += 16;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.commonList_FsgHandle);
        bitStream.pushShort((short)this.commonList_FsgHandle_absolutePosition);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.commonList_FsgHandle = bitStream.popFrontShort();
        this.commonList_FsgHandle_absolutePosition = bitStream.popFrontShort();
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 51;
    }

    @Override
    public int getFunctionId() {
        return CurrentStation_Handle2_Status.functionId();
    }
}

