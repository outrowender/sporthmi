/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class SwitchRadioMedia_StartResult
implements StartResultMethod {
    public int source;
    private static final int SOURCE_BITSIZE;
    public static final int SOURCE_RADIO_LAST_MODE;
    public static final int SOURCE_MEDIA_LAST_MODE;
    public static final int SOURCE_RADIO_PRESET_LIST;
    public static final int SOURCE_RADIO_COMMON_LIST;

    public SwitchRadioMedia_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public SwitchRadioMedia_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.source = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SwitchRadioMedia_StartResult switchRadioMedia_StartResult = (SwitchRadioMedia_StartResult)bAPEntity;
        return this.source == switchRadioMedia_StartResult.source;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SwitchRadioMedia_StartResult:");
        stringBuffer.append("\n - Source: ");
        switch (this.source) {
            case 0: {
                stringBuffer.append("0x00 (radio last mode)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (media last mode)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (radio preset list)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (radio common list)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
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
        bitStream.pushByte((byte)this.source);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.source = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return SwitchRadioMedia_StartResult.functionId();
    }
}

