/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineMusic_State_Status
implements StatusProperty {
    public int state;
    private static final int STATE_BITSIZE;
    public static final int STATE_ONLINE_RADIO_OFF_DISABLED;
    public static final int STATE_NORMAL_OPERATION_PLAYBACK_OF_RECEIVED_DATA;
    public static final int STATE_CONNECTING_TO_NETWORK_CONNECTION_SETUP_IN_PROGRESS;
    public static final int STATE_DATA_CONNECTION_SETUP_CONFIRMATION_IS_STILL_PENDING;
    public static final int STATE_NO_DATA_RECEIVED_FROM_ONLINE_RADIO_SERVER_BUT_CONNECTION_IS_ESTABLISHED_SUCCESSFULLY;
    public static final int STATE_BUFFERING_DATA_NO_PLAYBACK_OF_RECEIVED_DATA_YET;
    public static final int STATE_NO_NETWORK;
    public static final int STATE_NO_SIM_AVAILABLE;
    public static final int STATE_LOW_BANDWIDTH;
    public static final int STATE_AUTHENTIFICATION_FAILED;
    public static final int STATE_SUBSCRIPTION_MISSING;
    public int bufferLevel;
    private static final int BUFFER_LEVEL_BITSIZE;
    public static final int DUMMY_MIN;
    public int dummy;
    private static final int DUMMY_BITSIZE;

    public OnlineMusic_State_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineMusic_State_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.state = 0;
        this.bufferLevel = 0;
        this.dummy = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineMusic_State_Status onlineMusic_State_Status = (OnlineMusic_State_Status)bAPEntity;
        return this.state == onlineMusic_State_Status.state && this.bufferLevel == onlineMusic_State_Status.bufferLevel && this.dummy == onlineMusic_State_Status.dummy;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OnlineMusic_State_Status:");
        stringBuffer.append("\n - State: ");
        switch (this.state) {
            case 0: {
                stringBuffer.append("0x00 (OnlineRadio OFF/disabled)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (normal operation (playback of received data))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (connecting to network (connection setup in progress))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (data connection setup confirmation is still pending)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (no data received from OnlineRadio server but connection is established successfully)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (buffering data (no playback of received data yet))");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (no network)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (no SIM available)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (low bandwidth)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (authentification failed)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (subscription missing)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - BufferLevel - ");
        stringBuffer.append(this.bufferLevel);
        stringBuffer.append("\n - Dummy - ");
        stringBuffer.append(this.dummy);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.state);
        bitStream.pushByte((byte)this.bufferLevel);
        bitStream.pushShort((short)this.dummy);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.state = bitStream.popFrontByte();
        this.bufferLevel = bitStream.popFrontByte();
        this.dummy = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 49;
    }

    @Override
    public int getFunctionId() {
        return OnlineMusic_State_Status.functionId();
    }
}

