/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_UpdateInfo
implements BAPEntity {
    private static final int MAX_TEXT_LENGTH = 3074;
    public final BAPString text = new BAPString(3074);
    public static final int LANGUAGE_DEUTSCH_GERMAN = 0;
    public static final int LANGUAGE_UK_ENGLISCH_UK_ENGLISH = 1;
    public static final int LANGUAGE_US_ENGLISCH_US_ENGLISH = 2;
    public static final int LANGUAGE_FRANZSISCH_FRENCH = 3;
    public static final int LANGUAGE_ITALIENISCH_ITALIAN = 4;
    public static final int LANGUAGE_SPANISCH_SPANISH = 5;
    public static final int LANGUAGE_PORTUGIESISCH_PORTUGUESE = 6;
    public static final int LANGUAGE_POLNISCH_POLISH = 7;
    public static final int LANGUAGE_TSCHECHISCH_CZECH = 8;
    public static final int LANGUAGE_UNGARISCH_HUNGARIAN = 9;
    public static final int LANGUAGE_DNISCH_DANISH = 10;
    public static final int LANGUAGE_SCHWEDISCH_SWEDISH = 11;
    public static final int LANGUAGE_FINNISCH_FINNISH = 12;
    public static final int LANGUAGE_NIEDERLNDISCH_DUTCH = 13;
    public static final int LANGUAGE_CHINESISCH_TRADITIONELL_CHINESE_TRADITONAL = 14;
    public static final int LANGUAGE_JAPANISCH_JAPANESE = 15;
    public static final int LANGUAGE_RUSSISCH_RUSSIAN = 16;
    public static final int LANGUAGE_GRIECHISCH_GREEK = 17;
    public static final int LANGUAGE_KOREANISCH_KOREAN = 18;
    public static final int LANGUAGE_FRANZSISCH_KANADISCH_FRENCH_CANADIAN = 19;
    public static final int LANGUAGE_SPANISCH_US_SPANISH_US = 20;
    public static final int LANGUAGE_PORTUGISISCH_US_PORTUGUESE_US = 21;
    public static final int LANGUAGE_TRKISCH_TURKISH = 22;
    public static final int LANGUAGE_CHINESISCH_MANDARIN_CHINESE_MANDARIN = 23;
    public static final int LANGUAGE_CHINESICH_KANTONESISCH_CHINESE_CANTONESE = 24;
    public static final int LANGUAGE_ARABISCH_ARABIC = 25;
    public static final int LANGUAGE_PORTUGIESISCH_BRASILIEN_PORTUGUESE_BRAZIL = 26;
    public static final int LANGUAGE_MALAYSISCH_MALAYSIAN = 27;
    public static final int LANGUAGE_THAILNDISCH_THAI = 28;
    public static final int LANGUAGE_NORWEGISCH_NORWEGIAN = 29;
    public static final int LANGUAGE_KROATISCH_CROATIAN = 30;
    public static final int LANGUAGE_SERBISCH_SERBIAN = 31;
    public static final int LANGUAGE_SLOWAKISCH_SLOVAK = 32;
    public static final int LANGUAGE_RUMNISCH_ROMANIAN = 33;
    public static final int LANGUAGE_HINDI_HINDI = 34;
    public static final int LANGUAGE_INDONESISCH_INDONESIAN = 35;
    public static final int LANGUAGE_ASERBAIDSCHANISCH_AZERBAIJANIAN = 36;
    public static final int LANGUAGE_BOSNISCH_BOSNIAN = 37;
    public static final int LANGUAGE_SLOWENISCH_SLOVENIAN = 38;
    public static final int LANGUAGE_BULGARISCH_BULGARIAN = 39;
    public static final int LANGUAGE_LETTISCH_LATVIAN = 40;
    public static final int LANGUAGE_ESTNISCH_ESTONIAN = 41;
    public static final int LANGUAGE_LITAUISCH_LITHUANIAN = 42;
    public static final int LANGUAGE_UKRAINISCH_UKRAINIAN = 43;
    public static final int LANGUAGE_HEBRISCH_HEBREW = 44;
    public static final int LANGUAGE_KATALANISCH_CATALAN = 45;
    public static final int LANGUAGE_GALICISCH_GALICIAN = 46;
    public static final int LANGUAGE_BASKISCH_BASQUE = 47;
    public static final int LANGUAGE_ENGLISCH_CHINA_ENGLISH_CHINA = 48;
    public static final int LANGUAGE_ENGLISCH_JAPAN_ENGLISH_JAPAN = 49;
    public static final int LANGUAGE_ENGLISCH_KOREA_ENGLISH_KOREA = 50;
    public static final int LANGUAGE_ENGLISCH_TAIWAN_ENGLISH_TAIWAN = 51;
    public int language;

    public OnlineUpdateState_Deprecated_UpdateInfo() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_UpdateInfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.language = 0;
    }

    public void reset() {
        this.internalReset();
        this.text.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_UpdateInfo onlineUpdateState_Deprecated_UpdateInfo = (OnlineUpdateState_Deprecated_UpdateInfo)bAPEntity;
        return this.text.equalTo(onlineUpdateState_Deprecated_UpdateInfo.text) && this.language == onlineUpdateState_Deprecated_UpdateInfo.language;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OnlineUpdateState_Deprecated_UpdateInfo");
        stringBuffer.append("\n - text:" + this.text.toString());
        stringBuffer.append("\n - language:" + this.language);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.text.serialize(bitStream);
        bitStream.pushByte((byte)this.language);
    }

    public void deserialize(BitStream bitStream) {
        this.text.deserialize(bitStream);
        this.language = bitStream.popFrontByte();
    }
}

