/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TimeToDestination_Status$TimeInfo
implements BAPEntity {
    public int timeInfoType;
    private static final int TIME_INFO_TYPE_BITSIZE;
    public static final int TIME_INFO_TYPE_TIME_TO_DESTINATION;
    public static final int TIME_INFO_TYPE_ARRIVAL_TIME;
    public static final int TIME_INFO_TYPE_ARRIVAL_TIME_IS_LOCAL_TIME_IN_ANOTHER_TIME_ZONE_DF4_1;
    public static final int TIME_INFO_TYPE_NOT_SUPPORTED_ANY_TIME_INFO_TYPE;
    public int navigationTimeFormat;
    private static final int NAVIGATION_TIME_FORMAT_BITSIZE;
    public static final int NAVIGATION_TIME_FORMAT_24_HOUR_FORMAT;
    public static final int NAVIGATION_TIME_FORMAT_12_HOUR_FORMAT;
    public int minute;
    private static final int MINUTE_BITSIZE;
    public int hour;
    private static final int HOUR_BITSIZE;
    public int day;
    private static final int DAY_BITSIZE;
    public int month;
    private static final int MONTH_BITSIZE;
    public int year;
    private static final int YEAR_BITSIZE;

    public TimeToDestination_Status$TimeInfo() {
        this.internalReset();
        this.customInitialization();
    }

    public TimeToDestination_Status$TimeInfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timeInfoType = 0;
        this.navigationTimeFormat = 0;
        this.minute = 0;
        this.hour = 0;
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TimeToDestination_Status$TimeInfo timeToDestination_Status$TimeInfo = (TimeToDestination_Status$TimeInfo)bAPEntity;
        return this.timeInfoType == timeToDestination_Status$TimeInfo.timeInfoType && this.navigationTimeFormat == timeToDestination_Status$TimeInfo.navigationTimeFormat && this.minute == timeToDestination_Status$TimeInfo.minute && this.hour == timeToDestination_Status$TimeInfo.hour && this.day == timeToDestination_Status$TimeInfo.day && this.month == timeToDestination_Status$TimeInfo.month && this.year == timeToDestination_Status$TimeInfo.year;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TimeInfo:");
        stringBuffer.append("\n - TimeInfoType: ");
        switch (this.timeInfoType) {
            case 0: {
                stringBuffer.append("0x0 (TimeToDestination)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (ArrivalTime)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (ArrivalTime is local time in another time zone (DF4.1))");
                break;
            }
            case 15: {
                stringBuffer.append("0xF (not supported (= any time info type))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - NavigationTimeFormat: ");
        switch (this.navigationTimeFormat) {
            case 0: {
                stringBuffer.append("0x0 (24 hour format)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (12 hour format)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Minute - ");
        stringBuffer.append(this.minute);
        stringBuffer.append("\n - Hour - ");
        stringBuffer.append(this.hour);
        stringBuffer.append("\n - Day - ");
        stringBuffer.append(this.day);
        stringBuffer.append("\n - Month - ");
        stringBuffer.append(this.month);
        stringBuffer.append("\n - Year - ");
        stringBuffer.append(this.year);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.timeInfoType);
        bitStream.pushBits(4, this.navigationTimeFormat);
        bitStream.pushByte((byte)this.minute);
        bitStream.pushByte((byte)this.hour);
        bitStream.pushByte((byte)this.day);
        bitStream.pushByte((byte)this.month);
        bitStream.pushByte((byte)this.year);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.timeInfoType = bitStream.popFrontBits(4);
        this.navigationTimeFormat = bitStream.popFrontBits(4);
        this.minute = bitStream.popFrontByte();
        this.hour = bitStream.popFrontByte();
        this.day = bitStream.popFrontByte();
        this.month = bitStream.popFrontByte();
        this.year = bitStream.popFrontByte();
    }
}

