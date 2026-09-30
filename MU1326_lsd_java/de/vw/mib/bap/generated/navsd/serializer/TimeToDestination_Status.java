/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TimeToDestination_Status
implements StatusProperty {
    public final TimeInfo timeInfo = new TimeInfo();
    public final ValidityInformation validityInformation = new ValidityInformation();

    public TimeToDestination_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TimeToDestination_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.timeInfo.reset();
        this.validityInformation.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        TimeToDestination_Status timeToDestination_Status = (TimeToDestination_Status)bAPEntity;
        return this.timeInfo.equalTo(timeToDestination_Status.timeInfo) && this.validityInformation.equalTo(timeToDestination_Status.validityInformation);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TimeToDestination_Status:");
        stringBuffer.append("\n - TimeInfo - ");
        stringBuffer.append(this.timeInfo.toString());
        stringBuffer.append("\n - ValidityInformation - ");
        stringBuffer.append(this.validityInformation.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.timeInfo.bitSize();
        return n += this.validityInformation.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.timeInfo.serialize(bitStream);
        this.validityInformation.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.timeInfo.deserialize(bitStream);
        this.validityInformation.deserialize(bitStream);
    }

    public static int functionId() {
        return 22;
    }

    public int getFunctionId() {
        return TimeToDestination_Status.functionId();
    }

    public static final class TimeInfo
    implements BAPEntity {
        public int timeInfoType;
        private static final int TIME_INFO_TYPE_BITSIZE = 4;
        public static final int TIME_INFO_TYPE_TIME_TO_DESTINATION = 0;
        public static final int TIME_INFO_TYPE_ARRIVAL_TIME = 1;
        public static final int TIME_INFO_TYPE_ARRIVAL_TIME_IS_LOCAL_TIME_IN_ANOTHER_TIME_ZONE_DF4_1 = 2;
        public static final int TIME_INFO_TYPE_NOT_SUPPORTED_ANY_TIME_INFO_TYPE = 15;
        public int navigationTimeFormat;
        private static final int NAVIGATION_TIME_FORMAT_BITSIZE = 4;
        public static final int NAVIGATION_TIME_FORMAT_24_HOUR_FORMAT = 0;
        public static final int NAVIGATION_TIME_FORMAT_12_HOUR_FORMAT = 1;
        public int minute;
        private static final int MINUTE_BITSIZE = 8;
        public int hour;
        private static final int HOUR_BITSIZE = 8;
        public int day;
        private static final int DAY_BITSIZE = 8;
        public int month;
        private static final int MONTH_BITSIZE = 8;
        public int year;
        private static final int YEAR_BITSIZE = 8;

        public TimeInfo() {
            this.internalReset();
            this.customInitialization();
        }

        public TimeInfo(BitStream bitStream) {
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

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            TimeInfo timeInfo = (TimeInfo)bAPEntity;
            return this.timeInfoType == timeInfo.timeInfoType && this.navigationTimeFormat == timeInfo.navigationTimeFormat && this.minute == timeInfo.minute && this.hour == timeInfo.hour && this.day == timeInfo.day && this.month == timeInfo.month && this.year == timeInfo.year;
        }

        private void customInitialization() {
        }

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

        public void serialize(BitStream bitStream) {
            bitStream.pushBits(4, this.timeInfoType);
            bitStream.pushBits(4, this.navigationTimeFormat);
            bitStream.pushByte((byte)this.minute);
            bitStream.pushByte((byte)this.hour);
            bitStream.pushByte((byte)this.day);
            bitStream.pushByte((byte)this.month);
            bitStream.pushByte((byte)this.year);
        }

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

    public static final class ValidityInformation
    implements BAPEntity {
        private static final int RESERVED_BIT_6__7_BITSIZE = 2;
        public boolean timeInfo_YearIsAvailableToBeDisplayed;
        public boolean timeInfo_MonthIsAvailableToBeDisplayed;
        public boolean timeInfo_DayIsAvailableToBeDisplayed;
        public boolean timeInfo_HourIsValid;
        public boolean timeInfo_MinuteIsValid;
        public boolean reserved_bit_0;
        private static final int VALIDITY_INFORMATION_BITSIZE = 8;

        public ValidityInformation() {
            this.internalReset();
            this.customInitialization();
        }

        public ValidityInformation(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.timeInfo_YearIsAvailableToBeDisplayed = false;
            this.timeInfo_MonthIsAvailableToBeDisplayed = false;
            this.timeInfo_DayIsAvailableToBeDisplayed = false;
            this.timeInfo_HourIsValid = false;
            this.timeInfo_MinuteIsValid = false;
            this.reserved_bit_0 = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            ValidityInformation validityInformation = (ValidityInformation)bAPEntity;
            return this.timeInfo_YearIsAvailableToBeDisplayed == validityInformation.timeInfo_YearIsAvailableToBeDisplayed && this.timeInfo_MonthIsAvailableToBeDisplayed == validityInformation.timeInfo_MonthIsAvailableToBeDisplayed && this.timeInfo_DayIsAvailableToBeDisplayed == validityInformation.timeInfo_DayIsAvailableToBeDisplayed && this.timeInfo_HourIsValid == validityInformation.timeInfo_HourIsValid && this.timeInfo_MinuteIsValid == validityInformation.timeInfo_MinuteIsValid && this.reserved_bit_0 == validityInformation.reserved_bit_0;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ValidityInformation:");
            stringBuffer.append("\n - Bit 5: ");
            if (this.timeInfo_YearIsAvailableToBeDisplayed) {
                stringBuffer.append("true  (TimeInfo.Year is available / to be displayed");
            } else {
                stringBuffer.append("false  (TimeInfo.Year is not available / not to be displayed");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.timeInfo_MonthIsAvailableToBeDisplayed) {
                stringBuffer.append("true  (TimeInfo.Month is available / to be displayed");
            } else {
                stringBuffer.append("false  (TimeInfo.Month is not available / not to be displayed");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.timeInfo_DayIsAvailableToBeDisplayed) {
                stringBuffer.append("true  (TimeInfo.Day is available / to be displayed");
            } else {
                stringBuffer.append("false  (TimeInfo.Day is not available / not to be displayed");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.timeInfo_HourIsValid) {
                stringBuffer.append("true  (TimeInfo.Hour is valid");
            } else {
                stringBuffer.append("false  (TimeInfo.Hour is invalid");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.timeInfo_MinuteIsValid) {
                stringBuffer.append("true  (TimeInfo.Minute is valid");
            } else {
                stringBuffer.append("false  (TimeInfo.Minute is invalid");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.reserved_bit_0) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(2);
            bitStream.pushBoolean(this.timeInfo_YearIsAvailableToBeDisplayed);
            bitStream.pushBoolean(this.timeInfo_MonthIsAvailableToBeDisplayed);
            bitStream.pushBoolean(this.timeInfo_DayIsAvailableToBeDisplayed);
            bitStream.pushBoolean(this.timeInfo_HourIsValid);
            bitStream.pushBoolean(this.timeInfo_MinuteIsValid);
            bitStream.pushBoolean(this.reserved_bit_0);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(2);
            this.timeInfo_YearIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
            this.timeInfo_MonthIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
            this.timeInfo_DayIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
            this.timeInfo_HourIsValid = bitStream.popFrontBoolean();
            this.timeInfo_MinuteIsValid = bitStream.popFrontBoolean();
            this.reserved_bit_0 = bitStream.popFrontBoolean();
        }
    }
}

