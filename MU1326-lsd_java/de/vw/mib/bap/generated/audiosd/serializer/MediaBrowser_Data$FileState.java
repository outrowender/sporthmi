/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowser_Data$FileState
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean importNotPlayable;
    public boolean importPending;
    public boolean importRunning;
    public boolean deadLink;
    public boolean corruptedFileFolder;
    public boolean drmProteced;
    public boolean emptyFolder;
    private static final int RESERVED_BIT_8__15_BITSIZE;
    private static final int FILE_STATE_BITSIZE;

    public MediaBrowser_Data$FileState() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowser_Data$FileState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.importNotPlayable = false;
        this.importPending = false;
        this.importRunning = false;
        this.deadLink = false;
        this.corruptedFileFolder = false;
        this.drmProteced = false;
        this.emptyFolder = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowser_Data$FileState mediaBrowser_Data$FileState = (MediaBrowser_Data$FileState)bAPEntity;
        return this.reserved_bit_7 == mediaBrowser_Data$FileState.reserved_bit_7 && this.importNotPlayable == mediaBrowser_Data$FileState.importNotPlayable && this.importPending == mediaBrowser_Data$FileState.importPending && this.importRunning == mediaBrowser_Data$FileState.importRunning && this.deadLink == mediaBrowser_Data$FileState.deadLink && this.corruptedFileFolder == mediaBrowser_Data$FileState.corruptedFileFolder && this.drmProteced == mediaBrowser_Data$FileState.drmProteced && this.emptyFolder == mediaBrowser_Data$FileState.emptyFolder;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FileState:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.reserved_bit_7) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.importNotPlayable) {
            stringBuffer.append("true  (import not playable");
        } else {
            stringBuffer.append("false  (import playable / not an import");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.importPending) {
            stringBuffer.append("true  (import pending");
        } else {
            stringBuffer.append("false  (import not pending");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.importRunning) {
            stringBuffer.append("true  (import running");
        } else {
            stringBuffer.append("false  (import finished / unknown import state");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.deadLink) {
            stringBuffer.append("true  (dead link");
        } else {
            stringBuffer.append("false  (not a dead link");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.corruptedFileFolder) {
            stringBuffer.append("true  (corrupted file/folder");
        } else {
            stringBuffer.append("false  (file/folder is not corrupted");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.drmProteced) {
            stringBuffer.append("true  (DRM proteced");
        } else {
            stringBuffer.append("false  (not DRM proteced");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.emptyFolder) {
            stringBuffer.append("true  (empty folder");
        } else {
            stringBuffer.append("false  (not an empty folder");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.importNotPlayable);
        bitStream.pushBoolean(this.importPending);
        bitStream.pushBoolean(this.importRunning);
        bitStream.pushBoolean(this.deadLink);
        bitStream.pushBoolean(this.corruptedFileFolder);
        bitStream.pushBoolean(this.drmProteced);
        bitStream.pushBoolean(this.emptyFolder);
        bitStream.resetBits(8);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.importNotPlayable = bitStream.popFrontBoolean();
        this.importPending = bitStream.popFrontBoolean();
        this.importRunning = bitStream.popFrontBoolean();
        this.deadLink = bitStream.popFrontBoolean();
        this.corruptedFileFolder = bitStream.popFrontBoolean();
        this.drmProteced = bitStream.popFrontBoolean();
        this.emptyFolder = bitStream.popFrontBoolean();
        bitStream.discardBits(8);
    }
}

