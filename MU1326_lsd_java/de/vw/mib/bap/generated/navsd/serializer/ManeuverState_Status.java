/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ManeuverState_Status
implements StatusProperty {
    public int state;
    private static final int STATE_BITSIZE = 8;
    public static final int STATE_INIT_UNKNOWN = 0;
    public static final int STATE_FOLLOW = 1;
    public static final int STATE_PREPARE = 2;
    public static final int STATE_DISTANCE = 3;
    public static final int STATE_CALL_FOR_ACTION = 4;
    public int dummy1;
    private static final int DUMMY1_BITSIZE = 8;
    public int dummy2;
    private static final int DUMMY2_BITSIZE = 8;
    public int dummy3;
    private static final int DUMMY3_BITSIZE = 8;

    public ManeuverState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ManeuverState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.state = 0;
        this.dummy1 = 0;
        this.dummy2 = 0;
        this.dummy3 = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ManeuverState_Status maneuverState_Status = (ManeuverState_Status)bAPEntity;
        return this.state == maneuverState_Status.state && this.dummy1 == maneuverState_Status.dummy1 && this.dummy2 == maneuverState_Status.dummy2 && this.dummy3 == maneuverState_Status.dummy3;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ManeuverState_Status:");
        stringBuffer.append("\n - State: ");
        switch (this.state) {
            case 0: {
                stringBuffer.append("0x00 (init / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (Follow)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (Prepare)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (Distance)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (Call for Action)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Dummy1 - ");
        stringBuffer.append(this.dummy1);
        stringBuffer.append("\n - Dummy2 - ");
        stringBuffer.append(this.dummy2);
        stringBuffer.append("\n - Dummy3 - ");
        stringBuffer.append(this.dummy3);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.state);
        bitStream.pushByte((byte)this.dummy1);
        bitStream.pushByte((byte)this.dummy2);
        bitStream.pushByte((byte)this.dummy3);
    }

    public void deserialize(BitStream bitStream) {
        this.state = bitStream.popFrontByte();
        this.dummy1 = bitStream.popFrontByte();
        this.dummy2 = bitStream.popFrontByte();
        this.dummy3 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 55;
    }

    public int getFunctionId() {
        return ManeuverState_Status.functionId();
    }
}

