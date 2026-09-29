/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SourceState_Status
implements StatusProperty {
    public int stateInfo;
    private static final int STATE_INFO_BITSIZE;
    public static final int STATE_INFO_UNKNOWN_OFF;
    public static final int STATE_INFO_SCAN;
    public static final int STATE_INFO_MIX;
    public static final int STATE_INFO_REPEAT;
    public static final int STATE_INFO_REPEAT_MIX;
    public static final int STATE_INFO_MANUAL_TUNING;
    public static final int STATE_INFO_SEEK;
    public static final int STATE_INFO_PLAY_MORE_LIKE_THIS;
    public int stateInfo_Scope;
    private static final int STATE_INFO_SCOPE_BITSIZE;
    public static final int STATE_INFO_SCOPE_UNKNOWN_SCOPE_ANY_SCOPE;
    public static final int STATE_INFO_SCOPE_FILE_TRACK;
    public static final int STATE_INFO_SCOPE_DEVICE;
    public static final int STATE_INFO_SCOPE_MEDIUM;
    public static final int STATE_INFO_SCOPE_DIRECTORY_WITHOUT_SUBDIRECTORIES;
    public static final int STATE_INFO_SCOPE_DIRECTORY_WITH_SUBDIRECTORIES;
    public static final int STATE_INFO_SCOPE_ALL_DIRECTORIES_ALL_FOLDERS;
    public static final int STATE_INFO_SCOPE_PLAYLIST;
    public static final int STATE_INFO_SCOPE_ALL_PLAYLISTS;

    public SourceState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SourceState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stateInfo = 0;
        this.stateInfo_Scope = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SourceState_Status sourceState_Status = (SourceState_Status)bAPEntity;
        return this.stateInfo == sourceState_Status.stateInfo && this.stateInfo_Scope == sourceState_Status.stateInfo_Scope;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SourceState_Status:");
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

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.stateInfo);
        bitStream.pushByte((byte)this.stateInfo_Scope);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.stateInfo = bitStream.popFrontByte();
        this.stateInfo_Scope = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return SourceState_Status.functionId();
    }
}

