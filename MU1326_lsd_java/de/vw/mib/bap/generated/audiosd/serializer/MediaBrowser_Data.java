/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowser_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_FILE_TYPE_FILE_STATE_FILE_NAME = 0;
    public static final int RECORD_ADDRESS_FILE_TYPE_FILE_STATE = 1;
    public static final int RECORD_ADDRESS_FILE_NAME = 2;
    public static final int RECORD_ADDRESS_POS = 15;
    private int pos;
    public int fileType;
    private static final int FILE_TYPE_BITSIZE = 8;
    public static final int FILE_TYPE_ANY_TYPE_UNKNOWN = 0;
    public static final int FILE_TYPE_DIRECTORY_FOLDER = 1;
    public static final int FILE_TYPE_ITEM_TRACK = 2;
    public static final int FILE_TYPE_PLAYLIST = 3;
    public static final int FILE_TYPE_PLAYLIST_FOLDER = 4;
    public static final int FILE_TYPE_UNKNOWN_CATEGORY = 5;
    public static final int FILE_TYPE_AUDIO_FILE = 6;
    public static final int FILE_TYPE_VIDEO_FILE = 7;
    public static final int FILE_TYPE_CD_AUDIO_TRACK = 8;
    public static final int FILE_TYPE_CD_AUDIO_TRACK_CD_TEXT = 9;
    public static final int FILE_TYPE_VOICEMEMO_FILE = 10;
    public static final int FILE_TYPE_IMAGE_FILE = 11;
    public static final int FILE_TYPE_AUDIO_FOLDER = 12;
    public static final int FILE_TYPE_VIDEO_FOLDER = 13;
    public static final int FILE_TYPE_IMAGE_FOLDER = 14;
    public static final int FILE_TYPE_VOICEMEMO_FOLDER = 15;
    public static final int FILE_TYPE_CATEGORY_GENRE = 16;
    public static final int FILE_TYPE_CATEGORY_GENRES = 17;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_GENRE = 18;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_GENRES = 19;
    public static final int FILE_TYPE_CATEGORY_ARTIST = 20;
    public static final int FILE_TYPE_CATEGORY_ARTISTS = 21;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_ARTIST = 22;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_ARTISTS = 23;
    public static final int FILE_TYPE_CATEGORY_COMPOSER = 24;
    public static final int FILE_TYPE_CATEGORY_COMPOSERS = 25;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_COMPOSER = 26;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_COMPOSERS = 27;
    public static final int FILE_TYPE_CATEGORY_YEAR = 28;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_YEAR = 29;
    public static final int FILE_TYPE_CATEGORY_COMMENT = 30;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_COMMENT = 31;
    public static final int FILE_TYPE_CATEGORY_ALBUM = 32;
    public static final int FILE_TYPE_CATEGORY_ALBUMS = 33;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_ALBUM = 34;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_ALBUMS = 35;
    public static final int FILE_TYPE_CATEGORY_SONG = 36;
    public static final int FILE_TYPE_CATEGORY_SONGS = 37;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_SONG = 38;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_SONGS = 39;
    public static final int FILE_TYPE_CATEGORY_AUDIOBOOK = 40;
    public static final int FILE_TYPE_CATEGORY_AUDIOBOOKS = 41;
    public static final int FILE_TYPE_CATEGORY_ALL = 42;
    public static final int FILE_TYPE_CATEGORY_PODCAST = 43;
    public static final int FILE_TYPE_CATEGORY_PODCASTS = 44;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED = 45;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR = 46;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS = 47;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS = 48;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS = 49;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS = 50;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED = 51;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED = 52;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO = 53;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLISTS = 54;
    public static final int FILE_TYPE_CATEGORY_MOVIES_DF4_1 = 55;
    public static final int FILE_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1 = 56;
    public static final int FILE_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1 = 57;
    public static final int FILE_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1 = 58;
    public static final int FILE_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1 = 59;
    public static final int FILE_TYPE_CATEGORY_FAVORITES_DF4_1 = 60;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1 = 61;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1 = 62;
    public static final int FILE_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1 = 63;
    public static final int FILE_TYPE_DVD_MAIN_MENUE = 64;
    public static final int FILE_TYPE_DVD_CHAPTER = 65;
    public static final int FILE_TYPE_DVD_TITLE = 66;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1 = 81;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1 = 82;
    public static final int FILE_TYPE_CATEGORY_MOOD_DF4_1 = 83;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1 = 84;
    public static final int FILE_TYPE_NOT_SUPPORTED = 255;
    public final FileState fileState;
    public final BAPString fileName;
    private static final int MAX_FILE_NAME_LENGTH = 97;

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public int getPos() {
        return this.pos;
    }

    public MediaBrowser_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.fileState = new FileState();
        this.fileName = new BAPString(97);
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowser_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.fileType = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.fileState.reset();
        this.fileName.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowser_Data mediaBrowser_Data = (MediaBrowser_Data)bAPEntity;
        return this.arrayHeader.equalTo(mediaBrowser_Data.arrayHeader) && this.pos == mediaBrowser_Data.pos && this.fileType == mediaBrowser_Data.fileType && this.fileState.equalTo(mediaBrowser_Data.fileState) && this.fileName.equalTo(mediaBrowser_Data.fileName);
    }

    private void customInitialization() {
        this.fileName.setLimitingLengthByCharacters();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaBrowser_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - FileType: ");
        switch (this.fileType) {
            case 0: {
                stringBuffer.append("0x00 (any type / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (directory / folder)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (item/track)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (playlist)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (playlist folder)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (unknown category)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (audio file)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (video file)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (CD audio track)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (CD audio track - CD text)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (voicememo file)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (image file)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (audio folder)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (video folder)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (image folder)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (voicememo folder)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (category - genre)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (category - genres)");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (category - unknown genre)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (category - unknown genres)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (category - artist)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (category - artists)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (category - unknown artist)");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (category - unknown artists)");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (category - composer)");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (category - composers)");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (category - unknown composer)");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (category - unknown composers)");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (category - year)");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (category - unknown year)");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (category - comment)");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (category - unknown comment)");
                break;
            }
            case 32: {
                stringBuffer.append("0x20 (category - album)");
                break;
            }
            case 33: {
                stringBuffer.append("0x21 (category - albums)");
                break;
            }
            case 34: {
                stringBuffer.append("0x22 (category - unknown album)");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (category - unknown albums)");
                break;
            }
            case 36: {
                stringBuffer.append("0x24 (category - song)");
                break;
            }
            case 37: {
                stringBuffer.append("0x25 (category - songs)");
                break;
            }
            case 38: {
                stringBuffer.append("0x26 (category - unknown song)");
                break;
            }
            case 39: {
                stringBuffer.append("0x27 (category - unknown songs)");
                break;
            }
            case 40: {
                stringBuffer.append("0x28 (category - audiobook)");
                break;
            }
            case 41: {
                stringBuffer.append("0x29 (category - audiobooks)");
                break;
            }
            case 42: {
                stringBuffer.append("0x2A (category - all)");
                break;
            }
            case 43: {
                stringBuffer.append("0x2B (category - podcast)");
                break;
            }
            case 44: {
                stringBuffer.append("0x2C (category - podcasts)");
                break;
            }
            case 45: {
                stringBuffer.append("0x2D (category - dynamic playlist not rated)");
                break;
            }
            case 46: {
                stringBuffer.append("0x2E (category - dynamic playlist 1 star)");
                break;
            }
            case 47: {
                stringBuffer.append("0x2F (category - dynamic playlist 2 stars)");
                break;
            }
            case 48: {
                stringBuffer.append("0x30 (category - dynamic playlist 3 stars)");
                break;
            }
            case 49: {
                stringBuffer.append("0x31 (category - dynamic playlist 4 stars)");
                break;
            }
            case 50: {
                stringBuffer.append("0x32 (category - dynamic playlist 5 stars)");
                break;
            }
            case 51: {
                stringBuffer.append("0x33 (category - dynamic playlist most played)");
                break;
            }
            case 52: {
                stringBuffer.append("0x34 (category - dynamic playlist last played)");
                break;
            }
            case 53: {
                stringBuffer.append("0x35 (category - dynamic playlist on-the-go)");
                break;
            }
            case 54: {
                stringBuffer.append("0x36 (category - dynamic playlists)");
                break;
            }
            case 55: {
                stringBuffer.append("0x37 (category - movies (DF4.1))");
                break;
            }
            case 56: {
                stringBuffer.append("0x38 (category - music videos (DF4.1))");
                break;
            }
            case 57: {
                stringBuffer.append("0x39 (category - video podcasts (german: Sendungen) (DF4.1))");
                break;
            }
            case 58: {
                stringBuffer.append("0x3A (category - borrowed videos (DF4.1))");
                break;
            }
            case 59: {
                stringBuffer.append("0x3B (category - last copied files (DF4.1))");
                break;
            }
            case 60: {
                stringBuffer.append("0x3C (category - favorites (DF4.1))");
                break;
            }
            case 61: {
                stringBuffer.append("0x3D (category - unknown podcast (DF4.1))");
                break;
            }
            case 62: {
                stringBuffer.append("0x3E (category - unknown podcasts (DF4.1))");
                break;
            }
            case 63: {
                stringBuffer.append("0x3F (category - various artists (DF4.1))");
                break;
            }
            case 64: {
                stringBuffer.append("0x40 (DVD main menue)");
                break;
            }
            case 65: {
                stringBuffer.append("0x41 (DVD chapter)");
                break;
            }
            case 66: {
                stringBuffer.append("0x42 (DVD title)");
                break;
            }
            case 81: {
                stringBuffer.append("0x51 (category - unknown audiobook (DF4.1))");
                break;
            }
            case 82: {
                stringBuffer.append("0x52 (category - unknown audiobooks (DF4.1))");
                break;
            }
            case 83: {
                stringBuffer.append("0x53 (category - mood (DF4.1))");
                break;
            }
            case 84: {
                stringBuffer.append("0x54 (category - unknown mood (DF4.1))");
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
        stringBuffer.append("\n - FileState - ");
        stringBuffer.append(this.fileState.toString());
        stringBuffer.append("\n - FileName - ");
        stringBuffer.append(this.fileName.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.fileState.bitSize();
                n += this.fileName.bitSize();
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.fileState.bitSize();
                break;
            }
            case 2: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.fileName.bitSize();
                break;
            }
            case 15: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                break;
            }
        }
        return n;
    }

    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.fileType);
                this.fileState.serialize(bitStream);
                this.fileName.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.fileType);
                this.fileState.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.fileName.serialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fileType = bitStream.popFrontByte();
                this.fileState.deserialize(bitStream);
                this.fileName.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fileType = bitStream.popFrontByte();
                this.fileState.deserialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fileName.deserialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    public static final class FileState
    implements BAPEntity {
        public boolean reserved_bit_7;
        public boolean importNotPlayable;
        public boolean importPending;
        public boolean importRunning;
        public boolean deadLink;
        public boolean corruptedFileFolder;
        public boolean drmProteced;
        public boolean emptyFolder;
        private static final int RESERVED_BIT_8__15_BITSIZE = 8;
        private static final int FILE_STATE_BITSIZE = 16;

        public FileState() {
            this.internalReset();
            this.customInitialization();
        }

        public FileState(BitStream bitStream) {
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

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            FileState fileState = (FileState)bAPEntity;
            return this.reserved_bit_7 == fileState.reserved_bit_7 && this.importNotPlayable == fileState.importNotPlayable && this.importPending == fileState.importPending && this.importRunning == fileState.importRunning && this.deadLink == fileState.deadLink && this.corruptedFileFolder == fileState.corruptedFileFolder && this.drmProteced == fileState.drmProteced && this.emptyFolder == fileState.emptyFolder;
        }

        private void customInitialization() {
        }

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

        public int bitSize() {
            int n = 0;
            return n += 16;
        }

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
}

