/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentVolume_Status
implements StatusProperty {
    public int entertainmentVolume;
    private static final int ENTERTAINMENT_VOLUME_BITSIZE;
    public int navigationVolume;
    private static final int NAVIGATION_VOLUME_BITSIZE;
    public int taVolume;
    private static final int TA_VOLUME_BITSIZE;
    public int phoneVolume;
    private static final int PHONE_VOLUME_BITSIZE;
    public int sdsVolume;
    private static final int SDS_VOLUME_BITSIZE;
    public int changingVolumeType;
    private static final int CHANGING_VOLUME_TYPE_BITSIZE;
    public static final int CHANGING_VOLUME_TYPE_NO_VOLUME_IS_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_ENTERTAINMENT_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_NAVIGATION_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_TA_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_PHONE_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_SDS_VOLUME_IS_BEING_CHANGED;

    public CurrentVolume_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentVolume_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.entertainmentVolume = 0;
        this.navigationVolume = 0;
        this.taVolume = 0;
        this.phoneVolume = 0;
        this.sdsVolume = 0;
        this.changingVolumeType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentVolume_Status currentVolume_Status = (CurrentVolume_Status)bAPEntity;
        return this.entertainmentVolume == currentVolume_Status.entertainmentVolume && this.navigationVolume == currentVolume_Status.navigationVolume && this.taVolume == currentVolume_Status.taVolume && this.phoneVolume == currentVolume_Status.phoneVolume && this.sdsVolume == currentVolume_Status.sdsVolume && this.changingVolumeType == currentVolume_Status.changingVolumeType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CurrentVolume_Status:");
        stringBuffer.append("\n - EntertainmentVolume - ");
        stringBuffer.append(this.entertainmentVolume);
        stringBuffer.append("\n - NavigationVolume - ");
        stringBuffer.append(this.navigationVolume);
        stringBuffer.append("\n - TaVolume - ");
        stringBuffer.append(this.taVolume);
        stringBuffer.append("\n - PhoneVolume - ");
        stringBuffer.append(this.phoneVolume);
        stringBuffer.append("\n - SdsVolume - ");
        stringBuffer.append(this.sdsVolume);
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
            case 4: {
                stringBuffer.append("0x04 (TA volume is being changed)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (phone volume is being changed)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (SDS volume is being changed)");
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
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.entertainmentVolume);
        bitStream.pushByte((byte)this.navigationVolume);
        bitStream.pushByte((byte)this.taVolume);
        bitStream.pushByte((byte)this.phoneVolume);
        bitStream.pushByte((byte)this.sdsVolume);
        bitStream.pushByte((byte)this.changingVolumeType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.entertainmentVolume = bitStream.popFrontByte();
        this.navigationVolume = bitStream.popFrontByte();
        this.taVolume = bitStream.popFrontByte();
        this.phoneVolume = bitStream.popFrontByte();
        this.sdsVolume = bitStream.popFrontByte();
        this.changingVolumeType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return CurrentVolume_Status.functionId();
    }
}

