/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateList_UpdateDomain;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateList_UpdatePrecondition;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_UPDATE_ID_UPDATE_DOMAIN_DESCRIPTION_ONLINE_UPDATE_LANGUAGE_UPDATE_PRECONDITION_DOWNLOAD_SIZE_DOWNLOAD_SIZE_UNIT_ESTIMATED_UPDATE_DURATION = 1;
    public static final int RECORD_ADDRESS_POS = 15;
    public static final int POS_MIN = 0;
    public int pos;
    private static final int MAX_UPDATEID_LENGTH = 21;
    public final BAPString updateId;
    public OnlineUpdateList_UpdateDomain updateDomain;
    private static final int MAX_DESCRIPTIONONLINEUPDATE_LENGTH = 3074;
    public final BAPString descriptionOnlineUpdate;
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
    public OnlineUpdateList_UpdatePrecondition updatePrecondition;
    public static final int DOWNLOAD_SIZE_MIN = 0;
    public int downloadSize;
    public static final int DOWNLOAD_SIZE_UNIT_NO_INFORMATION_DEFAULT_DURING_STARTUP = 0;
    public static final int DOWNLOAD_SIZE_UNIT_BYTE = 1;
    public static final int DOWNLOAD_SIZE_UNIT_KILOBYTE = 2;
    public static final int DOWNLOAD_SIZE_UNIT_MEGABYTE = 3;
    public static final int DOWNLOAD_SIZE_UNIT_GIGABYTE = 4;
    public static final int DOWNLOAD_SIZE_UNIT_TERABYTE = 5;
    public int downloadSizeUnit;
    public static final int ESTIMATED_UPDATE_DURATION_MIN = 1;
    public int estimatedUpdateDuration;

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public OnlineUpdateList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.updateId = new BAPString(21);
        this.updateDomain = new OnlineUpdateList_UpdateDomain();
        this.descriptionOnlineUpdate = new BAPString(3074);
        this.updatePrecondition = new OnlineUpdateList_UpdatePrecondition();
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.language = 0;
        this.downloadSize = 0;
        this.downloadSizeUnit = 0;
        this.estimatedUpdateDuration = 1;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.updateId.reset();
        this.updateDomain.reset();
        this.descriptionOnlineUpdate.reset();
        this.updatePrecondition.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateList_Data onlineUpdateList_Data = (OnlineUpdateList_Data)bAPEntity;
        return this.arrayHeader.equalTo(onlineUpdateList_Data.arrayHeader) && this.pos == onlineUpdateList_Data.pos && this.updateId.equalTo(onlineUpdateList_Data.updateId) && this.updateDomain.equalTo(onlineUpdateList_Data.updateDomain) && this.descriptionOnlineUpdate.equalTo(onlineUpdateList_Data.descriptionOnlineUpdate) && this.language == onlineUpdateList_Data.language && this.updatePrecondition.equalTo(onlineUpdateList_Data.updatePrecondition) && this.downloadSize == onlineUpdateList_Data.downloadSize && this.downloadSizeUnit == onlineUpdateList_Data.downloadSizeUnit && this.estimatedUpdateDuration == onlineUpdateList_Data.estimatedUpdateDuration;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OnlineUpdateList_Data");
        stringBuffer.append("\n - pos:" + this.pos);
        stringBuffer.append("\n - updateId:" + this.updateId.toString());
        stringBuffer.append("\n - updateDomain:" + this.updateDomain.toString());
        stringBuffer.append("\n - descriptionOnlineUpdate:" + this.descriptionOnlineUpdate.toString());
        stringBuffer.append("\n - language:" + this.language);
        stringBuffer.append("\n - updatePrecondition:" + this.updatePrecondition.toString());
        stringBuffer.append("\n - downloadSize:" + this.downloadSize);
        stringBuffer.append("\n - downloadSizeUnit:" + this.downloadSizeUnit);
        stringBuffer.append("\n - estimatedUpdateDuration:" + this.estimatedUpdateDuration);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.updateId.serialize(bitStream);
                this.updateDomain.serialize(bitStream);
                this.descriptionOnlineUpdate.serialize(bitStream);
                bitStream.pushByte((byte)this.language);
                this.updatePrecondition.serialize(bitStream);
                bitStream.pushShort((short)this.downloadSize);
                bitStream.pushByte((byte)this.downloadSizeUnit);
                bitStream.pushByte((byte)this.estimatedUpdateDuration);
                break;
            }
        }
    }

    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.updateId.deserialize(bitStream);
                this.updateDomain.deserialize(bitStream);
                this.descriptionOnlineUpdate.deserialize(bitStream);
                this.language = bitStream.popFrontByte();
                this.updatePrecondition.deserialize(bitStream);
                this.downloadSize = bitStream.popFrontShort();
                this.downloadSizeUnit = bitStream.popFrontByte();
                this.estimatedUpdateDuration = bitStream.popFrontByte();
                break;
            }
        }
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public int getPos() {
        return this.pos;
    }
}

