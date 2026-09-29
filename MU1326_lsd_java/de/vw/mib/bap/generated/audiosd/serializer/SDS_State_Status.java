/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SDS_State_Status
implements StatusProperty {
    public int state;
    private static final int STATE_BITSIZE;
    public static final int STATE_SDS_NOT_BUILT_IN;
    public static final int STATE_SDS_INITIALISING_SDS_IS_BEING_INITIALISED;
    public static final int STATE_SDS_INITIALISING_ACTIVE;
    public static final int STATE_SDS_ACTIVE_RECOGNIZER_OPEN;
    public static final int STATE_SDS_ACTIVE_RECOGNIZER_CLOSED;
    public static final int STATE_SDS_NOT_READY;
    public static final int STATE_SDS_DEACTIVATED_VOICE_RECOGNITION_NOT_ACTIVE;
    public static final int STATE_SDS_PAUSE_VOICE_RECOGNITION_IS_PAUSED;
    public static final int STATE_SDS_NOT_BUIT_IN_ACTIVE;
    public static final int STATE_SDS_DESIRED_LANGUAGE_NOT_AVAILABLE;
    public static final int STATE_SDS_LANGUAGE_IS_BEEING_LOADED;
    public static final int STATE_SDS_DOWNLOAD_UNSUCCESSFUL;
    public static final int STATE_SDS_NOT_AVAILABLE_DUE_TO_ACTIVE_RVC_APS_OPS;
    public static final int STATE_SDS_TEMPORARY_NOT_AVAILABLE;
    public static final int STATE_EXTERNAL_SDS_ACTIVE_DF4_1;

    public SDS_State_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SDS_State_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.state = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SDS_State_Status sDS_State_Status = (SDS_State_Status)bAPEntity;
        return this.state == sDS_State_Status.state;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SDS_State_Status:");
        stringBuffer.append("\n - State: ");
        switch (this.state) {
            case 0: {
                stringBuffer.append("0x00 (SDS not built-in)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (SDS initialising (SDS is being initialised))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (SDS initialising (active))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (SDS active, recognizer open (speech dialog system is active, voice recognition is active))");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (SDS active, recognizer closed (speech dialog system is active, voice recognition is active))");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (SDS not ready)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (SDS deactivated (voice recognition not active))");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (SDS pause (voice recognition is paused))");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (SDS not buit-in (active))");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (SDS (desired) language not available)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (SDS language is beeing loaded)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (SDS download unsuccessful)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (SDS not available due to active RVC/APS/OPS)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (SDS temporary not available)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (external SDS active (DF4.1))");
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
        bitStream.pushByte((byte)this.state);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.state = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 41;
    }

    @Override
    public int getFunctionId() {
        return SDS_State_Status.functionId();
    }
}

