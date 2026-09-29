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
    private static final int CALIBRATION_STATE_BITSIZE;
    public static final int CALIBRATION_STATE_CALIBRATED;
    public static final int CALIBRATION_STATE_CALIBRATION_ACTIVE;
    public static final int CALIBRATION_STATE_INTERFERING_FIELD;
    public static final int CALIBRATION_STATE_NOT_SUPPORTED;

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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Calibration_SetGet calibration_SetGet = (Calibration_SetGet)bAPEntity;
        return this.calibrationState == calibration_SetGet.calibrationState;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.calibrationState);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.calibrationState = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 27;
    }

    @Override
    public int getFunctionId() {
        return Calibration_SetGet.functionId();
    }
}

