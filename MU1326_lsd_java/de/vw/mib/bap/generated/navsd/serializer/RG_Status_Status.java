/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RG_Status_Status
implements StatusProperty {
    public int rg_Status;
    private static final int RG_STATUS_BITSIZE = 8;
    public static final int RG_STATUS_RG_NOT_ACTIVE = 0;
    public static final int RG_STATUS_RG_ACTIVE = 1;
    public static final int RG_STATUS_RG_SUSPENDED_DF4_1 = 2;
    public static final int RG_STATUS_NOT_SUPPORTED = 255;

    public RG_Status_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public RG_Status_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.rg_Status = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RG_Status_Status rG_Status_Status = (RG_Status_Status)bAPEntity;
        return this.rg_Status == rG_Status_Status.rg_Status;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RG_Status_Status:");
        stringBuffer.append("\n - RG_Status: ");
        switch (this.rg_Status) {
            case 0: {
                stringBuffer.append("0x00 (RG not active)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (RG active)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (RG suspended (DF4.1))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (not supported)");
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
        bitStream.pushByte((byte)this.rg_Status);
    }

    public void deserialize(BitStream bitStream) {
        this.rg_Status = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 17;
    }

    public int getFunctionId() {
        return RG_Status_Status.functionId();
    }
}

