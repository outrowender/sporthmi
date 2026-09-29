/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DataConnectionIndication_Status
implements StatusProperty {
    public int connectionIndication;
    private static final int CONNECTION_INDICATION_BITSIZE;
    public static final int CONNECTION_INDICATION_NO_DATA_CONNECTION;
    public static final int CONNECTION_INDICATION_DATA_CONNECTION_ACTIVE;
    public int dataVolumeUplink;
    private static final int DATA_VOLUME_UPLINK_BITSIZE;
    public int dataVolumeDownlink;
    private static final int DATA_VOLUME_DOWNLINK_BITSIZE;

    public DataConnectionIndication_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DataConnectionIndication_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.connectionIndication = 0;
        this.dataVolumeUplink = 0;
        this.dataVolumeDownlink = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DataConnectionIndication_Status dataConnectionIndication_Status = (DataConnectionIndication_Status)bAPEntity;
        return this.connectionIndication == dataConnectionIndication_Status.connectionIndication && this.dataVolumeUplink == dataConnectionIndication_Status.dataVolumeUplink && this.dataVolumeDownlink == dataConnectionIndication_Status.dataVolumeDownlink;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DataConnectionIndication_Status:");
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

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 32;
        return n += 32;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.connectionIndication);
        bitStream.pushInt(this.dataVolumeUplink);
        bitStream.pushInt(this.dataVolumeDownlink);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.connectionIndication = bitStream.popFrontByte();
        this.dataVolumeUplink = bitStream.popFrontInt();
        this.dataVolumeDownlink = bitStream.popFrontInt();
    }

    public static int functionId() {
        return 44;
    }

    @Override
    public int getFunctionId() {
        return DataConnectionIndication_Status.functionId();
    }
}

