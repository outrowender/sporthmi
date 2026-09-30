/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SourceState_SetGet
implements SetGetProperty {
    public int stateInfo;
    private static final int STATE_INFO_BITSIZE = 8;
    public static final int STATE_INFO_UNKNOWN_OFF = 0;
    public static final int STATE_INFO_SCAN = 1;
    public static final int STATE_INFO_MIX = 2;
    public static final int STATE_INFO_REPEAT = 3;
    public static final int STATE_INFO_REPEAT_MIX = 4;
    public static final int STATE_INFO_MANUAL_TUNING = 5;
    public static final int STATE_INFO_SEEK = 6;
    public static final int STATE_INFO_PLAY_MORE_LIKE_THIS = 7;
    public int stateInfo_Scope;
    private static final int STATE_INFO_SCOPE_BITSIZE = 8;
    public static final int STATE_INFO_SCOPE_UNKNOWN_SCOPE_ANY_SCOPE = 0;
    public static final int STATE_INFO_SCOPE_FILE_TRACK = 1;
    public static final int STATE_INFO_SCOPE_DEVICE = 2;
    public static final int STATE_INFO_SCOPE_MEDIUM = 3;
    public static final int STATE_INFO_SCOPE_DIRECTORY_WITHOUT_SUBDIRECTORIES = 4;
    public static final int STATE_INFO_SCOPE_DIRECTORY_WITH_SUBDIRECTORIES = 5;
    public static final int STATE_INFO_SCOPE_ALL_DIRECTORIES_ALL_FOLDERS = 6;
    public static final int STATE_INFO_SCOPE_PLAYLIST = 7;
    public static final int STATE_INFO_SCOPE_ALL_PLAYLISTS = 8;

    public SourceState_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public SourceState_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stateInfo = 0;
        this.stateInfo_Scope = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        SourceState_SetGet sourceState_SetGet = (SourceState_SetGet)bAPEntity;
        return this.stateInfo == sourceState_SetGet.stateInfo && this.stateInfo_Scope == sourceState_SetGet.stateInfo_Scope;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SourceState_SetGet:");
        stringBuffer.append("\n - StateInfo: ");
        switch (this.stateInfo) {
            case 0: {
                stringBuffer.append("0x00 (unknown / off)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (scan)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (mix)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (repeat)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (repeat / mix)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (manual tuning)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (seek)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (play more like this)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - StateInfo_Scope: ");
        switch (this.stateInfo_Scope) {
            case 0: {
                stringBuffer.append("0x00 (unknown scope / any scope)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (file / track)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (device)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (medium)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (directory without subdirectories)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (directory with subdirectories)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (all directories / all folders)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (playlist)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (all playlists)");
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
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.stateInfo);
        bitStream.pushByte((byte)this.stateInfo_Scope);
    }

    public void deserialize(BitStream bitStream) {
        this.stateInfo = bitStream.popFrontByte();
        this.stateInfo_Scope = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 20;
    }

    public int getFunctionId() {
        return SourceState_SetGet.functionId();
    }
}

