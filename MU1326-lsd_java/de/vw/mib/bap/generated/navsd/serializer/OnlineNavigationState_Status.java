/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineNavigationState_Status
implements StatusProperty {
    public int state;
    private static final int STATE_BITSIZE;
    public static final int STATE_OFF;
    public static final int STATE_INIT_LOADING;
    public static final int STATE_ACTIVE;
    public static final int STATE_NO_DATA_CONNECTION;
    public int progress;
    private static final int PROGRESS_BITSIZE;
    public int onlineNavigationSystem;
    private static final int ONLINE_NAVIGATION_SYSTEM_BITSIZE;
    public static final int ONLINE_NAVIGATION_SYSTEM_ONLINE_NAVIGATION_NOT_BUILT_IN;
    public static final int ONLINE_NAVIGATION_SYSTEM_GOOGLE_NAVIGATION;
    public static final int ONLINE_NAVIGATION_SYSTEM_UNKNOWN_TECHNICAL_SYSTEM_FOR_ONLINE_NAVIGATION;

    public OnlineNavigationState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineNavigationState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.state = 0;
        this.progress = 0;
        this.onlineNavigationSystem = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineNavigationState_Status onlineNavigationState_Status = (OnlineNavigationState_Status)bAPEntity;
        return this.state == onlineNavigationState_Status.state && this.progress == onlineNavigationState_Status.progress && this.onlineNavigationSystem == onlineNavigationState_Status.onlineNavigationSystem;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OnlineNavigationState_Status:");
        stringBuffer.append("\n - State: ");
        switch (this.state) {
            case 0: {
                stringBuffer.append("0x00 (off)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (init/loading)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (active)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (no data connection)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Progress - ");
        stringBuffer.append(this.progress);
        stringBuffer.append("\n - OnlineNavigationSystem: ");
        switch (this.onlineNavigationSystem) {
            case 0: {
                stringBuffer.append("0x00 (online navigation not built-in)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (GOOGLE navigation)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown technical system for online navigation)");
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
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.state);
        bitStream.pushByte((byte)this.progress);
        bitStream.pushByte((byte)this.onlineNavigationSystem);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.state = bitStream.popFrontByte();
        this.progress = bitStream.popFrontByte();
        this.onlineNavigationSystem = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 48;
    }

    @Override
    public int getFunctionId() {
        return OnlineNavigationState_Status.functionId();
    }
}

