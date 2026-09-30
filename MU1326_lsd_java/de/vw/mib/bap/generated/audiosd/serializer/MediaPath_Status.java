/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MediaPath_Status
implements StatusProperty {
    public int folder_Type;
    private static final int FOLDER_TYPE_BITSIZE = 8;
    public static final int FOLDER_TYPE_ANY_TYPE_UNKNOWN = 0;
    public static final int FOLDER_TYPE_FOLDER = 1;
    public static final int FOLDER_TYPE_PLAYLIST_FOLDER = 4;
    public static final int FOLDER_TYPE_AUDIO_FOLDER = 12;
    public static final int FOLDER_TYPE_VIDEO_FOLDER = 13;
    public static final int FOLDER_TYPE_IMAGE_FOLDER = 14;
    public static final int FOLDER_TYPE_VOICEMEMO_FOLDER = 15;
    public static final int FOLDER_TYPE_CATEGORY_GENRE = 16;
    public static final int FOLDER_TYPE_CATEGORY_GENRES = 17;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_GENRE = 18;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_GENRES = 19;
    public static final int FOLDER_TYPE_CATEGORY_ARTIST = 20;
    public static final int FOLDER_TYPE_CATEGORY_ARTISTS = 21;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_ARTIST = 22;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_ARTISTS = 23;
    public static final int FOLDER_TYPE_CATEGORY_COMPOSER = 24;
    public static final int FOLDER_TYPE_CATEGORY_COMPOSERS = 25;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_COMPOSER = 26;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_COMPOSERS = 27;
    public static final int FOLDER_TYPE_CATEGORY_YEAR = 28;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_YEAR = 29;
    public static final int FOLDER_TYPE_CATEGORY_COMMENT = 30;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_COMMENT = 31;
    public static final int FOLDER_TYPE_CATEGORY_ALBUM = 32;
    public static final int FOLDER_TYPE_CATEGORY_ALBUMS = 33;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_ALBUM = 34;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_ALBUMS = 35;
    public static final int FOLDER_TYPE_CATEGORY_SONG = 36;
    public static final int FOLDER_TYPE_CATEGORY_SONGS = 37;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_SONG = 38;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_SONGS = 39;
    public static final int FOLDER_TYPE_CATEGORY_AUDIOBOOK = 40;
    public static final int FOLDER_TYPE_CATEGORY_AUDIOBOOKS = 41;
    public static final int FOLDER_TYPE_CATEGORY_ALL = 42;
    public static final int FOLDER_TYPE_CATEGORY_PODCAST = 43;
    public static final int FOLDER_TYPE_CATEGORY_PODCASTS = 44;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED = 45;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR = 46;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS = 47;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS = 48;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS = 49;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS = 50;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED = 51;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED = 52;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO = 53;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLISTS = 54;
    public static final int FOLDER_TYPE_CATEGORY_MOVIES_DF4_1 = 55;
    public static final int FOLDER_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1 = 56;
    public static final int FOLDER_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1 = 57;
    public static final int FOLDER_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1 = 58;
    public static final int FOLDER_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1 = 59;
    public static final int FOLDER_TYPE_CATEGORY_FAVORITES_DF4_1 = 60;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1 = 61;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1 = 62;
    public static final int FOLDER_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1 = 63;
    public static final int FOLDER_TYPE_DVD_MAIN_MENUE = 64;
    public static final int FOLDER_TYPE_DVD_CHAPTER = 65;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1 = 81;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1 = 82;
    public static final int FOLDER_TYPE_CATEGORY_MOOD_DF4_1 = 83;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1 = 84;
    public static final int FOLDER_TYPE_NOT_SUPPORTED = 255;
    public final BAPString path = new BAPString(152);
    private static final int MAX_PATH_LENGTH = 152;

    public MediaPath_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaPath_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.folder_Type = 0;
    }

    public void reset() {
        this.internalReset();
        this.path.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MediaPath_Status mediaPath_Status = (MediaPath_Status)bAPEntity;
        return this.folder_Type == mediaPath_Status.folder_Type && this.path.equalTo(mediaPath_Status.path);
    }

    private void customInitialization() {
        this.path.setLimitingLengthByCharacters();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaPath_Status:");
        stringBuffer.append("\n - Folder_Type: ");
        switch (this.folder_Type) {
            case 0: {
                stringBuffer.append("0x00 (any type / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (folder)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (playlist folder)");
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
        stringBuffer.append("\n - Path - ");
        stringBuffer.append(this.path.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        return n += this.path.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.folder_Type);
        this.path.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.folder_Type = bitStream.popFrontByte();
        this.path.deserialize(bitStream);
    }

    public static int functionId() {
        return 37;
    }

    public int getFunctionId() {
        return MediaPath_Status.functionId();
    }
}

