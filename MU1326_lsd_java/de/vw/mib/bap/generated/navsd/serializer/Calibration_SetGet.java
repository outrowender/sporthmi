/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Calibration_SetGet
implements SetGetProperty {
    public int calibrationState;
    private static final int CALIBRATION_STATE_BITSIZE = 8;
    public static final int CALIBRATION_STATE_CALIBRATED = 0;
    public static final int CALIBRATION_STATE_CALIBRATION_ACTIVE = 1;
    public static final int CALIBRATION_STATE_INTERFERING_FIELD = 2;
    public static final int CALIBRATION_STATE_NOT_SUPPORTED = 255;

    public Calibration_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public Calibration_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.calibrationState = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        Calibration_SetGet calibration_SetGet = (Calibration_SetGet)bAPEntity;
        return this.calibrationState == calibration_SetGet.calibrationState;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Calibration_SetGet:");
        stringBuffer.append("\n - CalibrationState: ");
        switch (this.calibrationState) {
            case 0: {
                stringBuffer.append("0x00 (calibrated)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (calibration active)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (interfering field)");
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
        bitStream.pushByte((byte)this.calibrationState);
    }

    public void deserialize(BitStream bitStream) {
        this.calibrationState = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 27;
    }

    public int getFunctionId() {
        return Calibration_SetGet.functionId();
    }
}

