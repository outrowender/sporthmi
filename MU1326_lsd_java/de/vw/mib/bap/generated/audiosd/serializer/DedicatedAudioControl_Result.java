/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DedicatedAudioControl_Result
implements ResultMethod {
    public int dedicatedAudioControlResult;
    private static final int DEDICATED_AUDIO_CONTROL_RESULT_BITSIZE = 8;
    public static final int DEDICATED_AUDIO_CONTROL_RESULT_SUCCESSFUL = 0;
    public static final int DEDICATED_AUDIO_CONTROL_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED = 1;
    public static final int DEDICATED_AUDIO_CONTROL_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int DEDICATED_AUDIO_CONTROL_RESULT_ABORT_NOT_SUCCESSFUL = 3;

    public int getResultCode() {
        return this.dedicatedAudioControlResult;
    }

    public DedicatedAudioControl_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public DedicatedAudioControl_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dedicatedAudioControlResult = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DedicatedAudioControl_Result dedicatedAudioControl_Result = (DedicatedAudioControl_Result)bAPEntity;
        return this.dedicatedAudioControlResult == dedicatedAudioControl_Result.dedicatedAudioControlResult;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DedicatedAudioControl_Result:");
        stringBuffer.append("\n - dedicatedAudioControlResult: ");
        switch (this.dedicatedAudioControlResult) {
            case 0: {
                stringBuffer.append("0x00 (successful)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (not successful / not supported)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (abort successful)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (abort not successful)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.dedicatedAudioControlResult);
    }

    public void deserialize(BitStream bitStream) {
        this.dedicatedAudioControlResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return DedicatedAudioControl_Result.functionId();
    }
}

