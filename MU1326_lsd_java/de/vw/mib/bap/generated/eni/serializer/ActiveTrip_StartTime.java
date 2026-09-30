/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveTrip_StartTime
implements BAPEntity {
    public static final int YEAR_MIN = 2000;
    public int year;
    public static final int MONTH_MIN = 0;
    public int month;
    public static final int DAY_MIN = 0;
    public int day;
    public static final int HOUR_MIN = 0;
    public int hour;
    public static final int MINUTE_MIN = 0;
    public int minute;
    public static final int SECOND_MIN = 0;
    public int second;

    public ActiveTrip_StartTime() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveTrip_StartTime(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.year = 2000;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveTrip_StartTime activeTrip_StartTime = (ActiveTrip_StartTime)bAPEntity;
        return this.year == activeTrip_StartTime.year && this.month == activeTrip_StartTime.month && this.day == activeTrip_StartTime.day && this.hour == activeTrip_StartTime.hour && this.minute == activeTrip_StartTime.minute && this.second == activeTrip_StartTime.second;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActiveTrip_StartTime");
        stringBuffer.append("\n - year:" + this.year);
        stringBuffer.append("\n - month:" + this.month);
        stringBuffer.append("\n - day:" + this.day);
        stringBuffer.append("\n - hour:" + this.hour);
        stringBuffer.append("\n - minute:" + this.minute);
        stringBuffer.append("\n - second:" + this.second);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.year);
        bitStream.pushByte((byte)this.month);
        bitStream.pushByte((byte)this.day);
        bitStream.pushByte((byte)this.hour);
        bitStream.pushByte((byte)this.minute);
        bitStream.pushByte((byte)this.second);
    }

    public void deserialize(BitStream bitStream) {
        this.year = bitStream.popFrontByte();
        this.month = bitStream.popFrontByte();
        this.day = bitStream.popFrontByte();
        this.hour = bitStream.popFrontByte();
        this.minute = bitStream.popFrontByte();
        this.second = bitStream.popFrontByte();
    }
}

