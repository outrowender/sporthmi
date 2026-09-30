/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DedicatedAudioControl_StartResult
implements StartResultMethod {
    public int controlType;
    private static final int CONTROL_TYPE_BITSIZE = 8;
    public static final int CONTROL_TYPE_SELECT_LIST_ENTRY = 0;
    public static final int CONTROL_TYPE_NEXT = 1;
    public static final int CONTROL_TYPE_PREVIOUS = 2;
    public static final int CONTROL_TYPE_FAST_FORWARD = 3;
    public static final int CONTROL_TYPE_FAST_BACKWARD_REWIND = 4;
    public static final int CONTROL_TYPE_UPDATE_STATION_LIST_RELATED_TO_ACTIVE_BAND = 5;
    public static final int CONTROL_TYPE_CANCEL_STATION_LIST_UPDATE = 6;
    public static final int CONTROL_TYPE_CANCEL_SEEK_SCAN = 7;
    public int additionalControlInformation;
    private static final int ADDITIONAL_CONTROL_INFORMATION_BITSIZE = 16;
    public int listType;
    private static final int LIST_TYPE_BITSIZE = 8;
    public static final int LIST_TYPE_NO_LIST = 0;
    public static final int LIST_TYPE_RECEPTION_LIST = 1;
    public static final int LIST_TYPE_RADIO_TV_PRESET_LIST = 2;
    public static final int LIST_TYPE_MEDIA_BROWSER = 3;
    public static final int LIST_TYPE_TP_MEMO_LIST = 4;
    public static final int LIST_TYPE_COMMON_LIST_DF4_1 = 5;

    public DedicatedAudioControl_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public DedicatedAudioControl_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.controlType = 0;
        this.additionalControlInformation = 0;
        this.listType = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult = (DedicatedAudioControl_StartResult)bAPEntity;
        return this.controlType == dedicatedAudioControl_StartResult.controlType && this.additionalControlInformation == dedicatedAudioControl_StartResult.additionalControlInformation && this.listType == dedicatedAudioControl_StartResult.listType;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DedicatedAudioControl_StartResult:");
        stringBuffer.append("\n - ControlType: ");
        switch (this.controlType) {
            case 0: {
                stringBuffer.append("0x00 (select list entry)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (next)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (previous)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (fast forward)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (fast backward (rewind))");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (update station list (related to active band))");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (cancel station list update)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (cancel seek/scan)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - AdditionalControlInformation - ");
        stringBuffer.append(this.additionalControlInformation);
        stringBuffer.append("\n - ListType: ");
        switch (this.listType) {
            case 0: {
                stringBuffer.append("0x00 (no list)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (ReceptionList)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (RadioTV_PresetList)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (MediaBrowser)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (TpMemoList)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (CommonList (DF4.1))");
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
        n += 8;
        n += 16;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.controlType);
        bitStream.pushShort((short)this.additionalControlInformation);
        bitStream.pushByte((byte)this.listType);
    }

    public void deserialize(BitStream bitStream) {
        this.controlType = bitStream.popFrontByte();
        this.additionalControlInformation = bitStream.popFrontShort();
        this.listType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return DedicatedAudioControl_StartResult.functionId();
    }
}

