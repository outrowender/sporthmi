/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_DownloadSize
implements BAPEntity {
    public static final int SIZE_MIN = 0;
    public int size;
    public static final int UNIT_NO_INFORMATION_DEFAULT_DURING_STARTUP = 0;
    public static final int UNIT_BYTE = 1;
    public static final int UNIT_KILOBYTE = 2;
    public static final int UNIT_MEGABYTE = 3;
    public static final int UNIT_GIGABYTE = 4;
    public static final int UNIT_TERABYTE = 5;
    public int unit;

    public OnlineUpdateState_Deprecated_DownloadSize() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_DownloadSize(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.size = 0;
        this.unit = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_DownloadSize onlineUpdateState_Deprecated_DownloadSize = (OnlineUpdateState_Deprecated_DownloadSize)bAPEntity;
        return this.size == onlineUpdateState_Deprecated_DownloadSize.size && this.unit == onlineUpdateState_Deprecated_DownloadSize.unit;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OnlineUpdateState_Deprecated_DownloadSize");
        stringBuffer.append("\n - size:" + this.size);
        stringBuffer.append("\n - unit:" + this.unit);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.size);
        bitStream.pushByte((byte)this.unit);
    }

    public void deserialize(BitStream bitStream) {
        this.size = bitStream.popFrontShort();
        this.unit = bitStream.popFrontByte();
    }
}

