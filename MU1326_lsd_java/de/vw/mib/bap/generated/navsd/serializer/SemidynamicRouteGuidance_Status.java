/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status
implements StatusProperty {
    public final TrafficImpact trafficImpact = new TrafficImpact();
    public final Delay delay = new Delay();
    public final NewDistanceToDestination newDistanceToDestination = new NewDistanceToDestination();
    public final NewTimeToDestination newTimeToDestination = new NewTimeToDestination();
    public final ValidityInformation validityInformation = new ValidityInformation();

    public SemidynamicRouteGuidance_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.trafficImpact.reset();
        this.delay.reset();
        this.newDistanceToDestination.reset();
        this.newTimeToDestination.reset();
        this.validityInformation.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status semidynamicRouteGuidance_Status = (SemidynamicRouteGuidance_Status)bAPEntity;
        return this.trafficImpact.equalTo(semidynamicRouteGuidance_Status.trafficImpact) && this.delay.equalTo(semidynamicRouteGuidance_Status.delay) && this.newDistanceToDestination.equalTo(semidynamicRouteGuidance_Status.newDistanceToDestination) && this.newTimeToDestination.equalTo(semidynamicRouteGuidance_Status.newTimeToDestination) && this.validityInformation.equalTo(semidynamicRouteGuidance_Status.validityInformation);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SemidynamicRouteGuidance_Status:");
        stringBuffer.append("\n - TrafficImpact - ");
        stringBuffer.append(this.trafficImpact.toString());
        stringBuffer.append("\n - Delay - ");
        stringBuffer.append(this.delay.toString());
        stringBuffer.append("\n - NewDistanceToDestination - ");
        stringBuffer.append(this.newDistanceToDestination.toString());
        stringBuffer.append("\n - NewTimeToDestination - ");
        stringBuffer.append(this.newTimeToDestination.toString());
        stringBuffer.append("\n - ValidityInformation - ");
        stringBuffer.append(this.validityInformation.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.trafficImpact.bitSize();
        n += this.delay.bitSize();
        n += this.newDistanceToDestination.bitSize();
        n += this.newTimeToDestination.bitSize();
        return n += this.validityInformation.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.trafficImpact.serialize(bitStream);
        this.delay.serialize(bitStream);
        this.newDistanceToDestination.serialize(bitStream);
        this.newTimeToDestination.serialize(bitStream);
        this.validityInformation.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.trafficImpact.deserialize(bitStream);
        this.delay.deserialize(bitStream);
        this.newDistanceToDestination.deserialize(bitStream);
        this.newTimeToDestination.deserialize(bitStream);
        this.validityInformation.deserialize(bitStream);
    }

    public static int functionId() {
        return 50;
    }

    public int getFunctionId() {
        return SemidynamicRouteGuidance_Status.functionId();
    }

    public static final class Delay
    implements BAPEntity {
        public int minute;
        private static final int MINUTE_BITSIZE = 8;
        public int hour;
        private static final int HOUR_BITSIZE = 8;

        public Delay() {
            this.internalReset();
            this.customInitialization();
        }

        public Delay(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.minute = 0;
            this.hour = 0;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Delay delay = (Delay)bAPEntity;
            return this.minute == delay.minute && this.hour == delay.hour;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Delay:");
            stringBuffer.append("\n - Minute - ");
            stringBuffer.append(this.minute);
            stringBuffer.append("\n - Hour - ");
            stringBuffer.append(this.hour);
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.minute);
            bitStream.pushByte((byte)this.hour);
        }

        public void deserialize(BitStream bitStream) {
            this.minute = bitStream.popFrontByte();
            this.hour = bitStream.popFrontByte();
        }
    }

    public static final class TrafficImpact
    implements BAPEntity {
        private static final int RESERVED_BIT_2__7_BITSIZE = 6;
        public boolean alternativeRouteAvailable;
        public boolean trafficImpactOnCurrentRoute;
        private static final int TRAFFIC_IMPACT_BITSIZE = 8;

        public TrafficImpact() {
            this.internalReset();
            this.customInitialization();
        }

        public TrafficImpact(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.alternativeRouteAvailable = false;
            this.trafficImpactOnCurrentRoute = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            TrafficImpact trafficImpact = (TrafficImpact)bAPEntity;
            return this.alternativeRouteAvailable == trafficImpact.alternativeRouteAvailable && this.trafficImpactOnCurrentRoute == trafficImpact.trafficImpactOnCurrentRoute;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("TrafficImpact:");
            stringBuffer.append("\n - Bit 1: ");
            if (this.alternativeRouteAvailable) {
                stringBuffer.append("true  (alternative route available");
            } else {
                stringBuffer.append("false  (no alternative route available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.trafficImpactOnCurrentRoute) {
                stringBuffer.append("true  (traffic impact on current route");
            } else {
                stringBuffer.append("false  (no traffic impact on current route or unknown");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(6);
            bitStream.pushBoolean(this.alternativeRouteAvailable);
            bitStream.pushBoolean(this.trafficImpactOnCurrentRoute);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(6);
            this.alternativeRouteAvailable = bitStream.popFrontBoolean();
            this.trafficImpactOnCurrentRoute = bitStream.popFrontBoolean();
        }
    }

    public static final class ValidityInformation
    implements BAPEntity {
        private static final int RESERVED_BIT_6__7_BITSIZE = 2;
        public boolean newTimeToDestination_YearIsAvailableToBeDisplayed;
        public boolean newTimeToDestination_MonthIsAvailableToBeDisplayed;
        public boolean newTimeToDestination_DayIsAvailableToBeDisplayed;
        public boolean newTimeToDestination_HourIsValid;
        public boolean newTimeToDestination_MinuteIsValid;
        public boolean newDistanceToDestinationIsValid;
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
            this.newTimeToDestination_YearIsAvailableToBeDisplayed = false;
            this.newTimeToDestination_MonthIsAvailableToBeDisplayed = false;
            this.newTimeToDestination_DayIsAvailableToBeDisplayed = false;
            this.newTimeToDestination_HourIsValid = false;
            this.newTimeToDestination_MinuteIsValid = false;
            this.newDistanceToDestinationIsValid = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            ValidityInformation validityInformation = (ValidityInformation)bAPEntity;
            return this.newTimeToDestination_YearIsAvailableToBeDisplayed == validityInformation.newTimeToDestination_YearIsAvailableToBeDisplayed && this.newTimeToDestination_MonthIsAvailableToBeDisplayed == validityInformation.newTimeToDestination_MonthIsAvailableToBeDisplayed && this.newTimeToDestination_DayIsAvailableToBeDisplayed == validityInformation.newTimeToDestination_DayIsAvailableToBeDisplayed && this.newTimeToDestination_HourIsValid == validityInformation.newTimeToDestination_HourIsValid && this.newTimeToDestination_MinuteIsValid == validityInformation.newTimeToDestination_MinuteIsValid && this.newDistanceToDestinationIsValid == validityInformation.newDistanceToDestinationIsValid;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ValidityInformation:");
            stringBuffer.append("\n - Bit 5: ");
            if (this.newTimeToDestination_YearIsAvailableToBeDisplayed) {
                stringBuffer.append("true  (NewTimeToDestination.Year is available / to be displayed");
            } else {
                stringBuffer.append("false  (NewTimeToDestination.Year is not available / not to be displayed");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.newTimeToDestination_MonthIsAvailableToBeDisplayed) {
                stringBuffer.append("true  (NewTimeToDestination.Month is available / to be displayed");
            } else {
                stringBuffer.append("false  (NewTimeToDestination.Month is not available / not to be displayed");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.newTimeToDestination_DayIsAvailableToBeDisplayed) {
                stringBuffer.append("true  (NewTimeToDestination.Day is available / to be displayed");
            } else {
                stringBuffer.append("false  (NewTimeToDestination.Day is not available / not to be displayed");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.newTimeToDestination_HourIsValid) {
                stringBuffer.append("true  (NewTimeToDestination.Hour is valid");
            } else {
                stringBuffer.append("false  (NewTimeToDestination.Hour is not valid");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.newTimeToDestination_MinuteIsValid) {
                stringBuffer.append("true  (NewTimeToDestination.Minute is valid");
            } else {
                stringBuffer.append("false  (NewTimeToDestination.Minute is not valid");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.newDistanceToDestinationIsValid) {
                stringBuffer.append("true  (NewDistanceToDestination is valid");
            } else {
                stringBuffer.append("false  (NewDistanceToDestination is not valid");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(2);
            bitStream.pushBoolean(this.newTimeToDestination_YearIsAvailableToBeDisplayed);
            bitStream.pushBoolean(this.newTimeToDestination_MonthIsAvailableToBeDisplayed);
            bitStream.pushBoolean(this.newTimeToDestination_DayIsAvailableToBeDisplayed);
            bitStream.pushBoolean(this.newTimeToDestination_HourIsValid);
            bitStream.pushBoolean(this.newTimeToDestination_MinuteIsValid);
            bitStream.pushBoolean(this.newDistanceToDestinationIsValid);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(2);
            this.newTimeToDestination_YearIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
            this.newTimeToDestination_MonthIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
            this.newTimeToDestination_DayIsAvailableToBeDisplayed = bitStream.popFrontBoolean();
            this.newTimeToDestination_HourIsValid = bitStream.popFrontBoolean();
            this.newTimeToDestination_MinuteIsValid = bitStream.popFrontBoolean();
            this.newDistanceToDestinationIsValid = bitStream.popFrontBoolean();
        }
    }

    public static final class NewTimeToDestination
    implements BAPEntity {
        public int timeInfoType;
        private static final int TIME_INFO_TYPE_BITSIZE = 4;
        public static final int TIME_INFO_TYPE_TIME_TO_DESTINATION = 0;
        public static final int TIME_INFO_TYPE_ARRIVAL_TIME = 1;
        public static final int TIME_INFO_TYPE_ARRIVAL_TIME_IS_LOCAL_TIME_IN_ANOTHER_TIME_ZONE = 2;
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

        public NewTimeToDestination() {
            this.internalReset();
            this.customInitialization();
        }

        public NewTimeToDestination(BitStream bitStream) {
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
            NewTimeToDestination newTimeToDestination = (NewTimeToDestination)bAPEntity;
            return this.timeInfoType == newTimeToDestination.timeInfoType && this.navigationTimeFormat == newTimeToDestination.navigationTimeFormat && this.minute == newTimeToDestination.minute && this.hour == newTimeToDestination.hour && this.day == newTimeToDestination.day && this.month == newTimeToDestination.month && this.year == newTimeToDestination.year;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("NewTimeToDestination:");
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
                    stringBuffer.append("0x2 (ArrivalTime is local time in another time zone)");
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

    public static final class NewDistanceToDestination
    implements BAPEntity {
        public int distance;
        private static final int DISTANCE_BITSIZE = 32;
        public int unit;
        private static final int UNIT_BITSIZE = 8;
        public static final int UNIT_METER = 0;
        public static final int UNIT_KILOMETER = 1;
        public static final int UNIT_YARD = 2;
        public static final int UNIT_FEET = 3;
        public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE = 4;
        public static final int UNIT_QUARTER_MILES_N_1_4MILE = 5;
        public static final int UNIT_NOT_SUPPORTED_NO_INFORMATION_ABOUT_UNIT_AVAILABLE = 255;
        public int typeOfDistance;
        private static final int TYPE_OF_DISTANCE_BITSIZE = 8;
        public static final int TYPE_OF_DISTANCE_ROAD_DISTANCE = 0;
        public static final int TYPE_OF_DISTANCE_LINEAR_DISTANCE = 1;
        public static final int TYPE_OF_DISTANCE_DISTANCE_INVALID = 255;

        public NewDistanceToDestination() {
            this.internalReset();
            this.customInitialization();
        }

        public NewDistanceToDestination(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.distance = 0;
            this.unit = 0;
            this.typeOfDistance = 0;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            NewDistanceToDestination newDistanceToDestination = (NewDistanceToDestination)bAPEntity;
            return this.distance == newDistanceToDestination.distance && this.unit == newDistanceToDestination.unit && this.typeOfDistance == newDistanceToDestination.typeOfDistance;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("NewDistanceToDestination:");
            stringBuffer.append("\n - Distance - ");
            stringBuffer.append(this.distance);
            stringBuffer.append("\n - Unit: ");
            switch (this.unit) {
                case 0: {
                    stringBuffer.append("0x00 (meter)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (kilometer)");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (yard)");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (feet)");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (mile (UK and US (statute mile)))");
                    break;
                }
                case 5: {
                    stringBuffer.append("0x05 (quarter mile(s) (n* 1/4mile))");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (not supported / no information about unit available)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - TypeOfDistance: ");
            switch (this.typeOfDistance) {
                case 0: {
                    stringBuffer.append("0x00 (road distance)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (linear distance)");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (distance invalid)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 32;
            n += 8;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushInt(this.distance);
            bitStream.pushByte((byte)this.unit);
            bitStream.pushByte((byte)this.typeOfDistance);
        }

        public void deserialize(BitStream bitStream) {
            this.distance = bitStream.popFrontInt();
            this.unit = bitStream.popFrontByte();
            this.typeOfDistance = bitStream.popFrontByte();
        }
    }
}

