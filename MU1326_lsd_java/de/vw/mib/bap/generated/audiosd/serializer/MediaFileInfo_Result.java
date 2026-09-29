/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MediaFileInfo_Result
implements ResultMethod {
    public int mediaFileInfoResult;
    private static final int MEDIA_FILE_INFO_RESULT_BITSIZE;
    public static final int MEDIA_FILE_INFO_RESULT_SUCCESSFUL;
    public static final int MEDIA_FILE_INFO_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED;
    public static final int MEDIA_FILE_INFO_RESULT_ABORT_SUCCESSFUL;
    public static final int MEDIA_FILE_INFO_RESULT_ABORT_NOT_SUCCESSFUL;
    public final BAPString artist = new BAPString(76);
    private static final int MAX_ARTIST_LENGTH;
    public final BAPString title = new BAPString(76);
    private static final int MAX_TITLE_LENGTH;
    public final BAPString album = new BAPString(76);
    private static final int MAX_ALBUM_LENGTH;

    @Override
    public int getResultCode() {
        return this.mediaFileInfoResult;
    }

    public MediaFileInfo_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaFileInfo_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mediaFileInfoResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.artist.reset();
        this.title.reset();
        this.album.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaFileInfo_Result mediaFileInfo_Result = (MediaFileInfo_Result)bAPEntity;
        return this.mediaFileInfoResult == mediaFileInfo_Result.mediaFileInfoResult && this.artist.equalTo(mediaFileInfo_Result.artist) && this.title.equalTo(mediaFileInfo_Result.title) && this.album.equalTo(mediaFileInfo_Result.album);
    }

    private void customInitialization() {
        this.artist.setLimitingLengthByCharacters();
        this.title.setLimitingLengthByCharacters();
        this.album.setLimitingLengthByCharacters();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaFileInfo_Result:");
        stringBuffer.append("\n - MediaFileInfoResult: ");
        switch (this.mediaFileInfoResult) {
            case 0: {
                stringBuffer.append("0x00 (successful)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (not successful / not supported)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (abort successful)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (abort not successful)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Artist - ");
        stringBuffer.append(this.artist.toString());
        stringBuffer.append("\n - Title - ");
        stringBuffer.append(this.title.toString());
        stringBuffer.append("\n - Album - ");
        stringBuffer.append(this.album.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += this.artist.bitSize();
        n += this.title.bitSize();
        return n += this.album.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mediaFileInfoResult);
        this.artist.serialize(bitStream);
        this.title.serialize(bitStream);
        this.album.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mediaFileInfoResult = bitStream.popFrontByte();
        this.artist.deserialize(bitStream);
        this.title.deserialize(bitStream);
        this.album.deserialize(bitStream);
    }

    public static int functionId() {
        return 39;
    }

    @Override
    public int getFunctionId() {
        return MediaFileInfo_Result.functionId();
    }
}

