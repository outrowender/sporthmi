/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AnnouncementInfo_Status
implements StatusProperty {
    public int announcementType;
    private static final int ANNOUNCEMENT_TYPE_BITSIZE = 8;
    public static final int ANNOUNCEMENT_TYPE_NO_MESSAGE_ANNOUNCEMENT_ACTIVE = 0;
    public static final int ANNOUNCEMENT_TYPE_RDS_PTY31_ANNOUNCEMENT_KATASTROPHENMELDUNG = 1;
    public static final int ANNOUNCEMENT_TYPE_TRAFFIC_ANNOUNCEMENT = 2;
    public static final int ANNOUNCEMENT_TYPE_TRANSPORT_FLASH = 3;
    public static final int ANNOUNCEMENT_TYPE_NEWS = 4;
    public static final int ANNOUNCEMENT_TYPE_AREA_WEATHER = 5;
    public static final int ANNOUNCEMENT_TYPE_EVENT_ANNOUNCEMENT = 6;
    public static final int ANNOUNCEMENT_TYPE_SPECIAL_EVENT = 7;
    public static final int ANNOUNCEMENT_TYPE_PROGRAMME_INFORMATION_RADIO_INFO = 8;
    public static final int ANNOUNCEMENT_TYPE_SPORT_REPORT = 9;
    public static final int ANNOUNCEMENT_TYPE_FINANCIAL_REPORT = 10;
    public static final int ANNOUNCEMENT_TYPE_EMERGENCY_INFORMATION_EMERGENCY_ANNOUNCEMENT = 11;
    public static final int ANNOUNCEMENT_TYPE_TMC_TTS_TMC_READING = 12;
    public static final int ANNOUNCEMENT_TYPE_WARNING_SERVICE = 13;
    public final BAPString stationName = new BAPString(49);
    private static final int MAX_STATION_NAME_LENGTH = 49;

    public AnnouncementInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public AnnouncementInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.announcementType = 0;
    }

    public void reset() {
        this.internalReset();
        this.stationName.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        AnnouncementInfo_Status announcementInfo_Status = (AnnouncementInfo_Status)bAPEntity;
        return this.announcementType == announcementInfo_Status.announcementType && this.stationName.equalTo(announcementInfo_Status.stationName);
    }

    private void customInitialization() {
        this.stationName.setLimitingLengthByCharacters();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AnnouncementInfo_Status:");
        stringBuffer.append("\n - AnnouncementType: ");
        switch (this.announcementType) {
            case 0: {
                stringBuffer.append("0x00 (no message/announcement active)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (RDS PTY31 announcement (\\\"Katastrophenmeldung\\\"))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (traffic announcement (road traffic flash; i.e. information about problems on the road))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (transport flash (e.g. schedules of buses, ferries, planes or trains))");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (news)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (area weather)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (event announcement)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (special event (information on unscheduled or previously unforeseen events))");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (programme information (radio info))");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (sport report)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (financial report)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (emergency information (emergency announcement))");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (TMC TTS (TMC reading))");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (warning / service)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - StationName - ");
        stringBuffer.append(this.stationName.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        return n += this.stationName.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.announcementType);
        this.stationName.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.announcementType = bitStream.popFrontByte();
        this.stationName.deserialize(bitStream);
    }

    public static int functionId() {
        return 28;
    }

    public int getFunctionId() {
        return AnnouncementInfo_Status.functionId();
    }
}

