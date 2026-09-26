/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowser_FolderLevel_Status
implements StatusProperty {
    public int folderLevel;
    private static final int FOLDER_LEVEL_BITSIZE;
    public int ref_MediaBrowser;
    private static final int REF_MEDIA_BROWSER_BITSIZE;
    public int ref_MediaBrowser_absolutePosition;
    private static final int REF_MEDIA_BROWSER_ABSOLUTE_POSITION_BITSIZE;

    public MediaBrowser_FolderLevel_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowser_FolderLevel_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.folderLevel = 0;
        this.ref_MediaBrowser = 0;
        this.ref_MediaBrowser_absolutePosition = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowser_FolderLevel_Status mediaBrowser_FolderLevel_Status = (MediaBrowser_FolderLevel_Status)bAPEntity;
        return this.folderLevel == mediaBrowser_FolderLevel_Status.folderLevel && this.ref_MediaBrowser == mediaBrowser_FolderLevel_Status.ref_MediaBrowser && this.ref_MediaBrowser_absolutePosition == mediaBrowser_FolderLevel_Status.ref_MediaBrowser_absolutePosition;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaBrowser_FolderLevel_Status:");
        stringBuffer.append("\n - FolderLevel - ");
        stringBuffer.append(this.folderLevel);
        stringBuffer.append("\n - Ref_MediaBrowser - ");
        stringBuffer.append(this.ref_MediaBrowser);
        stringBuffer.append("\n - Ref_MediaBrowser_absolutePosition - ");
        stringBuffer.append(this.ref_MediaBrowser_absolutePosition);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 16;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.folderLevel);
        bitStream.pushShort((short)this.ref_MediaBrowser);
        bitStream.pushShort((short)this.ref_MediaBrowser_absolutePosition);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.folderLevel = bitStream.popFrontByte();
        this.ref_MediaBrowser = bitStream.popFrontShort();
        this.ref_MediaBrowser_absolutePosition = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 35;
    }

    @Override
    public int getFunctionId() {
        return MediaBrowser_FolderLevel_Status.functionId();
    }
}

