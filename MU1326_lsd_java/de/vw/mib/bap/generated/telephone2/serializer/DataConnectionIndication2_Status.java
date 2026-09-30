/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DataConnectionIndication2_Status
implements StatusProperty {
    public int connectionIndication;
    private static final int CONNECTION_INDICATION_BITSIZE = 8;
    public static final int CONNECTION_INDICATION_NO_DATA_CONNECTION = 0;
    public static final int CONNECTION_INDICATION_DATA_CONNECTION_ACTIVE = 1;
    public int dataVolumeUplink;
    private static final int DATA_VOLUME_UPLINK_BITSIZE = 32;
    public int dataVolumeDownlink;
    private static final int DATA_VOLUME_DOWNLINK_BITSIZE = 32;

    public DataConnectionIndication2_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DataConnectionIndication2_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.connectionIndication = 0;
        this.dataVolumeUplink = 0;
        this.dataVolumeDownlink = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DataConnectionIndication2_Status dataConnectionIndication2_Status = (DataConnectionIndication2_Status)bAPEntity;
        return this.connectionIndication == dataConnectionIndication2_Status.connectionIndication && this.dataVolumeUplink == dataConnectionIndication2_Status.dataVolumeUplink && this.dataVolumeDownlink == dataConnectionIndication2_Status.dataVolumeDownlink;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DataConnectionIndication2_Status:");
        stringBuffer.append("\n - ConnectionIndication: ");
        switch (this.connectionIndication) {
            case 0: {
                stringBuffer.append("0x00 (no data connection)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (data connection active)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - DataVolumeUplink - ");
        stringBuffer.append(this.dataVolumeUplink);
        stringBuffer.append("\n - DataVolumeDownlink - ");
        stringBuffer.append(this.dataVolumeDownlink);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 32;
        return n += 32;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.connectionIndication);
        bitStream.pushInt(this.dataVolumeUplink);
        bitStream.pushInt(this.dataVolumeDownlink);
    }

    public void deserialize(BitStream bitStream) {
        this.connectionIndication = bitStream.popFrontByte();
        this.dataVolumeUplink = bitStream.popFrontInt();
        this.dataVolumeDownlink = bitStream.popFrontInt();
    }

    public static int functionId() {
        return 21;
    }

    public int getFunctionId() {
        return DataConnectionIndication2_Status.functionId();
    }
}

