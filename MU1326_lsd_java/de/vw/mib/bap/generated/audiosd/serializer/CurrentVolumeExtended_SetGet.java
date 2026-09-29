/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentVolumeExtended_SetGet
implements SetGetProperty {
    public int changingVolumeType;
    private static final int CHANGING_VOLUME_TYPE_BITSIZE;
    public static final int CHANGING_VOLUME_TYPE_NO_VOLUME_IS_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_ENTERTAINMENT_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_NAVIGATION_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_PHONE_RINGING_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_TA_TP_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_CAR_PARKING_FADER_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_READ_MESSAGE_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_TMC_TRAFFIC_MESSAGE_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_PHONE_CALL_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_READ_CONTACT_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_MMI_TOUCH_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_ANNOUNCEMENT_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_ONLINE_VOLUME_TYPE_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_SDS_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_EXTERNAL_SDS_VOLUME_IS_BEING_CHANGED_DF4_4;
    public int reserve1;
    private static final int RESERVE1_BITSIZE;
    public int reserve2;
    private static final int RESERVE2_BITSIZE;
    public int genericVolume;
    private static final int GENERIC_VOLUME_BITSIZE;

    public CurrentVolumeExtended_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentVolumeExtended_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.changingVolumeType = 0;
        this.reserve1 = 0;
        this.reserve2 = 0;
        this.genericVolume = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentVolumeExtended_SetGet currentVolumeExtended_SetGet = (CurrentVolumeExtended_SetGet)bAPEntity;
        return this.changingVolumeType == currentVolumeExtended_SetGet.changingVolumeType && this.reserve1 == currentVolumeExtended_SetGet.reserve1 && this.reserve2 == currentVolumeExtended_SetGet.reserve2 && this.genericVolume == currentVolumeExtended_SetGet.genericVolume;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CurrentVolumeExtended_SetGet:");
        stringBuffer.append("\n - ChangingVolumeType: ");
        switch (this.changingVolumeType) {
            case 0: {
                stringBuffer.append("0x00 (no volume is changed)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (entertainment volume is being changed)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (navigation volume is being changed)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (phone ringing volume is being changed)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (TA/TP volume is being changed)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (car parking fader is being changed)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (read message volume is being changed)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (TMC traffic message volume is being changed)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (phone  call volume is being changed)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (read contact volume is being changed)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (MMI touch volume is being changed)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (announcement volume is being changed)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (online volume type is being changed)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (SDS volume is being changed)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (external SDS volume is being changed (DF4.4))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Reserve1 - ");
        stringBuffer.append(this.reserve1);
        stringBuffer.append("\n - Reserve2 - ");
        stringBuffer.append(this.reserve2);
        stringBuffer.append("\n - GenericVolume - ");
        stringBuffer.append(this.genericVolume);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.changingVolumeType);
        bitStream.pushByte((byte)this.reserve1);
        bitStream.pushByte((byte)this.reserve2);
        bitStream.pushByte((byte)this.genericVolume);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.changingVolumeType = bitStream.popFrontByte();
        this.reserve1 = bitStream.popFrontByte();
        this.reserve2 = bitStream.popFrontByte();
        this.genericVolume = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 47;
    }

    @Override
    public int getFunctionId() {
        return CurrentVolumeExtended_SetGet.functionId();
    }
}

