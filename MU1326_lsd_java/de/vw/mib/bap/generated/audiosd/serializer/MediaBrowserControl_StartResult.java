/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowserControl_StartResult
implements StartResultMethod {
    public int control;
    private static final int CONTROL_BITSIZE;
    public static final int CONTROL_GO_TO_CURRENT_FILE;
    public static final int CONTROL_GO_TO_ROOT_DIRECTORY;
    public static final int CONTROL_GO_TO_PARENT_DIRECTORY;
    public static final int CONTROL_GO_TO_SOURCE;
    public static final int CONTROL_OPEN_FOLDER_PLAYLIST;
    public int reference;
    private static final int REFERENCE_BITSIZE;

    public MediaBrowserControl_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowserControl_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.control = 0;
        this.reference = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowserControl_StartResult mediaBrowserControl_StartResult = (MediaBrowserControl_StartResult)bAPEntity;
        return this.control == mediaBrowserControl_StartResult.control && this.reference == mediaBrowserControl_StartResult.reference;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaBrowserControl_StartResult:");
        stringBuffer.append("\n - Control: ");
        switch (this.control) {
            case 0: {
                stringBuffer.append("0x00 (go to current file)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (go to root directory)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (go to parent directory)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (go to source)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (open folder/playlist)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Reference - ");
        stringBuffer.append(this.reference);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.control);
        bitStream.pushShort((short)this.reference);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.control = bitStream.popFrontByte();
        this.reference = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 38;
    }

    @Override
    public int getFunctionId() {
        return MediaBrowserControl_StartResult.functionId();
    }
}

